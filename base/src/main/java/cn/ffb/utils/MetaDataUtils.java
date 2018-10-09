package cn.ffb.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * Created by lingfei on 2017/1/23.
 */

public class MetaDataUtils {

    public static String getString(Context context, String name) {
        return getMetaData(context).getString(name);
    }

    public static Bundle getMetaData(Context context) {
        try {
            ApplicationInfo appInfo =
                    context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return new Bundle();
    }

}
