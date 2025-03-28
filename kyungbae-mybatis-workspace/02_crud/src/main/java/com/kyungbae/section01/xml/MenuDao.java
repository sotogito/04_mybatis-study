package com.kyungbae.section01.xml;

import com.kyungbae.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

public class MenuDao {

    public int insertMenu(SqlSession sqlSession, MenuDto menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }
}
