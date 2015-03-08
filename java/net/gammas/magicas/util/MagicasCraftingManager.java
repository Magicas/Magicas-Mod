package net.gammas.magicas.util;

import net.gammas.magicas.blocks.MagicasBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MagicasCraftingManager 
{
	
	public static void RegisterRecipes()
	{
		AddCraftingRecipes();
	}
	
	public static void AddCraftingRecipes()
	{
		
		// Shaped
		GameRegistry.addRecipe(new ItemStack(MagicasBlocks.EssenceExtractorIdle, 1), new Object[] { "III", "ICI", "WWW", 'I', Items.iron_ingot, 'W', Blocks.planks, 'C', Items.quartz });
		
		
		// Shapeless
		
	}
	
	public static void AddSmeltingRecipes()
	{
		
	}
	
}
