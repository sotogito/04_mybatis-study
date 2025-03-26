package com.seungjoo.secion01.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {//최초로 해당 메소드 호출시 -> sqlSessionFactory 객체 생성
            try {
                InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                e.printStackTrace();

            }


        }
        return sqlSessionFactory.openSession(false);

    }
}