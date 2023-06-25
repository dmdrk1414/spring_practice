package me.parkseungchan.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 매핑 작업에 사용하는 인터페이스 파일
// member 테이블과 Member 클래스를 매핑하는 코드

@Repository
// 매핑 작업에는 인터페이스 파일이 필요
public interface MemberRepository extends JpaRepository<Member, Long> {
}
