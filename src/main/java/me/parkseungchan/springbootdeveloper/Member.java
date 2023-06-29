package me.parkseungchan.springbootdeveloper;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 퍼시스턴트 계층 - db 관련
// Member DAO를 생성하고 실제 DB에 접근하는 코드를 작성

// 'member'라는 이름의 테이블에 접근하는 데 사용할 객체

// ---------------------------------------------
// 1. 엔티티로 지정
// @Entity 애너테이션은 Member 객체를 JPA가 관리하는 엔티티로 지정한다.
// Member 클래스와 실제 데이터 베이스의 테이블을 매핑
// @Entity의 속성중 name을 사용하면 name의 값을 가진 테이블 이름과 매핑
// 지정을 안하면 클래스 이름과 같은 데이터베이스의 테이블인 member 테이블과 매핑
// @Entity(name = "member_list")
@Entity
@Getter

// 2. 기본 생성자
// protected 기본 생성자이다.
// 엔티티는 반드시 기본 생성자가 있어야 하고, 접근 제어자는 public 또는 protected여야 한다.
// protected가 더 안전하다
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    // 3. id 필들르 기본키로 지정
    // @Id는 Long 타입의 id 필드를 테이블의 기본키로 지정한다.
    @Id

    // 4. 기본키 자동으로 1씩 증가.
    // @GeneratedValue는 기본키의 생성 방식을 결정한다.
    // 여기서는 자동으로 기본키가 증가하도록 지정했다.
    // 밑에 표로 정리했다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    // 5. name이라는 not null 컬럼과 매핑
    // @Column 애너테이션은 데이터베이스의 컴럼과 필드를 매핑해준다.
    // 대표적인 @Column 애너테이션의 속성 표 밑에 있다.
    @Column(name = "name", nullable = false)
    private String name;
}