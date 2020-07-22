package org.boss.oss.common.adapter.concrete;

import lombok.extern.slf4j.Slf4j;
import org.boss.oss.common.adapter.DownloadAdapter;

import java.io.File;

@Slf4j
public class ConcreteDownloadAdapter implements DownloadAdapter {
    @Override
    public boolean download(File file, String objName) {
        log.info("下载中...");
        return true;
    }
}
