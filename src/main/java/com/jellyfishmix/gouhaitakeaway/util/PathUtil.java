package com.jellyfishmix.gouhaitakeaway.util;

public class PathUtil {
    // 获取当前系统的操作符
    private static String separator = System.getProperty("file.separator");

    // 获取预先规定的项目图片根路径
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";

        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/java_image/gouhai-takeaway/";
        } else {
            // basePath = "/Users/qianshijie/Programming/Backend/Java/Images/gouhai-takeaway/";
            basePath = "/root/Programming/Server/Images/gouhai-takeaway/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    /**
     * 根据业务需求，获取项目图片子路径
     * 得到的是"targetPath"，当前店铺所在的图片储存目录，仅为当前店铺服务。
     * @return
     */
    public static String getCommodityImgPath() {
        String imagePath = "commodity/";
        return imagePath.replace("/", separator);
    }
}
