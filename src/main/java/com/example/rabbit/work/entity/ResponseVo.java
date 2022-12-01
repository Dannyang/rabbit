package com.example.rabbit.work.entity;

public class ResponseVo<T> {
    private Integer code;
    private String msg;
    private T data;
    public static <T> ResponseVo<T> success() {
        return new ResponseVo<T>();
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<>(data);
    }

    public static <T> ResponseVo<T> error(int code, String msg) {
        return new ResponseVo<>(code, msg);
    }

    public ResponseVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public ResponseVo(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public ResponseVo() {
        this.code = 0;
        this.msg = "success";
        this.data = null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
