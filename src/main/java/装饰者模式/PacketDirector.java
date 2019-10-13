package 装饰者模式;

public abstract class PacketDirector implements IPacketCreator{
	IPacketCreator component;
	public PacketDirector(IPacketCreator c) {
		component = c;
	}

}
