package com.sungc.director;

public class PacketHTTPHeaderCreator extends PacketDirector{

	public PacketHTTPHeaderCreator(IPacketCreator c) {
		super(c);
	}

	@Override
	public String handleContent() {
		StringBuffer sb = new StringBuffer();
		sb.append("Cache-Control:no-cache\n");
		sb.append("Date:2018/1/24\n");
		sb.append(component.handleContent());
		return sb.toString();
	}
	

}
