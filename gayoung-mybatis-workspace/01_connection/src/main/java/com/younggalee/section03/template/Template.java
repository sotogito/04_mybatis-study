package com.younggalee.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {

    /*
    // SqlSesstionFactory 싱글톤 적용전

    public static SqlSession getSqlSession(){
        SqlSessionFactory sqlSessionFactory = null;
        try { // 하지만 이 부분은 매번 읽어올 필요 없음. 최초의 한번 실행 후 재사용해야함. (기존에 생성하던거 사용하도록 하기)
            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml"); // classpath 위치로부터 경로 작성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // 호출마다 트랜잭션처리를 위해 매번 생성되어야하는 것 맞음

        return sqlSession;
    }

    */

    // sqlSessionFactory 싱글톤 적용 후
    private static SqlSessionFactory sqlSessionFactory; // 최초는 생성만, null
    // 실행은 나중에 되어도 프로그램 구동시 우선 할당할 것임.

    public static SqlSession getSqlSession(){
        if(sqlSessionFactory == null) { // 생성되지 않은 경우, 현재 최초로 메소드를 호출시킨 상황
            try {
                InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml"); // classpath 위치로부터 경로 작성
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 두번째 호출시부터는 if문 안의 구문 실행되지 X
        System.out.println("sqlSesstionFactory: " + sqlSessionFactory);

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        return sqlSession;
    }
    // close, commit, rollback 따로 만들 필요 없음. session 가지고 다 할 수 있다함.
}
