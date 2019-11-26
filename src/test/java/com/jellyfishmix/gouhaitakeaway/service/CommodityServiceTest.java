package com.jellyfishmix.gouhaitakeaway.service;

import com.jellyfishmix.gouhaitakeaway.BaseTest;
import com.jellyfishmix.gouhaitakeaway.dto.ImageHolder;
import com.jellyfishmix.gouhaitakeaway.entity.Commodity;
import com.jellyfishmix.gouhaitakeaway.exceptions.CommodityOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CommodityServiceTest extends BaseTest {
    @Autowired
    private CommodityService commodityService;

    @Test
    @Ignore
    public void testAddProduct() throws FileNotFoundException, CommodityOperationException {
        File thumbnailFile = new File("/Users/qianshijie/Programming/Backend/Java/Images/o2o/xiaohuangren.jpg");
        InputStream inputStream = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), inputStream);

        Commodity commodity = new Commodity();
        commodity.setName("红薯");
        commodity.setOriginalPrice(10);
        commodity.setCurrentPrice(8);
        commodity.setEnable(true);
        commodity.setDescribe("暂无描述");
        commodity.setSum(1);
        commodity.setUnderRevision(false);
        commodity.setSeeMore(false);
        commodity.setImgURL("sssr");

        commodityService.addCommodity(commodity, thumbnail);
    }
}
