import com.google.common.collect.HashMultiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

public class MultiSetTest {
    /**
     * gava提供的集合类
     */
    @Test
    public void  test1(){
        String str = "收到货后厚度佛i对收哦王瑞沃尔u日哦为是上次你那边四道口附近";

        char[] chars = str.toCharArray();

        HashMultiset<Character> hashMultiset = HashMultiset.create();

        Chars.asList(chars).stream()
                .forEach(character -> {hashMultiset.add(character);});

        System.out.println("总共有" + hashMultiset.size() + "个字符");
        System.out.println("收子有" + hashMultiset.count('收') + "个");
    }

}
