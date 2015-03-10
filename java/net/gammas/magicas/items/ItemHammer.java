package net.gammas.magicas.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;

public class ItemHammer extends Item
{
	
	public ItemHammer(int durability)
	{
		setMaxDamage(durability);
		setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() 
	{
		return true;
	}
	
}
