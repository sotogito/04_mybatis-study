package com.johnth.section01.java_config;

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
        String username = "TH";
        String password = "root";

        /*
            # Environment
            1. DB접속에 관한 환경설정 정보를 가지는 인스턴스
            2. Mybatis 환경설정객체(Configuration) 를 생성하는데 사용
            3. Environment {name} = new Environment(); 선언
                1) 환경정보이름: 생성할 해당 환경정보의 이름 결정
                2) 트랜잭션 매니저 종류: 트랜잭션 처리를 담당하는 객체
                            CLASS                                     Mybatis XML
                    - JDBCTransactionFactory        : 수동 커밋 <transactionManager type="JDBC"/>
                    - ManagedTransactionFactory    : 자동 커밋 <transactionManager type="Managed"/>
                3) 커넥션 풀(Connection Pool) 사용여부
                    - PooledDataSource              : Connection Pool 사용(권장) <dataSource type="POOLED">
                    - UnPooledDataSource            :         //      미사용     <dataSource type="UNPOOLED">

                    * Connection Pool: 생성된 Connection 객체를 담아둘 수 있는 영역(재사용가능)
         */
        Environment environment = new Environment("dev"
            , new JdbcTransactionFactory()
            , new PooledDataSource(driver, url, username, password));

        /*
            # Configuration
            1. Mybatis 환경 설정 객체
            2. DB접속 관련 정보, Mapper 등록, 별칭 등록 등 전역 설정정보를 담을 수 있음
            3. new Configuration(현재 사용할 환경인 Enviroment 객체)로 생성
         */
        Configuration configuration = new Configuration(environment);

        /*
            # SqlSessionFactory
            1. SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
            2. SqlSessionFactoryBuilder 인스턴스의 build 메서드로 생성
                new SqlSessionFactoryBuilder().build(Configuration 객체 / config파일과 연결된 InputStream객체 )로 생성
            3. Singleton Pattern 권장
         */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /*
            # SqlSession
            1. MyBatis 기능을 활용해서 sql문 실행, 트랜잭션 처리, 자원반납 메서드들을 제공해주는 객체
            2. 사용자 요청시마다 생성하고 요청처리가 완료되면 close 권장
            3. SqlSessionFactory객체.openSession(autocommit활성화여부)로 생성
         */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println(sqlSession);

        sqlSession.close();

    }
}
