package com.cloudbusinessdiscount.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.ByteConstants;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import java.util.HashSet;
import java.util.Set;

import okhttp3.OkHttpClient;

public class ImagePipelineConfigFactory {
	private static final int MAX_HEAP_SIZE = (int) Runtime.getRuntime().maxMemory();
	public static final int MAX_DISK_CACHE_SIZE = 50 * ByteConstants.MB;
	public static final int MAX_MEMORY_CACHE_SIZE = MAX_HEAP_SIZE / 8;
	private static final String IMAGE_PIPELINE_CACHE_DIR = "imagepipeline_cache";
	private static ImagePipelineConfig sImagePipelineConfig;
	private static ImagePipelineConfig sOkHttpImagePipelineConfig;

	/**
	 * 使用Android自带的网络加载图片
	 */
	public static ImagePipelineConfig getImagePipelineConfig(Context context) {
		if (sImagePipelineConfig == null) {
			ImagePipelineConfig.Builder configBuilder = ImagePipelineConfig.newBuilder(context);
			configBuilder.setProgressiveJpegConfig(mProgressiveJpegConfig);
			configBuilder.setBitmapsConfig(Bitmap.Config.RGB_565);
			configBuilder.setResizeAndRotateEnabledForNetwork(true);//已对网络图也能进行resize处理，减少内存开销；
			configBuilder.setDownsampleEnabled(true);
			configureCaches(configBuilder, context);
			configureLoggingListeners(configBuilder);
			sImagePipelineConfig = configBuilder.build();
		}
		return sImagePipelineConfig;
	}

	/**
	 * 使用OkHttp网络库加载图片
	 */
	public static ImagePipelineConfig getOkHttpImagePipelineConfig(Context context) {
		if (sOkHttpImagePipelineConfig == null) {
			OkHttpClient okHttpClient = new OkHttpClient();
			ImagePipelineConfig.Builder configBuilder = OkHttpImagePipelineConfigFactory.newBuilder(context,
					okHttpClient);
			configBuilder.setProgressiveJpegConfig(mProgressiveJpegConfig);
			configBuilder.setBitmapsConfig(Bitmap.Config.RGB_565);
			configBuilder.setResizeAndRotateEnabledForNetwork(true);//已对网络图也能进行resize处理，减少内存开销；
			configBuilder.setDownsampleEnabled(true);
			configureCaches(configBuilder, context);
			configureLoggingListeners(configBuilder);
			sOkHttpImagePipelineConfig = configBuilder.build();
		}
		return sOkHttpImagePipelineConfig;
	}

	/**
	 * 配置内存缓存和磁盘缓存
	 */
	private static void configureCaches(ImagePipelineConfig.Builder configBuilder, Context context) {
		Log.e("MAX_MEMORY_CACHE_SIZE=",MAX_MEMORY_CACHE_SIZE+"");
		final MemoryCacheParams bitmapCacheParams = new MemoryCacheParams(MAX_MEMORY_CACHE_SIZE, // Max
																									// total
																									// size
																									// of
																									// elements
																									// in
																									// the
																									// cache
				Integer.MAX_VALUE, // Max entries in the cache
				MAX_MEMORY_CACHE_SIZE, // Max total size of elements in eviction
										// queue
				Integer.MAX_VALUE, // Max length of eviction queue
				Integer.MAX_VALUE); // Max cache entry size
		configBuilder.setBitmapMemoryCacheParamsSupplier(new Supplier<MemoryCacheParams>() {
			public MemoryCacheParams get() {
				return bitmapCacheParams;
			}
		}).setMainDiskCacheConfig(
				DiskCacheConfig.newBuilder(context).setBaseDirectoryPath(context.getApplicationContext().getCacheDir())
						.setBaseDirectoryName(IMAGE_PIPELINE_CACHE_DIR).setMaxCacheSize(MAX_DISK_CACHE_SIZE).build());
	}

	private static void configureLoggingListeners(ImagePipelineConfig.Builder configBuilder) {
		Set<RequestListener> requestListeners = new HashSet<>();
		requestListeners.add(new RequestLoggingListener());
		configBuilder.setRequestListeners(requestListeners);
	}

	// 渐进式图片
	static ProgressiveJpegConfig mProgressiveJpegConfig = new ProgressiveJpegConfig() {
		@Override
		public int getNextScanNumberToDecode(int scanNumber) {
			return scanNumber + 2;
		}

		public QualityInfo getQualityInfo(int scanNumber) {
			boolean isGoodEnough = (scanNumber >= 5);
			return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
		}
	};
}