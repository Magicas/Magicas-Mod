package net.gammas.magicas.recipes;

import net.gammas.magicas.items.MagicasItems;
import net.gammas.magicas.util.ContainerHelp;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class EssenceInfuserRecipes
{

	public EssenceInfuserRecipes()
	{

	}

	public static ItemStack getRecipe(ItemStack item, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5)
	{
		return getOutput(item.getItem(), item2.getItem(), item3.getItem(), item4.getItem(), item5.getItem());
	}

	public static ItemStack getOutput(Item item, Item item2, Item item3, Item item4, Item item5)
	{
		if (item5 == Items.iron_helmet)
		{
			ItemStack newItem = new ItemStack(MagicasItems.ironInfusedHelmet, 1);
			newItem.stackTagCompound = new NBTTagCompound();

			Item[] items = new Item[]
			{ item, item2, item3, item4 };

			for (int i = 0; i < 4; i++)
			{
				if (items[i] != null)
				{
					if (items[i] == MagicasItems.fireEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("FireInfused", true);
					}

					if (items[i] == MagicasItems.waterEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("WaterInfused", true);
					}

					if (items[i] == MagicasItems.earthEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("EarthInfused", true);
					}

					if (items[i] == MagicasItems.airEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("AirInfused", true);
					}

					if (items[i] == MagicasItems.lifeEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LifeInfused", true);
					}

					if (items[i] == MagicasItems.deathEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("DeathInfused", true);
					}

					if (items[i] == MagicasItems.steamEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("SteamInfused", true);
					}

					if (items[i] == MagicasItems.lavaEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LavaInfused", true);
					}
				}
			}

			return newItem;
		}

		if (item5 == Items.iron_chestplate)
		{
			ItemStack newItem = new ItemStack(MagicasItems.ironInfusedChestplate, 1);
			newItem.stackTagCompound = new NBTTagCompound();

			Item[] items = new Item[]
			{ item, item2, item3, item4 };

			for (int i = 0; i < 4; i++)
			{
				if (items[i] != null)
				{
					if (items[i] == MagicasItems.fireEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("FireInfused", true);
					}

					if (items[i] == MagicasItems.waterEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("WaterInfused", true);
					}

					if (items[i] == MagicasItems.earthEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("EarthInfused", true);
					}

					if (items[i] == MagicasItems.airEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("AirInfused", true);
					}

					if (items[i] == MagicasItems.lifeEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LifeInfused", true);
					}

					if (items[i] == MagicasItems.deathEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("DeathInfused", true);
					}

					if (items[i] == MagicasItems.steamEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("SteamInfused", true);
					}

					if (items[i] == MagicasItems.lavaEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LavaInfused", true);
					}
				}
			}

			return newItem;
		}

		if (item5 == Items.iron_leggings)
		{
			ItemStack newItem = new ItemStack(MagicasItems.ironInfusedLeggings, 1);
			newItem.stackTagCompound = new NBTTagCompound();

			Item[] items = new Item[]
			{ item, item2, item3, item4 };

			for (int i = 0; i < 4; i++)
			{
				if (items[i] != null)
				{
					if (items[i] == MagicasItems.fireEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("FireInfused", true);
					}

					if (items[i] == MagicasItems.waterEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("WaterInfused", true);
					}

					if (items[i] == MagicasItems.earthEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("EarthInfused", true);
					}

					if (items[i] == MagicasItems.airEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("AirInfused", true);
					}

					if (items[i] == MagicasItems.lifeEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LifeInfused", true);
					}

					if (items[i] == MagicasItems.deathEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("DeathInfused", true);
					}

					if (items[i] == MagicasItems.steamEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("SteamInfused", true);
					}

					if (items[i] == MagicasItems.lavaEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LavaInfused", true);
					}
				}
			}

			return newItem;
		}

		if (item5 == Items.iron_boots)
		{
			ItemStack newItem = new ItemStack(MagicasItems.ironInfusedBoots, 1);
			newItem.stackTagCompound = new NBTTagCompound();

			Item[] items = new Item[]
			{ item, item2, item3, item4 };

			for (int i = 0; i < 4; i++)
			{
				if (items[i] != null)
				{
					if (items[i] == MagicasItems.fireEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("FireInfused", true);
					}

					if (items[i] == MagicasItems.waterEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("WaterInfused", true);
					}

					if (items[i] == MagicasItems.earthEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("EarthInfused", true);
					}

					if (items[i] == MagicasItems.airEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("AirInfused", true);
					}

					if (items[i] == MagicasItems.lifeEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LifeInfused", true);
					}

					if (items[i] == MagicasItems.deathEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("DeathInfused", true);
					}

					if (items[i] == MagicasItems.steamEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("SteamInfused", true);
					}

					if (items[i] == MagicasItems.lavaEssenceShard)
					{
						newItem.stackTagCompound.setBoolean("LavaInfused", true);
					}
				}
			}

			return newItem;
		}

		return null;
	}
}
