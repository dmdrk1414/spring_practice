package me.parkseungchan.springbootdeveloper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityManagerTest {
    //    @Autowired // EntityManager 을 주입한다.
    @PersistenceContext // EntityManager 을 할당 주입
            EntityManager em;

    public void example() {
        // 1. 엔티티 메니저가 엔티티를 관리하니 않는 상태 (비영속 상태)
        Member member = new Member(1L, "홍길동");

        // 2. 엔티티가 관리 상태가 됩니다 (관리 상태).
        em.persist(member);

        // 3. 엔티티 객체가 분리된 상태가 됩니다. (분리 상태)
        em.detach((member));

        // 4. 엔티티 객체가 삭제된 상태가 됩니다. (삭제 상태).
        em.remove(member);
    }
}
