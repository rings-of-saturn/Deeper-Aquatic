package rings_of_saturn.github.io.deeper_aquatic.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import rings_of_saturn.github.io.deeper_aquatic.components.ModComponents;
import rings_of_saturn.github.io.deeper_aquatic.event.KeyInputHandler;
import rings_of_saturn.github.io.deeper_aquatic.item.Items;
import rings_of_saturn.github.io.deeper_aquatic.particle.Particles;
import rings_of_saturn.github.io.deeper_aquatic.particle.PrismiumParticle;

import static rings_of_saturn.github.io.deeper_aquatic.networking.Packets.registerS2CPackets;

public class DeeperAquaticClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(Particles.PRISMIUM_SWING_PARTICLE, PrismiumParticle.Factory::new);

        KeyInputHandler.register();
        registerModelPredicateProviders();
        registerS2CPackets();
    }
    public static void registerModelPredicateProviders() {
        // For versions before 1.21, replace 'Identifier.ofVanilla' with 'new Identifier'.
        ModelPredicateProviderRegistry.register(Items.PRISMIUM_SABER, Identifier.ofVanilla("blocking"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return itemStack.getOrDefault(ModComponents.BLOCKING, 0).byteValue();
        });
    }
}
