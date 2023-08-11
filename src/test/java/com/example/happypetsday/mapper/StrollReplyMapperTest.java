package com.example.happypetsday.mapper;

import com.example.happypetsday.dto.StrollReplyDto;
import com.example.happypetsday.vo.StrollBoardVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class StrollReplyMapperTest {

    @Autowired
    StrollReplyMapper strollReplyMapper;
    StrollReplyDto strollReplyDto;
    StrollBoardVo strollBoardVo;

    @BeforeEach
    void setUp() {
    }

    @Test
    void insert() {
    }

    @Test
    void selectListPage() {
    }

    @Test
    void selectTotal() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void update() {
    }
}