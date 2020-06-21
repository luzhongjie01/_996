import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest {
    @Test
    public void createOptionalTest01(){
        //optional创建的三种方式
        Optional<Object> empty = Optional.empty();

        //这种方式创建如果方法传入值为空会抛出异常
//        Optional<Object> o = Optional.of(null);


        //传入值为空不会抛出异常
        Optional<String> o1 = Optional.ofNullable(null);



        o1.ifPresent(t -> System.out.println("如果值不为空我就会执行"));

        Object aaa = o1.orElse("AAA");
        System.out.println(aaa);

        List list =null;

    }
}
