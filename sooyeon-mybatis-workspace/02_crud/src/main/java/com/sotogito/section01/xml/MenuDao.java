package com.sotogito.section01.xml;

import com.sotogito.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDao {
    /**
     * ## MyBatis 방식으로 xml파일에 작성된 spl문 실행
     * sqlSessino.sql 문 종류별 메서드 ("실행할 sql문 지짗"[, sql문 실행시 필요한 데이터]
     *
     * - sql문 종류별 메서드
     *      1) selectList : 해당 sql문의 실행 결과를 List<E> 로 반환해줌(조회 결과가 없을 경우 텅 빈 리스트)
     *      2) selectOne : 해당 sql문의 실행 결과를 T로 반환
     *      3) insert | update | delete : 해당 sql문 실행 결과를 int로 반환
     *
     * - 실행할 sql문 : "Mapper 파일명.sql문의id"
     *       Mapper 파일명 == xml의 namespace값
     *      sql문의 id    == 해당 xml 내의 id값
     *
     * - sql문 실행시 필요한 데이터
     *      무조건 한 개만 전달 가능(Anytype)
     *      즉, 다수의 데이터일 경우 Map 또는 DTO에 담아서 전달
     *      전달된 데이터가 xml의 sql문에 알아서 바인딩됨 (물론 xml에서 바인딩 처리해야됨)
     */

    /**
     * JDBC에서는
     * 1. conn, dto넘기기
     * 2. pr 생성
     * 3. sql문 쿼리 받아오기
     * 4. ?에 바인딩 하나하나하기
     * 5. 지원반납 close
     * 6. 결과 반환
     */
    public int insertMenu(SqlSession sqlSession, MenuDto menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDto menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.deleteMenu", menuCode);
        ///tbl_order_menu에 FK로 설정된 메뉴는 삭제되지 않는다.
        /// Cannot delete or update a parent row
    }

    public List<String> selectMenuNameList(SqlSession sqlSession) {
        /// 여러행을 받아와야한다.
        return sqlSession.selectList("MenuMapper.selectMenuNameList");
    }

    public List<MenuDto> selectOrderableMenuList(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectOrderableMenuList");
    }

    public int selectOrderableMenuCount(SqlSession sqlSession) {
        return sqlSession.selectOne("MenuMapper.selectOrderableMenuCount");
    }

    public MenuDto selectMenuByMenuCode (SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("MenuMapper.selectMenuByMenuCode", menuCode);
    }
}
