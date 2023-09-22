package com.ly.ly_base_imageloader.code.imagei;

import android.graphics.Bitmap;

public interface ImageDownLoadCallBack {

    void onDownLoadSuccess(Bitmap bitmap);

    void onDownLoadFailed();
}
