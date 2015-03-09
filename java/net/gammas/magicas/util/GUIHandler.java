package net.gammas.magicas.util;

import net.gammas.magicas.GUI.GUIEssenceCombiner;
import net.gammas.magicas.GUI.GUIEssenceExtractor;
import net.gammas.magicas.blocks.MagicasBlocks;
import net.gammas.magicas.container.ContainerEssenceCombiner;
import net.gammas.magicas.container.ContainerEssenceExtractor;
import net.gammas.magicas.tileentites.TileEntityEssenceCombiner;
import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null)
		{
			switch(ID)
			{
			case MagicasBlocks.GuiIDEssenceExtractor:
				if (entity instanceof TileEntityEssenceExtractor)
				{
					return new ContainerEssenceExtractor(player.inventory, (TileEntityEssenceExtractor) entity);
				}
				return null;
			case MagicasBlocks.GuiIDEssenceCombiner:
				if (entity instanceof TileEntityEssenceCombiner)
				{
					return new ContainerEssenceCombiner(player.inventory, (TileEntityEssenceCombiner) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if (entity != null)
		{
			switch(ID)
			{
			case MagicasBlocks.GuiIDEssenceExtractor:
				if (entity instanceof TileEntityEssenceExtractor)
				{
					return new GUIEssenceExtractor(player.inventory, (TileEntityEssenceExtractor) entity);
				}
				return null;
			case MagicasBlocks.GuiIDEssenceCombiner:
				if (entity instanceof TileEntityEssenceCombiner)
				{
					return new GUIEssenceCombiner(player.inventory, (TileEntityEssenceCombiner) entity);
				}
				return null;
			}
		}
		return null;
	}
	
}
