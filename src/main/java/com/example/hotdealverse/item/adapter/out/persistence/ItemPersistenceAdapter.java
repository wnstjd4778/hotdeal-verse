package com.example.hotdealverse.item.adapter.out.persistence;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.item.adapter.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.application.port.out.ItemPort;
import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.item.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemPersistenceAdapter implements ItemPort {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> getItems(GetItemsReqDto getItemsReqDto) {
        Pageable pageable = PageRequest.of(getItemsReqDto.getPage(), getItemsReqDto.getSize(), Sort.by("createdAt").descending());
        List<ItemJpaEntity> itemJpaEntityList = this.itemRepository.findAllByTitleContaining(getItemsReqDto.getKeyword(), pageable).stream().toList();
        return itemJpaEntityList.stream().map(ItemMapper::convertEntityToItem).toList();
    }

    @Override
    public void sentAlarm() {
        this.itemRepository.updateAllItemsToSent();
    }

    @Override
    public Long getTotalItemsCnt(GetItemsReqDto getItemsReqDto) {

        return this.itemRepository.countAllByTitleContaining(getItemsReqDto.getKeyword());
    }

    @Override
    public Item getItemById(Long itemId) {
        ItemJpaEntity itemJpaEntity = this.itemRepository.findById(itemId).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );
        itemJpaEntity.addViewCnt();
        this.itemRepository.save(itemJpaEntity);

        return ItemMapper.convertEntityToItem(itemJpaEntity);
    }

    @Override
    public List<Item> getItemsByRank(String key, Date startDate, long size) {
        PageRequest pageable = PageRequest.of(0, (int) size);
        List<ItemJpaEntity> itemJpaEntityList = this.itemRepository.findAllBySortKeyAndStartDate(key, startDate, pageable);
        return itemJpaEntityList.stream().map(ItemMapper::convertEntityToItem).toList();
    }
}
