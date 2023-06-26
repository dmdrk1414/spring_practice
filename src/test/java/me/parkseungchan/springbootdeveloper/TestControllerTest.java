package me.parkseungchan.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

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
}