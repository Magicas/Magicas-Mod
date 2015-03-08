package net.gammas.magicas.tileentites;

import net.gammas.magicas.blocks.EssenceExtractor;
import net.gammas.magicas.recipes.EssenceExtractorRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEssenceExtractor extends TileEntity implements ISidedInventory{

	private ItemStack slots[];
	private String customName;
	
	public int cooktime;
	public int power;
	public static final int maxPower = 10000;
	public static final int alloySpeed = 10;	
	private static final int[] slots_top = new int[] {0};
	private static final int[] slots_bottom = new int[] {1};
	private static final int[] slots_side = new int[] {2};
	
	
	public TileEntityEssenceExtractor(){
		slots = new ItemStack[3];
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}
	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if(slots[var1] != null) {
			if(slots[var1].stackSize <= var2) {
				ItemStack is = slots[var1];
				slots[var1] = null;
				return is;
			}
			ItemStack is1 = slots[var1].splitStack(var2);
			
			if(slots[var1].stackSize == 0) {
				slots[var1] = null;
			}
			return is1;
		}else{
			return null;
		}
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(slots[i] != null){
			ItemStack itemstack = slots[i];
			slots[i] = null;
			return itemstack;
		}else{
			return null;
		}
	}
	@Override
	public void setInventorySlotContents(int i, ItemStack is) {
		slots[i] = is;
		if(is != null && is.stackSize > getInventoryStackLimit()){
			is.stackSize = getInventoryStackLimit();
		}
	}
	@Override
	public String getInventoryName() {
		return "container.essenceExtractor";
	}
	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}
	
	public void setGuiDisplayName(String name){
		this.customName = name;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord) != this){
			return false;
		}else{
			return player.getDistanceSq((double) xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64;
		}
	}
	@Override
	public void openInventory() {}
	
	@Override
	public void closeInventory() {}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		return slot == 2 ? false : (slot == 1 || slot == 2 ? hasItemPower (is) : true);
	}

	public boolean hasItemPower(ItemStack is){
		return getItemPower(is) > 0;
		
	}
	private static int getItemPower (ItemStack is) {
		if(is == null) {
			return 0;
		}else{
			Item item = is.getItem();
			
			if (item == Items.coal){
				return 5000;
			}
			if(item == Items.lava_bucket){
				return 50000;
			}
			if(item == Items.blaze_rod){
				return 15000;
			}
			if(item == Item.getItemFromBlock(Blocks.torch)){
				return 5000;
			}
			
			
			return 0;
		}
	}
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound nbt1 = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");
			
			if(b0 >= 0 && b0 < slots.length){
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
		
		power = nbt.getShort("PowerTime");
		cooktime = nbt.getShort("CookTime");
		
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setShort("PowerTime", (short)power);
		nbt.setShort("CookTime", (short)cooktime);
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < slots.length; i++){
			if(slots[i] != null){
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte)i);
				list.appendTag(nbt1);
				slots[i].writeToNBT(nbt1);
			}
		}
		
		nbt.setTag("Items", list);
	}
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}
	@Override
	public boolean canInsertItem(int var1, ItemStack is, int var2) {
		return this.isItemValidForSlot(var1, is);
	}
	@Override
	public boolean canExtractItem(int var1, ItemStack is, int var2) {
		return var2 != 0 || var1 != 1 || is.getItem() == Items.bucket;
	}
	
	public int getAlloyingProcessScaled(int i){
		return (cooktime * i)/ this.alloySpeed;
	}
	public int getPowerRemainingScaled(int i){
		return (cooktime * i)/ maxPower;
	}
	private boolean canAlloy(){
		
		if(slots[0] == null || slots[1] == null) {
			return false;
		}
		ItemStack itemstack = EssenceExtractorRecipes.getRecipe(slots[0].getItem(), slots[1].getItem());

		
		if(itemstack == null){
			return false;
		}
		if(slots[2] == null){
			return true;
		}
		if(!slots[2].isItemEqual(itemstack)){
			return false;
		}
		if(slots[2].stackSize < getInventoryStackLimit() && slots[2].stackSize < slots[2].getMaxStackSize()) {
			return true;
		}else{
			return slots[2].stackSize < itemstack.getMaxStackSize();
		}
	}
	public void alloy(){
		if(canAlloy()){
			ItemStack itemstack = EssenceExtractorRecipes.getRecipe(slots[0].getItem(), slots[1].getItem());
		
		if(slots[2] == null){
			slots[2] = itemstack.copy();
		}else if (slots[2].isItemEqual(itemstack)){
			slots[2].stackSize += itemstack.stackSize;
			}
			
			for (int i = 0; i < 2; i++){
				if(slots[i].stackSize <= 0){
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				}else{
					slots[i].stackSize--;
				}
				if(slots[i].stackSize <= 0){
					slots[i] = null;
				}
			}
		
		}
		
	}
	
	public boolean hasPower(){
		return power > -1;
	}
	
	public void updateEntity(){
		boolean flag = this.hasPower();
		boolean flag1 = false;
		
		if(hasPower() && this.isExtracting()) {
			this.power--;
			if (this.power < 0)
			{
				power = 100000;
			}
		}	
			if(hasPower() && canAlloy()){
				cooktime++;
				
				if(this.cooktime == this.alloySpeed) {
					this.cooktime = 0;
					this.alloy();
					flag1 = true;
				}
			}else{
				cooktime = 0;
			}
			
			if(flag != this.isExtracting()){
				flag1 = true;
				EssenceExtractor.updateBlockState(this.isExtracting(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			
		if(flag1)
		{
			this.markDirty();
		}
	}
	
	public boolean isExtracting()
	{
		return this.cooktime > 0;
	}
	
	@Override
	 public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
	 NBTTagCompound nbttagcompound = pkt.func_148857_g();
	 this.readFromNBT(nbttagcompound);
	 }
	 
	 @Override
	 public Packet getDescriptionPacket() {
	 NBTTagCompound nbttagcompound = new NBTTagCompound();
	 this.writeToNBT(nbttagcompound);
	 return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, nbttagcompound);
	 }
}