package mc.Mitchellbrine.necromancy.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTotem extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer pillar;
    ModelRenderer base;
  
  public ModelTotem()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(0F, 0F, 0F, 16, 6, 16);
      head.setRotationPoint(-8F, 10F, -8F);
      head.setTextureSize(64, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      pillar = new ModelRenderer(this, 0, 23);
      pillar.addBox(0F, 0F, 0F, 6, 6, 6);
      pillar.setRotationPoint(-3F, 16F, -3F);
      pillar.setTextureSize(64, 128);
      pillar.mirror = true;
      setRotation(pillar, 0F, 0F, 0F);
      base = new ModelRenderer(this, 0, 35);
      base.addBox(0F, 0F, 0F, 8, 2, 8);
      base.setRotationPoint(-4F, 22F, -4F);
      base.setTextureSize(64, 128);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    head.render(f5);
    pillar.render(f5);
    base.render(f5);
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
