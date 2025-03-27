package com.kyungbae.section01.java_config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver"; // mysql-connectior-j 필요
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "kyungbae";
        String pwd = "kyungbae";

        // MyBatis 라이브러리 필요
        // Environment
        Environment environment = new Environment("dev"
                , new JdbcTransactionFactory()
                , new PooledDataSource(driver, url, user, pwd)
        );

        // Configuration
        Configuration configuration = new Configuration(environment);

        // SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        // SqlSession 객체 생성 (MyBatis 객체)
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println(sqlSession);

        sqlSession.close();

    }
}
