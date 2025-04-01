package com.kyungbae.section03.common;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.kyungbae.section03.common.Template.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @DisplayName("sqlSession 객체를 정상적으로 가져온다")
    @Test
    void getSqlSessionTest() {
        SqlSession sqlSession = getSqlSession();
        // assertNotNull(sqlSession);
        assertThat(sqlSession).isNotNull();
    }
}