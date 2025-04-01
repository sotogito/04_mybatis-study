package com.younggalee.section03.common;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static com.younggalee.section03.common.Template.getSqlSession;

class TemplateTest {

    @DisplayName("sqlSession 객체를 정상적으로 가져올 수 있다.")
    @Test
    void test() {
        SqlSession sqlSession = getSqlSession();
//        assertNotNull(sqlSession);
        assertThat(sqlSession).isNotNull();
    }
}