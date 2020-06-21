import com.superkind.lamda.file.FileServiceImpl;
import org.junit.Test;

import java.util.function.Predicate;

public class FileTest {

    @Test
    public void readFileTest(){

        String url ="D:\\aaa.txt";
        FileServiceImpl fileService = new FileServiceImpl();
        fileService.fileHandler(url,content -> {
            System.out.println(content);

        });


    }





}
