package com.example.hotdealverse.item.adapter.in.web;

import com.example.hotdealverse.item.application.port.in.ItemUseCase;
import com.example.hotdealverse.item.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.dto.res.GetItemResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemUseCase itemUseCase;

    @GetMapping("/items")
    public ResponseEntity<List<GetItemResDto>> getItems(
            GetItemsReqDto getItemsReqDto
    ) {
        List<GetItemResDto> getItemResDtoList = this.itemUseCase.getItems(getItemsReqDto);
        return new ResponseEntity<>(getItemResDtoList, HttpStatus.OK);
    }

}
