package cn.ffb.dialog.core;

import android.util.SparseArray;

import cn.ffb.dialog.provider.AlertDialogProvider;
import cn.ffb.dialog.provider.BottomSheetDialogProvider;
import cn.ffb.dialog.provider.CircleProgressDialogProvider;
import cn.ffb.dialog.provider.ContentViewDialogProvider;
import cn.ffb.dialog.provider.EditTextDialogProvider;
import cn.ffb.dialog.provider.ListDialogProvider;
import cn.ffb.dialog.provider.LoadingDialogProvider0;
import cn.ffb.dialog.provider.LoadingDialogProvider1;
import cn.ffb.dialog.provider.LoadingDialogProvider2;
import cn.ffb.dialog.provider.MessageDialogProvider;
import cn.ffb.dialog.provider.ProgressDialogProvider;


/**
 * 对话框生成工厂
 *
 * @author   lingfei  2017/6/4
 */
public final class DialogFactory {
    private final static SparseArray<IDialogProvider<?>> dialogProviders = new SparseArray<>();

    static {
        register(DialogType.DIALOG_OTHER, new ContentViewDialogProvider());
        register(DialogType.DIALOG_MESSAGE, new MessageDialogProvider());
        register(DialogType.DIALOG_ALERT, new AlertDialogProvider());
        register(DialogType.DIALOG_LOADING0, new LoadingDialogProvider0());
        register(DialogType.DIALOG_LOADING1, new LoadingDialogProvider1());
        register(DialogType.DIALOG_LOADING2, new LoadingDialogProvider2());
        register(DialogType.DIALOG_LIST, new ListDialogProvider());
        register(DialogType.DIALOG_EDIT_TEXT, new EditTextDialogProvider());
        register(DialogType.DIALOG_CIRCLE_PROGRESS, new CircleProgressDialogProvider());
        register(DialogType.DIALOG_BOTTOM_SHEET, new BottomSheetDialogProvider());
        register(DialogType.DIALOG_PROGRESS, new ProgressDialogProvider());
    }

    public static <T extends DialogBuilder<T>> void register(int dialogType, IDialogProvider<T> dialogProvider) {
        dialogProviders.put(dialogType, dialogProvider);
    }

    public static <T extends DialogBuilder<T>> IDialog create(DialogBuilder<T> dialogBuilder) {
        int dialogType = dialogBuilder.getDialogType();
        IDialogProvider dialogProvider = dialogProviders.get(dialogType);
        return dialogProvider.createDialog(dialogBuilder);
    }

}
