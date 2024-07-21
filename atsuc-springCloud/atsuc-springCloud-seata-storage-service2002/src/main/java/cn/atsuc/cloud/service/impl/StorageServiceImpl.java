package cn.atsuc.cloud.service.impl;

import cn.atsuc.cloud.mapper.StorageMapper;
import cn.atsuc.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author atsuc
 * @date 2024/7/20 18:14
 * @email s202011105851@163.com
 * @description
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }

}
