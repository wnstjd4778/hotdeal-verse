package com.example.hotdealverse.alarm.adapter.in.web;

import com.example.hotdealverse.alarm.application.port.in.AlarmUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmUseCase alarmUseCase;

    @Scheduled(fixedRate = 600000)
    private void send() {
        alarmUseCase.send();
    }
}
