package com.huifeng.mall.admin.utils;

//返回通用结果对象
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     *成功返回对象
     * @param data  封装的数据
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }
}
