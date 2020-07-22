package org.boss.oss.common.adapter;

import java.io.File;

public interface DownloadAdapter {
    boolean download(File file, String objName);
}
