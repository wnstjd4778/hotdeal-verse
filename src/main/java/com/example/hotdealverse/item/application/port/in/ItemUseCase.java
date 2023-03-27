package com.example.hotdealverse.item.application.port.in;

import com.example.hotdealverse.item.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.dto.res.GetItemResDto;

import java.util.List;

public interface ItemUseCase {

    public List<GetItemResDto> getItems(GetItemsReqDto getItemsReqDto);

}
