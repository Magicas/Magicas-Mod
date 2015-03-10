package net.gammas.magicas.util;

import net.gammas.magicas.blocks.MagicasBlocks;
import net.gammas.magicas.models.ItemRendererEssenceExtractor;
import net.gammas.magicas.models.TileEntityEssenceExtractorRenderer;
import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEssenceExtractor.class, new TileEntityEssenceExtractorRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MagicasBlocks.EssenceExtractorIdle), new ItemRendererEssenceExtractor(new TileEntityEssenceExtractorRenderer(), new TileEntityEssenceExtractor()));
	}
}
