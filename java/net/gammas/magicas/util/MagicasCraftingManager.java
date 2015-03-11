package net.gammas.magicas.util;

import net.gammas.magicas.blocks.MagicasBlocks;
import net.gammas.magicas.items.MagicasItems;
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
		GameRegistry.addRecipe(new ItemStack(MagicasBlocks.EssenceExtractorIdle, 1), new Object[] { "III", " I ", "WWW", 'I', Items.iron_ingot, 'W', Blocks.planks });
		GameRegistry.addRecipe(new ItemStack(MagicasBlocks.EssenceCombinerIdle, 1), new Object[] { "GGG", "GCG", "WWW", 'G', Items.gold_ingot, 'W', Blocks.planks, 'C', Items.quartz });
		GameRegistry.addRecipe(new ItemStack(MagicasItems.stoneHammer, 1), new Object[] { "CCC", "CCC", " S ", 'C', Blocks.cobblestone, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MagicasItems.stoneChisel, 1), new Object[] { "  C", " C ", "S  ", 'C', Blocks.cobblestone, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MagicasItems.stoneHammer, 1), new Object[] { "III", "III", " S ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MagicasItems.stoneChisel, 1), new Object[] { "  I", " I ", "S  ", 'I', Items.iron_ingot, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MagicasItems.stoneHammer, 1), new Object[] { "DDD", "DDD", " S ", 'D', Items.diamond, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MagicasItems.stoneChisel, 1), new Object[] { "  D", " D ", "S  ", 'D', Items.diamond, 'S', Items.stick});
		
		
		// Shapeless
		
	}
	
	public static void AddSmeltingRecipes()
	{
		
	}
	
}
