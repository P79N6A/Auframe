package com.android.maiguo.activity.aliyun.image;

import android.support.annotation.DrawableRes;

/**
 * @author cross_ly
 * @date 2018/12/05
 * <p>描述:图片库参数构建类
 */
public class ImageLoaderOptions {

    private int mHolderDrawableId;  // 设置占位图
    private int mErrorDrawableId;  //是否展示加载错误的图片
    private boolean mIsAsBitmap = false;   //是否获取bitmap展示
    private boolean mIsCrossFade = false; //默认为true
    private float mThumbnail = 1f; //默认为1
    private boolean mIsCenterCrop = false;
    private boolean mIsSkipMemoryCache = false; //是否跳过内存缓存
    private boolean mIsSkipDiskCacheCache = false; //是否跳过磁盘缓存
    private boolean mIsCircle = false;

    private ImageLoaderOptions() {
        //私有构造
    }

    public boolean isCircle() {
        return mIsCircle;
    }

    public boolean isCenterCrop() {
        return mIsCenterCrop;
    }

    public int getHolderDrawableId() {
        return mHolderDrawableId;
    }

    public int getErrorDrawableId() {
        return mErrorDrawableId;
    }

    public boolean isAsBitmap() {
        return mIsAsBitmap;
    }

    public boolean isCrossFade() {
        return mIsCrossFade;
    }

    public float getThumbnail() {
        return mThumbnail;
    }

    public boolean isSkipMemoryCache() {
        return mIsSkipMemoryCache;
    }

    public boolean isSkipDiskCacheCache() {
        return mIsSkipDiskCacheCache;
    }

    /**
     * 建造者
     */
    public final static class Builder {

        private final ImageLoaderOptions mLoaderOptions;

        public Builder() {
            mLoaderOptions = new ImageLoaderOptions();
        }

        public Builder placeholder(@DrawableRes int mHolderDrawableId) {
            mLoaderOptions.mHolderDrawableId = mHolderDrawableId;
            return this;
        }

        /**
         * 淡入淡出
         *
         * @return Builder
         */
        public Builder crossFade() {
            mLoaderOptions.mIsCrossFade = true;
            return this;
        }

        /**
         * centerCrop
         *
         * @return Builder
         */
        public Builder centerCrop() {
            mLoaderOptions.mIsCenterCrop = true;
            return this;
        }

        /**
         * 加载圆形
         *
         * @return Builder
         */
        public Builder circle() {
            mLoaderOptions.mIsCircle = true;
            return this;
        }

        /**
         * Glide 的 thumbnail() API 允许你指定一个 RequestBuilder 以与你的主请求并行启动。
         * thumbnail() 会在主请求加载过程中展示。如果主请求在缩略图请求之前完成，则缩略图请求中的图像将不会被展示。
         * thumbnail() API 允许你简单快速地加载图像的低分辨率版本，并且同时加载图像的无损版本，
         * 这可以减少用户盯着加载指示器 【例如进度条–译者注】 的时间。
         *
         * 此方法就适配glide的简化版本，它只需要一个 sizeMultiplier 参数。如果你只是想为你的加载相同的图片，
         * 但尺寸为 View 或 Target 的某个百分比的话特别有用：
         * @param sizeMultiplier 原图的比列
         * @return Builder
         */
        public Builder thumbnail(float sizeMultiplier) {
            mLoaderOptions.mThumbnail = sizeMultiplier;
            return this;
        }

        /**
         * RequestBuilders 是特定于它们将要加载的资源类型的。默认情况下你会得到一个 Drawable RequestBuilder ，
         * 但你可以使用 as... 系列方法来改变请求类型。例如，如果你调用了 asBitmap() ，你就将获得一个 BitmapRequestBuilder 对象，
         * 而不是默认的 Drawable RequestBuilder。
         *
         * @return Builder
         */
        public Builder asBitmap() {
            mLoaderOptions.mIsAsBitmap = true;
            return this;
        }

        /**
         * 错误占位图
         *
         * @param mErrorDrawableId 资源id
         * @return Builder
         */
        public Builder error(@DrawableRes int mErrorDrawableId) {
            mLoaderOptions.mErrorDrawableId = mErrorDrawableId;
            return this;
        }

        /**
         * 跳过硬盘缓存
         *
         * @return Builder
         */
        public Builder skipDiskCacheCache() {
            mLoaderOptions.mIsSkipDiskCacheCache = true;
            return this;
        }

        /**
         * 跳过内存缓存
         *
         * @return Builder
         */
        public Builder skipMemoryCache() {
            mLoaderOptions.mIsSkipMemoryCache = true;
            return this;

        }

        /**
         * 获取构建的ImageLoaderOptions对象
         *
         * @return mLoaderOptions
         */
        public ImageLoaderOptions build() {
            return mLoaderOptions;
        }

    }

}
