package com.thd.shiro.shiro02;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RoleTest extends BaseTest {

    /**
     * Shiro提供了 hasRole/hasRoles 用于判断用户是否拥有某个角色/某些权限；但是没有提供如
     * hashAnyRole用于判断是否有某些权限中的某一个。
     * <p/>
     * Shiro提供了 hasAllRoles 用于判断用户是否拥有全部角色/权限，并返回对应结果集
     */
    @Test
    public void testHasRole() {
        login("classpath:shiro-role.ini", "tao", "123456");
        //判断拥有角色：role1
        Assert.assertTrue(subject().hasRole("role1"));
        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }

    /**
     * Shiro提供的checkRole/checkRoles和hasRole/hasAllRoles不同的地方是它在判断为假的情况下会抛出
     * UnauthorizedException异常。
     */
    @Test
    public void testCheckRole() {
        login("classpath:shiro-role.ini", "tao", "123456");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        try {
            subject().checkRoles("role1", "role3");
        } catch (AuthorizationException e) {
            Assert.assertEquals("Subject does not have role [role3]", e.getMessage());
        }
    }
}
