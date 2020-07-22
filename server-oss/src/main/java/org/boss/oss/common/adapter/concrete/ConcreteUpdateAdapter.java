package org.boss.oss.common.adapter.concrete;

import lombok.extern.slf4j.Slf4j;
import org.boss.oss.common.adapter.UpdateloadAdapter;

import java.io.File;

@Slf4j
public class ConcreteUpdateAdapter implements UpdateloadAdapter {
    @Override
    public boolean update(File file, String objName) {
        log.info("更新中...");
        return true;
    }
}
