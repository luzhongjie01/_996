import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件拷贝
 */
public class FileCopyTest {

    @Test
    public  void fileCopyTest(){
        String original ="D:\\jie\\workspace\\_996\\original\\FileCopyTest.java";
        String target ="D:\\jie\\workspace\\_996\\targetTest\\target.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
             fileInputStream = new FileInputStream(original);
             fileOutputStream = new FileOutputStream(target);

             Integer i =0;
             while ((i = fileInputStream.read()) != -1){
                 fileOutputStream.write(i);
             }
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileOutputStream !=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
