import com.alibaba.fastjson.JSON;
import com.superkind.lamda.cart.Cart;
import com.superkind.lamda.cart.CartServiceImpl;
import com.superkind.lamda.cart.SkuCateGoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class StreamOperatorTest {

    List<Cart> list = null;

    @Before
    public  void init(){
        list = CartServiceImpl.getCarts();
    }


    @Test
    public void streamFilter(){
        list.stream()
                .filter(cart -> SkuCateGoryEnum.BOOKCLASS.equals(cart.getSkuCateGory()))
                .forEach(cart -> {
                    System.out.println(JSON.toJSONString(cart,true));
                });
    }


    @Test
    public  void streamMap(){
        list.stream()
                .map(cart -> cart.getSkuName())
                .forEach(cartName -> {
                    System.out.println(cartName);
                });
    }


    @Test
    public void streamFlatMap(){
        ArrayList<List<String>> twoList = new ArrayList(){{
            add(Arrays.asList("AAA","BBB"));
            add(Arrays.asList("CCC","DDD"));
        }};
        twoList.stream()
                .flatMap(list -> twoList.stream() )
                .distinct()
                .collect(Collectors.toList())
                .forEach(cartName -> {
            System.out.println(cartName);
        });


    }

    /**
     * 将一个对象转换为流
     */
    @Test
    public void streamFlatMap2(){
        list.stream()
                .flatMap(cart -> Arrays.stream(cart.getSkuName().split("")) )
                .distinct()
                .collect(Collectors.toList())
                .forEach(cartName -> {
                    System.out.println(cartName);
                });


    }

    /**
     * 与forEach区别,
     * peek中间操作,
     * forEach终端操作
     */
    @Test
    public void streamPeek(){
        list.stream()
                .peek(cart -> System.out.println(cart.getSkuName()))
                .sorted(Comparator.comparing(cart -> cart.getTotalPrice()))
                .forEach(cart -> {
                    System.out.println(JSON.toJSONString(cart));
                });
    }



    @Test
    public void streamSkip(){
        list.stream()
                .skip(3)
                .forEach(cart -> {
                    System.out.println(JSON.toJSONString(cart));
                });
    }

    @Test
    public void streamLimit(){
        list.stream()
                .limit(3)
                .forEach(cart -> {
                    System.out.println(JSON.toJSONString(cart));
                });
    }


    //终端操作,断路操作
    //allMatch匹配所有元素返回true
    @Test
    public void streamAllMatch(){
        boolean b = list.stream()
                .allMatch(cart ->
                    cart.getTotalPrice() > 3000
                );
        System.out.println(b);
    }



    //anyMatch只要一个匹配返回true
    @Test
    public void streamAnyMatch(){
        boolean b = list.stream()
                .anyMatch(cart -> cart.getTotalPrice() > 2000);
        System.out.println(b);
    }

    //noneMatch全部不匹配返回true
    @Test
    public void streamNoneMatch(){
        boolean b = list.stream()
                .noneMatch(cart -> cart.getTotalPrice() > 2000);
        System.out.println(b);
    }

    //findFirst 找到第一个元素
    @Test
    public void streamFindFirst(){
        Optional<Cart> first = list.stream()
                .findFirst();
        System.out.println(JSON.toJSONString(first.get()));
    }

    //findAny 找到其中的一个元素
    @Test
    public void streamFindAny(){
        Optional<Cart> first = list.stream()
                .findAny();
        System.out.println(JSON.toJSONString(first.get()));
    }


    //非短路操作
    @Test
    public void streamMax(){
        OptionalDouble max = list.stream()
                .mapToDouble(cart -> cart.getTotalPrice())
                .max();
        System.out.println(max.getAsDouble());
    }

    @Test
    public void streamMix(){
        OptionalDouble max = list.stream()
                .mapToDouble(cart -> cart.getTotalPrice())
                .min();
        System.out.println(max.getAsDouble());
    }

    @Test
    public void streamCount(){
        long count = list.stream()
                .count();
        System.out.println(count );
    }
}
