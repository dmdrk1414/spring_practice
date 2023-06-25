package me.parkseungchan.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 서비스 - 비즈니스 계층

// 라우터 역활을 하는 에너테이션
// 라우터란 GTTP 요청과 메서드를 연결하는 장치를 말한다.
// 이 에너테이션이 있으야 클라이언트의 요청에 맞는 메서드를 실행가능
@RestController
// TestController을 라우터로 지정해
// /test 라는 GET 요청이 왔을 때 test() 메서드를 실행하도록 구성
public class TestController {
    @Autowired // TestService 빈 수입
    TestService testService; // TestService 빈 주입

    @GetMapping("/test") // /test GET 요청이 오면 test() 메서드 실행
    public List<Member> getAllMembers(){
        List<Member> members = testService.getAllMembers();
        return members;
    }
}
