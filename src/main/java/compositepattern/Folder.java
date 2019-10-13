package compositepattern;

import java.util.ArrayList;

/**
 * Created by 11981 on 2018/5/13.
 * 文件夹类-容器构件
 */
public class Folder extends AbstractFile{
    private ArrayList<AbstractFile> fileList = new ArrayList<AbstractFile>();
    private String name;

    public Folder(String name){
        this.name = name;
    }

    @Override
    public void add(AbstractFile file){
        fileList.add(file);
    }


    @Override
    public void remove(AbstractFile file){
        fileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i){
        return fileList.get(i);
    }

    @Override
    public void killVirus(){
        System.out.println("***对文件夹：" + name +  "进行杀毒");
        for (Object object : fileList){
            ((AbstractFile)object).killVirus();
        }
    }
}
