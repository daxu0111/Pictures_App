package com.daxu.picturesapp.util;

import com.daxu.picturesapp.Enum.ResultEnum;
import com.daxu.picturesapp.domain.Result;

import java.util.List;

public class ResultUtil {
    public static <T> Result<T> defineSuccess(Integer code, T data, List<T> datas, String token)
    {
        Result result =new Result<>();
        result.setCode(code);
        result.setState("success");
        result.setData(data);
        result.setDatas(datas);
        result.setToken(token);
        return result;
    }
    public static <T> Result<T> SuccessWithdata( T data)
    {
        Result result =new Result<>();
        result.setCode(ResultEnum.SUCCESS);
        result.setState("success");
        result.setData(data);
        return result;
    }
    public static <T> Result<T> SuccessWithdatas( List<T> datas)
    {
        Result result =new Result<>();
        result.setCode(ResultEnum.SUCCESS);
        result.setState("success");
        result.setDatas(datas);
        return result;
    }
    public static <T> Result<T> SuccessWithtoken(T data,String token)
    {
        Result result =new Result<>();
        result.setCode(ResultEnum.SUCCESS);
        result.setState("success");
        result.setData(data);
        result.setToken(token);
        return result;
    }
    public static <T> Result<T> Definefail(Integer code,String msg)
    {
        Result result =new Result<>();
        result.setCode(code);
        result.setState(msg);
        return result;
    }
    public static <T> Result<T> fail(String msg)
    {
        Result result =new Result<>();
        result.setCode(ResultEnum.FAIL);
        result.setState(msg);
        return result;
    }
    public static <T> Result<T> Loginfail(String msg)
    {
        Result result =new Result<>();
        result.setCode(ResultEnum.FAIL_LOGIN);
        result.setState(msg);
        return result;
    }
}
