package net.gammas.magicas.slot;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class SlotEssenceExtractorHammer extends SlotFurnace
{

	public SlotEssenceExtractorHammer(EntityPlayer player, IInventory inv, int i, int j, int k)
	{
		super(player, inv, i, j, k);
	}
	
	@Override
	public boolean isItemValid(ItemStack is)
	{
		return is.getItem() == MagicasItems.stoneHammer;
	}

}
