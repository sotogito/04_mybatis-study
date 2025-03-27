package com.ibe6.section01.xml;

import com.ibe6.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDao {


        /*
         * 기존의 JDBC방식
        public 결과 메소드(Connection conn, 데이터){
            1. PreaparedStatement 생성
            2. 파라미터 바인딩 (? 에 데이터 채우기)
            3. sql 실행
            4. 결과 매핑 (rset 데이터꺼내서 dto의 필드에 담기)
            5. 자원반납
            6. 결과반환
        }
     */


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

    public int updateMenu(SqlSession sqlSession, MenuDto menu){
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int code){
        return sqlSession.delete("MenuMapper.deleteMenu", code);
    }

    public List<String> selectMenuNameList(SqlSession sqlSession){
        return sqlSession.selectList("MenuMapper.selectMenuNameList");
    }

    public List<MenuDto> selectOrderableMenuList(SqlSession sqlSession){
        return sqlSession.selectList("MenuMapper.selectOrderableMenuList");
    }
    public int selectOrderableMenuCount(SqlSession sqlSession){
        return sqlSession.selectOne("MenuMapper.selectOrderableMenuCount");
    }

    public MenuDto selectMenuByCode(SqlSession sqlSession, int code){
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }
}
