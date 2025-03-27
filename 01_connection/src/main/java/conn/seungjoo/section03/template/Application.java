package conn.seungjoo.section03.template;

import org.apache.ibatis.session.SqlSession;

import static conn.seungjoo.section03.template.Template.getSqlSession;

public class Application {
    public static void main(String[] args) {
        //조회요청
        SqlSession sqlSession = getSqlSession();
        System.out.println("조회요청의 sqlSession " + sqlSession);
 //sqlSession은 트랜잭션처리와 관련된 것이어서 매번 생성돼는게 맞음
        // sqlSessionFactory는 하나만 생성해서 재 사용하면 됨
        //수정 요청
        SqlSession sqlSession2 = getSqlSession();
        System.out.println("수정 요청의 sqlSession:" + sqlSession2);
    }



}
