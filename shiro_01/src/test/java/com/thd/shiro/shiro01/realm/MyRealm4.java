package com.thd.shiro.shiro01.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author TaoHuadeng
 * @version 1.0
 * @since 2016年03月26日13:21:28
 */
public class MyRealm4 implements Realm {

    public String getName() {
        return "myrealm4";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken; //仅支持UsernamePasswordToken类型的Token
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();  //得到用户名
        String password = new String((char[]) token.getCredentials()); //得到密码
        if (!"tao".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }

        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }

        System.out.println("MyRealm4 SimpleAuthenticationInfo");
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
