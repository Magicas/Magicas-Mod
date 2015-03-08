package net.gammas.magicas.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class MagicasWorld 
{
	public static void InitWorld()
	{
		RegisterWorldGen(new MagicasWorldGen(), 1);
	}
	
	public static void RegisterWorldGen(IWorldGenerator WorldGen, int prioity)
	{
		GameRegistry.registerWorldGenerator(WorldGen, prioity);
	}
}
