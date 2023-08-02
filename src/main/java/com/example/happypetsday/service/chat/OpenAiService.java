package com.example.happypetsday.service.chat;

import com.example.happypetsday.aspect.annotation.LoggingPointCut;
import com.example.happypetsday.vo.AiChatVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenAiService {
    private final WebClient webClient;
    private final String endPoint = "https://api.openai.com/v1/chat/completions";

    /**
     * WebClient를 초기화하는 생성자.
     * WebClient는 생성 비용이 큰 객체이므로, 생성자에서 한 번 초기화
     * @param apiKey OpenAI API 키
     */
    public OpenAiService(@Value("${gpt.api}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl(endPoint)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    /**
     * 원하는 답변 결과를 얻기 위해 기존 메세지 앞에
     * OpenAI에 전송할 메시지를 설정하는 메소드
     * @param list 사용자의 메시지 목록
     * @return 시스템, 사용자, 그리고 어시스턴트의 메시지가 추가된 목록
     */
    private List<AiChatVo> messageSetting(List<AiChatVo> list){
        AiChatVo system = new AiChatVo();
        system.setRole("system");
        system.setContent("You are a customer service representative for our site, capable of answering anything about our website. The name of our site is Happy Pet's Day, and we provide various services for pets. The main features include finding someone to walk your pet with, support and reservation for pet sitters, pet recommendations, and providing information related to pet adoption.\n" +
                "If a question comes in about the features or services on our site, based on the previous question, make the user able to use the service right away by providing them with:\n" +
                "1. <a href=\"/stroll/list\" style=\"font-weight: bolder; font-size: 20px; color: #68a5fe;\">산책메이트 구하기</a> \n" +
                "2. <a href=\"/sitter/list\" style=\" font-weight: bolder; font-size: 20px; color: #68a5fe;\">펫시터 예약</a> \n" +
                "3. <a href=\"/adopt/list\" style=\" font-weight: bolder; font-size: 20px; color: #68a5fe;\">반려동물 입양 정보</a> \n" +
                "4. <a href=\"/recommend/main\" style=\" font-weight: bolder; font-size: 20px; color: #68a5fe;\">반려동물 추천</a>\n" +
                "In the form of 'a tags', place the service name and url exactly as I showed you in the HTML tags.\n" +
                "If a difficult question comes in, or if a user complains, comfort them and provide our company number 111-111-1111 and company email official@elevenliter.com, asking them to contact us. Please answer in Korean and be concise.");

        list.add(0,system);
        AiChatVo user = new AiChatVo();
        user.setRole("user");
        user.setContent("이 사이트는 어떤 기능이나 서비스 있어?");
        list.add(1,user);
        AiChatVo assistant = new AiChatVo();
        assistant.setRole("assistant");
        assistant.setContent("Happy Pet's Day 웹 사이트에는 다음과 같은 서비스들이 있습니다\n" +
                "1. <a href=\"/stroll/list\" style=\"font-weight: bolder; font-size: 20px; color: #68a5fe;\">산책메이트 구하기</a> : 반려동물과 함께 산책할 파트너를 찾을 수 있는 서비스입니다.\n" +
                "2. <a href=\"/sitter/list\" style=\" font-weight: bolder; font-size: 20px; color: #68a5fe;\">펫시터 예약</a>: 여행이나 일상 생활 중에 반려동물을 맡길 수 있는 펫시터를 예약할 수 있는 서비스입니다.\n" +
                "3. <a href=\"/adopt/list\" style=\" font-weight: bolder; font-size: 20px; color: #68a5fe;\">반려동물 입양 정보</a>: 입양하고 싶은 반려동물에 대한 정보와 입양 신청을 할 수 있는 서비스입니다.\n" +
                "4. <a href=\"/recommend/main\" style=\" font-weight: bolder; font-size: 20px; color: #68a5fe;\">반려동물 추천</a>: 자신의 생활 방식과 성향에 맞는 반려동물을 추천받을 수 있는 서비스입니다.\n" +
                "5. 기타 궁금한 사항이나 문의사항에 대해서는 고객센터를 통해 문의하실 수 있습니다.\n" +
                "원하시는 서비스를 이용하시려면 해당 서비스의 링크를 클릭하시면 됩니다.");
        list.add(2,assistant);
        return list;
    }

    /**
     * OpenAI에 전송할 요청 본문을 생성하는 메소드
     * @param list 사용자의 메시지 목록
     * @return OpenAI에 전송할 요청 본문
     */
    private Map<String, Object> createRequestBody(List<AiChatVo> list) {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("model", "gpt-3.5-turbo");
        reqBody.put("messages", messageSetting(list));
        reqBody.put("temperature", 0.8);
        reqBody.put("max_tokens", 1000);
        return reqBody;
    }


    /**
     * OpenAI에 메시지를 보내고 응답을 받는 메소드
     * @param list 사용자의 메시지 목록
     * @return OpenAI로부터 받은 응답
     */
    public Mono<Map> getGptMessage(List<AiChatVo> list) {
        Map<String, Object> requestBody = createRequestBody(list);
        return webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToMono(Map.class);
    }
}