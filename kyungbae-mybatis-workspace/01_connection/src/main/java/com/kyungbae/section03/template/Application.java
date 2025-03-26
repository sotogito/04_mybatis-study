package com.kyungbae.section03.template;

import org.apache.ibatis.session.SqlSession;

import static com.kyungbae.section03.template.Template.getSqlSession;

public class Application {
    public static void main(String[] args) {

        // 조회요청시 sqlSession 생성
        SqlSession sqlSession1 = getSqlSession();
        System.out.println("조회요청세션 : " + sqlSession1);

        // 수정요청
        SqlSession sqlSession2 = getSqlSession();
        System.out.println("수정요청세션 : " + sqlSession2);

    }
}
