import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamReduceTest {

    @Test
    public void test() {

        List<Order> list = new ArrayList() {
            {
                add(new Order(1, 2, new BigDecimal("2000.5")));
                add(new Order(2, 3, new BigDecimal("4000.5")));
                add(new Order(3, 5, new BigDecimal("6000.5")));
            }
        };
        BigDecimal reduce1 = list.stream()
                .map(order -> order.getOrderPrice())
                .reduce(new BigDecimal("0"),
                        BigDecimal::add,
                        BigDecimal::add);
        System.out.println(JSON.toJSONString(reduce1, true));


    }

    class Order {
        private Integer id;
        private Integer orderNumber;
        private BigDecimal orderPrice;

        public Order(Integer id, Integer orderNumber, BigDecimal orderPrice) {
            this.id = id;
            this.orderNumber = orderNumber;
            this.orderPrice = orderPrice;
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
    }
}

