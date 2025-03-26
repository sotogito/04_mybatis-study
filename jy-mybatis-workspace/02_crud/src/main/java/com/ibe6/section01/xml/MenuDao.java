package com.ibe6.section01.xml;

import com.ibe6.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

public class MenuDao {

    /*
        ## MyBatis 방식으로 xml파일에 작성된 sql문 실행 ##
        sqlSession.sql문종류별메소드( "실행할sql문 지칭"[, sql문실행시 필요한데이터] )

        1. sql문 종류별 메소드
           1) selectList  : 해당 sql문의 실행 결과를 List<E>로 반환해줌 (조회결과가 없을 경우 텅빈리스트)
           2) selectOne   : 해당 sql문의 실행 결과를 T로 반환해줌 (조회결과가 없을 경우 null)
           3) insert|update|delete : 해당 sql문의 실행 결과를 int로 반환해줌

        2. 실행할 sql문 : "Mapper파일명.sql문의id"
            Mapper파일명 == xml의 namespace값
            sql문의 id == 해당 xml내의 id값

        3. sql문 실행시 필요한 데이터
            무조건 한 개만 전달 가능 (AnyType)
            즉, 다수의 데이터일 경우 Map 또는 DTO에 담아서 전달
            전달된 데이터가 xml의 sql문에 알아서 바인딩됨 (물론 xml에서 바인딩 처리해야됨)

     */
    public int insertMenu(SqlSession sqlSession, MenuDto menu){
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }
}
