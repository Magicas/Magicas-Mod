package net.gammas.magicas.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class SlotEssenceExtractorBottle extends SlotFurnace
{

	public SlotEssenceExtractorBottle(EntityPlayer player, IInventory inv, int i, int j, int k)
	{
		super(player, inv, i, j, k);
	}
	
	@Override
	public boolean isItemValid(ItemStack is)
	{
		return is.getItem() == Items.glass_bottle;
	}

}
