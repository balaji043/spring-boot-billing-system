package com.bam.bs.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class UserRequest {
    Boolean isAllUserRequest;
}
