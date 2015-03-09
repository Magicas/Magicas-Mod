package net.gammas.magicas.recipes;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EssenceExtractorRecipes 
{
	
	public EssenceExtractorRecipes() 
	{
		
	}
	
	public static ItemStack getRecipe(Item item, Item item2) 
	{
		return getOutput(item, item2);
	}
	
	public static ItemStack getOutput(Item item, Item item2)
	{
		//Recipe: EXAMPLE
		if(item == MagicasItems.fireEssence && item2 == Items.glass_bottle ) 
		{
			return new ItemStack(MagicasItems.bottleOfFireEssence, 1);	
		}
		
		if(item == MagicasItems.waterEssence && item2 == Items.glass_bottle ) 
		{
			return new ItemStack(MagicasItems.bottleOfWaterEssence, 1);	
		}
		
		if(item == MagicasItems.earthEssence && item2 == Items.glass_bottle ) 
		{
			return new ItemStack(MagicasItems.bottleOfEarthEssence, 1);	
		}
		
		if(item == MagicasItems.airEssence && item2 == Items.glass_bottle ) 
		{
			return new ItemStack(MagicasItems.bottleOfAirEssence, 1);	
		}
		
		if (item == MagicasItems.fireEssence && item2 == MagicasItems.waterEssence)
		{
			return new ItemStack(MagicasItems.earthEssence);
		}
		
		if (item == MagicasItems.waterEssence && item2 == MagicasItems.fireEssence)
		{
			return new ItemStack(MagicasItems.earthEssence);
		}
		
		return null;
	}
	
}
