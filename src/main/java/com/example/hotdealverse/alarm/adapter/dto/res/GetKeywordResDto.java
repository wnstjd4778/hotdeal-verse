package com.example.hotdealverse.alarm.adapter.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GetKeywordResDto {

    private long id;

    private String keyword;
}
