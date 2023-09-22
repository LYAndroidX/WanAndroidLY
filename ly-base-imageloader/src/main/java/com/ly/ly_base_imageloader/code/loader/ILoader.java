package com.ly.ly_base_imageloader.code.loader;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.MemoryCategory;
import com.ly.ly_base_imageloader.code.config.SingleConfig;
import com.ly.ly_base_imageloader.code.utils.DownLoadImageService;

public interface ILoader {

    void init(Context context, int cacheSizeInM, MemoryCategory memoryCategory, boolean isInternalCD);

    void request(SingleConfig config);

    void pause();

    void resume();

    void clearDiskCache();

    void clearMomoryCache(View view);

    void clearMomory();

    boolean  isCached(String url);

    void trimMemory(int level);

    void clearAllMemoryCaches();

    void saveImageIntoGallery(DownLoadImageService downLoadImageService);
}
