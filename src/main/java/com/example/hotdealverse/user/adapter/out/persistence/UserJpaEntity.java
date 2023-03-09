package com.example.hotdealverse.user.adapter.out.persistence;

import com.example.hotdealverse.user.adapter.out.persistence.base.BaseTimeEntity;
import com.example.hotdealverse.user.domain.AuthProvider;
import com.example.hotdealverse.user.domain.RoleType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJpaEntity extends BaseTimeEntity {

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
}
