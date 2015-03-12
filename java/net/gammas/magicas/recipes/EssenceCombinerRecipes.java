package net.gammas.magicas.recipes;

import net.gammas.magicas.items.MagicasItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EssenceCombinerRecipes
{

	public EssenceCombinerRecipes()
	{

	}

	public static ItemStack getRecipe(Item item, Item item2)
	{
		return getOutput(item, item2);
	}

	public static ItemStack getOutput(Item item, Item item2)
	{
		if (item == MagicasItems.fireEssenceShard && item2 == MagicasItems.waterEssenceShard)
			return new ItemStack(MagicasItems.steamEssenceShard, 1);

		if (item == MagicasItems.waterEssenceShard && item2 == MagicasItems.fireEssenceShard)
			return new ItemStack(MagicasItems.steamEssenceShard, 1);

		if (item == MagicasItems.fireEssenceShard && item2 == MagicasItems.earthEssenceShard)
			return new ItemStack(MagicasItems.lavaEssenceShard, 1);

		if (item == MagicasItems.earthEssenceShard && item2 == MagicasItems.fireEssenceShard)
			return new ItemStack(MagicasItems.lavaEssenceShard, 1);
		
		if (item == MagicasItems.waterEssenceShard && item2 == MagicasItems.earthEssenceShard)
			return new ItemStack(MagicasItems.lifeEssenceShard, 1);

		if (item == MagicasItems.earthEssenceShard && item2 == MagicasItems.waterEssenceShard)
			return new ItemStack(MagicasItems.lifeEssenceShard, 1);
		
		if (item == MagicasItems.fireEssenceShard && item2 == MagicasItems.lifeEssenceShard)
			return new ItemStack(MagicasItems.deathEssenceShard, 1);

		if (item == MagicasItems.lifeEssenceShard && item2 == MagicasItems.fireEssenceShard)
			return new ItemStack(MagicasItems.deathEssenceShard, 1);

		return null;
	}

}
