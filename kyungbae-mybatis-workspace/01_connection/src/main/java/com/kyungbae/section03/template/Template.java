package com.kyungbae.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /* // SqlSessionFactory 싱글턴 생성 전
    public static SqlSession getSqlSession(){

        SqlSessionFactory sqlSessionFactory = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        return sqlSession;
    }
     */
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        if (sqlSessionFactory == null) {
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sqlSessionFactory : " + sqlSessionFactory);

        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession;
    }

}
