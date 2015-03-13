package net.gammas.magicas.models;

import org.lwjgl.opengl.GL11;

import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemRendererEssenceExtractor implements IItemRenderer
{

	private TileEntitySpecialRenderer render;
	private TileEntity entity;

	public ItemRendererEssenceExtractor(TileEntitySpecialRenderer render, TileEntity entity)
	{
		this.render = render;
		this.entity = entity;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		if (type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		GL11.glScalef(1F, 1F, 1F);
		this.render.renderTileEntityAt(entity, 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
