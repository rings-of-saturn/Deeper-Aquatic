package rings_of_saturn.github.io.deeper_aquatic.mixin;


import com.mojang.authlib.GameProfile;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rings_of_saturn.github.io.deeper_aquatic.components.ModComponents;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
	@Shadow @Final private GameProfile gameProfile;

	@Shadow private ItemStack selectedItem;

	@Inject(method = "applyDamage", at = @At("HEAD"))
	protected void injectDamageMethod(DamageSource source, float amount, CallbackInfo ci) {
		if (source.getAttacker() != null) {
			World world = source.getAttacker().getWorld();
			if (!world.isClient() && world.getServer() != null) {
				PlayerEntity victim = world.getServer().getPlayerManager().getPlayer(this.gameProfile.getId());
				if (victim != null && victim.isPlayer()) {
					ItemStack handStack = victim.getStackInHand(Hand.MAIN_HAND);
					if(handStack.getOrDefault(ModComponents.BLOCKING, 0).byteValue() == 1) {
						byte dashValue = handStack.getOrDefault(ModComponents.DASH_CHARGE, 0).byteValue();
						if (dashValue++ <= 7) {
							dashValue++;
						} else {
							dashValue = 7;
						}
						handStack.set(ModComponents.DASH_CHARGE, dashValue);
					}
				}
			}
		}
	}
	@Inject(method = "canBeHitByProjectile", at = @At("HEAD"), cancellable = true)
	protected void blockProjectiles(CallbackInfoReturnable<Boolean> cir){
		if(this.selectedItem.getOrDefault(ModComponents.BLOCKING, 0).byteValue() == 1){
			cir.setReturnValue(true);
		}
	}
}