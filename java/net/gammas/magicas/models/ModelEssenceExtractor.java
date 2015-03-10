package net.gammas.magicas.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEssenceExtractor extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer BaseTop;
    ModelRenderer Stand;
    ModelRenderer StandTop;
  
  public ModelEssenceExtractor()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 3, 16);
      Base.setRotationPoint(-8F, 21F, -8F);
      Base.setTextureSize(128, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      BaseTop = new ModelRenderer(this, 0, 20);
      BaseTop.addBox(0F, 0F, 0F, 14, 2, 14);
      BaseTop.setRotationPoint(-7F, 19F, -7F);
      BaseTop.setTextureSize(128, 64);
      BaseTop.mirror = true;
      setRotation(BaseTop, 0F, 0F, 0F);
      Stand = new ModelRenderer(this, 65, 0);
      Stand.addBox(0F, 0F, 0F, 6, 10, 6);
      Stand.setRotationPoint(-3F, 9F, -3F);
      Stand.setTextureSize(128, 64);
      Stand.mirror = true;
      setRotation(Stand, 0F, 0F, 0F);
      StandTop = new ModelRenderer(this, 57, 20);
      StandTop.addBox(0F, 0F, 0F, 8, 1, 8);
      StandTop.setRotationPoint(-4F, 8F, -4F);
      StandTop.setTextureSize(128, 64);
      StandTop.mirror = true;
      setRotation(StandTop, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    BaseTop.render(f5);
    Stand.render(f5);
    StandTop.render(f5);
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
