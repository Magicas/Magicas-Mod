package net.gammas.magicas.util;

import net.gammas.magicas.models.TileEntityEssenceExtractorRenderer;
import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEssenceExtractor.class, new TileEntityEssenceExtractorRenderer());
	}
}
