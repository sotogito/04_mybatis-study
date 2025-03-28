package com.sotogito.secion03;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSession은 트랜잭션을 위하여 다른 객체여야하지만 SqlSessionFactory는 재사용이 가능하다.
 */
public class Template {

    /// SqlSessionFactory 싱글톤 적용 전 (SqlSessionFactory 호출할 대마다 객체 새로 생성) - 불필요
    /*
    public static SqlSession getSqlSession(){
        SqlSessionFactory sqlSessionFactory = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

       return sqlSessionFactory.openSession(false);
    }
     */


    //SqlSessionFactory 싱글톤 적용 후
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null){
            try {
                InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }



}
