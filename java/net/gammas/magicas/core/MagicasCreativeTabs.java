package net.gammas.magicas.core;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MagicasCreativeTabs 
{
	public static CreativeTabs creativeTabMagicas;
	
	public static void InitCreativeTabs()
	{
		creativeTabMagicas = new CreativeTabs("magicasTab")
		{
			
			@Override
			public Item getTabIconItem()
			{
				return MagicasItems.magicWandBlue;
			}
		};
	}
	
}
