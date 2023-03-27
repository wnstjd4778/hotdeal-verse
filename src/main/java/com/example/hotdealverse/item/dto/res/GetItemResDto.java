package com.example.hotdealverse.item.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class GetItemResDto {

    private long id;

    private String title;

    private String nickname;

    private Long replyNum;

    private Long recommendNum;

    private String href;

    private Date createdAt;
}
