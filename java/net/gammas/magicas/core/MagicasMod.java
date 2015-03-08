package net.gammas.magicas.core;

import net.gammas.magicas.blocks.MagicasBlocks;
import net.gammas.magicas.items.MagicasItems;
import net.gammas.magicas.util.CommonProxy;
import net.gammas.magicas.util.Referances;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Referances.MODID, name = Referances.MODNAME, version = Referances.VERSION)
public class MagicasMod 
{
	//@SidedProxy(clientSide = "net.gammas.magicas.util.ClientProxy", serverSide = "net.gammas.magicas.util.CommonProxy")
	//public static CommonProxy proxy;
	
	public static CreativeTabs creativeTabMagicas;
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		creativeTabMagicas = new CreativeTabs("magicasTab")
		{
			
			@Override
			public Item getTabIconItem()
			{
				return MagicasItems.magicWandBlue;
			}
		};
		
		MagicasItems.InitItems();
		MagicasItems.RegisterItems();
		MagicasBlocks.InitBlocks();
		MagicasBlocks.RegisterBlocks();
		
		//proxy.registerProxies();
	}
}
