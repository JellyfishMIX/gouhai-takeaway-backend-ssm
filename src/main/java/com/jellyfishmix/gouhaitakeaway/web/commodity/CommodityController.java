package com.jellyfishmix.gouhaitakeaway.web.commodity;

import com.jellyfishmix.gouhaitakeaway.entity.Commodity;
import com.jellyfishmix.gouhaitakeaway.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/commodity")
public class CommodityController {
    /**
     * 获取菜单列表
     */
    @Autowired
    private CommodityService commodityService;
    @RequestMapping(value = "/getcommoditylist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getCommodityList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Commodity> commodityList;

        try {
            commodityList = commodityService.getCommodityList();
            modelMap.put("commodityList", commodityList);
            modelMap.put("total", commodityList.size());
        } catch (Exception e) {
            e.printStackTrace();    // Exception所拥有的一个方法，把stack trace中的信息打印出来。It's a very simple, but very useful tool for diagnosing an exceptions. It tells you what happened and where in the code this happened.
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}
