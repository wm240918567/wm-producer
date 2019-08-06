package com.wm.producer.controller;

import com.alibaba.fastjson.annotation.JSONField;
import com.wm.resp.Resp;
import com.wm.tools.date.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class ProducerController {

    @GetMapping("/get1")
    public ResponseEntity<String> get1() {
        LocalDateTime now = LocalDateTime.now();
        Date date = DateUtils.toDate(now);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return Resp.success("hahaha" + format);
    }

    @GetMapping("/get2")
    public ResponseEntity<Test> get2(){
        return Resp.success(new Test(1,"wm",LocalDateTime.now()));
    }

    @PostMapping("/post1")
    public ResponseEntity<Test2> post1(@Valid @RequestBody Test test){
        return Resp.success(new Test2(1,"wm"));
    }

    @AllArgsConstructor
    @Data
    public class Test{

        @NotNull(message = "id不能为空")
        private int id;

        @Size(max = 2,message = "名字长度不能超过2位")
        private String name;

        @JSONField(format = "yyyy-MM-dd hh:mm:ss sss")
        private LocalDateTime localDateTime;
    }

    @AllArgsConstructor
    @Data
    public class Test2{

        @NotNull(message = "id不能为空")
        private int id;

        @Size(max = 2,message = "名字长度不能超过2位")
        private String name;

    }

}
