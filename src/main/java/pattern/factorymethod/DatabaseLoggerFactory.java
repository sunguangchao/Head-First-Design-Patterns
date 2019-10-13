package pattern.factorymethod;

/**
 * Created by 11981 on 2018/5/3.
 */
public class DatabaseLoggerFactory implements LoggerFactory {


    @Override
    public Logger createLogger(){
        //连接数据库，代码省略
        Logger logger = new DatabaseLogger();
        return logger;
    }
}
