package com.solar.petadoptionsystem.system.test.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.solar.petadoptionsystem.common.dto.BaseEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("sys_user_info")
public class SysUserInfo extends BaseEntity {

    @TableField("user_id")
    // 用户ID
    private Long userId;
    // 昵称
    private String nickName;
    // 邮箱
    private String email;
    // 密码
    private String password;
    // 手机号
    private String phone;
    // 头像路径
    private String avatar;
    // 用户类型 A管理员 C用户，默认为 "C"
    private String userType;

}
