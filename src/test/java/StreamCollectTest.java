import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StreamCollectTest {

    @Test
    public void test() {
        List<Order> list = new ArrayList() {
            {
                add(new Order(1, "zhangsan", 2, new BigDecimal("2000.5")));
                add(new Order(2, "lisi", 3, new BigDecimal("4000.5")));
                add(new Order(3, "lisi", 5, new BigDecimal("6000.5")));
            }
        };

        HashMap<String, Order> collect = list.stream()
                .parallel()
                .collect(() -> new HashMap<String, Order>(),
                        (map, order) -> {
                            if (map.containsKey(order.getAccount())) {
                                Order getOrder = map.get(order.getAccount());
                                getOrder.setOrderNumber(getOrder.orderNumber + order.orderNumber);
                                getOrder.setOrderPrice(getOrder.getOrderPrice().add(order.getOrderPrice()));
                                map.put(order.account, getOrder);
                            } else {
                                map.put(order.getAccount(), order);
                            }
                        },
                        (map1, map2) -> {
                            System.out.println("进入并行方法");
                            map2.forEach((key, value) -> {
                                map1.merge(key, value, ((order, order2) -> {
                                    return new Order(order.id, key, order.orderNumber + order2.orderNumber, order.getOrderPrice().add(order2.orderPrice));
                                }));
                            });

                        }
                );
        System.out.println(JSON.toJSONString(collect,true));
    }

    class Order {
        private Integer id;
        private String account;
        private Integer orderNumber;
        private BigDecimal orderPrice;

        public Order(Integer id, String account, Integer orderNumber, BigDecimal orderPrice) {
            this.id = id;
            this.account = account;
            this.orderNumber = orderNumber;
            this.orderPrice = orderPrice;
        }

        public String getAccount() {
            return account;
        }

        public Integer getId() {
            return id;
        }

        public Integer getOrderNumber() {
            return orderNumber;
        }

        public BigDecimal getOrderPrice() {
            return orderPrice;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
        }

        public void setOrderPrice(BigDecimal orderPrice) {
            this.orderPrice = orderPrice;
        }

        public void setAccount(String account) {
            this.account = account;
        }
    }
}

