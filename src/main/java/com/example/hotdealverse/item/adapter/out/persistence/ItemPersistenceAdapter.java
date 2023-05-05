package com.example.hotdealverse.item.adapter.out.persistence;

import com.example.hotdealverse.item.application.port.out.ItemPort;
import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.item.adapter.in.web.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemPersistenceAdapter implements ItemPort {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> getItems(GetItemsReqDto getItemsReqDto) {
        Pageable pageable = PageRequest.of(getItemsReqDto.getPage(), getItemsReqDto.getSize());
        List<ItemJpaEntity> itemJpaEntityList = this.itemRepository.findAllByTitleContaining(getItemsReqDto.getKeyword(), pageable).stream().toList();
        return itemJpaEntityList.stream().map(ItemMapper::convertEntityToItem).toList();
    }

    @Override
    public void sentAlarm() {
        this.itemRepository.updateAllItemsToSent();
    }
}
