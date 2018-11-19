package com.myproj.myproj.utils;

/**
 *Created by wangjinyu on 2018/11/17 10:23.
 */
public class ResponseEntity<E> {
    private String code;

    private String message;

    private E result;

    public ResponseEntity() {

    }

    public ResponseEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(String code, String message, E result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResponseEntity(E result) {
        //code不赋值 默认为0，成功
        this.code = "0";
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getResult() {
        return result;
    }

    public void setResult(E result) {
        this.result = result;
    }
}
