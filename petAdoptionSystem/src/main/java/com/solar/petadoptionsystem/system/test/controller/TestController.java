package com.solar.petadoptionsystem.system.test.controller;

import com.solar.petadoptionsystem.system.test.dto.SysUserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试类")
public class TestController {

    @GetMapping("/test")
    @Operation(summary = "测试接口")
    public String test() {
        SysUserInfo sysUserInfo = new SysUserInfo();
        return "test";
    }
}
