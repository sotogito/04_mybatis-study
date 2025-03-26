package com.podoseee.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
/* // SqlSessionFactory 싱글톤 적용 전
    public static SqlSession getSqlSession(){

        SqlSessionFactory sqlSessionFactory = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml"); // classpath 위치로부터 경로 작성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("sqlSessionFactory: " + sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        return sqlSession;
    }
 */

  // SqlSessionFactory 싱글톤 적용 후
  private static SqlSessionFactory sqlSessionFactory;

  public static SqlSession getSqlSession(){

      if(sqlSessionFactory == null){ // 최초로 해당 메소드 호출시 => sqlSessionFactory 객체 생성
          try {
              InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml"); // classpath 위치로부터 경로 작성
              sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      // 두 번째 호출시부터는 if 안의 구문 실행 x
      System.out.println("sqlSessionFactory: " + sqlSessionFactory);

      SqlSession sqlSession = sqlSessionFactory.openSession(false);
      return sqlSession;
  }


}
