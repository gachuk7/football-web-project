package com.example.footballwebproject.comment.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CommentServiceTest {
    @Test
    void pathDelimiterTest() {
        String test = "1/2/3/4/5/";
        String[] str = test.split("/");
        Assertions.assertThat(str.length).isEqualTo(5);
    }

    @Test
    void subCommnetTest(){

    }

}