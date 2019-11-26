package com.jellyfishmix.gouhaitakeaway.web.commodity;

import com.jellyfishmix.gouhaitakeaway.dto.CommodityExecution;
import com.jellyfishmix.gouhaitakeaway.dto.ImageHolder;
import com.jellyfishmix.gouhaitakeaway.entity.Commodity;
import com.jellyfishmix.gouhaitakeaway.enums.CommodityStateEnum;
import com.jellyfishmix.gouhaitakeaway.service.CommodityService;
import com.jellyfishmix.gouhaitakeaway.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 获取菜单列表
     */
    @RequestMapping(value = "/getcommoditylist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getCommodityList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Commodity> commodityList;

        try {
            commodityList = commodityService.getCommodityList();
            modelMap.put("success", true);
            modelMap.put("commodityList", commodityList);
            modelMap.put("total", commodityList.size());
        } catch (Exception e) {
            e.printStackTrace();    // Exception所拥有的一个方法，把stack trace中的信息打印出来。It's a very simple, but very useful tool for diagnosing an exceptions. It tells you what happened and where in the code this happened.
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    /**
     * 添加商品
     * @param request
     * @return
     */
    @RequestMapping(value = "/addcommodity", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addCommodity(HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartHttpServletRequest;
        ImageHolder thumbnail;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        // 图片处理
        try {
            if (commonsMultipartResolver.isMultipart(request)) {
                multipartHttpServletRequest = (MultipartHttpServletRequest) request;
                // 取出略缩图并构建ImageHolder对象
                CommonsMultipartFile thumbnailFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile("imageFile");
                if (thumbnailFile != null) {
                    thumbnail = new ImageHolder(thumbnailFile.getOriginalFilename(), thumbnailFile.getInputStream());
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "上传的图片不能为空");
                    return modelMap;
                }
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "上传的图片不能为空");
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }

        // entity处理
        String name = HttpServletRequestUtil.getString(request, "name");
        name = new String(name.getBytes("8859_1"), "utf8"); // 接收中文，转码
        Integer originalPrice = HttpServletRequestUtil.getInt(request, "originalPrice");
        Integer currentPrice = HttpServletRequestUtil.getInt(request, "currentPrice");
        Boolean enable = HttpServletRequestUtil.getBoolean(request, "enable");
        String describe = HttpServletRequestUtil.getString(request, "describe");    // 接收中文，转码
        describe = new String(describe.getBytes("8859_1"), "utf8");
        Integer sum = HttpServletRequestUtil.getInt(request, "sum");
        Boolean isUnderRevision = HttpServletRequestUtil.getBoolean(request, "isUnderRevision");
        Boolean isSeeMore = HttpServletRequestUtil.getBoolean(request, "isSeeMore");

        Commodity commodity = new Commodity();
        commodity.setName(name);
        commodity.setOriginalPrice(originalPrice);
        commodity.setCurrentPrice(currentPrice);
        commodity.setEnable(enable);
        commodity.setDescribe(describe);
        commodity.setSum(sum);
        commodity.setUnderRevision(isUnderRevision);
        commodity.setSeeMore(isSeeMore);

        // commodity.setName("红薯");
        // commodity.setOriginalPrice(10);
        // commodity.setCurrentPrice(8);
        // commodity.setEnable(true);
        // commodity.setDescribe("暂无描述");
        // commodity.setSum(1);
        // commodity.setUnderRevision(false);
        // commodity.setSeeMore(false);

        try {
            CommodityExecution commodityExecution = commodityService.addCommodity(commodity, thumbnail);
            if (commodityExecution.getState() == CommodityStateEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                return modelMap;
            } else {
                modelMap.put("success", false);
                modelMap.put("errState", commodityExecution.getState());
                modelMap.put("errStateInfo", commodityExecution.getStateInfo());
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/updatecommodity", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> updateCommodity(@RequestBody Commodity commodity) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        try {
            CommodityExecution commodityExecution = commodityService.updateCommodity(commodity);
            if (commodityExecution.getState() == CommodityStateEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                return modelMap;
            } else {
                modelMap.put("success", false);
                modelMap.put("errState", commodityExecution.getState());
                modelMap.put("errStateInfo", commodityExecution.getStateInfo());
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }

    /**
     * 删除商品
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/deletecommodity", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> deleteCommodity(@RequestBody Commodity commodity) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        try {
            CommodityExecution commodityExecution = commodityService.deleteCommodity(commodity);
            if (commodityExecution.getState() == CommodityStateEnum.SUCCESS.getState()) {
                modelMap.put("success", true);
                return modelMap;
            } else {
                modelMap.put("success", false);
                modelMap.put("errState", commodityExecution.getState());
                modelMap.put("errStateInfo", commodityExecution.getStateInfo());
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }
}
