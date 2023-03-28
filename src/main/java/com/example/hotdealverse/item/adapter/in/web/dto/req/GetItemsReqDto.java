package com.example.hotdealverse.item.adapter.in.web.dto.req;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetItemsReqDto {

    private int page = 0;

    private int size = 10;

    private String keyword = "";
}
