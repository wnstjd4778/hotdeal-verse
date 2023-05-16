package com.example.hotdealverse.item.adapter.in.web.controller;

import com.example.hotdealverse.common.payload.ApiBaseResponse;
import com.example.hotdealverse.common.payload.ApiTotalBaseResponse;
import com.example.hotdealverse.item.application.port.in.ItemUseCase;
import com.example.hotdealverse.item.adapter.dto.req.GetItemsReqDto;
import com.example.hotdealverse.item.adapter.dto.res.GetItemResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemUseCase itemUseCase;

    @GetMapping("/items")
    public ResponseEntity<ApiBaseResponse> getItems(
            GetItemsReqDto getItemsReqDto
    ) {
        List<GetItemResDto> getItemResDtoList = this.itemUseCase.getItems(getItemsReqDto);
        Long total = this.itemUseCase.getTotalItemsCnt(getItemsReqDto);
        ApiTotalBaseResponse apiTotalBaseResponse = new ApiTotalBaseResponse(getItemResDtoList, total);
        return new ResponseEntity<>(apiTotalBaseResponse, HttpStatus.OK);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ApiBaseResponse> getItem(
            @PathVariable("itemId") Long itemId
    ) {
        GetItemResDto getItemResDto = this.itemUseCase.getItem(itemId);
        ApiBaseResponse apiBaseResponse = new ApiBaseResponse(getItemResDto);
        return new ResponseEntity<>(apiBaseResponse, HttpStatus.OK);
    }
}
