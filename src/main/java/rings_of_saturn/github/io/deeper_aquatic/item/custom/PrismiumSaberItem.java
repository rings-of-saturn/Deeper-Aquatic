package rings_of_saturn.github.io.deeper_aquatic.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import rings_of_saturn.github.io.deeper_aquatic.components.ModComponents;

public class PrismiumSaberItem extends SwordItem {
    public PrismiumSaberItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack handStack = user.getStackInHand(hand);
        if (user.getAttackCooldownProgress(0F) == 1F) {
            handStack.set(ModComponents.BLOCKING, (byte) 1);
            user.setCurrentHand(hand);
            return TypedActionResult.consume(handStack);
        }
        return TypedActionResult.fail(handStack);
    }





    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 2, true, false, false));
        super.usageTick(world, user, stack, remainingUseTicks);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        stack.set(ModComponents.BLOCKING, (byte)0);
        user.hasStatusEffect(StatusEffects.RESISTANCE);
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!selected){
            onStoppedUsing(stack, world, (LivingEntity) entity, 0);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        onStoppedUsing(entity.getStack(), entity.getEntityWorld(), null, 0);
        super.onItemEntityDestroyed(entity);
    }
}
