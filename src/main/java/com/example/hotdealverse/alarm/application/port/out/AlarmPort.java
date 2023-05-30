package com.example.hotdealverse.alarm.application.port.out;

import com.example.hotdealverse.alarm.domain.Alarm;

import java.util.List;

public interface AlarmPort {

    void send(List<Alarm> alarmList);
}
