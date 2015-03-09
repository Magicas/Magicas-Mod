package net.gammas.magicas.container;

import net.gammas.magicas.slot.SlotEssenceCombiner;
import net.gammas.magicas.slot.SlotEssenceExtractor;
import net.gammas.magicas.tileentites.TileEntityEssenceCombiner;
import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerEssenceCombiner extends Container {

	private TileEntityEssenceCombiner essenceCombiner;
	private int dualCookTime;
	
	public ContainerEssenceCombiner(InventoryPlayer invPlayer, TileEntityEssenceCombiner teEssenceCombiner){
		dualCookTime = 0;
		
		essenceCombiner = teEssenceCombiner;
		
		
		//TODO: GET COORDS FOR SLOTS!
		this.addSlotToContainer(new Slot ((IInventory)teEssenceCombiner, 0, 66, 24));
		this.addSlotToContainer(new Slot ((IInventory)teEssenceCombiner, 1, 66, 44));
		this.addSlotToContainer(new SlotEssenceCombiner(invPlayer.player, teEssenceCombiner, 2, 124, 35));

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
		return essenceCombiner.isUseableByPlayer(player);
	}


	
	public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.essenceCombiner.cooktime);
    }
	

	
	
	
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ != 1 && p_82846_2_ != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (essenceCombiner.isItemEssence(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 3 && p_82846_2_ < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
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

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }
	
	 public void detectAndSendChanges()
	    {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.crafters.size(); ++i)
	        {
	            ICrafting icrafting = (ICrafting)this.crafters.get(i);

	            if (this.dualCookTime != this.essenceCombiner.cooktime)
	            {
	                icrafting.sendProgressBarUpdate(this, 0, this.essenceCombiner.cooktime);
	            }
	        }
	        this.dualCookTime = this.essenceCombiner.cooktime;

	    }
	
	 @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int i, int j)
	    {
	        if (i == 0)
	        {
	            this.essenceCombiner.cooktime = j;
	        }

	    }

	
	
	
	
	
	
	
	
	
}