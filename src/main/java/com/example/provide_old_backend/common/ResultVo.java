package com.example.provide_old_backend.common;

import lombok.Data;

@Data
public class ResultVo<T> {
    private Boolean flag;
    private String message;
    private T data;

    public static <T> ResultVo<T> success() {
        ResultVo<T> result = new ResultVo<>();
        result.setFlag(true);
        result.setMessage("操作成功");
        return result;
    }

    public static <T> ResultVo<T> success(T data) {
        ResultVo<T> result = new ResultVo<>();
        result.setFlag(true);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> ResultVo<T> success(String message, T data) {
        ResultVo<T> result = new ResultVo<>();
        result.setFlag(true);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> ResultVo<T> error(String message) {
        ResultVo<T> result = new ResultVo<>();
        result.setFlag(false);
        result.setMessage(message);
        return result;
    }
}
