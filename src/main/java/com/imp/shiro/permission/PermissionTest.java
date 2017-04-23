package com.imp.shiro.permission;

import com.imp.shiro.utils.ShiroUtil;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * Created by 郑和明(IMP) ;
 * Created date is  2017/4/23.
 */
public class PermissionTest {
    public static void main(String[] args) {
      Subject subject= ShiroUtil.login("classpath:shiro-permission.ini","admin","admin");

       if(subject==null){
           return;
       }

        System.out.println(subject.isPermitted("user:save")?"有该权限":"无该权限");

        System.out.println(subject.isPermitted(new WildcardPermission("user:update"))?"有该权限":"无该权限");

        System.out.println(subject.isPermittedAll("user:update","user:delete")?"有该权限":"无该权限");

        boolean [] res=subject.isPermitted("user:save","user:add");
        System.out.println(res[0]);
        System.out.println(res[1]);



        subject.checkPermission("user:add");
    }
}
