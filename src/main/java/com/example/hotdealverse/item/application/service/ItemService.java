package com.example.hotdealverse.item.application.service;

import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.item.adapter.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.adapter.dto.res.GetItemResDto;
import com.example.hotdealverse.item.application.port.in.ItemUseCase;
import com.example.hotdealverse.item.application.port.out.ItemPort;
import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.item.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemUseCase {

    private final ItemPort itemPort;

    @Override
    public List<GetItemResDto> getItems(GetItemsReqDto getItemsReqDto, UserPrincipal userPrincipal) {
        List<Item> itemList = this.itemPort.getItems(getItemsReqDto);
        List<GetItemResDto> getItemResDtoList;

        if (userPrincipal != null) {

            getItemResDtoList = itemList.stream().map((item) ->
                    ItemMapper.convertItemToGetItemResDtoWithUserId(item, userPrincipal.getId())
            ).toList();

        } else {

            getItemResDtoList = itemList.stream().map((item) -> ItemMapper.convertItemToGetItemResDto(item)).toList();

        }
        return getItemResDtoList;
    }

    @Override
    public Long getTotalItemsCnt(GetItemsReqDto getItemsReqDto) {
        return this.itemPort.getTotalItemsCnt(getItemsReqDto);
    }

    @Override
    public GetItemResDto getItem(Long itemId, UserPrincipal userPrincipal) {
        Item item = this.itemPort.getItemById(itemId);
        GetItemResDto getItemResDtoList;
        if (userPrincipal != null) {

            getItemResDtoList = ItemMapper.convertItemToGetItemResDtoWithUserId(item, userPrincipal.getId());

        } else {

            getItemResDtoList = ItemMapper.convertItemToGetItemResDto(item);

        }

        return getItemResDtoList;
    }

    @Override
    public List<GetItemResDto> getItemsByRank(String key, Date startDate, long size) {
        List<Item> itemList = this.itemPort.getItemsByRank(key, startDate, size);

        return itemList.stream().map((item) -> ItemMapper.convertItemToGetItemResDto(item)).toList();
    }
}
