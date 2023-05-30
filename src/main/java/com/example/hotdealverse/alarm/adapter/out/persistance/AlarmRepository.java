package com.example.hotdealverse.alarm.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<AlarmJpaEntity, Long> {

}
