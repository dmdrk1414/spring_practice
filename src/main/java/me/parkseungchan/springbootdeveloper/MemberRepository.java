package me.parkseungchan.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 매핑 작업에 사용하는 인터페이스 파일
// member 테이블과 Member 클래스를 매핑하는 코드

@Repository
// 매핑 작업에는 인터페이스 파일이 필요
// 기본 CRUD 메서드를 사용하기 위한 JpaRepository 상속예시
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Parameter
    //	관리한 엔티티 이름 : Member
    //	엔티티 기본키의 타입 : Long
}