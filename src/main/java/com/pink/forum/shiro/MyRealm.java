package com.pink.forum.shiro;

import com.pink.forum.entity.User;
import com.pink.forum.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cyb
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登陆的对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal(); // 拿到User

        //设置当前用户的权限
        info.addRole(currentUser.getAuthorization());

        //return info
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userService.selectByName(userToken.getUsername());

        if (user == null || user.getStatus() != 0) {
            System.out.println(userToken.getUsername());
            return null; // 抛出UnknownAccountException
        }

        // 密码认证 shiro自己做
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
    }
}