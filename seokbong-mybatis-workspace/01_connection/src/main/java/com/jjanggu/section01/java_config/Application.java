package com.jjanggu.section01.java_config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

    public static void main(String[] args){

        String driver = "com.mysql.cj.jdbc.Driver"; // mysql-connector-j 라이브러리 필요
        String url = "jdbc:mysql://localhost:3306/menudb";
        String username = "jjanggu";
        String password = "jjanggu";

        // mybatis 라이브러리 필요
        /*
            ## Environment ##
            1. DB 접속에 관한 환경 설정 정보를 가지는 인스턴드
            2. MyBatis 환경설정객체(Configuration)를 생성하는데 사용됨
            3. new Environment(환경정보이름, 트랜잭션매니저종류결정, 커넥션풀사용여부); 로 생성
               1) 환경정보이름 : 생성할 해당환경 정보의 이름 결정
               2) 트랜잭션 매니저 종류 : 트랜잭션 처리를 담당하는 객체
                  - JdbcTransactionFactory    : 수동 커밋 (권장)
                  - ManagedTransactionFactory : 자동 커밋
               3) 커넥션풀 사용여부
                  - PooledDataSource    : connection pool 사용 (권장)
                  - UnpooledDataSource  :           "    미사용

                  * Connection Pool : 생성된 Connection 객체를 담아둘 수 있는 영역(재사용가능)
         */

        Environment environment
                = new Environment("dev"
                            , new JdbcTransactionFactory()
                            , new PooledDataSource(driver, url, username, password)
                    );

        /*
            ## Configuration ##
            1. MyBatis 환경 설정 객체
            2. DB접속 관련 정보, Mapper 등록, 별칭(Alias) 등록 등
               MyBatis 전역 설정 정보를 담을 수 있음
            3. new Configuration(현재 사용할 환경인 Environment 객체) 로 생성
         */
        Configuration configuration = new Configuration(environment);
        // configuration.addMapper();
        // configuration.setJdbcTypeForNull();

        /*
            ## SqlSessionFactory ##
            1. SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
            2. SqlSessionFactoryBuilder 인스턴스의 build 메소드로 생성
               new SqlSessionFactoryBuilder().build( Configuration객체 | config파일과 연결된 InputStream객체 ) 로 생성
            3. 애플리케이션 기동 중에 여러번 빌드되지 않게 싱글톤 패턴 권장
         */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /*
            ## SqlSession
            1. MyBatis 기능 활용해서 sql문 실행, 트랜잭션 처리, 자원 반납 메소드들을 제공해주는 객체
            2. 사용자 요청시마다 생성하고 요청 처리가 완료되면 close 하는걸 권장
            3. SqlSessionFactory객체.openSession(autocommit활성화여부) 로 생성
         */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println(sqlSession);

        sqlSession.close();







    }
}
