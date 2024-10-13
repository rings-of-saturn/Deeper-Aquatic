package rings_of_saturn.github.io.deeper_aquatic.networking.packet;

import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import rings_of_saturn.github.io.deeper_aquatic.networking.Packets;

public record PrismiumDashPayload(ItemStack stack) implements CustomPayload {
    public static final CustomPayload.Id<PrismiumDashPayload> ID = new CustomPayload.Id<>(Packets.PRISMIUM_DASH_ID);
    public static final PacketCodec<RegistryByteBuf, PrismiumDashPayload> CODEC = PacketCodec.tuple(
            ItemStack.PACKET_CODEC, PrismiumDashPayload::stack,
            PrismiumDashPayload::new);

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }

}
