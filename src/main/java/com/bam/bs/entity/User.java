package com.bam.bs.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import com.bam.bs.util.Role;

import java.io.Serializable;

@Entity
@Table(name = "USER")
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = -2432216802067413443L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private Role role;

}
