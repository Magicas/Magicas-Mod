package net.gammas.magicas.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends Item 
{
	private float Damage;

	public ItemWand(float Damage) 
	{
		this.maxStackSize = 1;
		this.setMaxDamage(this.getMaxDamage());
		this.Damage = Damage;
	}

	// Makes It So It Looks Like The Player Is Holding The Wand
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() 
	{
		return true;
	}

	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int duration) 
	{
        int j = this.getMaxItemUseDuration(itemStack) - duration;

        ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        
        if (event.isCanceled())
        {
            return;
        }
        
        j = event.charge;
        float f = (float)j / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if ((double)f < 0.1D)
        {
            return;
        }

        if (f > 1.0F)
        {
        	f = 1.0F;
        }

        EntityArrow entityarrow = new EntityArrow(world, player, f * 5.0F);
        
		entityarrow.setIsCritical(true);
		entityarrow.setFire(100);

		itemStack.damageItem(1, player);
		world.playSoundAtEntity(player, "random.fire", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + Damage * 0.5F);

		if (!world.isRemote) 
		{
			world.spawnEntityInWorld(entityarrow);
		}
	}
	
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        return itemStack;
    }
    
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 24000;
    }
    
    public EnumAction getItemUseAction(ItemStack itemStack)
    {
        return EnumAction.bow;
    }
    
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }
        
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));

        return itemStack;
    }
    
    public int getItemEnchantability()
    {
        return 1;
    }
}
