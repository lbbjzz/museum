package com.zsc.museum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocalResovel implements LocaleResolver {
//    先获取HTTP请求的语言，然后根据语言创建区域对象locale.
//自定义区域解析方式

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest){
        String l = httpServletRequest.getParameter("l");
        String header = httpServletRequest.getHeader("Accept-Language");
        Locale locale=null;
        if (!StringUtils.isEmpty(l)){
            String[] split=l.split("_");
            locale=new Locale(split[0],split[1]);

        }else{
//            Accept-Language: zh-CN,zh;q=0.9
            String[] splits=header.split(",");
            String[] split=splits[0].split("-");
            locale=new Locale(split[0],split[1]);
        }
        return locale;

    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse,@Nullable Locale locale){

    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocalResovel();
    }

}
