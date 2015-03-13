package net.gammas.magicas.world;

import java.util.Random;

import net.gammas.magicas.blocks.MagicasBlocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MagicasWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case -1:
			GenerateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			GenerateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void GenerateNether(World world, Random random, int chunkX, int chunkZ)
	{

	}

	private void GenerateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 24; i++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(24);
			int randPosZ = chunkZ + random.nextInt(16);

			(new WorldGenMinable(MagicasBlocks.fireEssenceOre, 3)).generate(world, random, randPosX, randPosY, randPosZ);
		}

		for (int i = 0; i < 24; i++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(54);
			int randPosZ = chunkZ + random.nextInt(16);

			if (world.getBiomeGenForCoords(randPosX, randPosZ) == BiomeGenBase.river || world.getBiomeGenForCoords(randPosX, randPosZ) == BiomeGenBase.ocean || world.getBiomeGenForCoords(randPosX, randPosZ) == BiomeGenBase.deepOcean)
			{
				(new WorldGenMinable(MagicasBlocks.waterEssenceOre, 3)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}

		for (int i = 0; i < 24; i++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(64);
			int randPosZ = chunkZ + random.nextInt(16);

			(new WorldGenMinable(MagicasBlocks.earthEssenceOre, 3)).generate(world, random, randPosX, randPosY, randPosZ);
		}

		for (int i = 0; i < 24; i++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(64) + 64;
			int randPosZ = chunkZ + random.nextInt(16);

			(new WorldGenMinable(MagicasBlocks.airEssenceOre, 3)).generate(world, random, randPosX, randPosY, randPosZ);
		}
	}

}
