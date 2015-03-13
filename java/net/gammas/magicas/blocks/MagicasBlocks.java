package net.gammas.magicas.blocks;

import net.gammas.magicas.biome.features.MagicasLeaf;
import net.gammas.magicas.biome.features.MagicasLog;
import net.gammas.magicas.biome.features.MagicasSapling;
import net.gammas.magicas.core.MagicasCreativeTabs;
import net.gammas.magicas.items.ItemLeafBlocks;
import net.gammas.magicas.items.ItemLogBlocks;
import net.gammas.magicas.items.ItemSaplingBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class MagicasBlocks
{

	private static CreativeTabs MagicasTab = MagicasCreativeTabs.creativeTabMagicas;

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
	public static Block blockSapling;

	// GUI IDs
	public static final int GuiIDEssenceExtractor = 0;
	public static final int GuiIDEssenceCombiner = 1;
	public static final int GuiIDEssenceInfuser = 2;

	// Hardness

	private static World world;
	private static int y;
	private static int x;
	private static int z;

	private static final float stone = Blocks.stone.getBlockHardness(world, x, y, z);
	private static final float obsidian = Blocks.obsidian.getBlockHardness(world, x, y, z);
	private static final float wood = Blocks.planks.getBlockHardness(world, x, y, z);
	private static final float dirt = Blocks.dirt.getBlockHardness(world, x, y, z);
	private static final float snow = Blocks.snow.getBlockHardness(world, x, y, z);

	// Step Sounds

	private static final SoundType stoneStep = Block.soundTypeStone;
	private static final SoundType woodStep = Block.soundTypeWood;
	private static final SoundType ironStep = Block.soundTypeMetal;
	private static final SoundType grassStep = Block.soundTypeGrass;
	private static final SoundType gravelStep = Block.soundTypeGravel;

	// Materials

	private static final Material stoneMat = Material.rock;
	private static final Material ironMat = Material.iron;
	private static final Material grassMat = Material.grass;
	private static final Material dirtMat = Material.ground;

	public static void InitBlocks()
	{
		// Natural
		taintedGrass = new BlockTaintedGrass(grassMat).setBlockName("taintedgrass").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setHardness(dirt).setStepSound(grassStep);

		// Ores
		fireEssenceOre = new BlockFireEssenceOre(stoneMat).setBlockName("fireEssenceOre").setCreativeTab(MagicasTab).setBlockTextureName("magicasmod:fireEssenceOre").setHardness(stone).setStepSound(stoneStep);
		waterEssenceOre = new BlockWaterEssenceOre(stoneMat).setBlockName("waterEssenceOre").setCreativeTab(MagicasTab).setBlockTextureName("magicasmod:waterEssenceOre").setHardness(stone).setStepSound(stoneStep);
		earthEssenceOre = new BlockEarthEssenceOre(stoneMat).setBlockName("earthEssenceOre").setCreativeTab(MagicasTab).setBlockTextureName("magicasmod:earthEssenceOre").setHardness(stone).setStepSound(stoneStep);
		airEssenceOre = new BlockAirEssenceOre(stoneMat).setBlockName("airEssenceOre").setCreativeTab(MagicasTab).setBlockTextureName("magicasmod:airEssenceOre").setHardness(stone).setStepSound(stoneStep);

		// Machines
		EssenceExtractorIdle = new EssenceExtractor(ironMat, false).setBlockName("essenceExtractorIdle").setCreativeTab(MagicasTab).setHardness(stone).setStepSound(ironStep);
		EssenceExtractorActive = new EssenceExtractor(ironMat, true).setBlockName("essenceExtractorActive").setHardness(stone).setStepSound(ironStep);
		EssenceCombinerIdle = new EssenceCombiner(ironMat, false).setBlockName("essenceCombinerIdle").setCreativeTab(MagicasTab).setHardness(stone).setStepSound(ironStep);
		EssenceCombinerActive = new EssenceCombiner(ironMat, true).setBlockName("essenceCombinerActive").setHardness(stone).setStepSound(ironStep);
		EssenceInfuserIdle = new EssenceInfuser(ironMat, false).setBlockName("essenceInfuserIdle").setCreativeTab(MagicasTab).setHardness(stone).setStepSound(ironStep);
		EssenceInfuserActive = new EssenceInfuser(ironMat, true).setBlockName("essenceInfuserActive").setHardness(stone).setStepSound(ironStep);

		// Trees
		blockLog = new MagicasLog().setBlockName("Log").setCreativeTab(MagicasTab).setBlockTextureName("magicasmod:Log").setHardness(wood).setStepSound(woodStep);
		blockLeaf = new MagicasLeaf().setBlockName("Leaf").setCreativeTab(MagicasTab).setBlockTextureName("magicasmod:Leaf").setHardness(dirt / 5 * 4).setStepSound(grassStep);
		blockSapling = new MagicasSapling().setBlockName("Sapling").setCreativeTab(MagicasTab).setBlockTextureName("magicasmod:Sapling").setStepSound(grassStep);
	}

	public static void RegisterBlocks()
	{
		Register(taintedGrass);
		Register(fireEssenceOre);
		Register(waterEssenceOre);
		Register(earthEssenceOre);
		Register(airEssenceOre);
		Register(EssenceExtractorIdle);
		Register(EssenceExtractorActive);
		Register(EssenceCombinerIdle);
		Register(EssenceCombinerActive);
		Register(EssenceInfuserIdle);
		Register(EssenceInfuserActive);
		GameRegistry.registerBlock(blockLog, ItemLogBlocks.class, blockLog.getUnlocalizedName());
		GameRegistry.registerBlock(blockLeaf, ItemLeafBlocks.class, blockLeaf.getUnlocalizedName());
		GameRegistry.registerBlock(blockSapling, ItemSaplingBlocks.class, blockSapling.getUnlocalizedName());
	}

	private static void Register(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
}
