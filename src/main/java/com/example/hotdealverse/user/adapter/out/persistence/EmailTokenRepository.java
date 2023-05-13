package com.example.hotdealverse.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailTokenRepository extends JpaRepository<EmailTokenJpaEntity, Long> {

    Optional<EmailTokenJpaEntity> findByEmailAndToken(String email, String token);
}
