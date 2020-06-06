package com.jellyfishmix.gouhaitakeaway.service.Impl;

import com.jellyfishmix.gouhaitakeaway.dao.CommodityDao;
import com.jellyfishmix.gouhaitakeaway.dto.CommodityExecution;
import com.jellyfishmix.gouhaitakeaway.dto.ImageHolder;
import com.jellyfishmix.gouhaitakeaway.entity.Commodity;
import com.jellyfishmix.gouhaitakeaway.enums.CommodityStateEnum;
import com.jellyfishmix.gouhaitakeaway.exceptions.CommodityOperationException;
import com.jellyfishmix.gouhaitakeaway.service.CommodityService;
import com.jellyfishmix.gouhaitakeaway.util.ImageUtil;
import com.jellyfishmix.gouhaitakeaway.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    /**
     * 列出菜单列表
     * @return commodityList
     */
    @Override
    public List<Commodity> getCommodityList() {
        return commodityDao.queryCommodityList();
    };

    /**
     * 添加商品
     * @param commodity
     * @return int
     */
    @Override
    @Transactional
    public CommodityExecution addCommodity(Commodity commodity, ImageHolder thumbnail) {
        // 空值判断
        if (commodity != null) {
            // 图像处理
            String targetPath = PathUtil.getCommodityImgPath();
            String imgRelativePath = ImageUtil.generateThumbnail(thumbnail, targetPath);
            String imgURL = "https://jellyfishmix.com/gouhai-takeaway/images" + imgRelativePath;
            commodity.setImgRelativePath(imgRelativePath);
            commodity.setImgURL(imgURL);

            // 添加entity
            try {
                int effectedNum = commodityDao.insertCommodity(commodity);
                if (effectedNum <= 0) {
                    throw new CommodityOperationException("添加商品失败");
                }
            } catch (Exception e) {
                throw new CommodityOperationException("添加商品失败，errMsg: " + e.toString());
            }
            return new CommodityExecution(CommodityStateEnum.SUCCESS);
        } else {
            return new CommodityExecution(CommodityStateEnum.EMPTY);
        }
    }

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    @Override
    @Transactional
    public CommodityExecution updateCommodity(Commodity commodity) {
        if (commodity != null) {
            try {
                int effectedNum = commodityDao.updateCommodity(commodity);
                if (effectedNum <= 0) {
                    throw new CommodityOperationException("修改商品失败");
                }
                return new CommodityExecution(CommodityStateEnum.SUCCESS);
            } catch (Exception e) {
                throw new CommodityOperationException("修改商品失败，errMsg: " + e.toString());
            }
        } else {
            return new  CommodityExecution(CommodityStateEnum.EMPTY);
        }
    }

    /**
     * 删除商品
     * @param commodity
     * @return
     */
    @Override
    @Transactional
    public CommodityExecution deleteCommodity(Commodity commodity) {
        if (commodity != null) {
            try {
                int effectedNum = commodityDao.deleteCommodity(commodity);
                if (effectedNum <= 0) {
                    throw new CommodityOperationException("删除商品失败");
                }
                // 删除存储的图片
                ImageUtil.deleteFileOrPath(commodity.getImgRelativePath());

                return new CommodityExecution(CommodityStateEnum.SUCCESS);
            } catch (Exception e) {
                throw new CommodityOperationException("删除商品失败，errMsg: " + e.toString());
            }
        } else {
            return new  CommodityExecution(CommodityStateEnum.EMPTY);
        }
    }
}
