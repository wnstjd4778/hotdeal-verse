package com.example.hotdealverse.item.application.port.in;

import com.example.hotdealverse.item.adapter.in.web.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.adapter.in.web.dto.res.GetItemResDto;

import java.util.List;

public interface ItemUseCase {

    List<GetItemResDto> getItems(GetItemsReqDto getItemsReqDto);

    Long getTotalItemsCnt(GetItemsReqDto getItemsReqDto);
}
