package com.example.hotdealverse.item.adapter.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetItemResDto {

    private long id;

    private String title;

    private String nickname;

    private List<GetCommentResDto> commentList;

    private Long recommendNum;

    private String href;

    private Date createdAt;

    private String imgName;

    private boolean check;

    private Long viewCnt;
}
