package com.zll.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回消息体
 */
@Data
@NoArgsConstructor
public class Result {

    boolean success; //操作是否成功
    Integer code; //返回状态码
    String message; //返回消息
    Object data; //返回数据

    //无需数据返回的构造,使用枚举
    public Result(ResultCode resultCode) {
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
    }

    //有数据返回的构造,使用枚举
    public Result(ResultCode resultCode, Object data) {
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
        this.data = data;
    }

    //无需数据返回的构造
    public Result(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    //操作成功
    public static Result SUCCESS() {
        return new Result(ResultCode.SUCCESS);
    }

    //系统错误
    public static Result ERROR() {
        return new Result(ResultCode.SERVER_ERROR);
    }

    //操作失败
    public static Result FAIL() {
        return new Result(ResultCode.FAIL);
    }


}
