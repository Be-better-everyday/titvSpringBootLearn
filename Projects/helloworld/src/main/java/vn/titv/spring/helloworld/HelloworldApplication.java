package vn.titv.spring.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloworldApplication {
    @Value("${khoahoc.name}")
    private String name;
    @Value("${khoahoc.mentor}")
    private String mentor;
    @Value("${khoahoc.website}")
    private String website;

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "Xin chao 123!sdfsfsdfs";
    }
    @GetMapping("/info")
    public String info(){
        return String.join("<br/>", "Name : " + name, "Mentor: " + mentor, "Website : " + website);
    }

    @GetMapping("/h2")
    public String h2(){
        return "Xin chao 123!h2";
    }
}
