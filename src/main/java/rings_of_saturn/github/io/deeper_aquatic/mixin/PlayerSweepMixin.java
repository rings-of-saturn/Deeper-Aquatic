package rings_of_saturn.github.io.deeper_aquatic.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rings_of_saturn.github.io.deeper_aquatic.item.Items;
import rings_of_saturn.github.io.deeper_aquatic.particle.Particles;

@Mixin(PlayerEntity.class)
public abstract class PlayerSweepMixin {
    @Inject(method = "spawnSweepAttackParticles", at = @At("HEAD"), cancellable = true)
    public void injectSweepAttackParticles(CallbackInfo ci) {
        PlayerEntity player = ((PlayerEntity) (Object) this);
        if(player.getStackInHand(Hand.MAIN_HAND).getItem() == Items.PRISMIUM_SABER && player.getWorld() instanceof ServerWorld) {
            ci.cancel();
            double d = -MathHelper.sin(player.getYaw() * (0.017453292F));
            double e = MathHelper.cos(player.getYaw() * (0.017453292F));
            ((ServerWorld) player.getWorld()).spawnParticles(Particles.PRISMIUM_SWING_PARTICLE, player.getX() + d*2.5, player.getBodyY(0.5), player.getZ() + e*2.5, 0, d, 0.0, e, 0.0);
        }
    }
}
