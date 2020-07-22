package org.boss.oss.tool;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;

import lombok.extern.slf4j.Slf4j;
import org.boss.oss.common.conf.Configure;


import java.io.IOException;

/**
 * @ClassName: OSSTool
 * @Description: OSS文件传输服务的工具类
 */
@Slf4j
public class OSSTool {

    private static String propertiesFilePath;
    // endPoint是访问OSS的域名（外网）
    public static String endPoint;
    // accessKeyId和accessKeySecret是OSS的访问密钥
    public static String accessKeyId;
    public static String getAccessKeySecret;
    // Bucket用来存储Object的存储空间
    public static String bucketName;
    // Object是OSS存储的基本单元，成为OSS的对象，也被称为OSS的文件
    public static String objPath;

    /**
     * @Description: 初始化参数
     */
    private static void init() throws IOException {
        propertiesFilePath = PropertiesFileTool.readPropertiesFile(Configure.propertiesFilePath, "OSSPropertiesFilePath");
        endPoint = PropertiesFileTool.readPropertiesFile(propertiesFilePath, "endPoint");
        accessKeyId = PropertiesFileTool.readPropertiesFile(propertiesFilePath, "accessKeyId");
        getAccessKeySecret = PropertiesFileTool.readPropertiesFile(propertiesFilePath, "getAccessKeySecret");
        bucketName = PropertiesFileTool.readPropertiesFile(propertiesFilePath, "bucketName");
        objPath = PropertiesFileTool.readPropertiesFile(propertiesFilePath, "objPath");
    }

    /**
     * 已经默认了存储位置，用户只用输入文件名称就可以初始化Object
     * @param fileName 文件名称
     * @return 文件目录
     */
    public static String initObject(String fileName){
        return objPath+fileName;
    }

    /**
     * 检查Bucket是否存在，并初始化OSS连接对象
     * @param ossClient OSS连接对象
     */
    public static void init(OSS ossClient){
        try {
            // 判断Bucket是否存在
            // 存在则打印一下结果，不存在则根据名称创建一个Bucket
            if (ossClient.doesBucketExist(bucketName)){
                log.debug("OOSTools---已经创建了Bucket：" + bucketName);
            } else {
                ossClient.createBucket(bucketName);
                log.debug("OOSTools---Bucket不存在，将为你创建Bucket：" + bucketName);
            }
        }catch (OSSException e){
            e.printStackTrace();
        }catch (ClientException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        }
    };
}
