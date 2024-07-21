package cn.atsuc.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author atsuc
 * @date 2024/7/8 22:55
 * @email s202011105851@163.com
 * @description
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {

    private String code;/** 结果状态 ,具体状态码参见枚举类ReturnCodeEnum.java*/
    private String message;
    private T data;
    private long timestamp ;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static<T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData = resultData.setCode(ReturnCodeEnum.RC200.getCode())
                                .setMessage(ReturnCodeEnum.RC200.getMsg())
                                .setData(data);
        return resultData;
    }

    public static<T> ResultData<T> fail(String code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData = resultData.setCode(code)
                .setMessage(message);
        return resultData;
    }
}
