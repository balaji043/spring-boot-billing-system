package com.bam.bs.dto;

import java.io.Serializable;

import com.bam.bs.util.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable {

    /**
     * SerialVersionUID
     */
    private static final long serialVersionUID = 7267798322870448165L;

    private Long id;

    private String name;

    private String userName;

    private String password;

    private UserRole role;
}
