package protocolsupport.protocol.transformer.middlepacketimpl.v1_5_1_6_1_7.clientbound.play;

import java.util.Collection;
import java.util.Collections;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleEntityRelMove;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;

public class EntityRelMove extends MiddleEntityRelMove<Collection<PacketData>> {

	@Override
	public Collection<PacketData> toData(ProtocolVersion version) {
		PacketDataSerializer serializer = PacketDataSerializer.createNew(version);
		serializer.writeInt(entityId);
		serializer.writeByte(relX);
		serializer.writeByte(relY);
		serializer.writeByte(relZ);
		return Collections.singletonList(new PacketData(ClientBoundPacket.PLAY_ENTITY_REL_MOVE_ID, serializer));
	}

}