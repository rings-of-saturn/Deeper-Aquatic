package rings_of_saturn.github.io.deeper_aquatic.networking;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic;
import rings_of_saturn.github.io.deeper_aquatic.components.ModComponents;
import rings_of_saturn.github.io.deeper_aquatic.networking.packet.PrismiumDashPayload;
import rings_of_saturn.github.io.deeper_aquatic.sound.Sounds;

import static com.mojang.text2speech.Narrator.LOGGER;
import static rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic.MOD_ID;

public class Packets {
    public static final Identifier PRISMIUM_DASH_ID = Identifier.of(MOD_ID, "prismium_saber_dash");

    public static void registerC2SPackets(){
        PayloadTypeRegistry.playC2S().register(PrismiumDashPayload.ID, PrismiumDashPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(PrismiumDashPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                DeeperAquatic.LOGGER.info("packet sent");
                if(payload.stack().getOrDefault(ModComponents.DASH_CHARGE, 0).byteValue() != 0){
                    DeeperAquatic.LOGGER.info("packet send & test 1 complete");
                    context.server().getWorld(context.player().getWorld().getRegistryKey()).playSoundFromEntity(
                            null, context.player(), Sounds.PRISMIUM_SABER_DASH, SoundCategory.PLAYERS, 1f, 0.5f);
                    Vec3d dir = new Vec3d(context.player().getRotationVector().toVector3f());
                    dir.multiply((double) (payload.stack().getOrDefault(ModComponents.DASH_CHARGE, 0).byteValue() * 3) + 1);
                    context.player().addVelocity(dir);
                    context.player().velocityModified = true;

                    context.player().getStackInHand(Hand.MAIN_HAND).set(ModComponents.DASH_CHARGE, (byte)0);
                }
            });
        });
        
    }

    public static void registerS2CPackets(){


    }
}
