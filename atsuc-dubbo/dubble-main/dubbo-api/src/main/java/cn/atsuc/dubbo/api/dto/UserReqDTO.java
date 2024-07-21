package cn.atsuc.dubbo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author atsuc
 * @date 2024/6/26 23:54
 * @email s202011105851@163.com
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReqDTO implements Serializable {

    private String userId;

}
