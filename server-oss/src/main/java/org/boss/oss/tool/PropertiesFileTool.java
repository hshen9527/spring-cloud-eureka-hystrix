package org.boss.oss.tool;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName: PropertiesFileReader
 * @Description: 获取配置文件信息
 */
public class PropertiesFileTool {

    /**
     * 根据配置文件地址和属性的Key值获得属性的Value
     *
     * @param filePath 配置文件路径
     * @param key 属性的Key
     * @return
     */
    public static String readPropertiesFile(String filePath, String key) throws FileNotFoundException, IOException {
        try {
            Properties props = new Properties();
            props.load(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            String value = props.getProperty(key);
            return value;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 更新（或插入）一对properties信息(主键及其键值)
     * 如果该主键已经存在，更新该主键的值； 如果该主键不存在，
     * 则插件一对键值。
     *
     * @param filePath 配置文件位置
     * @param key 要更新的属性Key
     * @param value 要更新的属性的Value
     */
    public static void writePropertiesFile(String filePath, String key, String value) throws IOException {
        Properties properties = new Properties();
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        properties.load(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        // 必须先用map将所有的内容先保存,不然一更新,原来的内容都没了
        Map<String, String> map = new HashMap<String, String>();
        Set<Object> keySet = properties.keySet();
        for (Object object : keySet) {
            String keytmp = (String) object;
            String valuetmp = (String) properties.getProperty(keytmp);
            System.out.println(keytmp + "=" + valuetmp);
            map.put(keytmp, valuetmp);
        }
        map.put(key, value);
        for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
            properties.setProperty(entry.getKey(), entry.getValue());
        }
        FileOutputStream fos = new FileOutputStream(file);
        properties.store(new OutputStreamWriter(fos), "update");
        fos.close();
        fis.close();
    }
}
