import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组
 * 根据传来的账号Id返回订单数据
 */
public class Case2 {


    @Test
    public void groupTest(){
        List<Order> orders = selectOrderByAccountIds(Arrays.asList("111", "222", "333"));
        Map<String, List<Order>> collect = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getOrderAccount()));
        System.out.println(JSON.toJSONString(collect,true));


    }

    class  Order{
        private Integer orderSn;
        private String orderAccount;

        public Order(Integer orderSn, String orderAccount) {
            this.orderSn = orderSn;
            this.orderAccount = orderAccount;
        }

        public Integer getOrderSn() {
            return orderSn;
        }

        public void setOrderSn(Integer orderSn) {
            this.orderSn = orderSn;
        }

        public String getOrderAccount() {
            return orderAccount;
        }

        public void setOrderAccount(String orderAccount) {
            this.orderAccount = orderAccount;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderSn=" + orderSn +
                    ", orderAccount='" + orderAccount + '\'' +
                    '}';
        }
    }

    public List<Order> selectOrderByAccountIds(List<String> accountIds){
        List<Order> orderList = Lists.newArrayList();
        for (int i = 0; i <10 ; i++) {
            orderList.add(
                    new Order(i,accountIds.get(i % accountIds.size()))
            );
        }
        return  orderList;
    }
}
