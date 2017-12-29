package work;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 11981 on 2017/12/7.
 * reference:https://segmentfault.com/q/1010000000359840/
 */
public class FileProcessorImpl implements FileProcessor{
    public String processByLine(String filePath, LineProcessor processor){
        StringBuilder sb = new StringBuilder();
        String str = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while (br.ready() != false){
                line = br.readLine();
                processor.doSomeThing(line.trim());
                sb.append(line);
            }
            str = sb.toString();
            str = new String(str.getBytes(), "GBK");
        }catch (FileNotFoundException infe){
            infe.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return str;
    }

    public static void main(String[] args) {
        FileProcessor fp = new FileProcessorImpl();
        final StringBuilder sb=new StringBuilder();
        String str = "";
        str = fp.processByLine("E:\\test\\readme.txt", new LineProcessor() {
            @Override
            public void doSomeThing(String oneLine) {
                sb.append(oneLine);
            }
        });
        System.out.println(str);

    }
}
