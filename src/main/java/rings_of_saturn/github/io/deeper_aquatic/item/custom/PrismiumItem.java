package rings_of_saturn.github.io.deeper_aquatic.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rings_of_saturn.github.io.deeper_aquatic.sound.Sounds;

public class PrismiumItem extends Item {
    public PrismiumItem(Settings settings) {
        super(settings);
    }
    static int soundTimer = 0;

    static int soundTimerMax = 30;



    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(world.isClient) {
            if(selected) {
                if (soundTimer >= soundTimerMax) {
                    entity.playSound(Sounds.PRISMIUM_IDLE, 0.5f, 0f);
                    soundTimer = 0;
                }
                if (!(soundTimer >= soundTimerMax))
                    soundTimer++;
            }
            super.inventoryTick(stack, world, entity, slot, selected);
        }
    }
}
