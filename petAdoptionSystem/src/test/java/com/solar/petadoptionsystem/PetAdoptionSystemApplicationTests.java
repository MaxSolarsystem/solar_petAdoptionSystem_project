package com.solar.petadoptionsystem;

import com.solar.petadoptionsystem.system.test.dto.SysUserInfo;
import com.solar.petadoptionsystem.system.test.mapper.SysUserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PetAdoptionSystemApplicationTests {

    @Autowired
    private SysUserInfoMapper userInfoMapper;

    @Test
    void contextLoads() {
        List<SysUserInfo> sysUserInfos = userInfoMapper.selectList(null);
        sysUserInfos.forEach(System.out::println);
    }

}
