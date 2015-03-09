package net.gammas.magicas.recipes;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EssenceCombinerRecipes 
{
	
	public EssenceRefinerRecipes() 
	{
		
	}
	
	public static ItemStack getRecipe(Item item, Item item2) 
	{
		return getOutput(item, item2);
	}
	
	public static ItemStack getOutput(Item item, Item item2)
	{
		if (item == MagicasItems.fireEssence && item2 == MagicasItems.waterEssence)
		{
			return new ItemStack(MagicasItems.steamEssence);
		}
		
		if (item == MagicasItems.waterEssence && item2 == MagicasItems.fireEssence)
		{
			return new ItemStack(MagicasItems.steamEssence);
		}
		
		return null;
	}
	
}
