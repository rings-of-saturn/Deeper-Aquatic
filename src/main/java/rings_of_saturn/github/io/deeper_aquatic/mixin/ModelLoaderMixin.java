package rings_of_saturn.github.io.deeper_aquatic.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.util.Map;

import static rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic.MOD_ID;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {

	@Shadow protected abstract void addModelToBake(ModelIdentifier id, UnbakedModel model);

	@Shadow protected abstract JsonUnbakedModel loadModelFromJson(Identifier id) throws IOException;

	@Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModelToBake(Lnet/minecraft/client/util/ModelIdentifier;Lnet/minecraft/client/render/model/UnbakedModel;)V"))
	public void addClosedBook(BlockColors blockColors, Profiler profiler, Map jsonUnbakedModels, Map blockStates, CallbackInfo ci) throws IOException {
		this.addModelToBake(new ModelIdentifier(Identifier.of(MOD_ID, "prismium_saber_gui"), "gui"), loadModelFromJson(Identifier.of(MOD_ID, "prismium_saber_gui")));
		this.addModelToBake(new ModelIdentifier(Identifier.of(MOD_ID, "prismium_saber_gui"), "ground"), loadModelFromJson(Identifier.of(MOD_ID, "prismium_saber_gui")));
	}
}