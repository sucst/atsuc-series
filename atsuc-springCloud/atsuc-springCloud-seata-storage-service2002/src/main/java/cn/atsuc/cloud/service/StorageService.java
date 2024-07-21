package cn.atsuc.cloud.service;

/**
 * @author atsuc
 * @date 2024/7/20 18:12
 * @email s202011105851@163.com
 * @description
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     */
    void decrease(Long productId, Integer count);

}
