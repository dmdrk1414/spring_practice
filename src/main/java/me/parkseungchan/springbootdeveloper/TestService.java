package me.parkseungchan.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //  @Component 에너테이션이 포함되어 있다. 빈으로 등록한다.
// 비지니스 계층
public class TestService {
    @Autowired // MemberRepository 빈을 주입한다.
    MemberRepository memberRepository; // MemberRepository 빈을 주입한다.

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
