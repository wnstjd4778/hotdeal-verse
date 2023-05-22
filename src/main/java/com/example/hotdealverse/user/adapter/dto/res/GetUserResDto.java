package com.example.hotdealverse.user.adapter.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetUserResDto {

    private long id;

    private String name;

}