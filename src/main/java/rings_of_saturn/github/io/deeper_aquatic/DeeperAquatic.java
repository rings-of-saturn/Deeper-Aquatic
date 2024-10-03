package rings_of_saturn.github.io.deeper_aquatic;

import net.fabricmc.api.ModInitializer;

import java.util.logging.Logger;

import static rings_of_saturn.github.io.deeper_aquatic.item.Items.registerItems;
import static rings_of_saturn.github.io.deeper_aquatic.particle.Particles.registerParticles;
import static rings_of_saturn.github.io.deeper_aquatic.sound.Sounds.registerSounds;

public class DeeperAquatic implements ModInitializer {
    public static String MOD_ID = "deeper_aquatic";
    public static Logger LOGGER = Logger.getLogger("Deeper Aquatic");

    @Override
    public void onInitialize() {
        registerItems();
        registerSounds();
        registerParticles();

    }
}
