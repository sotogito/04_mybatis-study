package com.younggalee.section01.xml;

import com.younggalee.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

public class MenuDAO {

    /*
        ## MyBatis 방식으로 xml파일에 작성된 sql문 실행 ##
        sqlSession.sql문종류별메소드("실행할 sql문 지칭"[, sql문 실행시 필요한 데이터] )

        1. sql문 종류별 메소드
            1) selectList : 해당 sql문의 실행 결과를 List<E>로 반환해줌 (조회결과 없을경우, 텅빈리스트)
            2) selectOne  : 해당 sql문의 실행결과를 T로 반환해줌 (조회결과가 없을 경우 null)
            3. insert|update|delete : 해당 sql문의 실행결과를 int로 반환해줌

        2. 실행할 sql문 : "mapper 파일명.sql문의 id"
            Mapper파일명 == xml 파일의 namespace값
            sql문의 id == 해당 xml내의 id값

        3. sql문 실행시 필요한 데이터 무조건 한개만 전달 가능 (하지만 형태는 상관없음)
           (즉, 다수의 데이터를 전달해야할 경우, Map 또는 DTO에 담아서 전달)
           전달된 데이터가 xml의 sql문에 알아서 바인딩됨 (물론 xml에서 바인딩 처리해야함)
     */

    public int insertMenu(SqlSession sqlSession, MenuDto menu){
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }
}
