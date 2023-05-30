package com.example.hotdealverse.common.payload;

import lombok.Getter;

@Getter
public class ApiTotalBaseResponse extends ApiBaseResponse {

    public ApiTotalBaseResponse(Object object, Long total) {
        super(object);
        this.total = total;
    }
    private Long total;
}