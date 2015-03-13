package net.gammas.magicas.items;

import java.util.List;
import java.util.UUID;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmourInfusedIron extends ItemArmor implements ISpecialArmor
{

	private int lifeLevel = 0;

	public ArmourInfusedIron(ArmorMaterial armorMaterial, int id, int slot)
	{
		super(armorMaterial, id, slot);

		if (slot == 0)
		{
			this.setTextureName("magicasmod" + ":" + "InfusedIronHelmet");
		}
		else if (slot == 1)
		{
			this.setTextureName("magicasmod" + ":" + "InfusedIronChestplate");
		}
		else if (slot == 2)
		{
			this.setTextureName("magicasmod" + ":" + "InfusedIronLeggings");
		}
		else if (slot == 3)
		{
			this.setTextureName("magicasmod" + ":" + "InfusedIronBoots");

		}
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type)
	{
		if (itemstack.getItem() == MagicasItems.ironInfusedHelmet || itemstack.getItem() == MagicasItems.ironInfusedChestplate || itemstack.getItem() == MagicasItems.ironInfusedBoots)
		{
			return "magicasmod" + ":" + "textures/model/armour/Infused_Iron_1.png";
		}
		else if (itemstack.getItem() == MagicasItems.ironInfusedLeggings)
		{
			return "magicasmod" + ":" + "textures/model/armour/Infused_Iron_2.png";
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack)
	{
		return stack.getItem() == Items.iron_ingot;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
	{
		if (source == source.fall)
		{
			if (armor.getItem() == MagicasItems.ironInfusedBoots)
			{
				if (armor.stackTagCompound != null)
				{
					NBTTagCompound nbtTag = armor.stackTagCompound;
					if (nbtTag.hasKey("AirInfused") && nbtTag.getBoolean("AirInfused"))
					{
						System.out.println("Damage = " + (MathHelper.floor_double(damage * 0.25D)));
						return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 0.25D));
					}
				}
			}
		}
		return new ArmorProperties(0, 0, 0);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
	{
		return 4;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
	{

	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced)
	{
		NBTTagCompound nbtTagCompound = stack.getTagCompound();

		if (nbtTagCompound != null)
		{
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			{
				if (nbtTagCompound.hasKey("FireInfused") && nbtTagCompound.getBoolean("FireInfused"))
				{
					tooltip.add("Infused With Fire");
				}

				if (nbtTagCompound.hasKey("WaterInfused") && nbtTagCompound.getBoolean("WaterInfused"))
				{
					tooltip.add("Infused With Water");
				}

				if (nbtTagCompound.hasKey("EarthInfused") && nbtTagCompound.getBoolean("EarthInfused"))
				{
					tooltip.add("Infused With Earth");
				}

				if (nbtTagCompound.hasKey("AirInfused") && nbtTagCompound.getBoolean("AirInfused"))
				{
					tooltip.add("Infused With Air");
				}

				if (nbtTagCompound.hasKey("LifeInfused") && nbtTagCompound.getBoolean("LifeInfused"))
				{
					tooltip.add("Infused With Life");
				}

				if (nbtTagCompound.hasKey("DeathInfused") && nbtTagCompound.getBoolean("DeathInfused"))
				{
					tooltip.add("Infused With Death");
				}

				if (nbtTagCompound.hasKey("SteamInfused") && nbtTagCompound.getBoolean("SteamInfused"))
				{
					tooltip.add("Infused With Steam");
				}

				if (nbtTagCompound.hasKey("LavaInfused") && nbtTagCompound.getBoolean("LavaInfused"))
				{
					tooltip.add("Infused With Lava");
				}
			}
			else
			{
				tooltip.add("Hold " + EnumChatFormatting.YELLOW + EnumChatFormatting.ITALIC + "Shift" + EnumChatFormatting.RESET + " For More Info");
			}
		}

	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{

		// Abilites!

		if (player.isSneaking())
		{
			if (itemStack.getItem() == MagicasItems.ironInfusedBoots)
			{
				if (itemStack.stackTagCompound != null)
				{
					NBTTagCompound nbtTag = itemStack.stackTagCompound;
					if (nbtTag.hasKey("DeathInfused") && nbtTag.getBoolean("DeathInfused"))
					{
						for (int y = -3; y < 2; y++)
						{
							for (int x = -3; x < 2; x++)
							{
								for (int z = -3; z < 2; z++)
								{
									if (world.getBlock((int) player.posX + x, (int) player.posY + y, (int) player.posZ + z) == Blocks.grass)
									{
										world.setBlock((int) player.posX + x, (int) player.posY + y, (int) player.posZ + z, Blocks.dirt);
									}
								}
							}
						}
					}

					if (nbtTag.hasKey("LifeInfused") && nbtTag.getBoolean("LifeInfused"))
					{
						int level = nbtTag.getInteger("LifeInfusedInt");
						for (int y = -3; y < 2; y++)
						{
							for (int x = -3; x < 2; x++)
							{
								for (int z = -3; z < 2; z++)
								{
									if (world.getBlock((int) player.posX + x, (int) player.posY + y, (int) player.posZ + z) == Blocks.dirt)
									{
										if (world.getBlock((int) player.posX + x, (int) player.posY + y + 1, (int) player.posZ + z) == Blocks.air)
										{
											world.setBlock((int) player.posX + x, (int) player.posY + y, (int) player.posZ + z, Blocks.grass);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (itemStack.getItem() == MagicasItems.ironInfusedLeggings)
		{
			if (itemStack.stackTagCompound != null)
			{
				NBTTagCompound nbtTag = itemStack.stackTagCompound;
				if (nbtTag.hasKey("AirInfused") && nbtTag.getBoolean("AirInfused"))
				{
					player.setAIMoveSpeed(1F);
				}
			}
		}
	}
}
