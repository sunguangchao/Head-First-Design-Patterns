package work;

/**
 * Created by 11981 on 2017/12/7.
 */
public interface FileProcessor {
    String processByLine(String filePath, LineProcessor processor);
}
