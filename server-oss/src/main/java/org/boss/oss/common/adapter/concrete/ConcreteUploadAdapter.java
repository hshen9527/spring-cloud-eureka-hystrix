package org.boss.oss.common.adapter.concrete;

import lombok.extern.slf4j.Slf4j;
import org.boss.oss.common.adapter.UploadAdapter;

import java.io.File;

@Slf4j
public class ConcreteUploadAdapter implements UploadAdapter {
    @Override
    public boolean update(File file, String objName) {
        log.info("上传中...");
        return true;
    }
}
