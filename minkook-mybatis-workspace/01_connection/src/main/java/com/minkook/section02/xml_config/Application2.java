package com.minkook.section02.xml_config;

import org.apache.ibatis.session.SqlSession;

import static com.minkook.secion03.Template.getSqlSession;

public class Application2 {
    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();
        System.out.println(sqlSession); //org.apache.ibatis.session.defaults.DefaultSqlSession@731a74c

        SqlSession sqlSession2 = getSqlSession();
        System.out.println(sqlSession2); //org.apache.ibatis.session.defaults.DefaultSqlSession@7d907bac
    }
}
