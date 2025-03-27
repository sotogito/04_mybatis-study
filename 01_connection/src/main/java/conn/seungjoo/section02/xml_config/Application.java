package conn.seungjoo.section02.xml_config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {


        //환경설정 관련 구문을 자바 코드가 아닌 외부 xml파일에 작성해서 적용

        SqlSessionFactory sqlSessionFactory = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();

        }
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println(sqlSession);
        sqlSession.close();
    }
}