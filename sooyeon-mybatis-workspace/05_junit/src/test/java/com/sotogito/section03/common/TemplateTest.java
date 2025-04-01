package com.sotogito.section03.common;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @DisplayName("SqlSession객체를 정상적으로 가져올 수 있다.")
    @Test
    void getSqlSession() {
        SqlSession sqlSession = Template.getSqlSession();

//        assertNotNull(sqlSession);
        assertThat(sqlSession).isNotNull();
    }
}