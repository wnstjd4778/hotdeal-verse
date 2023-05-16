package com.example.hotdealverse.item.application.port.out;

import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.item.adapter.dto.req.GetItemsReqDto;

import java.util.Date;
import java.util.List;

public interface ItemPort {

    List<Item> getItems(GetItemsReqDto getItemsReqDto);

    void sentAlarm();

    Long getTotalItemsCnt(GetItemsReqDto getItemsReqDto);

    Item getItemById(Long itemId);

    List<Item> getItemsByRank(String key, Date startDate, long size);
}
