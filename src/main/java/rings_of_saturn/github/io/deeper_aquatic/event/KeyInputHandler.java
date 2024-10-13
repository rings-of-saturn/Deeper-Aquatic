package rings_of_saturn.github.io.deeper_aquatic.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Hand;
import org.lwjgl.glfw.GLFW;
import rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic;
import rings_of_saturn.github.io.deeper_aquatic.networking.packet.PrismiumDashPayload;

public class KeyInputHandler {
	public static final String KEY_CATEGORY_PRISMIUM = "key.category.deeper_aquatic.deeper_aquatic";
	public static final String DASH = "key.deeper_aquatic.dash";


	public static KeyBinding dashKey;

	public static void registerKeyInputs(){
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player != null && dashKey.wasPressed()) {
				DeeperAquatic.LOGGER.info("Key Pressed and player exists!");
				ClientPlayNetworking.send(new PrismiumDashPayload(client.player.getStackInHand(Hand.MAIN_HAND)));
			}
		});
	}

	public static void register(){
		dashKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			DASH,
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_X,
			KEY_CATEGORY_PRISMIUM
		));

		registerKeyInputs();
	}
}
