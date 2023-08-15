package com.example.happypetsday.service.stroll;

import com.example.happypetsday.dto.StrollReplyDto;
import com.example.happypetsday.dto.UserDto;
import com.example.happypetsday.mapper.StrollReplyMapper;
import com.example.happypetsday.mapper.UserMapper;
import com.example.happypetsday.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@Slf4j
@Transactional
class ReplyServiceTest {

    @Mock
    private StrollReplyMapper replyMapper;

    @InjectMocks
    private StrollService strollService;
    private StrollReplyDto replyDto;

    @BeforeEach
    void setUp() {
    }

    @Test
    void register() {
    }

    @Test
    void findReplyList() {
    }

    @Test
    void findTotal() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void modify() {
    }
}