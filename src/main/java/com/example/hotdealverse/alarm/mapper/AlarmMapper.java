package com.example.hotdealverse.alarm.mapper;

import com.example.hotdealverse.alarm.adapter.out.persistance.AlarmJpaEntity;
import com.example.hotdealverse.alarm.domain.Alarm;
import com.example.hotdealverse.item.mapper.ItemMapper;

public class AlarmMapper {

    public static AlarmJpaEntity convertAlarmToEntity(Alarm alarm) {
        return AlarmJpaEntity.builder()
                .keyword(KeywordMapper.convertKeywordToEntity(alarm.getKeyword()))
                .item(ItemMapper.convertItemToEntity(alarm.getItem()))
                .build();
    }
}
