package rings_of_saturn.github.io.deeper_aquatic.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic.MOD_ID;

public class Particles {
    public static final SimpleParticleType PRISMIUM_SWING_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MOD_ID, "prismium_swing"), PRISMIUM_SWING_PARTICLE.getType());
    }

}
