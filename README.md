# FrescoDemo
Demo图片：

![demo](http://upload-images.jianshu.io/upload_images/3805053-8f17f893d2a377da.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

# 参考文档：

Fresco开源地址：[https://github.com/facebook/fresco](https://github.com/facebook/fresco) 

Fresco文档地址：[https://www.fresco-cn.org](https://www.fresco-cn.org/)

Fresco实践总结：http://blog.csdn.net/yanzhenjie1003/article/details/58727881

# 引入Fresco
这里告诉你如何在项目中引入 Fresco.
使用 Android Studio 或者其他 Gradle 构建的项目
编辑 build.gradle 文件:
```
dependencies {
  // 其他依赖
  compile 'com.facebook.fresco:fresco:0.12.0'
}
```
下面的依赖需要根据需求添加：
```
dependencies {
  // 在 API < 14 上的机器支持 WebP 时，需要添加
  compile 'com.facebook.fresco:animated-base-support:0.12.0'

  // 支持 GIF 动图，需要添加
  compile 'com.facebook.fresco:animated-gif:0.12.0'

  // 支持 WebP （静态图+动图），需要添加
  compile 'com.facebook.fresco:animated-webp:0.12.0'
  compile 'com.facebook.fresco:webpsupport:0.12.0'

  // 仅支持 WebP 静态图，需要添加
  compile 'com.facebook.fresco:webpsupport:0.12.0'
}
```

# 开始使用 Fresco

如果你仅仅是想简单下载一张网络图片，在下载完成之前，显示一张占位图，那么简单使用 [SimpleDraweeView](https://www.fresco-cn.org/javadoc/reference/com/facebook/drawee/view/SimpleDraweeView.html) 即可。
在加载图片之前，你必须初始化Fresco类。你只需要调用Fresco.initialize一次即可完成初始化，在 Application里面做这件事再适合不过了（如下面的代码），注意多次的调用初始化是无意义的。
```
public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Fresco.initialize(this);
	}
}
```


做完上面的工作后，你需要在 AndroidManifest.xml中指定你的 Application 类。为了下载网络图片，请确认你声明了网络请求的权限。

```
<manifest
    ...
    >
    <uses-permission android:name="android.permission.INTERNET" />
    <application
      ...
      android:label="@string/app_name"
      android:name=".MyApplication"
      >
      ...
    </application>
    ...
  </manifest>
```


在xml布局文件中, 加入命名空间：
```
<!-- 其他元素-->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:fresco="http://schemas.android.com/apk/res-auto"
    android:layout_height="match_parent"
    android:layout_width="match_parent">
```

加入SimpleDraweeView
```
<com.facebook.drawee.view.SimpleDraweeView
    android:id="@+id/my_image_view"
    android:layout_width="130dp"
    android:layout_height="130dp"
    fresco:placeholderImage="@drawable/my_drawable"
  />
```

开始加载图片:
```
Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/logo.png");
SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
draweeView.setImageURI(uri);
```

# 一些默认属性的设置
```
<com.facebook.drawee.view.SimpleDraweeView
  android:layout_width="20dp"
  android:layout_height="20dp"
  fresco:fadeDuration="300" // 淡出时间，毫秒。
  fresco:actualImageScaleType="focusCrop" // 等同于android:scaleType。
  fresco:placeholderImage="@color/wait_color" // 加载中…时显示的图。
  fresco:placeholderImageScaleType="fitCenter" // 加载中…显示图的缩放模式。
  fresco:failureImage="@drawable/error" // 加载失败时显示的图。
  fresco:failureImageScaleType="centerInside" // 加载失败时显示图的缩放模式。
  fresco:retryImage="@drawable/retrying" // 重试时显示图。
  fresco:retryImageScaleType="centerCrop" // 重试时显示图的缩放模式。
  fresco:progressBarImage="@drawable/progress_bar" // 进度条显示图。
  fresco:progressBarImageScaleType="centerInside" // 进度条时显示图的缩放模式。
  fresco:progressBarAutoRotateInterval="1000" // 进度条旋转时间间隔。
  fresco:backgroundImage="@color/blue" // 背景图，不会被View遮挡。

  fresco:roundAsCircle="false" // 是否是圆形图片。
  fresco:roundedCornerRadius="1dp" // 四角圆角度数，如果是圆形图片，这个属性被忽略。
  fresco:roundTopLeft="true" // 左上角是否圆角。
  fresco:roundTopRight="false" // 右上角是否圆角。
  fresco:roundBottomLeft="false" // 左下角是否圆角。
  fresco:roundBottomRight="true" // 左下角是否圆角。
  fresco:roundingBorderWidth="2dp" // 描边的宽度。
  fresco:roundingBorderColor="@color/border_color" 描边的颜色。
/>
```
# 支持的URI
 加载网络图片、url、assets、res、本地File图片
先给出支持的URI格式列表（列表来自fresco-cn.org）：

![  ](http://upload-images.jianshu.io/upload_images/3805053-5610199c61f6155d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
