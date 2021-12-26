package com.daxu.picturesapp.domain;

import com.daxu.picturesapp.Enum.ResultEnum;

import java.util.List;

public class Result<T> {
    private Integer code;
    private String token;
    private String state;
    private T data;
    private List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(ResultEnum code) {
        this.code = code.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", token='" + token + '\'' +
                ", state='" + state + '\'' +
                ", data=" + data +
                ", datas=" + datas +
                '}';
    }
}
