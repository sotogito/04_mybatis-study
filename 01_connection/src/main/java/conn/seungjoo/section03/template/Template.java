package conn.seungjoo.section03.template;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
/*    public static SqlSession getSqlSession() {
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
    */ //sqlSessionFactory 싱글톤 적용 후
        private static SqlSessionFactory sqlSessionFactory;

        public static SqlSession getSqlSession() {

            if(sqlSessionFactory == null) {//최초로 해당 메소드 호출시 -> sqlSessionFactory 객체 생성
                try {
                    InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

                } catch (IOException e) {
                    e.printStackTrace();

                }
                SqlSession sqlSession = sqlSessionFactory.openSession(false);

                return sqlSession;
            }

    }
}