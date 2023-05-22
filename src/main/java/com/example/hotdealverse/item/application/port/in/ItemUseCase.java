package com.example.hotdealverse.item.application.port.in;

import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.item.adapter.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.adapter.dto.res.GetItemResDto;

import java.util.Date;
import java.util.List;

public interface ItemUseCase {

    List<GetItemResDto> getItems(GetItemsReqDto getItemsReqDto, UserPrincipal userPrincipal);

    Long getTotalItemsCnt(GetItemsReqDto getItemsReqDto);

    GetItemResDto getItem(Long itemId, UserPrincipal userPrincipal);

    List<GetItemResDto> getItemsByRank(String key, Date startDate, long size);
}
