package com.example.happypetsday.controller.chat;

import com.example.happypetsday.aspect.annotation.LoggingPointCut;
import com.example.happypetsday.service.chat.OpenAiService;
import com.example.happypetsday.vo.AiChatVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/chatBot")
@RequiredArgsConstructor
public class OpenAiController {
    private final OpenAiService openAiService;

    @PostMapping("/question")
    public Mono<Map> question(@RequestBody List<AiChatVo> list) {
        return openAiService.getGptMessage(list);
    }
}
























