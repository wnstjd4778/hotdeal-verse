package com.example.hotdealverse.alarm.application.service;

import com.example.hotdealverse.alarm.application.port.in.AlarmUseCase;
import com.example.hotdealverse.alarm.application.port.out.AlarmPort;
import com.example.hotdealverse.alarm.application.port.out.KeywordPort;
import com.example.hotdealverse.alarm.domain.Alarm;
import com.example.hotdealverse.item.application.port.out.ItemPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AlarmService implements AlarmUseCase {

    private final AlarmPort alarmPort;
    private final ItemPort itemPort;
    private final KeywordPort keywordPort;

    @Override
    @Transactional
    public void send() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:5001/ruliweb/1", String.class);

        List<Alarm> alarmList = keywordPort.findAllKeywordsAndItemsNotSent();

        this.alarmPort.send(alarmList);
        itemPort.sentAlarm();
    }
}
