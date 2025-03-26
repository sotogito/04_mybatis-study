package com.ino.section03.template;

import org.apache.ibatis.session.SqlSession;

import static com.ino.section03.template.Template.getSqlSession;

public class Application {
    public static void main(String[] args) {

        SqlSession sqlSession1 = getSqlSession();
        System.out.println("select : " + sqlSession1);

        SqlSession sqlSession2 = getSqlSession();
        System.out.println("update : " + sqlSession2);

    }
}
