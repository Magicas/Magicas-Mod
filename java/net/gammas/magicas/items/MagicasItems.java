package net.gammas.magicas.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.gammas.magicas.core.MagicasCreativeTabs;
import net.gammas.magicas.core.MagicasMod;
import net.minecraft.item.Item;

public class MagicasItems 
{
	// Magic Wands
	public static Item magicWandBlue;
	public static Item magicWandGreen;
	public static Item magicWandOrange;
	
	// Essence
	public static Item fireEssence;
	public static Item waterEssence;
	public static Item earthEssence;
	public static Item airEssence;
	
	// Bottle Of Essence
	public static Item bottleOfFireEssence;
	public static Item bottleOfWaterEssence;
	public static Item bottleOfEarthEssence;
	public static Item bottleOfAirEssence;
	
	public static void InitItems()
	{
		// Magic Wands
		magicWandBlue = new ItemMagicWand(2).setUnlocalizedName("MagicWandBlue").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:MagicWandBlue");
		magicWandGreen = new ItemMagicWand(3).setUnlocalizedName("MagicWandGreen").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:MagicWandGreen");
		magicWandOrange = new ItemMagicWand(5).setUnlocalizedName("MagicWandOrange").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:MagicWandOrange");
		
		// Essence
		fireEssence = new ItemEssence().setUnlocalizedName("FireEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:FireEssence");
		waterEssence = new ItemEssence().setUnlocalizedName("WaterEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:WaterEssence");
		earthEssence = new ItemEssence().setUnlocalizedName("EarthEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:EarthEssence");
		airEssence = new ItemEssence().setUnlocalizedName("AirEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:AirEssence");
		
		// Bottle Of Essence
		bottleOfFireEssence = new ItemEssence().setUnlocalizedName("BottleOfFireEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:BottleOfFireEssence");
		bottleOfWaterEssence = new ItemEssence().setUnlocalizedName("BottleOfWaterEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:BottleOfWaterEssence");
		bottleOfEarthEssence = new ItemEssence().setUnlocalizedName("BottleOfEarthEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:BottleOfEarthEssence");
		bottleOfAirEssence = new ItemEssence().setUnlocalizedName("BottleOfAirEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:BottleOfAirEssence");
	}
	
	public static void RegisterItems()
	{
		
		// Game Registry
		GameRegistry.registerItem(magicWandBlue, magicWandBlue.getUnlocalizedName());
		GameRegistry.registerItem(magicWandGreen, magicWandGreen.getUnlocalizedName());
		GameRegistry.registerItem(magicWandOrange, magicWandOrange.getUnlocalizedName());
		GameRegistry.registerItem(fireEssence, fireEssence.getUnlocalizedName());
		GameRegistry.registerItem(waterEssence, waterEssence.getUnlocalizedName());
		GameRegistry.registerItem(earthEssence, earthEssence.getUnlocalizedName());
		GameRegistry.registerItem(airEssence, airEssence.getUnlocalizedName());
		GameRegistry.registerItem(bottleOfFireEssence, bottleOfFireEssence.getUnlocalizedName());
		GameRegistry.registerItem(bottleOfWaterEssence, bottleOfWaterEssence.getUnlocalizedName());
		GameRegistry.registerItem(bottleOfEarthEssence, bottleOfEarthEssence.getUnlocalizedName());
		GameRegistry.registerItem(bottleOfAirEssence, bottleOfAirEssence.getUnlocalizedName());
	}
}
