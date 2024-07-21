package cn.atsuc.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author atsuc
 * @date 2024/7/8 21:41
 * @email s202011105851@163.com
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayDTO implements Serializable {
    /** 主键 */
    private Integer id;
    /** 支付流水号 */
    private String payNo;
    /** 订单流水号 */
    private String orderNo;
    /** 用户账号ID */
    private Integer userId;
    /** 交易金额 */
    private BigDecimal amount;
}
