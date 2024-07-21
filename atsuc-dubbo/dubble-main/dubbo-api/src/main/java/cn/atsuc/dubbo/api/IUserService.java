package cn.atsuc.dubbo.api;

import cn.atsuc.dubbo.api.dto.UserReqDTO;
import cn.atsuc.dubbo.api.dto.UserResDTO;
import cn.atsuc.dubbo.api.types.Response;

/**
 * @author atsuc
 * @date 2024/6/26 23:47
 * @email s202011105851@163.com
 * @description 查询用户信息
 */
public interface IUserService {

    Response<UserResDTO> queryInfo(UserReqDTO resDTO);
}
