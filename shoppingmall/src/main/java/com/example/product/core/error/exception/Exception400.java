package com.example.product.core.error.exception;

import com.example.product.core.utils.ApiUtils;
import org.springframework.http.HttpStatus;

public class Exception400 extends RuntimeException {

    public Exception400(String message) {
        super(message);
    }


    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.BAD_REQUEST);
    }


    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }

}
