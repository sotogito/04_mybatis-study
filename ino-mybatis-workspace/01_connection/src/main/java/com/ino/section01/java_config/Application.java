package com.ino.section01.java_config;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String username = "ino";
        String password = "ino";

        Environment environment
                = new Environment("dev"
                , new JdbcTransactionFactory()
                , new PooledDataSource(driver, url, username, password)
        );

        Configuration configuration = new Configuration(environment);


        SqlSessionFactory sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactoryBuilder.openSession(false);

        System.out.println(sqlSession);
    }
}
