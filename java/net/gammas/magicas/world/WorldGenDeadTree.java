package net.gammas.magicas.world;

import java.util.Random;

import net.gammas.magicas.blocks.MagicasBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenDeadTree extends WorldGenAbstractTree
{
	private final int minTreeHeight;
	private final int randomTreeHeight;

	private final boolean vinesGrow;

	private final Block wood;
	private final Block leaves;

	private final int metaWood;
	private final int metaLeaves;

	public WorldGenDeadTree(Block wood, Block leaves, int metaWood, int metaLeaves)
	{
		this(wood, leaves, metaWood, metaLeaves, false, 4, 3, false);
	}

	public WorldGenDeadTree(Block wood, Block leaves, int metaWood, int metaLeaves, boolean doBlockNotify, int minTreeHeight, int randomTreeHeight, boolean vinesGrow)
	{
		super(doBlockNotify);
		this.wood = wood;
		this.leaves = leaves;

		this.minTreeHeight = minTreeHeight;
		this.randomTreeHeight = randomTreeHeight;

		this.metaWood = metaWood;
		this.metaLeaves = metaLeaves;
		this.vinesGrow = vinesGrow;
	}

	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int l = random.nextInt(3) + this.minTreeHeight;
		boolean flag = true;

		if (y >= 1 && y + l + 1 <= 256)
		{
			byte b0;
			int k1;
			Block block;

			for (int i1 = y; i1 <= y + 1 + l; ++i1)
			{
				b0 = 1;

				if (i1 == y)
				{
					b0 = 0;
				}

				if (i1 >= y + 1 + l - 2)
				{
					b0 = 2;
				}

				for (int j1 = x - b0; j1 <= x + b0 && flag; ++j1)
				{
					for (k1 = z - b0; k1 <= z + b0 && flag; ++k1)
					{
						if (i1 >= 0 && i1 < 256)
						{
							block = world.getBlock(j1, i1, k1);

							if (!this.isReplaceable(world, j1, i1, k1))
							{
								flag = false;
							}
						}
						else
						{
							flag = false;
						}
					}
				}
			}

			if (!flag)
			{
				return false;
			}
			else
			{
				Block block2 = world.getBlock(x, y - 1, z);

				boolean isSoil = block2.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockSapling) MagicasBlocks.blockSapling);
				if (isSoil && y < 256 - l - 1)
				{
					block2.onPlantGrow(world, x, y - 1, z, x, y, z);
					b0 = 3;
					byte b1 = 0;
					int l1;
					int i2;
					int j2;
					int i3;

					for (k1 = y - b0 + l; k1 <= y + l; ++k1)
					{
						i3 = k1 - (y + l);
						l1 = b1 + 1 - i3 / 2;

						for (i2 = x - l1; i2 <= x + l1; ++i2)
						{
							j2 = i2 - x;

							for (int k2 = z - l1; k2 <= z + l1; ++k2)
							{
								int l2 = k2 - z;

								if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || random.nextInt(2) != 0 && i3 != 0)
								{
									Block block1 = world.getBlock(i2, k1, k2);

									if (block1.isAir(world, i2, k1, k2) || block1.isLeaves(world, i2, k1, k2))
									{
										this.setBlockAndNotifyAdequately(world, i2, k1, k2, MagicasBlocks.blockLeaf, this.metaLeaves);
									}
								}
							}
						}
					}

					for (k1 = 0; k1 < l; ++k1)
					{
						block = world.getBlock(x, y + k1, z);

						if (block.isAir(world, x, y + k1, z) || block.isLeaves(world, x, y + k1, z))
						{
							this.setBlockAndNotifyAdequately(world, x, y + k1, z, MagicasBlocks.blockLog, this.metaWood);

							if (this.vinesGrow && k1 > 0)
							{
								if (random.nextInt(3) > 0 && world.isAirBlock(x - 1, y + k1, z))
								{
									this.setBlockAndNotifyAdequately(world, x - 1, y + k1, z, Blocks.vine, 8);
								}

								if (random.nextInt(3) > 0 && world.isAirBlock(x + 1, y + k1, z))
								{
									this.setBlockAndNotifyAdequately(world, x + 1, y + k1, z, Blocks.vine, 2);
								}

								if (random.nextInt(3) > 0 && world.isAirBlock(x, y + k1, z - 1))
								{
									this.setBlockAndNotifyAdequately(world, x, y + k1, z - 1, Blocks.vine, 1);
								}

								if (random.nextInt(3) > 0 && world.isAirBlock(x, y + k1, z + 1))
								{
									this.setBlockAndNotifyAdequately(world, x, y + k1, z + 1, Blocks.vine, 4);
								}
							}
						}
					}

					if (this.vinesGrow)
					{
						for (k1 = y - 3 + l; k1 <= y + l; ++k1)
						{
							i3 = k1 - (y + l);
							l1 = 2 - i3 / 2;

							for (i2 = x - l1; i2 <= x + l1; ++i2)
							{
								for (j2 = z - l1; j2 <= z + l1; ++j2)
								{
									if (world.getBlock(i2, k1, j2).isLeaves(world, i2, k1, j2))
									{
										if (random.nextInt(4) == 0 && world.getBlock(i2 - 1, k1, j2).isAir(world, i2 - 1, k1, j2))
										{
											this.growVines(world, i2 - 1, k1, j2, 8);
										}

										if (random.nextInt(4) == 0 && world.getBlock(i2 + 1, k1, j2).isAir(world, i2 + 1, k1, j2))
										{
											this.growVines(world, i2 + 1, k1, j2, 2);
										}

										if (random.nextInt(4) == 0 && world.getBlock(i2, k1, j2 - 1).isAir(world, i2, k1, j2 - 1))
										{
											this.growVines(world, i2, k1, j2 - 1, 1);
										}

										if (random.nextInt(4) == 0 && world.getBlock(i2, k1, j2 + 1).isAir(world, i2, k1, j2 + 1))
										{
											this.growVines(world, i2, k1, j2 + 1, 4);
										}
									}
								}
							}
						}

						if (random.nextInt(5) == 0 && l > 5)
						{
							for (k1 = 0; k1 < 2; ++k1)
							{
								for (i3 = 0; i3 < 4; ++i3)
								{
									if (random.nextInt(4 - k1) == 0)
									{
										l1 = random.nextInt(3);
										this.setBlockAndNotifyAdequately(world, x + Direction.offsetX[Direction.rotateOpposite[i3]], y + l - 5 + k1, z + Direction.offsetZ[Direction.rotateOpposite[i3]], Blocks.cocoa, l1 << 2 | i3);
									}
								}
							}
						}
					}

					return true;
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 * Grows vines downward from the given block for a given length. Args:
	 * World, x, starty, z, vine-length
	 */
	private void growVines(World p_76529_1_, int p_76529_2_, int p_76529_3_, int p_76529_4_, int p_76529_5_)
	{
		this.setBlockAndNotifyAdequately(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Blocks.vine, p_76529_5_);
		int i1 = 4;

		while (true)
		{
			--p_76529_3_;

			if (!p_76529_1_.getBlock(p_76529_2_, p_76529_3_, p_76529_4_).isAir(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_) || i1 <= 0)
			{
				return;
			}

			this.setBlockAndNotifyAdequately(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Blocks.vine, p_76529_5_);
			--i1;
		}
	}
}