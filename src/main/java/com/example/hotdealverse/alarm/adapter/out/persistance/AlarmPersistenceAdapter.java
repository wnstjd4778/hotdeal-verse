package com.example.hotdealverse.alarm.adapter.out.persistance;

import com.example.hotdealverse.alarm.application.port.out.AlarmPort;
import com.example.hotdealverse.alarm.domain.Alarm;
import com.example.hotdealverse.alarm.mapper.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AlarmPersistenceAdapter implements AlarmPort {

    private final RabbitTemplate rabbitTemplate;
    private final AlarmRepository alarmRepository;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.list[0].key}")
    private String key1;

    @Override
    public void send(List<Alarm> alarmList) {
        List<AlarmJpaEntity> alarmJpaEntityList = alarmList.stream().map(
                alarm -> {
                    this.rabbitTemplate.convertAndSend(exchange, key1, alarm);
                    AlarmJpaEntity alarmJpaEntity = AlarmMapper.convertAlarmToEntity(alarm);
                    alarmJpaEntity.getKeyword().addAlarm(alarmJpaEntity);
                    return alarmJpaEntity;
                }).toList();
        this.alarmRepository.saveAll(alarmJpaEntityList);
    }
}
