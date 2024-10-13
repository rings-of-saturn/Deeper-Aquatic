package rings_of_saturn.github.io.deeper_aquatic.components;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic.MOD_ID;

public class ModComponents {

    public static final ComponentType<Byte> BLOCKING = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(MOD_ID, "blocking"),
            ComponentType.<Byte>builder().codec(Codec.BYTE).build()
    );

    public static final ComponentType<Byte> DASH_CHARGE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(MOD_ID, "dash_charge"),
            ComponentType.<Byte>builder().codec(Codec.BYTE).build()
    );

    public static void registerModComponents(){

    }
}
