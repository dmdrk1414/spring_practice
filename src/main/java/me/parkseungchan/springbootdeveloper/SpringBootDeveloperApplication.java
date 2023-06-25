package me.parkseungchan.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 프레젠테이션 계층 - 컨트롤러
@SpringBootApplication
public class SpringBootDeveloperApplication { // spring boot 의 main 메서드를 의미한다.
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}