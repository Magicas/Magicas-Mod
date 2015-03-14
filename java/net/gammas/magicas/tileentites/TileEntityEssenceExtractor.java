package net.gammas.magicas.tileentites;

import java.util.Random;

import net.gammas.magicas.container.ContainerEssenceExtractor;
import net.gammas.magicas.items.MagicasItems;
import net.gammas.magicas.recipes.EssenceExtractorRecipes;
import net.gammas.magicas.util.ContainerHelp;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEssenceExtractor extends TileEntity implements ISidedInventory
{

	private ItemStack slots[];
	private String customName;
	public boolean isExtracting;

	public int cooktime;
	private static final int secondsToExtract = 3;
	public static final int extractingSpeed = 20 * secondsToExtract;
	private static final int[] slots_top = new int[]
	{ 2 };
	private static final int[] slots_bottom = new int[]
	{ 3 };
	private static final int[] slots_side = new int[]
	{ 0, 1 };

	public TileEntityEssenceExtractor()
	{
		slots = new ItemStack[4];
	}

	@Override
	public int getSizeInventory()
	{
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return slots[i];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2)
	{
		if (slots[var1] != null)
		{
			if (slots[var1].stackSize <= var2)
			{
				ItemStack is = slots[var1];
				slots[var1] = null;
				return is;
			}
			ItemStack is1 = slots[var1].splitStack(var2);

			if (slots[var1].stackSize == 0)
			{
				slots[var1] = null;
			}
			return is1;
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i)
	{
		if (slots[i] != null)
		{
			ItemStack itemstack = slots[i];
			slots[i] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack is)
	{
		slots[i] = is;
		if (is != null && is.stackSize > getInventoryStackLimit())
		{
			is.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName()
	{
		return "container.essenceExtractor";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	public void setGuiDisplayName(String name)
	{
		this.customName = name;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
		{
			return false;
		}
		else
		{
			return player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64;
		}
	}

	@Override
	public void openInventory()
	{
	}

	@Override
	public void closeInventory()
	{
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is)
	{
		if (slot == 0)
		{
			if (ContainerHelp.isHammer(is.getItem()))
			{
				return true;
			}
		}
		else if (slot == 1)
		{
			if (ContainerHelp.isChisel(is.getItem()))
			{
				return true;
			}
		}
		else if (slot == 2)
		{
			if (ContainerHelp.isEssenceChunk(is.getItem()));
		}

		return false;
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		NBTTagList list = nbt.getTagList("Items", 10);
		slots = new ItemStack[getSizeInventory()];
		for (int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound nbt1 = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("Slot");

			if (b0 >= 0 && b0 < slots.length)
			{
				slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}

		cooktime = nbt.getShort("CookTime");

	}

	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setShort("CookTime", (short) cooktime);
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < slots.length; i++)
		{
			if (slots[i] != null)
			{
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("Slot", (byte) i);
				list.appendTag(nbt1);
				slots[i].writeToNBT(nbt1);
			}
		}

		nbt.setTag("Items", list);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1)
	{
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack is, int var2)
	{
		return this.isItemValidForSlot(var1, is);
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack is, int var2)
	{
		return var2 != 0 || var1 != 1 || is.getItem() == Items.bucket;
	}

	public int getExtractingProcessScaled(int i)
	{
		return (cooktime * i) / this.extractingSpeed;
	}

	private boolean canExtract()
	{

		if (slots[0] == null || slots[1] == null || slots[2] == null)
		{
			return false;
		}

		ItemStack itemstack = EssenceExtractorRecipes.getRecipe(slots[0].getItem(), slots[1].getItem(), slots[2].getItem());

		if (itemstack == null)
		{
			return false;
		}

		if (slots[3] == null)
		{
			return true;
		}

		if (!slots[3].isItemEqual(itemstack))
		{
			return false;
		}

		if (slots[3].stackSize < getInventoryStackLimit() && slots[3].stackSize < slots[3].getMaxStackSize())
		{
			return true;
		}
		else
		{
			return slots[3].stackSize < itemstack.getMaxStackSize();
		}
	}

	public void extract()
	{
		if (canExtract())
		{
			ItemStack itemstack = EssenceExtractorRecipes.getRecipe(slots[0].getItem(), slots[1].getItem(), slots[2].getItem());

			if (slots[3] == null)
			{
				slots[3] = itemstack.copy();
			}
			else if (slots[3].isItemEqual(itemstack))
			{
				slots[3].stackSize += itemstack.stackSize;
			}

			for (int i = 0; i < 3; i++)
			{
				if (slots[i].stackSize <= 0)
				{
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				}
				else
				{
					if (i == 2)
					{
						slots[i].stackSize--;
					}
				}

				if (slots[i].stackSize <= 0)
				{
					slots[i] = null;
				}
			}

		}

	}

	private Random random;

	public void updateEntity()
	{
		boolean flag1 = false;

		if (canExtract())
		{
			cooktime++;
			isExtracting = true;

			if (this.cooktime == this.extractingSpeed)
			{
				this.cooktime = 0;
				if (slots[0].getItemDamage() == slots[0].getMaxDamage())
				{
					slots[0] = null;
				}
				else
				{
					slots[0].attemptDamageItem(1, random);
				}

				if (slots[1].getItemDamage() == slots[1].getMaxDamage())
				{
					slots[1] = null;
				}
				else
				{
					slots[1].attemptDamageItem(1, random);
				}
				this.extract();
				isExtracting = false;
				flag1 = true;
			}
		}
		else
		{
			cooktime = 0;
		}

		if (flag1)
		{
			this.markDirty();
		}
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound nbttagcompound = pkt.func_148857_g();
		this.readFromNBT(nbttagcompound);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, nbttagcompound);
	}
}