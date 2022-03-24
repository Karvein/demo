package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoad() throws SQLException {
        System.out.println("Datasource Type :"+dataSource.getClass());
        System.out.println("Datasource Connector"+dataSource.getConnection());
    }
}
