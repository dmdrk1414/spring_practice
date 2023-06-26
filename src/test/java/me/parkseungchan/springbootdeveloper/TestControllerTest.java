package me.parkseungchan.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 메인 애플리케이션 클래스에 추가하는 애너테이션인 @SpringBootApplication이 있는 클래스 찾고
//클래스 에 포함되어 있는 빈을 찾은 다음, 테스트용 애플리케이션 컨텍스트라는 것을 만든다
@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성

// MockMvc 생성 , MockMvc 는 어플리케이션을 서버에 배포하지 않고, 테스트용 MVB 환경을 만들어 요청 및 정송, 응답 기능을 제공하는 것
// 컨트롤러를 테스트할 때 사용되는 클래스
@AutoConfigureMockMvc
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build(); // MockMVC 설정
    }

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }


    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when
        // perform() 메서드는 요청을 전송하는 역할을 하는 메서드 결과로 ResultActions객체를 얻는다.
        // ResultActions 객체는 반환값을 검증하고 확인하는 andExpect() 메서드를 제공한다.
        final ResultActions result = mockMvc.perform(get(url)
                // 요청을 보낼 때 무슨 타입으로 응답을 받을지 결정하는 메서드
                // JSON, XML 등 다양한 타입이 있지만, 여기에서는 JSON을 받는다고 명시해두도록 합니다.
                .accept(MediaType.APPLICATION_JSON));

        // then
        result
                // andExpect() 메서드는 응답을 검증한다., 응답으로200(OK)을 반환하므로 isOk를 사용해 응답 코드가 OK(200)인지 확인
                .andExpect(status().isOk())
                
                // 응답의 0번째 값이 DB에서 저장한 값과 같은지 확인
                // jsonPath("$[0].${필드명}")은 JSON 응답값의 값을 가져오는 역할을 하는 메서드
                // 0번째 배열에 들어있는 객체의 id, name값을 가져오고, 저장된 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}