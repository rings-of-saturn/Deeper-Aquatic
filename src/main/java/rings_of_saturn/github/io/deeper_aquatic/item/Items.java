package rings_of_saturn.github.io.deeper_aquatic.item;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rings_of_saturn.github.io.deeper_aquatic.item.custom.PrismiumItem;
import rings_of_saturn.github.io.deeper_aquatic.item.custom.PrismiumSaberItem;
import rings_of_saturn.github.io.deeper_aquatic.materials.ToolMaterials;

import static rings_of_saturn.github.io.deeper_aquatic.DeeperAquatic.MOD_ID;

public class Items {
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static final Item PRISMIUM = registerItem("prismium", new PrismiumItem(new Item.Settings()));

    public static final Item PRISMIUM_SABER = registerItem("prismium_saber", new PrismiumSaberItem(ToolMaterials.PRISIUM,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.PRISIUM, 4, -3f)
                    .with(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                            new EntityAttributeModifier(Identifier.of(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE.getIdAsString()),
                                    1.75d, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                    .with(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            new EntityAttributeModifier(Identifier.of(EntityAttributes.GENERIC_MOVEMENT_SPEED.getIdAsString()),
                                    -0.02d, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND))));

    public static void registerItems() {
    }
}
