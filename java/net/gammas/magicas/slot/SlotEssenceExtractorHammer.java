package net.gammas.magicas.slot;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.Item;
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
		return isHammer(is.getItem());
	}
	
	public static boolean isHammer(Item item)
	{
	
		if (item == MagicasItems.stoneHammer) return true;
		if (item == MagicasItems.ironHammer) return true;
		if (item == MagicasItems.diamondHammer) return true;
		
		return false;
		
	}

}
