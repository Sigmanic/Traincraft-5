package train.client.render.renderSwitch;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import tmt.Tessellator;
import train.client.render.RenderSignal;
import train.client.render.renderSwitch.models.ModelsignalSpanish;
import train.common.blocks.blockSwitch.BlocksignalSpanish;
import train.common.library.Info;
import train.common.tile.TileSignal;
import train.common.tile.tileSwitch.TilesignalSpanish;
import net.minecraft.world.World;

public class RendersignalSpanish extends TileEntitySpecialRenderer {
    static final ModelsignalSpanish modelspanishSignal = new ModelsignalSpanish();
        private static final ResourceLocation texture = new ResourceLocation(Info.resourceLocation,Info.modelTexPrefix + "signalSpanishRed.png");
    private static final ResourceLocation texture2 = new ResourceLocation(Info.resourceLocation, Info.modelTexPrefix + "signalSpanishGreen.png");
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.5,y+0.6,z+0.5);
        //GL11.glRotated(180,0,1,0);

        boolean skipRender = false;

        switch (((TilesignalSpanish)tileEntity).getFacing()){
            case NORTH:{
                GL11.glRotated(180,0,0,1);
                GL11.glRotated(90,0,1,0);
                GL11.glTranslated(0.1875,0,0.125);
                break;
            }
            case SOUTH:{
                GL11.glRotated(180,0,0,1);
                GL11.glRotated(270,0,1,0);
                GL11.glTranslated(0.1875,0,0.125);
                break;
            }
            case EAST:{
                GL11.glRotated(180,0,0,1);
                GL11.glRotated(180,0,1,0);
                GL11.glTranslated(0.1875,0,0.125);
                break;
            }
            case WEST:{
                GL11.glRotated(180,0,0,1);
                GL11.glRotated(0,0,1,0);
                GL11.glTranslated(0.1875,0,0.125);
                break;
            }
            default:{
                skipRender = true;
            }
        }



        if (!skipRender) {
            World world = null;
            // tileEntity.getWorldObj().getBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord).isProvidingWeakPower(tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, 0) > 0
            if (((TilesignalSpanish) tileEntity).state == 1) {
                Tessellator.bindTexture(texture);
                modelspanishSignal.render(null, 0, 0, 0, 0, 0, 0.0625f);
            } else if (((TilesignalSpanish) tileEntity).state == 0) {
                Tessellator.bindTexture(texture2);
                modelspanishSignal.render(null, 0, 0, 0, 0, 0, 0.0625f);
            }
        }

        GL11.glPopMatrix();
    }


}