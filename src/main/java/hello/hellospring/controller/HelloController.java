package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // localhost:9090/hello-mvc?name=spring -> model에 name(param)을 담아서 hello-template.html로 return
    public String hellomvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") // localhost:9090/hello-string?name=spring -> 소스코드 확인하면 return 값만 존재 (태그 존재 x)
    @ResponseBody // 무지성 꼬라박기 - html 태그 없음 그냥 내용만 return (데이터를 그대로 내려준다)
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }

    // 문자가 아닌 데이터 내놔!
    @GetMapping("hello-api")
    @ResponseBody //json 반환이 default
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체를 넘겼을 때: 'JSON' - key:value 구조 (HTML vs JSON)
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}