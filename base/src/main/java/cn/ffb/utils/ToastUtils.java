package cn.ffb.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author lingfei 2017-5-9
 */

public class ToastUtils {

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void showToast(Context context, int message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
