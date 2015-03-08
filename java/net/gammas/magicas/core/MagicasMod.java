package net.gammas.magicas.core;

import net.gammas.magicas.blocks.MagicasBlocks;
import net.gammas.magicas.items.MagicasItems;
import net.gammas.magicas.tileentites.MagicasTileEntities;
import net.gammas.magicas.util.CommonProxy;
import net.gammas.magicas.util.GUIHandler;
import net.gammas.magicas.util.Referances;
import net.gammas.magicas.world.MagicasWorld;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Referances.MODID, name = Referances.MODNAME, version = Referances.VERSION)
public class MagicasMod 
{
	//@SidedProxy(clientSide = "net.gammas.magicas.util.ClientProxy", serverSide = "net.gammas.magicas.util.CommonProxy")
	//public static CommonProxy proxy;
	
	@Instance(Referances.MODID)
	public static MagicasMod instance;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		MagicasCreativeTabs.InitCreativeTabs();
		MagicasItems.InitItems();
		MagicasBlocks.InitBlocks();
		MagicasWorld.InitWorld();
		MagicasTileEntities.InitTileEntities();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{		
		MagicasItems.RegisterItems();
		MagicasBlocks.RegisterBlocks();
		MagicasTileEntities.RegisterTileEntities();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		
		//proxy.registerProxies();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}
