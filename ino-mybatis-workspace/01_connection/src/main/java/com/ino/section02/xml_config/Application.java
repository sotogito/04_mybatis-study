package com.ino.section02.xml_config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml"); // classPath 위치로부터의 경로 작성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println(sqlSession);

        sqlSession.close();
    }
}
