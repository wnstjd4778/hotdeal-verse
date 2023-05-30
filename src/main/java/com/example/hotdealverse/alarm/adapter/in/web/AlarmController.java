package com.example.hotdealverse.alarm.adapter.in.web;

import com.example.hotdealverse.alarm.application.port.in.AlarmUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmUseCase alarmUseCase;

    @Scheduled(fixedRate = 600000)
    private void send() {
        log.info("스케줄러 작동");
        alarmUseCase.send();
    }
}
