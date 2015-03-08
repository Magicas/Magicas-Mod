package net.gammas.magicas.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.gammas.magicas.core.MagicasMod;
import net.gammas.magicas.util.Referances;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTaintedGrass extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;
    
	public BlockTaintedGrass()
    {
		super(Material.grass);
		setStepSound(soundTypeGrass);
    }
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.top : (p_149691_1_ == 0 ? Blocks.stone.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        if (p_149673_5_ == 1)
        {
            return this.top;
        }
        else if (p_149673_5_ == 0)
        {
        	return this.bottom;
        }
        else
        {
            Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
            return this.blockIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("magicasmod:taintedgrass_side");;
        this.top = iconRegister.registerIcon("magicasmod:taintedgrass_top");
        this.bottom = iconRegister.registerIcon("magicasmod:taintedgrass_bottom");
    }
}
