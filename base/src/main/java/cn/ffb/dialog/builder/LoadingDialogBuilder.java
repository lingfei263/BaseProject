package cn.ffb.dialog.builder;

import android.content.Context;

import cn.ffb.dialog.core.DialogBuilder;
import cn.ffb.dialog.core.DialogType;

/**
 * @author lingfei  2017/6/4.
 */

public class LoadingDialogBuilder extends DialogBuilder<LoadingDialogBuilder> {

    protected LoadingDialogBuilder(Context context, int dialogType) {
        super(context, dialogType);
    }

    public static LoadingDialogBuilder getLoadingDialogBuilder0(Context context) {
        return new LoadingDialogBuilder(context, DialogType.DIALOG_LOADING0);
    }

    public static LoadingDialogBuilder getLoadingDialogBuilder1(Context context) {
        return new LoadingDialogBuilder(context, DialogType.DIALOG_LOADING1);
    }

    public static LoadingDialogBuilder getLoadingDialogBuilder2(Context context) {
        return new LoadingDialogBuilder(context, DialogType.DIALOG_LOADING2);
    }

}
