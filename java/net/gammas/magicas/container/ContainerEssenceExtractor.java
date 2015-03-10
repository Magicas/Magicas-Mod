package net.gammas.magicas.container;

import net.gammas.magicas.slot.SlotEssenceExtractor;
import net.gammas.magicas.slot.SlotEssenceExtractorChisel;
import net.gammas.magicas.slot.SlotEssenceExtractorHammer;
import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerEssenceExtractor extends Container {

	private TileEntityEssenceExtractor essenceExtractor;
	private int dualCookTime;
	
	public ContainerEssenceExtractor(InventoryPlayer invPlayer, TileEntityEssenceExtractor teEssenceExtractor){
		dualCookTime = 0;
		
		essenceExtractor = teEssenceExtractor;
		
		this.addSlotToContainer(new SlotEssenceExtractorHammer (invPlayer.player, teEssenceExtractor, 0, 26, 24));
		this.addSlotToContainer(new SlotEssenceExtractorChisel (invPlayer.player, teEssenceExtractor, 1, 26, 44));
		this.addSlotToContainer(new Slot ((IInventory)teEssenceExtractor, 2, 66, 34));
		this.addSlotToContainer(new SlotEssenceExtractor(invPlayer.player, teEssenceExtractor, 3, 124, 35));

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return essenceExtractor.isUseableByPlayer(player);
	}


	
	public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.essenceExtractor.cooktime);
    }
	

	
	
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotNumber);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotNumber == 3)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotNumber != 1 && slotNumber != 0)
            {
                if (essenceExtractor.isItemEssence(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (itemstack.getItem() == Items.glass_bottle)
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (slotNumber >= 3 && slotNumber < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (slotNumber >= 30 && slotNumber < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
	
	 public void detectAndSendChanges()
	    {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.crafters.size(); ++i)
	        {
	            ICrafting icrafting = (ICrafting)this.crafters.get(i);

	            if (this.dualCookTime != this.essenceExtractor.cooktime)
	            {
	                icrafting.sendProgressBarUpdate(this, 0, this.essenceExtractor.cooktime);
	            }
	        }
	        this.dualCookTime = this.essenceExtractor.cooktime;

	    }
	
	 @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int i, int j)
	    {
	        if (i == 0)
	        {
	            this.essenceExtractor.cooktime = j;
	        }

	    }

	
	
	
	
	
	
	
	
	
}