package me.parkseungchan.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {
    @Autowired
    MemberRepository memberRepository; // members CRUD 사용편하게 하는

    public void test() {
        // 1. 생성 (Create)
        memberRepository.save(new Member(1L, "A"));

        // 2. 초회 (Read)
        Optional<Member> member = memberRepository.findById(1L); // 단건 조회
        List<Member> allMembers = memberRepository.findAll(); // 단체 조회

        // 3. 삭제 (Delete)
        memberRepository.deleteById(1L);
    }
}
