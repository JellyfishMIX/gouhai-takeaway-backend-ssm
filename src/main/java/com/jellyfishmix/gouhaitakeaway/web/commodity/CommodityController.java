package com.jellyfishmix.gouhaitakeaway.web.commodity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jellyfishmix.gouhaitakeaway.entity.Commodity;
import com.jellyfishmix.gouhaitakeaway.service.CommodityService;
import com.jellyfishmix.gouhaitakeaway.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
     * 新增商品
     * @param request
     * @return
     */
    @RequestMapping(value = "/addcommodity", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> insertCommodity(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String commodityStr = HttpServletRequestUtil.getString(request, "commodityStr");
        ObjectMapper objectMapper = new ObjectMapper();
        Commodity commodity = null;
        try {
            commodity = objectMapper.readValue(commodityStr, Commodity.class);
            int effectedNum = commodityService.insertCommodity(commodity);
            modelMap.put("success", true);
            return modelMap;
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }

    /**
     * 修改商品
     * @param request
     * @return
     */
    @RequestMapping(value = "/updatecommodity", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> updateCommodity(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String commodityStr = HttpServletRequestUtil.getString(request, "commodityStr");
        ObjectMapper objectMapper = new ObjectMapper();
        Commodity commodity = null;
        try {
            commodity = objectMapper.readValue(commodityStr, Commodity.class);
            int effectedNum = commodityService.updateCommodity(commodity);
            modelMap.put("success", true);
            return modelMap;
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }

    /**
     * 删除商品
     * @param request
     * @return
     */
    @RequestMapping(value = "/deletecommodity", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> deleteCommodity(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        String commodityStr = HttpServletRequestUtil.getString(request, "commodityStr");
        ObjectMapper objectMapper = new ObjectMapper();
        Commodity commodity = null;
        try {
            commodity = objectMapper.readValue(commodityStr, Commodity.class);
            int effectNum = commodityService.deleteCommodity(commodity);
            modelMap.put("success", true);
            return modelMap;
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
    }
}
