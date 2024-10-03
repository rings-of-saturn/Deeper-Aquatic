package rings_of_saturn.github.io.deeper_aquatic.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import rings_of_saturn.github.io.deeper_aquatic.particle.Particles;
import rings_of_saturn.github.io.deeper_aquatic.particle.PrismiumParticle;

public class DeeperAquaticClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(Particles.PRISMIUM_SWING_PARTICLE, PrismiumParticle.Factory::new);
    }
}
