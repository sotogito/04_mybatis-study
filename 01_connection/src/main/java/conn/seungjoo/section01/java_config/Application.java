package conn.seungjoo.section01.java_config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver"; //이 라이브러리 필요
        String url = "jdbc:mysql://localhost:3306/menudb"; //생략시 3306으로 알아서 됨
        String username = "seungjoo";
        String password = "seungjoo";

        //MyBatis 라이브러리 필요
        /*
        1. DB접속에 관한 환경 설정 정보를 가지는 인스턴스
        2. Mybatis 환경설정객체(Configuration)을 생성하는데 사용됨
        3. new Environment(환경정보이름, 트랜잭션매니저종류결정, 커넥션풀)
            1)환경 정보이름 : 생성할 해당 환경 정보의 이름 결정
            2)트랜잭션 매니저 종류: 트랜잭션 처리를 담당하는 객체
                -JdbcTransactionFactory : 수동 커밋(권장)
                -ManageTransactionFactory : 자동 커밋
            3) 커넥션 풀 사용여부
                -PooledDataSource : Connection Pool 사용(권장)
                -UnPooledDataSource : 미사용

                * ConnectionPool : 생성된 Connection 객체를 담아둘 수 있는 영역(재사용 가능)


         */
        Environment environment = new Environment("dev",
                new JdbcTransactionFactory()
                , new PooledDataSource(driver, url, username, password)
                );

        Configuration configuration = new Configuration(environment);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession(false); //오토 커밋 비활성화


        System.out.println(sqlSession);

        sqlSession.close();















    }
}
