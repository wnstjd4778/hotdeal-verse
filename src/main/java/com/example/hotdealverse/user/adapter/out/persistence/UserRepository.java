package com.example.hotdealverse.user.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserJpaEntity, Long> {

    Optional<UserJpaEntity> findByProviderKey(String providerKey);
}
