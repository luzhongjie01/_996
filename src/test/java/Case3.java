import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 按照条件排序先后循序
 */
public class Case3 {
    private ArrayList<Trade> trades = null;

    @Before
    public  void initData(){
        trades = Lists.newArrayList();
        trades.add(new Trade(300.0,4,new Date(),"企业"));
        trades.add(new Trade(4500.0,9,new Date(),"个人"));
        trades.add(new Trade(400.0,8,new Date(),"个人"));
        trades.add(new Trade(4500.0,9,new Date(),"企业"));
        trades.add(new Trade(100.0,2,new Date(),"个人"));
        trades.add(new Trade(150.0,1,new Date(),"企业"));

    }


    @Test
    public void sortTest(){
        System.out.println(JSON.toJSONString(trades,true));
        System.out.println("***********************");
        List<Trade> collect = trades.stream()
                .sorted(Comparator.comparing(Trade::getPrice, Comparator.reverseOrder())
                        .thenComparing((Trade::getCreateTime))
                        .thenComparing(Trade::getCount, Comparator.reverseOrder())
                        .thenComparing(Trade::getUnit, (type1, type2) -> {
                            if ("企业".equals(type1) && "个人".equals(type2)) return -1;
                            if ("个人".equals(type1) && "企业".equals(type2)) return 1;
                            return 0;
                        })).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect,true));
    }

}


class Trade{
    private Double price;
    private Integer count;
    private Date createTime;
    private String unit;

    public Trade(Double price, Integer count, Date createTime, String unit) {
        this.price = price;
        this.count = count;
        this.createTime = createTime;
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}


