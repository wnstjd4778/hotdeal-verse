package com.development.apigateway.user.domain.entity;

import com.development.apigateway.user.domain.entity.base.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AuthProvider providerType;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Column(unique = true)
    private String providerKey;

    private Date accessDate;

    public void setAccessDate(Date date) {
        this.accessDate = date;
    }
}
