package 装饰者模式;

public class PacketHTMLHeaderCreator extends PacketDirector{
	public PacketHTMLHeaderCreator(IPacketCreator c) {
		super(c);
		
	}

	@Override
	public String handleContent() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<body>");
		sb.append(component.handleContent());
		sb.append("</html>");
		sb.append("</body>\n");
		return sb.toString();
	}

}
