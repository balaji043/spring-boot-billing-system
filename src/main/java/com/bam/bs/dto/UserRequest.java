package com.bam.bs.dto;

import com.bam.bs.util.UserRole;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class UserRequest {
    Boolean isAllUserRequest;
    UserRole role;
}
