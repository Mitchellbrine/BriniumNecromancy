package mc.Mitchellbrine.necromancy.client.render;

import mc.Mitchellbrine.necromancy.client.model.ModelTotem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTotem extends TileEntitySpecialRenderer{

    private final ModelTotem model;

    public RenderTotem()
    {
        this.model = new ModelTotem();
    }

    /**
     * Remove the comment when in use again
     private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
     {
     int meta = world.getBlockMetadata(x, y, z);
     GL11.glPushMatrix();
     GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
     GL11.glPopMatrix();
     }
     **/

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

        bindTexture(new ResourceLocation("briniumnecromancy:textures/entity/totem.png"));

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
