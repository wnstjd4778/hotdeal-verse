package com.example.hotdealverse.alarm.domain;

import com.example.hotdealverse.item.domain.Item;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Alarm implements Serializable {

    private Item item;

    private Keyword keyword;
}
