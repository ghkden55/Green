package com.example.product.core.error.exception;

import com.example.product.core.utils.ApiUtils;
import org.springframework.http.HttpStatus;

public class Exception404 extends RuntimeException {

    public Exception404(String message) {
        super(message);
    }


    public ApiUtils.ApiResult<?> body(){
        return ApiUtils.error(getMessage(), HttpStatus.NOT_FOUND);
    }


    public HttpStatus status(){
        return HttpStatus.NOT_FOUND;
    }

}
