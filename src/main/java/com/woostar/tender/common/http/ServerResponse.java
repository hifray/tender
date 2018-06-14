package com.woostar.tender.common.http;

import java.io.Serializable;

/**
 * @author huangs
 * @createtime 2018-06-05
 * @description 服务器响应封装类
 */
public final class ServerResponse<T> implements Serializable {
    /**
     * 响应状态码
     */
    private final Integer status;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    /**
     * Builder模式
     */
    private ServerResponse(Builder<T> builder) {
        this.status = builder.status;
        this.msg = builder.msg;
        this.data = builder.data;
    }

    public static class Builder<T> {
        private final Integer status;
        private String msg;
        private T data;

        public Builder(int status) {
            this.status = status;
        }

        public Builder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ServerResponse<T> build() {
            return new ServerResponse<>(this);
        }
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
