package com.sungc.director;

public class Main {
	public static void main(String[] args) {
		IPacketCreator pc = new PacketHTTPHeaderCreator(
				new PacketHTMLHeaderCreator(
						new PacketBodyCreator()));
		System.out.println(pc.handleContent());
	}

}
