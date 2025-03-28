package com.johnth.dto;

import org.apache.ibatis.session.SqlSession;

public class MenuDao {
    /*
        Mybatis 방식으로 xml파일에 작성된 sql 실행
        sqlSession.sqlMethod("runSQL, data")
     */
    public int insertMenu(SqlSession sqlSession, MenuDto menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }
}
