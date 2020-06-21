import com.alibaba.fastjson.JSON;
import com.superkind.lamda.cart.*;
import org.junit.Test;

import java.util.List;

public class VersionTest {

    @Test
    public void filterBookClassCart(){
        List<Cart> carts = CartServiceImpl.getCarts();
        List<Cart> list = CartServiceImpl.filterBookClassCart(carts);
        String s = JSON.toJSONString(list);
        System.out.println(s);
    }

    @Test
    public void filterByCateGory(){
        List<Cart> carts = CartServiceImpl.getCarts();
        List<Cart> list = CartServiceImpl.filterByCategory(carts, SkuCateGoryEnum.DIGITALCLASS);
        String s = JSON.toJSONString(list,true);
        System.out.println(s);
    }

    @Test
    public void filterByCategoryOrTotalPrice(){
        List<Cart> carts = CartServiceImpl.getCarts();
        List<Cart> list = CartServiceImpl.filterByCategoryOrTotalPrice(carts, SkuCateGoryEnum.DIGITALCLASS,2000.0,true);
        String s = JSON.toJSONString(list,true);
        System.out.println(s);
    }


    @Test
    public  void preDiCateTest(){
        List<Cart> carts = CartServiceImpl.getCarts();
        //List<Cart> list = CartServiceImpl.filterByPrediCate(carts, new BookCategoryPrediCate());
        List<Cart> list = CartServiceImpl.filterByPrediCate(carts, new TotalPricePrediCate());
        System.out.println(JSON.toJSONString(list,true));
    }

    /**
     * 使用匿名类
     */
    @Test
    public  void preDiCateTest2(){
        List<Cart> carts = CartServiceImpl.getCarts();
        List<Cart> list = CartServiceImpl.filterByPrediCate(carts, new PrediCate() {
            @Override
            public Boolean test(Cart cart) {
                return cart.getTotalPrice() >= 2000;
            }
        });
        System.out.println(JSON.toJSONString(list,true));
    }

}
