package net.gammas.magicas.container;

import net.gammas.magicas.items.MagicasItems;
import net.gammas.magicas.slot.SlotEssenceCombiner;
import net.gammas.magicas.slot.SlotEssenceExtractor;
import net.gammas.magicas.slot.SlotEssenceExtractorChisel;
import net.gammas.magicas.slot.SlotEssenceExtractorHammer;
import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.gammas.magicas.util.ContainerHelp;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerEssenceExtractor extends Container
{

	private TileEntityEssenceExtractor essenceExtractor;
	private int dualCookTime;

	public static final int INPUT_1 = 0, INPUT_2 = 1, INPUT_3 = 2, OUTPUT = 3;

	public ContainerEssenceExtractor(InventoryPlayer invPlayer, TileEntityEssenceExtractor teEssenceExtractor)
	{
		dualCookTime = 0;

		essenceExtractor = teEssenceExtractor;

		this.addSlotToContainer(new SlotEssenceExtractorHammer(invPlayer.player, teEssenceExtractor, INPUT_1, 26, 24));
		this.addSlotToContainer(new SlotEssenceExtractorChisel(invPlayer.player, teEssenceExtractor, INPUT_2, 26, 44));
		this.addSlotToContainer(new Slot((IInventory) teEssenceExtractor, INPUT_3, 66, 34));
		this.addSlotToContainer(new SlotEssenceExtractor(invPlayer.player, teEssenceExtractor, OUTPUT, 124, 35));
		
//		this.addSlotToContainer(new Slot ((IInventory)teEssenceCombiner, 0, 30, 35));
//		this.addSlotToContainer(new Slot ((IInventory)teEssenceCombiner, 1, 68, 35));
//		this.addSlotToContainer(new SlotEssenceCombiner(invPlayer.player, teEssenceCombiner, 2, 124, 35));

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return essenceExtractor.isUseableByPlayer(player);
	}

	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.essenceExtractor.cooktime);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// If itemstack is in Output stack
			if (par2 == OUTPUT)
			{
				// try to place in player inventory / action bar; add 36+1
				// because mergeItemStack uses < index,
				// so the last slot in the inventory won't get checked if you
				// don't add 1
				if (!this.mergeItemStack(itemstack1, OUTPUT + 1, OUTPUT + 36 + 1, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			// itemstack is in player inventory, try to place in appropriate
			// furnace slot
			else if (par2 != INPUT_1 && par2 != INPUT_2 && par2 != INPUT_3)
			{
				// if it can be smelted, place in the input slots
				if (ContainerHelp.isEssenceChunk(itemstack1.getItem()))
				{
					// try to place in either Input slot; add 1 to final input
					// slot because mergeItemStack uses < index
					if (!this.mergeItemStack(itemstack1, INPUT_3, INPUT_3 + 1, false))
					{
						return null;
					}
				}
				// if it's an energy source, place in Fuel slot
				else if (ContainerHelp.isHammer(itemstack1.getItem()))
				{
					if (!this.mergeItemStack(itemstack1, INPUT_1, INPUT_1 + 1, false))
					{
						return null;
					}
				}
				else if (ContainerHelp.isChisel(itemstack1.getItem()))
				{
					if (!this.mergeItemStack(itemstack1, INPUT_2, INPUT_2 + 1, false))
					{
						return null;
					}
				}
				// item in player's inventory, but not in action bar
				else if (par2 >= OUTPUT + 1 && par2 < OUTPUT + 28)
				{
					// place in action bar
					if (!this.mergeItemStack(itemstack1, OUTPUT + 28, OUTPUT + 37, false))
					{
						return null;
					}
				}
				// item in action bar - place in player inventory
				else if (par2 >= OUTPUT + 28 && par2 < OUTPUT + 37 && !this.mergeItemStack(itemstack1, OUTPUT + 1, OUTPUT + 28, false))
				{
					return null;
				}
			}
			// In one of the infuser slots; try to place in player inventory /
			// action bar
			else if (!this.mergeItemStack(itemstack1, OUTPUT + 1, OUTPUT + 37, false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			} else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}
		return itemstack;
	}

	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

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