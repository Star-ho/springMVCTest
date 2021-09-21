package com.example.demo;

import com.example.demo.People.PeopleJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RestController
public class TestRestController {
    private ObjectMapper objectMapper;
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @GetMapping("/")
//    public String mainGet(@RequestParam String a){//변수명으로 a로 해서 받을 수 있음
    public String mainGet(@RequestParam("a") String asd){
        System.out.println(asd);
        return "123";
    }
    @GetMapping("/{a}/aa")
//    public String mainGet2(@PathVariable String  a){//변수명을 a로 해서 받을 수 있음
    public String mainGet2(@PathVariable("a") String  asd){
        System.out.println(asd);
        return "123";
    }

    @PostMapping("/")
    public String mainPost1(@RequestBody String  name){//바디데이터받기 한번에 여러개 받으려면 객체로 받아야 할듯?
        System.out.println(name);
//        System.out.println(postParam);
        return "123";
    }

    @PostMapping("/{a}/aa")
//    public String mainPost2(@PathVariable String  a){//변수명을 a로 해서 받을 수 있음
    public String mainPost(@PathVariable("a") String  asd){//post에서 패스밸류, get밸류도 받을 수 있음
        System.out.println(asd);
        return "123";
    }
    @PostMapping("/id")
    public String mainPostJson(@RequestBody Map<String,Object> peopleJson){//JSON Map으로 받기
        System.out.println(peopleJson.get("name"));
        return "123";
    }
    @PostMapping("/id1")
    public String mainPostJsonArray(@RequestBody List<Map<String,Object>> peopleJson){//JSON Map List로 받기
        System.out.println(peopleJson.get(0).get("name"));
        System.out.println(peopleJson.get(1).get("name"));
        return "123";
    }
    @PostMapping("/id2")
    public String mainPostJsonArray2(@RequestBody Map<String,Object>[] peopleJson){//JSON Map 배열로 받기
        System.out.println(peopleJson[0].get("name"));
        System.out.println(peopleJson[1].get("name"));
        return "123";
    }

    @PostMapping("/id3")
    public String mainPostJsonArray3(@RequestBody String peopleJson) throws Exception{//JSON 객체 ObjectMapper사용
        PeopleJson a = objectMapper.readValue(peopleJson,PeopleJson.class);
        a.setName("123");
        System.out.println(a.getName());
        return "123";
    }
    @PostMapping("/id4")
    public String mainPostJsonArray3(@RequestBody PeopleJson peopleJson) {//JSON 객체로 바로 받기
        System.out.println(peopleJson.getName());
        return "123";
    }
}
