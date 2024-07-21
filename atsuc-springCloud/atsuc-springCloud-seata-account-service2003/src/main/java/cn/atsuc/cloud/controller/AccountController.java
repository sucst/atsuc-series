package cn.atsuc.cloud.controller;

import cn.atsuc.cloud.resp.ResultData;
import cn.atsuc.cloud.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author atsuc
 * @date 2024/7/20 19:00
 * @email s202011105851@163.com
 * @description
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 余额
     * @return ResultData
     */
    @PostMapping("/account/decrease")
    public ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        accountService.decrease(userId,money);
        return ResultData.success("扣减账户余额成功！");
    }

}
