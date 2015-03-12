package net.gammas.magicas.tileentites;

import cpw.mods.fml.common.registry.GameRegistry;

public class MagicasTileEntities 
{
	public static void InitTileEntities()
	{
		
	}
	
	public static void RegisterTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityEssenceExtractor.class, "EssenceExtractor");
		GameRegistry.registerTileEntity(TileEntityEssenceCombiner.class, "EssenceCombiner");
		GameRegistry.registerTileEntity(TileEntityEssenceInfuser.class, "EssenceInfuser");
	}
}
