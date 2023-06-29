package me.parkseungchan.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// JpaRepository에서 제공하는 메서드의 사용 방법을 보자.
@Service // Service <-  Repository -> DB
public class SpringDataJPAExampleMethod {
    @Autowired
    MemberRepository memberRepository; // Member(엔티티)관련 DB에 CRUD사용을 위한 레포지토리

    public void test() {
        // 1. 생성(Create)
        // save()메서드를 호출해 데이터 객체를 저장가능
        // 전달 인수로 엔티티 Member를 넘긴다.
        // 반환값으로 저장한 엔티티를 반환 받을 수 있다.
        memberRepository.save(new Member(1L, "A"));

        // 2. 조회(Read)
        // findById() 메서드에 id를 지정해 엔티티를 하나 조회 가능
        Optional<Member> member = memberRepository.findById(1L); // 단건 조회
        // findAll() 메서드는 전체 엔티티를 조회 가능
        List<Member> allMembers = memberRepository.findAll(); // 전체 조회

        // 3. 삭제(Delete)
        // deleteById() 메서드에 id를 지정하면 엔티티를 삭제 가능
        // 엔티티를 전달 인수로 넘겨 삭제할 수 있다
        memberRepository.deleteById(1L);
    }
}