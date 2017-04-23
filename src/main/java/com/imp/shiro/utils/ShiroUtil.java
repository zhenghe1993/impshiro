package com.imp.shiro.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by 郑和明(IMP) ;
 * Created date is  2017/4/23.
 */
public class ShiroUtil {



    public static Subject login(String configPath,String username,String password){

        Factory<SecurityManager> factory=new IniSecurityManagerFactory(configPath);
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken(username,password);

        try{
            subject.login(token);
            System.out.println("登陆成功");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
            subject=null;
        }

        return subject;
    }
}
