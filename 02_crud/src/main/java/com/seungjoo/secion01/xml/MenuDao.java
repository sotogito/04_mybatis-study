package com.seungjoo.secion01.xml;

import com.seungjoo.secion01.xml.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;

public class MenuDao {


    /*
   MyBatis 방식으로 xml파일에 작성된 sql문 실행
   sqlSession.sql문 종류별 메소드("실행할 sql문 지칭"[, sql문 실행시 필요한 데이터
   )
   1. sql문 종류별 메소드
   1) selectList : 해당 sql문의 실행 결과를 List<E>로 반환해줌 (조회 결과가 없을 경우 텅빈 리스트 반환)
   2) selectOne : 해당 sql문의 실행 결과를 T로 반환해줌(조회 결과가 없을 경우null)
   3) intsert, update, delete : 해당 sql문의 실행 결과를 int로 반환해줌


    2. 실행할 sql문 : "Mapper 파일명. sql문의 id"
       Mapper 파일명 == xml의 namespace값
       sql문의 id == 해당 xml 내의 id값

    3. sqlaㅜㄴ 실행시 필요한 데이터
        무조건 한개만 전달가능
        즉, 다수의 데이터일경우 맵또는 dto에 담아서 전달
        전달된 데이터가 xml의 sql문에 알아서 바인딩됨



     */


        public int insertMenu (SqlSession sqlSession, MenuDto menu){
            return sqlSession.insert("MenuMapper.insertMenu", menu);
        }

    }

