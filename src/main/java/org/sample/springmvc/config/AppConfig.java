package org.sample.springmvc.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.sample")
public class AppConfig extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver(); 
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        System.out.println("Set SqlSessionFactory");
        
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(sqlSessionFactory);

        return sqlSessionFactory;
    }
}
