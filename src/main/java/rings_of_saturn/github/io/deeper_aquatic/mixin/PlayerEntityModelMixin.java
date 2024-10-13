package rings_of_saturn.github.io.deeper_aquatic.mixin;


import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rings_of_saturn.github.io.deeper_aquatic.item.Items;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityModelMixin {
    @Inject(method = "getArmPose", at = @At("TAIL"), cancellable = true)
    private static void changeArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir){
        if(player.getStackInHand(Hand.MAIN_HAND).getItem() == Items.PRISMIUM_SABER || player.getStackInHand(Hand.OFF_HAND).getItem() == Items.PRISMIUM_SABER){
            cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_CHARGE);
        }

    }
}
