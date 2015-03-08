package net.gammas.magicas.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.gammas.magicas.core.MagicasCreativeTabs;
import net.gammas.magicas.core.MagicasMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class MagicasBlocks 
{
	
	public static Block taintedGrass;
	public static Block fireEssenceOre;
	public static Block waterEssenceOre;
	public static Block earthEssenceOre;
	public static Block airEssenceOre;
	
	public static void InitBlocks()
	{
		taintedGrass = new BlockTaintedGrass().setBlockName("taintedgrass").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas);
		fireEssenceOre = new BlockFireEssenceOre().setBlockName("fireEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:fireEssenceOre");
		waterEssenceOre = new BlockWaterEssenceOre().setBlockName("waterEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:waterEssenceOre");
		earthEssenceOre = new BlockEarthEssenceOre().setBlockName("earthEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:earthEssenceOre");
		airEssenceOre = new BlockAirEssenceOre().setBlockName("airEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:airEssenceOre");
	}
	
	public static void RegisterBlocks()
	{
		// Game Registry
		GameRegistry.registerBlock(taintedGrass, taintedGrass.getUnlocalizedName());
		GameRegistry.registerBlock(fireEssenceOre, fireEssenceOre.getUnlocalizedName());
		GameRegistry.registerBlock(waterEssenceOre, waterEssenceOre.getUnlocalizedName());
		GameRegistry.registerBlock(earthEssenceOre, earthEssenceOre.getUnlocalizedName());
		GameRegistry.registerBlock(airEssenceOre, airEssenceOre.getUnlocalizedName());
		
		// Language Registry
		LanguageRegistry.addName(taintedGrass, "Tainted Grass");
		LanguageRegistry.addName(fireEssenceOre, "Fire Essence Ore");
		LanguageRegistry.addName(waterEssenceOre, "Water Essence Ore");
		LanguageRegistry.addName(earthEssenceOre, "Earth Essence Ore");
		LanguageRegistry.addName(airEssenceOre, "Air Essence Ore");
	}
}
