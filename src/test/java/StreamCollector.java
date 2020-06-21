import com.alibaba.fastjson.JSON;
import com.superkind.lamda.cart.Cart;
import com.superkind.lamda.cart.CartServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//预定义方法使用
public class StreamCollector {

    List<Cart> list = null;

    @Before
    public  void init(){
        list = CartServiceImpl.getCarts();
    }
    @Test
    public void streamCollector(){
        List<Cart> collect = list.stream()
                .collect(Collectors.toList());
    }

    @Test
    public void groupingBy(){
        Map<Enum, List<Cart>> collect = list.stream()
                .collect(Collectors.groupingBy(cart -> cart.getSkuCateGory()));
        System.out.println(JSON.toJSONString(collect));
    }

    @Test
    public void partitioningBy(){
        Map<Boolean, List<Cart>> collect = list.stream()
                .collect(Collectors.partitioningBy(cart -> cart.getTotalPrice() > 2000));
        System.out.println(JSON.toJSONString(collect));
    }

}
