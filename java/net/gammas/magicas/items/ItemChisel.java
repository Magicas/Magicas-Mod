package net.gammas.magicas.items;

import net.gammas.magicas.util.Referances;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChisel extends Item
{
	
	public ItemChisel(int durability)
	{
		setMaxDamage(durability);
		setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() 
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon(Referances.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
