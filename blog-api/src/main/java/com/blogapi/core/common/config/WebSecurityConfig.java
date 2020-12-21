package com.blogapi.core.common.config;

import com.blogapi.core.common.config.JwtConfig;
import com.blogapi.core.security.jwt.JwtAuthenticationFilter;
import com.blogapi.core.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity  //启用Web安全
//@EnableGlobalMethodSecurity(prePostEnabled = true) //开启权限注解,默认是关闭的
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    protected AuthenticationManager authenticationManager;

    // 密码编码器
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER) // 提供一个bean，处理： a bean of type 'org.springframework.security.authentication.AuthenticationManager' that could not be found.
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 用来配置用户签名服务，主要是user-detail是机制。
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置用户名密码服务和密码编码方式
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    /*
     * 用来配置拦截保护的请求，比如什么请求放行，什么请求需要验证
     * */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        // 开启跨域,由于使用的是JWT，我们这里不需要csrf, 取消跨站请求伪造防护
        httpSecurity.cors().and().csrf().disable();

        httpSecurity
                .authorizeRequests()
                // 允许对于网站静态资源的无授权访问
//                .antMatchers(JwtConfig.antMatchers).permitAll()
                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/auth/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                .and()
                // 验证登陆
                .addFilter(new JwtAuthenticationFilter(this.authenticationManager))
                // 鉴权
                .addFilter(new JwtAuthorizationFilter(this.authenticationManager))
                // 基于token，所有不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}

