import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 테스트 코드 만드는 법
public class JUnitTest {
    @DisplayName("1 + 2는 3이다.")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        // assertEquals  첫 번째 인수 : 기대하는 값, 두 번째 인수 : 실제로 검증할 값
        Assertions.assertEquals(a + b, sum);
    }
}
