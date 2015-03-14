package net.gammas.magicas.items;

import net.gammas.magicas.util.Referances;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicWand extends ItemWand
{

	public ItemMagicWand(float Damage) 
	{
		super(Damage);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon(Referances.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

}
