package net.gammas.magicas.blocks;

import net.gammas.magicas.biome.features.MagicasLeaf;
import net.gammas.magicas.biome.features.MagicasLog;
import net.gammas.magicas.core.MagicasCreativeTabs;
import net.gammas.magicas.items.ItemLeafBlocks;
import net.gammas.magicas.items.ItemLogBlocks;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

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
	public static Block EssenceInfuserIdle;
	public static Block EssenceInfuserActive;
	
	// Trees
	public static Block blockLog;
	public static Block blockLeaf;

	// GUI IDs
	public static final int GuiIDEssenceExtractor = 0;
	public static final int GuiIDEssenceCombiner = 1;
	public static final int GuiIDEssenceInfuser = 2;

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
		EssenceInfuserIdle = new EssenceInfuser(false).setBlockName("essenceInfuserIdle").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas);
		EssenceInfuserActive = new EssenceInfuser(true).setBlockName("essenceInfuserActive");
		
		// Trees
		blockLog = new MagicasLog().setBlockName("Log").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:Log");
		blockLeaf = new MagicasLeaf().setBlockName("Leaf").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setBlockTextureName("magicasmod:Leaf");
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
		GameRegistry.registerBlock(EssenceCombinerIdle, EssenceCombinerIdle.getUnlocalizedName());
		GameRegistry.registerBlock(EssenceCombinerActive, EssenceCombinerActive.getUnlocalizedName());
		GameRegistry.registerBlock(EssenceInfuserIdle, EssenceInfuserIdle.getUnlocalizedName());
		GameRegistry.registerBlock(EssenceInfuserActive, EssenceInfuserActive.getUnlocalizedName());
		GameRegistry.registerBlock(blockLog, ItemLogBlocks.class, blockLog.getUnlocalizedName());
		GameRegistry.registerBlock(blockLeaf, ItemLeafBlocks.class, blockLeaf.getUnlocalizedName());
	}
}
