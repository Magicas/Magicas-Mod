package net.gammas.magicas.items;

import net.gammas.magicas.core.MagicasCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class MagicasItems
{
	private static CreativeTabs MagicasTab = MagicasCreativeTabs.creativeTabMagicas;

	// Armour
	public static Item ironInfusedHelmet;
	public static Item ironInfusedChestplate;
	public static Item ironInfusedLeggings;
	public static Item ironInfusedBoots;

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
	public static Item steamEssenceShard; // Fire + Water, Energy + Water
	public static Item lavaEssenceShard; // Earth + Fire
	public static Item dustEssenceShard; // Air + Earth
	public static Item energyEssenceShard; // Air + Fire
	public static Item dirtEssenceShard; // Earth + Water

	// Level 3
	public static Item lifeEssenceShard;
	public static Item deathEssenceShard;
	public static Item gunpowderEssenceShard; // Dust + Fire
	public static Item stoneEssenceShard; // Lava + Air
	public static Item obsidianEssenceShard; // Lava + Water

	// Level 4
	public static Item lightEssence;

	public static void InitItems()
	{

		// Armour
		ironInfusedHelmet = new ArmourInfusedIron(ArmorMaterial.IRON, 0, 0).setUnlocalizedName("IronInfusedHelmet").setCreativeTab(MagicasTab);
		ironInfusedChestplate = new ArmourInfusedIron(ArmorMaterial.IRON, 0, 1).setUnlocalizedName("IronInfusedChestplate").setCreativeTab(MagicasTab);
		ironInfusedLeggings = new ArmourInfusedIron(ArmorMaterial.IRON, 0, 2).setUnlocalizedName("IronInfusedLeggings").setCreativeTab(MagicasTab);
		ironInfusedBoots = new ArmourInfusedIron(ArmorMaterial.IRON, 0, 3).setUnlocalizedName("IronInfusedBoots").setCreativeTab(MagicasTab);

		// Magic Wands
		magicWandBlue = new ItemMagicWand(2).setUnlocalizedName("MagicWandBlue").setCreativeTab(MagicasTab);
		magicWandGreen = new ItemMagicWand(3).setUnlocalizedName("MagicWandGreen").setCreativeTab(MagicasTab);
		magicWandOrange = new ItemMagicWand(5).setUnlocalizedName("MagicWandOrange").setCreativeTab(MagicasTab);

		// Tools
		stoneHammer = new ItemHammer(25).setUnlocalizedName("StoneHammer").setCreativeTab(MagicasTab);
		stoneChisel = new ItemChisel(13).setUnlocalizedName("StoneChisel").setCreativeTab(MagicasTab);
		ironHammer = new ItemHammer(100).setUnlocalizedName("IronHammer").setCreativeTab(MagicasTab);
		ironChisel = new ItemChisel(52).setUnlocalizedName("IronChisel").setCreativeTab(MagicasTab);
		diamondHammer = new ItemHammer(2000).setUnlocalizedName("DiamondHammer").setCreativeTab(MagicasTab);
		diamondChisel = new ItemChisel(1040).setUnlocalizedName("DiamondChisel").setCreativeTab(MagicasTab);

		// Essence

		// Chunks
		fireEssenceChunk = new ItemEssence().setUnlocalizedName("FireEssenceChunk").setCreativeTab(MagicasTab);
		waterEssenceChunk = new ItemEssence().setUnlocalizedName("WaterEssenceChunk").setCreativeTab(MagicasTab);
		earthEssenceChunk = new ItemEssence().setUnlocalizedName("EarthEssenceChunk").setCreativeTab(MagicasTab);
		airEssenceChunk = new ItemEssence().setUnlocalizedName("AirEssenceChunk").setCreativeTab(MagicasTab);

		// Shards

		// Level 1
		fireEssenceShard = new ItemEssence().setUnlocalizedName("FireEssenceShard").setCreativeTab(MagicasTab);
		waterEssenceShard = new ItemEssence().setUnlocalizedName("WaterEssenceShard").setCreativeTab(MagicasTab);
		earthEssenceShard = new ItemEssence().setUnlocalizedName("EarthEssenceShard").setCreativeTab(MagicasTab);
		airEssenceShard = new ItemEssence().setUnlocalizedName("AirEssenceShard").setCreativeTab(MagicasTab);

		// Level 2
		steamEssenceShard = new ItemEssence().setUnlocalizedName("SteamEssenceShard").setCreativeTab(MagicasTab);
		lavaEssenceShard = new ItemEssence().setUnlocalizedName("LavaEssenceShard").setCreativeTab(MagicasTab);
		dustEssenceShard = new ItemEssence().setUnlocalizedName("DustEssenceShard").setCreativeTab(MagicasTab);
		energyEssenceShard = new ItemEssence().setUnlocalizedName("EnergyEssenceShard").setCreativeTab(MagicasTab);
		dirtEssenceShard = new ItemEssence().setUnlocalizedName("DirtEssenceShard").setCreativeTab(MagicasTab);

		// Level 3
		gunpowderEssenceShard = new ItemEssence().setUnlocalizedName("GunpowderEssenceShard").setCreativeTab(MagicasTab);
		stoneEssenceShard = new ItemEssence().setUnlocalizedName("StoneEssenceShard").setCreativeTab(MagicasTab);
		obsidianEssenceShard = new ItemEssence().setUnlocalizedName("ObsidianEssenceShard").setCreativeTab(MagicasTab);
		
		// TODO LEVEL THESE ESSENCE SHARDS
		lifeEssenceShard = new ItemEssence().setUnlocalizedName("LifeEssenceShard").setCreativeTab(MagicasTab);
		deathEssenceShard = new ItemEssence().setUnlocalizedName("DeathEssenceShard").setCreativeTab(MagicasTab);
	}

	public static void RegisterItems()
	{
		// Armour
		Register(ironInfusedHelmet);
		Register(ironInfusedChestplate);
		Register(ironInfusedLeggings);
		Register(ironInfusedBoots);

		// Wands
		Register(magicWandBlue);
		Register(magicWandGreen);
		Register(magicWandOrange);

		// Shards
		Register(fireEssenceShard);
		Register(waterEssenceShard);
		Register(earthEssenceShard);
		Register(airEssenceShard);
		Register(steamEssenceShard);
		Register(lavaEssenceShard);
		Register(lifeEssenceShard);
		Register(deathEssenceShard);
		Register(gunpowderEssenceShard);
		Register(steamEssenceShard);
		Register(obsidianEssenceShard);

		// Chunks
		Register(fireEssenceChunk);
		Register(waterEssenceChunk);
		Register(earthEssenceChunk);
		Register(airEssenceChunk);

		// Tools
		Register(stoneHammer);
		Register(stoneChisel);
		Register(ironHammer);
		Register(ironChisel);
		Register(diamondHammer);
		Register(diamondChisel);
	}

	private static void Register(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
}
