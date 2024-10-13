package rings_of_saturn.github.io.deeper_aquatic.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic.MOD_ID;

public class Sounds {
    public static SoundEvent PRISMIUM_SABER_SWING = registerSoundEvent("prismium_saber_swing");
    public static SoundEvent PRISMIUM_SABER_DASH = registerSoundEvent("prismium_saber_dash");
    public static SoundEvent PRISMIUM_IDLE = registerSoundEvent("prismium_idle");



    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    private static SoundEvent registerSoundEvent(String name, int range) {
        Identifier id = Identifier.of(MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id, range));
    }

    public static void registerSounds() {
    }
}
