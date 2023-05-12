package com.example.hotdealverse.item.application.service;

import com.example.hotdealverse.item.application.port.in.ItemUseCase;
import com.example.hotdealverse.item.application.port.out.ItemPort;
import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.item.adapter.in.web.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.adapter.in.web.dto.res.GetItemResDto;
import com.example.hotdealverse.item.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemUseCase {

    private final ItemPort itemPort;

    @Override
    public List<GetItemResDto> getItems(GetItemsReqDto getItemsReqDto) {
        List<Item> itemList = this.itemPort.getItems(getItemsReqDto);

        return itemList.stream().map((item) -> ItemMapper.convertItemToGetItemResDto(item)).toList();
    }

    @Override
    public Long getTotalItemsCnt(GetItemsReqDto getItemsReqDto) {
        return this.itemPort.getTotalItemsCnt(getItemsReqDto);
    }
}
