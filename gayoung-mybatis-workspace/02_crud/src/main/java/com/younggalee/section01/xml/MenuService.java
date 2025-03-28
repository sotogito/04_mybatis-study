package com.younggalee.section01.xml;


import com.younggalee.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import static com.younggalee.section01.xml.Template.getSqlSession;

//DB와 연결된 커넥션 객체를 생성했었는데
// 그 대신에 SQLSession객체를 생성할 것임.
public class MenuService {

    private MenuDAO menuDao = new MenuDAO();
    // 템플릿 만들어 놓은거 사용
    public int insertMenu(MenuDto menu){
        SqlSession sqlSession = getSqlSession();
        int result = menuDao.insertMenu(sqlSession, menu);

        if (result > 0) { //성공 > commit
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;

    }

}
