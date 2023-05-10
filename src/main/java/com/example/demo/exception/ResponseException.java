package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
public class ResponseException extends RuntimeException {
    @Getter
    private ResponseBody responseBody;

    public ResponseException(String msgKey, String msg, HttpStatus httpStatus) {
        this.responseBody = new ResponseBody(msgKey, msg, httpStatus);
    }

    @Getter
    public static class ResponseBody {
        private String msgKey;
        private String msg;
        private HttpStatus httpStatus;

        public ResponseBody(String msgKey, String msg, HttpStatus httpStatus) {
            this.msgKey = msgKey;
            this.msg = msg;
            this.httpStatus = httpStatus;
        }
    }
}
