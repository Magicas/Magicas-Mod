package net.gammas.magicas.blocks;

import java.util.Random;

import net.gammas.magicas.core.MagicasMod;
import net.gammas.magicas.tileentites.TileEntityEssenceExtractor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EssenceExtractor extends BlockContainer
{
	private boolean isActive;

	public EssenceExtractor(Material material, boolean isActive)
	{
		super(material);
		this.isActive = isActive;
		setHarvestLevel("pickaxe", 2);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("magicasmod:EssenceExtractor_Icon");
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, MagicasMod.instance, MagicasBlocks.GuiIDEssenceExtractor, world, x, y, z);
		}

		return true;
	}
	
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int whichDirectionFacing = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
            dropItems(world, x, y, z);
            super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z){
            Random rand = new Random();

            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (!(tileEntity instanceof IInventory)) {
                    return;
            }
            IInventory inventory = (IInventory) tileEntity;

            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                    ItemStack item = inventory.getStackInSlot(i);

                    if (item != null && item.stackSize > 0) {
                            float rx = rand.nextFloat() * 0.8F + 0.1F;
                            float ry = rand.nextFloat() * 0.8F + 0.1F;
                            float rz = rand.nextFloat() * 0.8F + 0.1F;

                            EntityItem entityItem = new EntityItem(world,
                                            x + rx, y + ry, z + rz,
                                            new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

                            if (item.hasTagCompound()) {
                                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                            }

                            float factor = 0.05F;
                            entityItem.motionX = rand.nextGaussian() * factor;
                            entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                            entityItem.motionZ = rand.nextGaussian() * factor;
                            world.spawnEntityInWorld(entityItem);
                            item.stackSize = 0;
                    }
            }
    }

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityEssenceExtractor();
	}

}
