package net.gammas.magicas.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.gammas.magicas.core.MagicasMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class MagicasBlocks 
{
	
	public static Block taintedGrass;
	
	public static void InitBlocks()
	{
		taintedGrass = new BlockTaintedGrass().setBlockName("taintedgrass").setCreativeTab(MagicasMod.creativeTabMagicas);
	}
	
	public static void RegisterBlocks()
	{
		GameRegistry.registerBlock(taintedGrass, taintedGrass.getUnlocalizedName());
		LanguageRegistry.addName(taintedGrass, "Tainted Grass");
	}
}
