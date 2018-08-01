package com.woostar.tender.common.http;

import java.io.Serializable;

/**
 * Class ServerResponse 服务器响应封装类
 *
 * @author huangshuo
 * Created on 2018-06-05
 */
public final class ServerResponse<T> implements Serializable {

    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = -1624665057128307191L;

    /**
     * Field status 响应状态码
     */
    private final Integer status;

    /**
     * Field msg 响应消息
     */
    private String msg;

    /**
     * Field data 响应数据
     */
    private T data;

    /**
     * Constructor ServerResponse creates a new ServerResponse instance.
     *
     * @param builder of type Builder
     */
    private ServerResponse(Builder<T> builder) {
        this.status = builder.status;
        this.msg = builder.msg;
        this.data = builder.data;
    }

    /**
     * Class Builder Builder内部类
     *
     */
    public static class Builder<T> {
        /**
         * Field status
         */
        private final Integer status;
        /**
         * Field msg
         */
        private String msg;
        /**
         * Field data
         */
        private T data;

        /**
         * Constructor Builder creates a new Builder instance.
         *
         * @param status of type int
         */
        public Builder(int status) {
            this.status = status;
        }

        /**
         * Method msg
         *
         * @param msg of type String
         * @return Builder
         */
        public Builder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        /**
         * Method data
         *
         * @param data of type T
         * @return Builder
         */
        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        /**
         * Method build
         * @return ServerResponse
         */
        public ServerResponse<T> build() {
            return new ServerResponse<>(this);
        }
    }

    /**
     * Method getStatus returns the status of this ServerResponse object.
     *
     *  Field status 响应状态码
     *
     * @return the status (type int) of this ServerResponse object.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Method getMsg returns the msg of this ServerResponse object.
     *
     *  Field msg 响应消息
     *
     * @return the msg (type String) of this ServerResponse object.
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Method getData returns the data of this ServerResponse object.
     *
     *  Field data 响应数据
     *
     * @return the data (type T) of this ServerResponse object.
     */
    public T getData() {
        return data;
    }
}
