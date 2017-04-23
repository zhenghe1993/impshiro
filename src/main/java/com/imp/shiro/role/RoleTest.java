package com.imp.shiro.role;

import com.imp.shiro.utils.ShiroUtil;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * Created by 郑和明(IMP) ;
 * Created date is  2017/4/23.
 */
public class RoleTest {
    public static void main(String[] args) {
      Subject subject= ShiroUtil.login("classpath:shiro-role.ini","admin","admin");

       if(subject==null){
           return;
       }
        System.out.println(subject.hasRole("role1")?"有role1 角色":"无role1 角色");

        boolean[] res= subject.hasRoles(Arrays.asList("role1","role2","role3"));

        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println(res[2]);

        System.out.println(subject.hasAllRoles(Arrays.asList("role1","role2","role3"))?"有 all 角色":"无 all 角色");



        subject.checkRole("role1");

    }
}
