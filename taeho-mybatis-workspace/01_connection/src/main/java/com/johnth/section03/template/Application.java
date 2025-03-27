package com.johnth.section03.template;

import org.apache.ibatis.session.SqlSession;

import static com.johnth.section03.template.Template.getSqlSession;

public class Application {
    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();
        System.out.println(sqlSession);

        SqlSession sqlSession2 = getSqlSession();
        System.out.println(sqlSession2);
    }
}
