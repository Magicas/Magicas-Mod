package net.gammas.magicas.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EssenceExtractor extends BlockContainer
{

	private boolean isActive;
	
	public EssenceExtractor(boolean isActive) 
	{
		super(Material.iron);
		this.isActive = isActive;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) 
	{
		return null;
	}

}
