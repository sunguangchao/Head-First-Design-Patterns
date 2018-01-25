package com.sungc.director;

public abstract class PacketDirector implements IPacketCreator{
	IPacketCreator component;
	public PacketDirector(IPacketCreator c) {
		component = c;
	}

}
