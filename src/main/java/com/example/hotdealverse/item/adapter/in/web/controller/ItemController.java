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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/items/rank")
    public ResponseEntity<ApiBaseResponse> getItemByRank(
            @RequestParam("startDate") String date,
            @RequestParam("key") String key,
            @RequestParam("size") int size
            ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = dateFormat.parse(date);
        System.out.println(startDate);
        System.out.println(key);
        System.out.println(size);
        List<GetItemResDto> getItemResDtoList = this.itemUseCase.getItemsByRank(key, startDate, size);
        ApiBaseResponse apiBaseResponse = new ApiBaseResponse(getItemResDtoList);
        return new ResponseEntity<>(apiBaseResponse, HttpStatus.OK);
    }
}
