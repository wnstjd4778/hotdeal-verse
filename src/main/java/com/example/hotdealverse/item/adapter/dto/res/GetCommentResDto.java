package com.example.hotdealverse.item.adapter.dto.res;

import com.example.hotdealverse.user.adapter.dto.res.GetUserResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class GetCommentResDto {

    private long id;

    private String content;

    private GetUserResDto user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}