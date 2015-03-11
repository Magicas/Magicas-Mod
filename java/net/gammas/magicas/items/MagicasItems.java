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
	
	// Tools
	public static Item stoneHammer;
	public static Item stoneChisel;
	public static Item ironHammer;
	public static Item ironChisel;
	public static Item diamondHammer;
	public static Item diamondChisel;
	
	// Essence
	
	// Chunks
	public static Item fireEssenceChunk;
	public static Item waterEssenceChunk;
	public static Item earthEssenceChunk;
	public static Item airEssenceChunk;
	
	// Shards 
	
	// Base
	public static Item fireEssenceShard;
	public static Item waterEssenceShard;
	public static Item earthEssenceShard;
	public static Item airEssenceShard;
	
	// Level 2
	public static Item steamEssence;
	public static Item lavaEssence;
	public static Item mudEssence;
	
	// Level 3
	public static Item explosiveEssence;
	public static Item lifeEssence;
	public static Item deathEssence;
	
	// Level 4
	public static Item lightEssence;
	
	public static void InitItems()
	{
		// Magic Wands
		magicWandBlue = new ItemMagicWand(2).setUnlocalizedName("MagicWandBlue").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:MagicWandBlue");
		magicWandGreen = new ItemMagicWand(3).setUnlocalizedName("MagicWandGreen").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:MagicWandGreen");
		magicWandOrange = new ItemMagicWand(5).setUnlocalizedName("MagicWandOrange").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:MagicWandOrange");
		
		
		// Tools
		stoneHammer = new ItemHammer(25).setUnlocalizedName("StoneHammer").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:StoneHammer");
		stoneChisel = new ItemChisel(13).setUnlocalizedName("StoneChisel").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:StoneChisel");
		ironHammer = new ItemHammer(100).setUnlocalizedName("IronHammer").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:IronHammer");
		ironChisel = new ItemChisel(52).setUnlocalizedName("IronChisel").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:IronChisel");
		diamondHammer = new ItemHammer(2000).setUnlocalizedName("DiamondHammer").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:DiamondHammer");
		diamondChisel = new ItemChisel(1040).setUnlocalizedName("DiamondChisel").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:DiamondChisel");
		
		// Essence
		
		// Chunks
		fireEssenceChunk = new ItemEssence().setUnlocalizedName("FireEssenceChunk").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:FireEssenceChunk");
		waterEssenceChunk = new ItemEssence().setUnlocalizedName("WaterEssenceChunk").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:WaterEssenceChunk");
		earthEssenceChunk = new ItemEssence().setUnlocalizedName("EarthEssenceChunk").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:EarthEssenceChunk");
		airEssenceChunk = new ItemEssence().setUnlocalizedName("AirEssenceChunk").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:AirEssenceChunk");
		
		// Shards
		fireEssenceShard = new ItemEssence().setUnlocalizedName("FireEssenceShard").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:FireEssenceShard");
		waterEssenceShard = new ItemEssence().setUnlocalizedName("WaterEssenceShard").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:WaterEssenceShard");
		earthEssenceShard = new ItemEssence().setUnlocalizedName("EarthEssenceShard").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:EarthEssenceShard");
		airEssenceShard = new ItemEssence().setUnlocalizedName("AirEssenceShard").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:AirEssenceShard");
		steamEssence = new ItemEssence().setUnlocalizedName("SteamEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:SteamEssence");
		lavaEssence = new ItemEssence().setUnlocalizedName("LavaEssence").setCreativeTab(MagicasCreativeTabs.creativeTabMagicas).setTextureName("magicasmod:LavaEssence");
	}
	
	public static void RegisterItems()
	{
		
		// Game Registry
		GameRegistry.registerItem(magicWandBlue, magicWandBlue.getUnlocalizedName());
		GameRegistry.registerItem(magicWandGreen, magicWandGreen.getUnlocalizedName());
		GameRegistry.registerItem(magicWandOrange, magicWandOrange.getUnlocalizedName());
		GameRegistry.registerItem(fireEssenceShard, fireEssenceShard.getUnlocalizedName());
		GameRegistry.registerItem(waterEssenceShard, waterEssenceShard.getUnlocalizedName());
		GameRegistry.registerItem(earthEssenceShard, earthEssenceShard.getUnlocalizedName());
		GameRegistry.registerItem(airEssenceShard, airEssenceShard.getUnlocalizedName());
		GameRegistry.registerItem(fireEssenceChunk, fireEssenceChunk.getUnlocalizedName());
		GameRegistry.registerItem(waterEssenceChunk, waterEssenceChunk.getUnlocalizedName());
		GameRegistry.registerItem(earthEssenceChunk, earthEssenceChunk.getUnlocalizedName());
		GameRegistry.registerItem(airEssenceChunk, airEssenceChunk.getUnlocalizedName());
		GameRegistry.registerItem(steamEssence, steamEssence.getUnlocalizedName());
		GameRegistry.registerItem(lavaEssence, lavaEssence.getUnlocalizedName());
		GameRegistry.registerItem(stoneHammer, stoneHammer.getUnlocalizedName());
		GameRegistry.registerItem(stoneChisel, stoneChisel.getUnlocalizedName());
		GameRegistry.registerItem(ironHammer, ironHammer.getUnlocalizedName());
		GameRegistry.registerItem(ironChisel, ironChisel.getUnlocalizedName());
		GameRegistry.registerItem(diamondHammer, diamondHammer.getUnlocalizedName());
		GameRegistry.registerItem(diamondChisel, diamondChisel.getUnlocalizedName());
	}
}
