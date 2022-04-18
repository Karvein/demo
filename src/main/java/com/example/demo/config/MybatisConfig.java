package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {
    // 配置数据源,意义在于能够确认数据库应用程序所使用的数据库或者数据库服务器
    @Bean
    /*
        bean标签：指定创建对象的
            id属性：唯一标识（配置文件中唯一）
            class属性：实现类的全限定名,即package.className
            scope属性：范围
                取值：singleton(单例默认) prototype（多例） 扩展：request,session,globesession..
                     singleton:对象是随着容器的创建而创建 随着容器的销毁而销毁 自始至终只有一个对象
                     prototype：对象的创建和销毁与容器的创建和销毁无关
                               每次执行getBean的时候创建新的对象 调用一次创建一次
                               销毁是会等待垃圾回收机制自动完成的
           init-method属性: 对象创建之后指定调用方法
           destroy-method属性：对象销毁后指定调用方法
    */
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
