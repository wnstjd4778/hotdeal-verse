package com.example.hotdealverse.common.payload;

import lombok.Getter;

@Getter
public class ApiBaseResponse {

    public ApiBaseResponse(Object object) {
        this.data = object;
    }

    private boolean success = true;

    private Object data;
}