package net.gammas.magicas.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEssenceExtractor extends ModelBase
{
  //fields
    ModelRenderer Leg2;
    ModelRenderer Leg1;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Top1;
    ModelRenderer Top2;
    ModelRenderer Top3;
    ModelRenderer Top4;
    ModelRenderer Grid1;
    ModelRenderer Grid2;
    ModelRenderer Grid3;
    ModelRenderer Stand1;
    ModelRenderer Stand2;
  
  public ModelEssenceExtractor()
  {
    textureWidth = 512;
    textureHeight = 32;
    
      Leg2 = new ModelRenderer(this, 61, 0);
      Leg2.addBox(0F, 0F, 0F, 2, 15, 2);
      Leg2.setRotationPoint(6F, 9F, -8F);
      Leg2.setTextureSize(512, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 52, 0);
      Leg1.addBox(0F, 0F, 0F, 2, 15, 2);
      Leg1.setRotationPoint(6F, 9F, 6F);
      Leg1.setTextureSize(512, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 70, 0);
      Leg3.addBox(0F, 0F, 0F, 2, 15, 2);
      Leg3.setRotationPoint(-8F, 9F, 6F);
      Leg3.setTextureSize(512, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 79, 0);
      Leg4.addBox(0F, 0F, 0F, 2, 15, 2);
      Leg4.setRotationPoint(-8F, 9F, -8F);
      Leg4.setTextureSize(512, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Top1 = new ModelRenderer(this, 89, 0);
      Top1.addBox(0F, 0F, 0F, 4, 1, 16);
      Top1.setRotationPoint(-8F, 8F, -8F);
      Top1.setTextureSize(512, 32);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, 0F);
      Top2 = new ModelRenderer(this, 130, 0);
      Top2.addBox(0F, 0F, 0F, 4, 1, 16);
      Top2.setRotationPoint(4F, 8F, -8F);
      Top2.setTextureSize(512, 32);
      Top2.mirror = true;
      setRotation(Top2, 0F, 0F, 0F);
      Top3 = new ModelRenderer(this, 161, 0);
      Top3.addBox(0F, 0F, 0F, 8, 1, 4);
      Top3.setRotationPoint(-4F, 8F, 4F);
      Top3.setTextureSize(512, 32);
      Top3.mirror = true;
      setRotation(Top3, 0F, 0F, 0F);
      Top4 = new ModelRenderer(this, 161, 7);
      Top4.addBox(0F, 0F, 0F, 8, 1, 4);
      Top4.setRotationPoint(-4F, 8F, -8F);
      Top4.setTextureSize(512, 32);
      Top4.mirror = true;
      setRotation(Top4, 0F, 0F, 0F);
      Grid1 = new ModelRenderer(this, 186, 0);
      Grid1.addBox(0F, 0F, 0F, 2, 1, 10);
      Grid1.setRotationPoint(2F, 9F, -5F);
      Grid1.setTextureSize(512, 32);
      Grid1.mirror = true;
      setRotation(Grid1, 0F, 0F, 0F);
      Grid2 = new ModelRenderer(this, 211, 0);
      Grid2.addBox(0F, 0F, 0F, 2, 1, 10);
      Grid2.setRotationPoint(-1F, 9F, -5F);
      Grid2.setTextureSize(512, 32);
      Grid2.mirror = true;
      setRotation(Grid2, 0F, 0F, 0F);
      Grid3 = new ModelRenderer(this, 236, 0);
      Grid3.addBox(0F, 0F, 0F, 2, 1, 10);
      Grid3.setRotationPoint(-4F, 9F, -5F);
      Grid3.setTextureSize(512, 32);
      Grid3.mirror = true;
      setRotation(Grid3, 0F, 0F, 0F);
      Stand1 = new ModelRenderer(this, 0, 0);
      Stand1.addBox(0F, 0F, 0F, 6, 1, 6);
      Stand1.setRotationPoint(-3F, 17F, -3F);
      Stand1.setTextureSize(512, 32);
      Stand1.mirror = true;
      setRotation(Stand1, 0F, 0F, 0F);
      Stand2 = new ModelRenderer(this, 31, 0);
      Stand2.addBox(0F, 0F, 0F, 2, 6, 2);
      Stand2.setRotationPoint(-1F, 18F, -1F);
      Stand2.setTextureSize(512, 32);
      Stand2.mirror = true;
      setRotation(Stand2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Leg2.render(f5);
    Leg1.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Top1.render(f5);
    Top2.render(f5);
    Top3.render(f5);
    Top4.render(f5);
    Grid1.render(f5);
    Grid2.render(f5);
    Grid3.render(f5);
    Stand1.render(f5);
    Stand2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
