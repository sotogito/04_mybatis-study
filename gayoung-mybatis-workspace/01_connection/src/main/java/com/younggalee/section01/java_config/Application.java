package com.younggalee.section01.java_config;

import jdk.jshell.spi.ExecutionEnv;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession.*;

public class Application {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver"; // mysql-connector-j 라이브러리 필요
        String url = "jdbc:mysql://localhost:3306/menudb";
        String username = "YoungGaLee";
        String password = "younggalee";

        // 마이바티스객체 (sql 실행, 반납용) sqlSession객체생성
        // 해당 객체를 생성하기 위해 environmnet 객체가 필요함

        /*
            ## Environmnet ##
            1. DB 접속에 관한 환경 설정 정보를 가지는 인스턴스
            2. MyBatis 환경설정객체(Configuration)를 생성하는데 사용됨
            3. new Environmnet(환경정보이름, 트랜젝션매니저종류결정, 커넥션풀사용여부);
                - 환경정보이름 : 생성할 해당환경정보의 이름결정 (ex개발용환경, 운영용환경, 테스트용 ..)
                - 트랜젝션매니저 종류 : 트랜잭션 처리를 담당하는 객체
                                - JdbcTranscationFactory : 수동 커밋 (권장)
                                - ManagedTransactionFactory : 자동 커밋
                - 커넥션풀 : 생성된 Connection 객체를 담아 놓을 수 있는 영역 (재사용가능)
                                - PooledDataSource : Connection Pool 사용 (권장)
                                - UnpooledDataSource : " 미사용


         */

        Environment env
                = new Environment("dev"  /* 운영환경은 보통 production  */
                            , new JdbcTransactionFactory() /* 수동커밋 */
                            , new PooledDataSource(driver, url, username, password)
                    );

        /*
            ## Configuration ##
            1. MyBatis 환경설정 객체
            2. environment를 포함하고 있음. DB 접속 관련 정보, Mapper 등록, 별칭(Alias) 등록 등
               MyBatis의 전역 설정 정보들을 담을 수 있음
            3. new Configration(현재사용할 환경객체)
         */

        Configuration conf = new Configuration(env); // 설정 추가 가능 (전역에 반영할)

        /*
            ## SqlSesstionFactory ##
            1. SqlSesstion 객체를 생성하기 위한 팩토리 역할의 인터페이스
            2. SqlSesstionFactoryBuilder 인스턴스의 buile메소드로 생성
                new SqlSesstionFactoryBuilder().build(Configuration 객체 | config.xml 파일과 연결된 InputStream 객체) 로 생성
            3. 어플리케이션 기동 중에 여러번 빌드되지 않게 싱글톤 패턴 권장
         */

        SqlSessionFactory sqlSesstionF = new SqlSessionFactoryBuilder().build(conf);

        /*
            ## SqlSession ##
            1. MyBatis 기능 활용해서 sql문 실행, 트랜잭션 처리, 자원반납 메소드들을 제공해주는 객체
            2. 사용자 요청시마다 생성하고 요청처리가 완료되면 close 하는걸 권장
            3. SqlSessionFactory 객체.openSession(autocommit 활성화 여부)  로 생성
         */
        SqlSession sqlSession = sqlSesstionF.openSession(false);

        System.out.println(sqlSession);
        sqlSession.close();


    }
}




















