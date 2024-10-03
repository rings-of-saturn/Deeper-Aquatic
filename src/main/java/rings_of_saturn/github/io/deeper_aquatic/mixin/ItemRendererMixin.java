package rings_of_saturn.github.io.deeper_aquatic.mixin;


import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import rings_of_saturn.github.io.deeper_aquatic.item.Items;

import static rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic.MOD_ID;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "HEAD"), argsOnly = true)
	public BakedModel useClosedBookModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
		if (stack.isOf(Items.PRISMIUM_SABER) && (renderMode == ModelTransformationMode.GUI || renderMode == ModelTransformationMode.FIXED))
            return ((ItemRendererAccessor)this).deeper_aquatic$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(MOD_ID, "prismium_saber_gui"), "gui"));
		if (stack.isOf(Items.PRISMIUM_SABER) && renderMode == ModelTransformationMode.GROUND) {
			return ((ItemRendererAccessor) this).deeper_aquatic$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(MOD_ID, "prismium_saber_gui"), "ground"));
		}
		return value;
	}
}