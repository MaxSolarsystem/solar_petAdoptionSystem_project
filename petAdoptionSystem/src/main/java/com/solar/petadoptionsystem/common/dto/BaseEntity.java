package com.solar.petadoptionsystem.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    // 创建人
    private Long createdBy;

    // 创建时间
    private LocalDateTime createdAt;

    // 更新人
    private Long updatedBy;

    // 更新时间
    private LocalDateTime updatedAt;

    // 备注
    private String remarks;

    // 是否删除 N否 Y是，默认为 "N"
    private String isDeleted;

    // 删除人
    private Long deletedBy;

    // 删除时间
    private LocalDateTime deletedAt;
}