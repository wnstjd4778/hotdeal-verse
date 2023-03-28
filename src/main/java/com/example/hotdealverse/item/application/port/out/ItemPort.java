package com.example.hotdealverse.item.application.port.out;

import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.item.adapter.in.web.dto.req.GetItemsReqDto;

import java.util.List;

public interface ItemPort {

    public List<Item> getItems(GetItemsReqDto getItemsReqDto);
}
