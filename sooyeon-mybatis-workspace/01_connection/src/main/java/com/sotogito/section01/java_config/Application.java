package com.sotogito.section01.java_config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;



public class Application {
    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver"; /// my-connector-j 라이브러리 필요
        String url = "jdbc:mysql://localhost:3306/menudb";
        String username = "sotogito";
        String password = "sotogito";

        Environment environment = new Environment("dev"
                , new JdbcTransactionFactory()
                , new PooledDataSource(driver, url, username, password)
        );

        Configuration configuration = new Configuration(environment);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println(sqlSession);

        sqlSession.close();

        /// MyBatis 라이브러리 필요
        /**
         * ## Environment
         * 1. DB 접속에 관한 환경 설정 정보를 가지는 인스턴스
         * 2. MyBatis 환경설정객체(Configuration)을 생성하는데 사용함
         *
         * new Environment(환경 정보 이름
         *                  , 트랜잭션매니저 종류 결정
         *                  , 커넥션풀 사용 여부);
         *
         *  1) 환경 정보 이름 : 생성할 해당 환경 정보의 이름 결정
         *  2) 트랜잭션 매니저 종류 : 트랜잭션 처리를 담당하는 객체
         *      - JdbcTransactionFactory : 수동 커밋(권장)
         *      - ManagedTransactionFactory : 자동 커밋
         *  3) 커넥션 풀 사용 여부
         *      - PooledDataSource : Connection Pool 사용(권장)
         *      - UnpooledDataSource :  "            미사용
         *
         *      * Connection Pool : 생성된 Connection 객체를 담아둥 수 있는 영역 (재사용가능)
         *
         */


        /**
         * ## Configration
         * 1. MyBatis 환경 성정 객체
         * 2. DB 접속 관련 정보, Mapper 등록, 별칭(Alias) 등록 등
         *    MyBatis 정역 성정 정보를 담을 수 있음
         *
         * new Configuration( 현재 사용할 환경인 Environment 객체 )
         */
//        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setCacheEnabled(false);


        /**
         * ## SqlSessionFactory
         * 1. SqlSession 객체를 생성하기 위한 택토리 역할의 인터페이스
         * 2. SqlSessionFactoryBuilder 인스턴스의 build 메서드로 생성
         *
         * new SqlSessionFactoryBuilder().build( Configuration객체 : config 파일과 연결된 InputStream객체)
         *
         * 3. 애플리케이션 기동 중에 여러번 빈드되지 않게 싱글톤 패턴 권장
         */


        /**
         * ## SqlSession
         * 1. MyBatis 기능 활용해서 sql문 실행, 트랜잭션 처리, 자원 반납 메서드들을 제공해주는 객체
         * 2. 사용자 요청시마다 생성하고 요청처리가 완료되면 close하는 걸 권장
         *
         * SqlSessionFactory객체.openSeaaion(autocommit활성여부)
         *
         *  SqlSession은 트랜잭션을 위하여 다른 객체여야하지만 SqlSessionFactory는 재사용이 가능하다.
         */
    }
}
