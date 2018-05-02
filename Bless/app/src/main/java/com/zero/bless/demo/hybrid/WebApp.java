package com.zero.bless.demo.hybrid;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.zero.bless.BuildConfig;
import com.zero.bless.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xiaocai on 2018/3/26.
 */

public class WebApp extends Activity {

    WebView mAppContainer;
    Button mOpenJsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_app);

        init();

    }

    public void init(){

        findView();

        WebSettings webSettings = mAppContainer.getSettings();

        webSettings.setJavaScriptEnabled(true); //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); //缩放至屏幕的大小

        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8"); //设置编码格式

        mAppContainer.setWebViewClient(new MyWebViewClient());
        mAppContainer.setWebChromeClient(new MyWebChromeClient());

        mAppContainer.loadUrl("file:///android_asset/test.html");

        mOpenJsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                testAndroidCallJs();

            }
        });

        testJsCallAndroid();

    }

    public void findView(){

        mAppContainer = (WebView)findViewById(R.id.app_container);

        mOpenJsBtn = (Button)findViewById(R.id.open_js_btn);

    }

    public void testAndroidCallJs(){

        if(mAppContainer != null){

            //4.4以前只能调用loadUrl
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){

                mAppContainer.loadUrl("javascript:show_message()");

            }
            else {

                mAppContainer.evaluateJavascript("javascript:show_message()", new ValueCallback<String>() {

                    @Override
                    public void onReceiveValue(String value) {

                        Log.d(">>>> debug", "webapp onjsalert value="+value);

                    }

                });

            }


        }

    }

    public void testJsCallAndroid(){

        if(mAppContainer != null){

            //通过addJavascriptInterface()将Java对象映射到JS对象
            mAppContainer.addJavascriptInterface(new TestJs(), "test_js");

        }

    }

    public class MyWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){

            Log.d(">>>>> debug ", "viewclient shouldoverrideurlloading url = "+url);

            if(url != null){

                //根据协议的参数，判断是否是所需要的url
                //一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"

                Uri uri = Uri.parse(url);

                if(uri.getScheme() != null && uri.getScheme().equals("js")){

                    if(uri.getAuthority() != null && uri.getAuthority().equals("webview")){

                        Set<String> keys = uri.getQueryParameterNames();

                        HashMap<String,String> param = new HashMap<>();

                        Iterator<String> keyIterator = keys.iterator();

                        while (keyIterator.hasNext()){

                            String key = keyIterator.next();

                            String name = key != null ? uri.getQueryParameter(key) : "null";

                            Log.d(">>>>> debug ", "viewclient shouldoverrideurlloading key = "+key + " name = " + name);

                        }

                        mAppContainer.loadUrl("javascript:get_android_return("+200+")"); //js需要返回值可通过该方法返回

                    }

                    return true;

                }

            }

            return super.shouldOverrideUrlLoading(view, url); //返回值为true表示有客户端自己控制，false等同默认处理。其他功能大多类似。

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){

            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onPageFinished(WebView view, String url){

            super.onPageFinished(view, url);

        }

        @Override
        public void onLoadResource(WebView view, String url){

            super.onLoadResource(view, url);

        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){

            super.onReceivedSslError(view, handler, error);

        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl){

            super.onReceivedError(view, errorCode, description, failingUrl);

        }

    }

    public class MyWebChromeClient extends WebChromeClient{

        @Override
        public void onProgressChanged(WebView view, int progress){
        }

        @Override
        public void onReceivedTitle(WebView view, String title){
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon){
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result)
        {

            Log.d(">>>> debug", "webapp onjsalert message="+message);

            return super.onJsAlert(view, url, message, result);

        }

        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result){

            return super.onJsConfirm(view, url, message, result);

        }

        /**
         *
         * @param view
         * @param url
         * @param message
         * @param defaultValue
         * @param result 代表消息框的返回值,通过该值返回给js
         * @return
         */
        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result){

            return super.onJsPrompt(view, url, message, defaultValue, result);

        }

    }

    public class TestJs extends Object{

        @JavascriptInterface
        public void test(String msg){

            Log.d(">>>>> debug ","js call test msg="+msg);

        }

    }

}
