package com.example.hotdealverse.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository extends JpaRepository<AuthTokenJpaEntity, Long> {
}
