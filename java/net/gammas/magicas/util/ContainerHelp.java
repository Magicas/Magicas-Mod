package net.gammas.magicas.util;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ContainerHelp
{

	public static boolean isEssenceChunk(Item item)
	{
		if (item == MagicasItems.fireEssenceChunk)
			return true;
		if (item == MagicasItems.waterEssenceChunk)
			return true;
		if (item == MagicasItems.earthEssenceChunk)
			return true;
		if (item == MagicasItems.airEssenceChunk)
			return true;

		return false;
	}

	public static boolean isEssenceShard(Item item)
	{
		if (item == MagicasItems.fireEssenceShard)
			return true;
		if (item == MagicasItems.waterEssenceShard)
			return true;
		if (item == MagicasItems.earthEssenceShard)
			return true;
		if (item == MagicasItems.airEssenceShard)
			return true;
		if (item == MagicasItems.steamEssenceShard)
			return true;
		if (item == MagicasItems.lavaEssenceShard)
			return true;
		if (item == MagicasItems.lifeEssenceShard)
			return true;
		if (item == MagicasItems.deathEssenceShard)
			return true;

		return false;
	}

	public static boolean isArmour(Item item)
	{
		if (item == Items.iron_helmet)
			return true;

		if (item == Items.iron_chestplate)
			return true;

		if (item == Items.iron_leggings)
			return true;

		if (item == Items.iron_boots)
			return true;

		return false;
	}

	public static boolean isHammer(Item item)
	{
		if (item == MagicasItems.stoneHammer)
			return true;
		if (item == MagicasItems.ironHammer)
			return true;
		if (item == MagicasItems.diamondHammer)
			return true;

		return false;
	}

	public static boolean isChisel(Item item)
	{
		if (item == MagicasItems.stoneChisel)
			return true;
		if (item == MagicasItems.ironChisel)
			return true;
		if (item == MagicasItems.diamondChisel)
			return true;

		return false;
	}

}
