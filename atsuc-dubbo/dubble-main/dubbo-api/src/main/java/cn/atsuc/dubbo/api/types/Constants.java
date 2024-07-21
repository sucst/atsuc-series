package cn.atsuc.dubbo.api.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author atsuc
 * @date 2024/6/26 23:51
 * @email s202011105851@163.com
 * @description
 */
public class Constants {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public enum ResponseCode {
        SUCCESS("0000", "成功"),
        UN_ERROR("0001", "未知失败"),
        ILLEGAL_PARAMETER("0002", "非法参数");

        private String code;
        private String info;

    }
}
