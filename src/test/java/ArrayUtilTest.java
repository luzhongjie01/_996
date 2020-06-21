import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayUtilTest {
    public static void main(String[] args) {
        //集合工具方法
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> set2 = Sets.newHashSet(4, 5, 6);
        //并集(双方独有的)
        System.out.println(Sets.union(set1,set2));

        //交集(双方一致的值)
        System.out.println(Sets.intersection(set1,set2));


        //差集(属于A,不属于B)
        System.out.println(Sets.difference(set1,set2));


        //相对差集(属于A,不属于B,属于B,不属于A)
        System.out.println(Sets.symmetricDifference(set1,set2));


        //把集合中的内容按照不同组合进行拆分
        System.out.println(JSON.toJSONString(Sets.powerSet(set1)));


        //笛卡尔积(A和B集合中的元素相乘)
        System.out.println(Sets.cartesianProduct(set1,set2));


        List list = Lists.newArrayList(1,2,3,4,5,6);

        //工具第二个参数把集合中的内容进行拆分
        System.out.println(Lists.partition(list,3));

        //反转
        System.out.println(Lists.reverse(list));

    }
}
