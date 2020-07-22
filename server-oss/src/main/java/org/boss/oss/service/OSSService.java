package org.boss.oss.service;

import org.boss.oss.common.adapter.DownloadAdapter;
import org.boss.oss.common.adapter.UploadAdapter;

import java.io.File;

public interface OSSService {

    boolean update(File file, String objName, UploadAdapter adapter);

    boolean download(File file, String objName, DownloadAdapter adapter);

    boolean delete(File file, String objName);
}
