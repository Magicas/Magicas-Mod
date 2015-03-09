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
	
	// Natural
	public static Block taintedGrass;
	
	// Ores
	public static Block fireEssenceOre;
	public static Block waterEssenceOre;
	public static Block earthEssenceOre;
	public static Block airEssenceOre;
	
	// Machines
	public static Block EssenceExtractorIdle;
	public static Block EssenceExtractorActive;
	public static Block EssenceCombinerIdle;
	public static Block EssenceCombinerActive;
	public static Block EssenceSplitterIdle;
	public static Block EssenceSplitterActive;
	
	// GUI IDs
	public static final int GuiIDEssenceExtractor = 0;
	public static final int GuiIDEssenceCombiner = 1;
	public static final int GuiIDEssenceSplitter = 2;
	
	public static void InitBlocks()
	{
		// Natural
		taintedGrass = new BlockTaintedGrass().setBlockName("taintedgrass").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas);
		
		// Ores
		fireEssenceOre = new BlockFireEssenceOre().setBlockName("fireEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:fireEssenceOre");
		waterEssenceOre = new BlockWaterEssenceOre().setBlockName("waterEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:waterEssenceOre");
		earthEssenceOre = new BlockEarthEssenceOre().setBlockName("earthEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:earthEssenceOre");
		airEssenceOre = new BlockAirEssenceOre().setBlockName("airEssenceOre").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:airEssenceOre");
		
		// Machines
		EssenceExtractorIdle = new EssenceExtractor(false).setBlockName("essenceExtractorIdle").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas);
		EssenceExtractorActive = new EssenceExtractor(true).setBlockName("essenceExtractorActive");
		EssenceCombinerIdle = new EssenceCombiner(false).setBlockName("essenceCombinerIdle").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas);
		EssenceCombinerActive = new EssenceCombiner(true).setBlockName("essenceCombinerActive");
		EssenceSplitterIdle = new EssenceSplitter(false).setBlockName("essenceSplitterIdle").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas);
		EssenceSplitterActive = new EssenceSplitter(true).setBlockName("essenceSplitterActive");
	}
	
	public static void RegisterBlocks()
	{
		// Game Registry
		GameRegistry.registerBlock(taintedGrass, taintedGrass.getUnlocalizedName());
		GameRegistry.registerBlock(fireEssenceOre, fireEssenceOre.getUnlocalizedName());
		GameRegistry.registerBlock(waterEssenceOre, waterEssenceOre.getUnlocalizedName());
		GameRegistry.registerBlock(earthEssenceOre, earthEssenceOre.getUnlocalizedName());
		GameRegistry.registerBlock(airEssenceOre, airEssenceOre.getUnlocalizedName());
		GameRegistry.registerBlock(EssenceExtractorIdle, EssenceExtractorIdle.getUnlocalizedName());
		GameRegistry.registerBlock(EssenceExtractorActive, EssenceExtractorActive.getUnlocalizedName());
		
		// Language Registry
//		LanguageRegistry.addName(taintedGrass, "Tainted Grass");
//		LanguageRegistry.addName(fireEssenceOre, "Fire Essence Ore");
//		LanguageRegistry.addName(waterEssenceOre, "Water Essence Ore");
//		LanguageRegistry.addName(earthEssenceOre, "Earth Essence Ore");
//		LanguageRegistry.addName(airEssenceOre, "Air Essence Ore");
//		LanguageRegistry.addName(EssenceExtractorIdle, "Essence Extractor");
//		LanguageRegistry.addName(EssenceExtractorActive, "Essence Extractor");
	}
}
