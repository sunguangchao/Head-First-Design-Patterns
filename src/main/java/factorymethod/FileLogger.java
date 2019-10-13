package factorymethod;

/**
 * Created by 11981 on 2018/5/3.
 */
public class FileLogger implements Logger {
    @Override
    public void writeLog(){
        System.out.println("文件日志记录");
    }
}
