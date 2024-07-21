package cn.atsuc.cloud.controller;

import cn.atsuc.cloud.entities.Pay;
import cn.atsuc.cloud.entities.PayDTO;
import cn.atsuc.cloud.resp.ResultData;
import cn.atsuc.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author atsuc
 * @date 2024/7/8 21:55
 * @email s202011105851@163.com
 * @description
 */
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value ="/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> add(@RequestBody Pay pay) {
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值："+i);
    }

    @DeleteMapping(value ="/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> del(@PathVariable("id") Integer id) {
        int i = payService.delPay(id);
        return ResultData.success(i);
    }

    @PutMapping(value ="/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.updatePay(pay);
        return ResultData.success("成功修改记录，返回值："+i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> get(@PathVariable("id") Integer id) {
        if(id == -4) throw new RuntimeException("id不能为负数");
        try {
            TimeUnit.SECONDS.sleep(62);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/getAll")
    public ResultData<List<Pay>> getAll() {
        List<Pay> payServiceAll = payService.getAll();
        return ResultData.success(payServiceAll);
    }

    /**
     * http://localhost:8001/pay/get/info
     * 注意：配置consul的Key/Value不能使用Tab键
     */
    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${atsuc.info}") String atsucInfo) {
        return "atsucInfo:" + atsucInfo  + "\t" + "port:"+port;
    }
}
