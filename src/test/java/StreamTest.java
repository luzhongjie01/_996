import com.alibaba.fastjson.JSON;
import com.superkind.lamda.cart.Cart;
import com.superkind.lamda.cart.CartServiceImpl;
import com.superkind.lamda.cart.SkuCateGoryEnum;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void  streamHandlerCart(){
        AtomicReference<Double> money =new AtomicReference<>(Double.valueOf(0.0));
        List<String> collect = CartServiceImpl.getCarts()
                .stream()
                //输出购物车中的商品
                .peek(cart -> JSON.toJSONString(cart))
                //过滤掉图书类商品
                .filter(cart -> !cart.getSkuCateGory().equals(SkuCateGoryEnum.BOOKCLASS))
                //进行排序
                .sorted(Comparator.comparing(Cart::getTotalPrice).reversed())
                //获得前两件商品
                .limit(2)
                //累计商品金额
                .peek(cart -> money.set(cart.getTotalPrice() + money.get()))
                //获取商品名称
                .map(Cart::getSkuName)
                .collect(Collectors.toList());

        System.out.println("商品名称:" + JSON.toJSONString(collect) + "价格:" + money);

    }
}
