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
	
	public static ItemStack getRecipe(Item item, Item item2, Item item3) 
	{
		return getOutput(item, item2, item3);
	}
	
	public static ItemStack getOutput(Item item, Item item2, Item item3)
	{
		
		if (isHammer(item) && isChisel(item2))
		{
			if (item3 == MagicasItems.fireEssenceChunk)
			{
				return new ItemStack(MagicasItems.fireEssenceShard, 1);
			}
			
			if (item3 == MagicasItems.waterEssenceChunk)
			{
				return new ItemStack(MagicasItems.waterEssenceShard, 1);
			}
			
			if (item3 == MagicasItems.earthEssenceChunk)
			{
				return new ItemStack(MagicasItems.earthEssenceShard, 1);
			}
			
			if (item3 == MagicasItems.airEssenceChunk)
			{
				return new ItemStack(MagicasItems.airEssenceShard, 1);
			}
			
			return null;
		}
		
		return null;
	}
	
	public static boolean isHammer(Item item)
	{
	
		if (item == MagicasItems.stoneHammer) return true;
		if (item == MagicasItems.ironHammer) return true;
		if (item == MagicasItems.diamondHammer) return true;
		
		return false;
		
	}
	
	public static boolean isChisel(Item item)
	{
		
		if (item == MagicasItems.stoneChisel) return true;
		if (item == MagicasItems.ironChisel) return true;
		if (item == MagicasItems.diamondChisel) return true;
		
		return false;
		
	}
	
}
