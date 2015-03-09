package net.gammas.magicas.recipes;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EssenceSplitterRecipes 
{
	
	public EssenceSplitterRecipes() 
	{
		
	}
	
	public static ItemStack getOutput1(Item item) 
	{
		if (item == MagicasItems.steamEssence)
		{
			return new ItemStack(MagicasItems.fireEssence);
		}
	}
	
	public static ItemStack getOutput2(Item item)
	{
		if (item == MagicasItems.steamEssence)
		{
			return new ItemStack(MagicasItems.waterEssence);
		}
	}
	
	public static ItemStack getOutput3(Item item, Item item2)
	{
		if (item == MagicasItems.steamEssence)
		{
			return null;
		}
	}
	
}
