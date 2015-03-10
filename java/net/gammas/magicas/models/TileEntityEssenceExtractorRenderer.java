package net.gammas.magicas.models;

import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class TileEntityEssenceExtractorRenderer extends TileEntitySpecialRenderer
{

	// The model of your block
	private final ModelEssenceExtractor model;
	private EntityItem entItem = null;
	private EntityItem entItem2 = null;
	private EntityItem entItem3 = null;

	public TileEntityEssenceExtractorRenderer()
	{
		this.model = new ModelEssenceExtractor();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		ResourceLocation texture = new ResourceLocation("magicasmod" + ":" + "textures/blocks/EssenceExtractor.png");
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

		int slot = 0;
		int slot2 = 1;
		int slot3 = 2;
		TileEntityEssenceExtractor tileEntity = (TileEntityEssenceExtractor) te;
		if (tileEntity.getStackInSlot(slot) != null)
		{
			if ((entItem == null) || entItem.getEntityItem().getItem() != tileEntity.getStackInSlot(slot).getItem())
				entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, new ItemStack(tileEntity.getStackInSlot(slot).getItem(), 1));

			GL11.glPushMatrix();
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0, 1, 0);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0, -1.1, -.20, 0, 0);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();

		}
		
		if (tileEntity.getStackInSlot(slot2) != null)
		{
			if ((entItem == null) || entItem.getEntityItem().getItem() != tileEntity.getStackInSlot(slot2).getItem())
				entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, new ItemStack(tileEntity.getStackInSlot(slot2).getItem(), 1));

			GL11.glPushMatrix();
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(0, 0, 1, 0);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0, -1.14, -.20, 0, 0);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
		}
		
		if (tileEntity.getStackInSlot(slot3) != null)
		{
			if ((entItem == null) || entItem.getEntityItem().getItem() != tileEntity.getStackInSlot(slot3).getItem())
				entItem = new EntityItem(tileEntity.getWorldObj(), x, y, z, new ItemStack(tileEntity.getStackInSlot(slot3).getItem(), 1));

			GL11.glPushMatrix();
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0, 1, 1);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0, -.20, -.48, 0, 0);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();

		}
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block)
	{
		Tessellator tess = Tessellator.instance;
		float brightness = block.getLightValue(world, i, j, k);
		int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int modulousModifier = skyLight % 65536;
		int divModifier = skyLight / 65536;
		tess.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
	}
}
