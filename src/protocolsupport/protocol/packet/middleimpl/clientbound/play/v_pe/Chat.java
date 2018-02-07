package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_pe;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.api.chat.ChatAPI.MessagePosition;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleChat;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.typeremapper.pe.PEPacketIDs;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class Chat extends MiddleChat {

	//TODO: Implement jukebox, system etc.
	public static final int RAW = 0;
	public static final int CHAT = 1;
	//public static final int TRANSLATION = 2;
	//public static final int POPUP = 3;
	//public static final int JUKEBOX = 4;
	public static final int TIP = 5;
	//public static final int SYSTEM = 6;
	//public static final int WHISPER = 7;
	//public static final int ANNOUNCEMENT = 8;
	
	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		int chatType = position == MessagePosition.HOTBAR ? TIP : RAW;
		ProtocolVersion version = connection.getVersion();
		ClientBoundPacketData serializer = ClientBoundPacketData.create(PEPacketIDs.CHAT, version);
		serializer.writeByte(chatType);
		serializer.writeByte(0); //isLocalise?
		StringSerializer.writeString(serializer, version, message.toLegacyText(cache.getLocale()));
		StringSerializer.writeString(serializer, version, ""); //Xbox user ID
		StringSerializer.writeString(serializer, version, ""); //Platform ID
		return RecyclableSingletonList.create(serializer);
	}

}
