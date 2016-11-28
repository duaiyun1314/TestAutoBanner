package com.example.andy.testautobanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * 图片加载类
 */
public class ImageUtils {
    private static final int maxDiskSize = 30 * 1024 * 1024;

    public static void initImageLoader(Context context) {
        Fresco.initialize(context, getImagePipelineConfig(context));
    }

    private static ImagePipelineConfig getImagePipelineConfig(Context context) {
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .setDownsampleEnabled(true)
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(context)
                        .setMaxCacheSize(maxDiskSize)
                        .setBaseDirectoryName("IMAGE").build())
                .build();
        return config;
    }

    public static Drawable getTintListDrawable(Context mContext, int mResDrawableId, int mResTintId){
        Drawable drawable = DrawableCompat.wrap(ContextCompat.getDrawable(mContext, mResDrawableId).mutate());
        DrawableCompat.setTintList(drawable, ContextCompat.getColorStateList(mContext, mResTintId));
        return drawable;
    }

    public static Drawable getTintDrawable(Context mContext ,int mResDrawableId, @ColorInt int tint){
        Drawable drawable = DrawableCompat.wrap(ContextCompat.getDrawable(mContext, mResDrawableId).mutate());
        DrawableCompat.setTint(drawable,tint);
        return drawable;
    }

}
