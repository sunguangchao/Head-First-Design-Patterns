package factorymethod;

/**
 * Created by 11981 on 2018/5/3.
 */
public class Client {
    public static void main(String[] args) {
        LoggerFactory factory;
        Logger logger;
//        factory = new FileLoggerFactory();
        factory = (LoggerFactory) XMLUtil.getBean();
        logger = factory.createLogger();
        logger.writeLog();
    }
}
