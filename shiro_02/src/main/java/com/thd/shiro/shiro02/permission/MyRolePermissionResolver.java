package com.thd.shiro.shiro02.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 角色解析器
 */
public class MyRolePermissionResolver implements RolePermissionResolver {
    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleString) {
        if("role1".equals(roleString)) {
            return Collections.singletonList((Permission) new WildcardPermission("menu:*"));
        }

        return null;
    }
}
