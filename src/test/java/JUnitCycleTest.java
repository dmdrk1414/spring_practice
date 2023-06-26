import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    // 전체 테스트를 하기전에
    @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 static 으로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    // 각 테스트 케이스를 시작하기 전에
    @BeforeEach // 테스트 케이스를 시작하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    // 전체 테스트를 마치고 종료하기 전에 1회실행
    @AfterAll // 전체 테스트를 마치고 종료하기 전에 1회 실행하므로 메서드는 static으로 선언
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    // 테이스 케이스마다 종료 전마다
    @AfterEach // 테이스 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}