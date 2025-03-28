package com.sotogito.section02.mapper_interface;

import com.sotogito.dto.MenuDto;

import java.util.List;

public interface MenuMapper {
    /// mapper.xml에 정의한 mapper id와 동일한 메서드명
    int insertMenu(MenuDto menu);

    /// 내부적으로 sqlSession.insert("MenuMapper.insertMenu", menu) 호출된 것과 같음
    MenuDto selectMenuByCode(int menuCode);

    int selectMenuCountBelowPrice(int price);

    /// 인터페이스 매퍼를 사용하면 selectOne, selectList 이런 거는 자동으로 처리
    List<MenuDto> selectMenuListByCategoryName(String categoryName);

}
