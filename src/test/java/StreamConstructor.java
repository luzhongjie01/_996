import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamConstructor {

    /**
     * 流生成的四种方式
     */


    //通过数值创建流
    @Test
    public void streamForValue(){
        Stream.of("AA","BB")
                .forEach(System.out::println);
    }


    //通过数组
    @Test
    public void streamForArray(){
        int number[] ={1,2,3,4};
        Arrays.stream(number)
                .forEach(System.out::println);
    }

    //通过文件
    @Test
    public void streamForFile() throws IOException {
        Files.lines(Paths.get("D:\\aaa.txt"))
                .forEach(System.out::println);
    }

    //通过函数
    @Test
    public void streamForFunction(){
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.forEach(System.out::println);
    }

    //随机数流
    @Test
    public void streamForFunction2(){
        Stream<Double> generate = Stream.generate(Math::random);
        generate.forEach(System.out::println);
    }


}
