package com.pink.freecoffee.shiro;

import com.pink.freecoffee.filter.ShiroFormAuthenticationFilter;
import com.pink.freecoffee.filter.ShiroRolesAuthorizationFilter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cyb
 */
@Configuration
public class ShiroConfig {
    //创建realm对象
    @Bean
    MyRealm myRealm() {
        MyRealm myRealm = new MyRealm();
        //修改凭证校验匹配器
        /*HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        myRealm.setCredentialsMatcher(credentialsMatcher);*/
        return myRealm;
    }

    //安全管理器
    @Bean
    DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联realm
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager());

        LinkedHashMap<String, Filter> filterLinkedHashMap = new LinkedHashMap<>();
        filterLinkedHashMap.put("authc", new ShiroFormAuthenticationFilter());
        filterLinkedHashMap.put("roles",new ShiroRolesAuthorizationFilter());
        bean.setFilters(filterLinkedHashMap);

        //添加过滤器 拦截
        /*
            anon: 无需认证
            authc: 必须认证
            user: 必须有 remember me 才能用
            perms: 拥有对某个资源的权限才能访问
            role: 拥有对某个角色的权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/api/v1/login", "anon");
        filterMap.put("/api/v1/me", "anon");
        filterMap.put("/api/v1/**", "authc");
        filterMap.put("/admin/ping", "anon");
        filterMap.put("/admin/login", "anon");
        filterMap.put("/admin/**", "roles[root]");
        filterMap.put("/success.html","anon");
        filterMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登陆请求

        return bean;
    }
}