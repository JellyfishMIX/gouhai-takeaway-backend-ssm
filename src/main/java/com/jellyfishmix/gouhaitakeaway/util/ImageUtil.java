package com.jellyfishmix.gouhaitakeaway.util;

import com.jellyfishmix.gouhaitakeaway.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");    // 可以控制日期格式的对象。getRandomFileName()使用
    private static final Random random = new Random();  // 有生成随机数功能的对象。getRandomFileName()使用
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);   // 引入日志

    /**
     * 生成缩略图
     * @param imageHolder
     * @param targetPath
     * @return
     */
    public static String generateThumbnail(ImageHolder imageHolder, String targetPath) {
        String fileName = generateRandomFileName() + getFileExtension(imageHolder.getImageName());  // 随机名 + 原文件后缀名
        makeDirPath(targetPath);    // 查看目标路径是否存在，没有的话就创建出来

        String relativePath = targetPath + fileName;
        logger.debug("current relativePath is: " + relativePath);   // debug中记录当前的相对路径。一旦程序出错，就可以根据debug信息进行调试。同时还可以根据logger.error提示的信息，确认错误是什么
        File absolutePathFile = new File(PathUtil.getImgBasePath() + relativePath);
        logger.debug("current absolutePath is: " + PathUtil.getImgBasePath() + relativePath);   // debug中记录当前的绝对路径。一旦程序出错，就可以根据debug信息进行调试。同时还可以根据logger.error提示的信息，确认错误是什么
        try {
            Thumbnails.of(imageHolder.getImageFileStream()).size(200, 200).toFile(absolutePathFile);
        } catch (IOException e) {
            logger.error(e.toString()); // 一旦程序出错，就可以根据debug信息进行调试。同时还可以根据logger.error提示的信息，确认错误是什么
            e.printStackTrace();
        }
        return relativePath;    // relativePath会存到数据库table`commodity`中的img_relative_path。根目录与运行设备有关，如果服务器迁移到别的运行设备，希望也可以正常运行。因此存入相对路径，在service层取相对路径时再加工为绝对路径
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     * @return
     */
    private static String generateRandomFileName() {
        int randomNum = random.nextInt(89999) + 10000;  // 获取随机的五位数
        String nowTimeStr = simpleDateFormat.format(new Date());
        return nowTimeStr + randomNum;
    }

    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 创建目标路径所涉及的目录，即/home/xiangzai/xxx.jpg
     * 那么home/xiangzai/xxx.jpg都会自动创建
     * @param targetPath
     * @return
     */
    private static void makeDirPath(String targetPath) {
        String absolutePath = PathUtil.getImgBasePath() + targetPath;   // 合成：预先规定的项目图片路径 + 目标图片子路径
        File dirPath = new File(absolutePath);  // dir, directory的缩写，意思是目录
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * storePath是文件的路径还是目录的路径
     * 如果storePath是文件路径则删除该文件
     * 如果storePath是目录路径则删除该目录下的所有文件
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] =fileOrPath.listFiles();
                for (int i=0; i<files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }
}
