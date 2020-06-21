import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;

public class ImmutableArrayTest {
    public static void main(String[] args) {
        //创建不可变集合三种方式

        ImmutableSet.copyOf(new ArrayList<>());

        ImmutableSet.builder().add(11,22);

        ImmutableSet.of(1,2);
    }
}
