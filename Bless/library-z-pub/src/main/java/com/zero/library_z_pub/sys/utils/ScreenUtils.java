package com.zero.library_z_pub.sys.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import com.zero.library_z_pub.sys.log.LogTool;

/**
 * Created by xiaocai on 2018/5/3.
 */

public class ScreenUtils {

    public static int dpToPx(Context context, int dp){

        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dp*scale + 0.5f);

    }

    public static int pxToDp(Context context, int px){

        float scale = context.getResources().getDisplayMetrics().density;
        return scale != 0 ? (int)(px/scale + 0.5f) : 0;

    }

    public static int[] getScreenSize(Context context){

        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;
        int[] size = {width, height};
        return size;

    }

    public static void logScreenInfo(Context context){

        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        String screenInfo = "The Screen density="+dm.density+" dpi="+dm.densityDpi+" w="+dm.widthPixels+" h="+dm.heightPixels;

        LogTool.log(screenInfo);

    }

}
