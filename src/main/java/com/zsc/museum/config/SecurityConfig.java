//package com.zsc.museum.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import javax.sql.DataSource;
//@EnableWebSecurity
//public class SecurityConfig  extends WebSecurityConfigurerAdapter{
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //配置url的访问权限
//        http.authorizeRequests()
//                .antMatchers("/tologin").permitAll()
//                .antMatchers("/photosave").permitAll()
//                .antMatchers("/findFirstPage").permitAll()
//                .antMatchers("/estimateEdit").permitAll()
//                .antMatchers("/culturalEntry").permitAll()
//                .antMatchers("/wareHouse").permitAll()
//                .antMatchers("/employees").permitAll()
//                .antMatchers("/borrowDetails").permitAll()
//                .antMatchers("/returnDetails").permitAll()
//                .anyRequest().authenticated();
//
////        //使用自定义的登录窗口
////        http.formLogin()
////                .loginPage("/tologin").permitAll()
////                .usernameParameter("number").passwordParameter("password")
////                //.defaultSuccessUrl("/")
////                .failureUrl("/tologin?error");
//        //实现注销
//        http.logout()
//                .logoutUrl("/mylogout")
//                .logoutSuccessUrl("/tologin");
//    }
//}
