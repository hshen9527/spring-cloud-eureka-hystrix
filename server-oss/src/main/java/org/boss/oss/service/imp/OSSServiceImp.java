package org.boss.oss.service.imp;

import org.boss.oss.common.adapter.DownloadAdapter;
import org.boss.oss.common.adapter.UploadAdapter;
import org.boss.oss.service.OSSService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @Class: OSSSERviceImp
 * @descript: 实现文件的上传下载以及删除
 */
@Service
public class OSSServiceImp implements OSSService {

    /**
     * 上传文件，由于不知道文件大小
     * 这里选择有Controller去选择合适的上传方案
     *
     * @param file object文件位置
     * @param objName object文件名称
     * @param adapter 文件上传的不同方案，由适配器封装
     * @return
     */
    @Override
    public boolean update(File file, String objName, UploadAdapter adapter) {
        // 具体的adapter 实现上传文件
        return adapter.update(file, objName);
    }

    /**
     * 下载文件，由于不知道文件大小
     * 这里选择有Controller去选择合适西在方案
     *
     * @param file object文件位置
     * @param objName object文件名称
     * @param adapter 文件下载的不同方案，由适配器封装
     * @return
     */
    @Override
    public boolean download(File file, String objName, DownloadAdapter adapter) {
        // 具体的adapter 实现下载文件
        return adapter.download(file, objName);
    }

    /**
     * 删除文件
     *
     * @param file object文件位置
     * @param objName object文件名称
     * @return
     */
    @Override
    public boolean delete(File file, String objName) {
        // 此处实现删除文件操作
        return true;
    }
}
