import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Case1 {

    /**
     * 扁平化
     * 求出当前用户的所有权限
     */
    @Test
    public void flatMapTest(){
        List<Role> list = new ArrayList();
        Role adminRole = new Role();
        List<Permission> permissions = Lists.newArrayList(
                new Permission("新增"),
                new Permission("查询"),
                new Permission("修改"),
                new Permission("删除") );
        adminRole.setPermissionList(permissions);
        list.add(adminRole);
        Role userRole = new Role();
        List<Permission> permissions2 = Lists.newArrayList(
                new Permission("新增"),
                new Permission("下载"));
        userRole.setPermissionList(permissions2);
        list.add(userRole);
        list.stream()
                .flatMap(role -> role.getPermissionList().stream())
                .distinct()
                .forEach(permission -> {
                    System.out.println(permission);
                });



    }

    class  Role{
        private List<Permission> permissionList;

        public List<Permission> getPermissionList() {
            return permissionList;
        }

        public void setPermissionList(List<Permission> permissionList) {
            this.permissionList = permissionList;
        }
    }


    class Permission{
        private String name;

        public Permission(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Permission{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
