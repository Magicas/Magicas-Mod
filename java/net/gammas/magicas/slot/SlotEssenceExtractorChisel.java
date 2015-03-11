package net.gammas.magicas.slot;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotEssenceExtractorChisel extends SlotFurnace
{

	public SlotEssenceExtractorChisel(EntityPlayer player, IInventory inv, int i, int j, int k)
	{
		super(player, inv, i, j, k);
	}
	
	@Override
	public boolean isItemValid(ItemStack is)
	{
		return isChisel(is.getItem());
	}
	
	public static boolean isChisel(Item item)
	{
		
		if (item == MagicasItems.stoneChisel) return true;
		if (item == MagicasItems.ironChisel) return true;
		if (item == MagicasItems.diamondChisel) return true;
		
		return false;
		
	}

}
