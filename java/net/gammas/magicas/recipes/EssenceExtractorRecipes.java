package net.gammas.magicas.recipes;

import net.gammas.magicas.items.MagicasItems;
import net.gammas.magicas.util.ContainerHelp;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class EssenceExtractorRecipes
{

	public EssenceExtractorRecipes()
	{

	}

	public static ItemStack getRecipe(Item item, Item item2, Item item3)
	{
		return getOutput(item, item2, item3);
	}

	public static ItemStack getOutput(Item item, Item item2, Item item3)
	{

		if (ContainerHelp.isHammer(item) && ContainerHelp.isChisel(item2))
		{
			if (item3 == MagicasItems.fireEssenceChunk)
			{
				return new ItemStack(MagicasItems.fireEssenceShard, 1);
			}

			if (item3 == MagicasItems.waterEssenceChunk)
			{
				return new ItemStack(MagicasItems.waterEssenceShard, 1);
			}

			if (item3 == MagicasItems.earthEssenceChunk)
			{
				return new ItemStack(MagicasItems.earthEssenceShard, 1);
			}

			if (item3 == MagicasItems.airEssenceChunk)
			{
				return new ItemStack(MagicasItems.airEssenceShard, 1);
			}

			if (item3 == Items.gunpowder)
			{
				return new ItemStack(MagicasItems.gunpowderEssenceShard, 1);
			}

			if (item3 == Item.getItemFromBlock(Blocks.obsidian))
			{
				return new ItemStack(MagicasItems.obsidianEssenceShard, 1);
			}

			return null;
		}

		return null;
	}
}
