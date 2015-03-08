package net.gammas.magicas.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.gammas.magicas.core.MagicasMod;
import net.minecraft.item.Item;

public class MagicasItems 
{
	
	public static Item magicWandBlue;
	public static Item magicWandGreen;
	public static Item magicWandOrange;
	
	public static void InitItems()
	{
		// Magic Wands
		magicWandBlue = new ItemMagicWand(2).setUnlocalizedName("MagicWandBlue").setCreativeTab(MagicasMod.creativeTabMagicas).setTextureName("magicasmod:MagicWandBlue");
		magicWandGreen = new ItemMagicWand(3).setUnlocalizedName("MagicWandGreen").setCreativeTab(MagicasMod.creativeTabMagicas).setTextureName("magicasmod:MagicWandGreen");
		magicWandOrange = new ItemMagicWand(5).setUnlocalizedName("MagicWandOrange").setCreativeTab(MagicasMod.creativeTabMagicas).setTextureName("magicasmod:MagicWandOrange");
	}
	
	public static void RegisterItems()
	{
		
		// Game Registry
		GameRegistry.registerItem(magicWandBlue, magicWandBlue.getUnlocalizedName());
		GameRegistry.registerItem(magicWandGreen, magicWandGreen.getUnlocalizedName());
		GameRegistry.registerItem(magicWandOrange, magicWandOrange.getUnlocalizedName());
		
		// Magic Wands
		LanguageRegistry.addName(magicWandBlue, "Blue Magic Wand");
		LanguageRegistry.addName(magicWandGreen, "Green Magic Wand");
		LanguageRegistry.addName(magicWandOrange, "Orange Magic Wand");
	}
}
