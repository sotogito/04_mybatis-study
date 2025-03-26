package com.ino.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
//    public static SqlSession getSqlSession() {
//
//        SqlSessionFactory sqlSessionFactory = null;
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml"); // classPath 위치로부터의 경로 작성
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSession sqlSession = sqlSessionFactory.openSession(false);
//
//        return sqlSession;
//    }

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            InputStream inputStream = null; // classPath 위치로부터의 경로 작성
            try {
                inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        System.out.println(sqlSessionFactory);
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession(false);
    }

}
