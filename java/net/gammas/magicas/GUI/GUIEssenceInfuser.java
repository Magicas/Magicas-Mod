package net.gammas.magicas.GUI;

import net.gammas.magicas.container.ContainerEssenceInfuser;
import net.gammas.magicas.tileentites.TileEntityEssenceInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GUIEssenceInfuser extends GuiContainer
{

	private ResourceLocation texture = new ResourceLocation("magicasmod" + ":" + "textures/gui/EssenceInfuser.png");
	private TileEntityEssenceInfuser essenceInfuser;

	public GUIEssenceInfuser(InventoryPlayer inv, TileEntityEssenceInfuser entity)
	{
		super(new ContainerEssenceInfuser(inv, entity));
		essenceInfuser = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
		String s = this.essenceInfuser.hasCustomInventoryName() ? this.essenceInfuser.getInventoryName() : I18n.format(this.essenceInfuser.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(s, this.xSize / 4 - this.fontRendererObj.getStringWidth(s), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.essenceInfuser.isInfusing)
		{
			int i1 = this.essenceInfuser.getExtractingProcessScaled(69);
			this.drawTexturedModalRect(k + 126, l + 76 - i1, 0, 69 - i1, 7, i1 + 2);
		}

	}

}
