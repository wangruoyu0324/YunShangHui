# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\AndroidStudio\SDK/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn
#指定代码的压缩级别
            -optimizationpasses 5

            #包明不混合大小写
            -dontusemixedcaseclassnames

            #不去忽略非公共的库类
            -dontskipnonpubliclibraryclasses

             #优化  不优化输入的类文件
            -dontoptimize

             #不做预校验
            -dontpreverify

             #混淆时是否记录日志
            -verbose

             # 混淆时所采用的算法
            -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

            #保护注解
            -keepattributes *Annotation*
            #不混淆资源类
            -keepclassmembers class **.R$* {
                public static <fields>;
            }

            -keep public class * extends android.app.Activity
            -keep public class * extends android.app.Application
            -keep public class * extends android.app.Service
            -keep public class * extends android.content.BroadcastReceiver
            -keep public class * extends android.content.ContentProvider
            -keep public class * extends android.app.backup.BackupAgentHelper
            -keep public class * extends android.preference.Preference
            -keep public class com.android.vending.licensing.ILicensingService

            -keepclasseswithmembernames class * {
                native <methods>;
            }

            -keepclasseswithmembers class * {
                public <init>(android.content.Context, android.util.AttributeSet);
            }

            -keepclasseswithmembers class * {
                public <init>(android.content.Context, android.util.AttributeSet, int);
            }

            -keepclassmembers class * extends android.app.Activity {
               public void *(android.view.View);
            }

            -keepclassmembers enum * {
                public static **[] values();
                public static ** valueOf(java.lang.String);
            }

            -keep class * implements android.os.Parcelable {
              public static final android.os.Parcelable$Creator *;
            }


-keep class com.google.**
-dontwarn com.google.**

-dontwarn android.net.SSLCertificateSocketFactory




# Fresco
# Keep our interfaces so they can be used by other ProGuard rules.
# See http://sourceforge.net/p/proguard/bugs/466/
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip
# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}
# Keep native methods
-keepclassmembers class * {
    native <methods>;
}
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**
-dontwarn com.facebook.infer.**

#ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}