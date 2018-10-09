package cn.ffb.dialog.provider;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.view.Window;

import cn.ffb.R;
import cn.ffb.dialog.builder.LoadingDialogBuilder;
import cn.ffb.dialog.core.DialogProvider;

/**
 * Created by lingfei on 2017/6/8.
 */

public class LoadingDialogProvider0 extends DialogProvider<LoadingDialogBuilder> {

    @Override
    public Dialog createInnerDialog(LoadingDialogBuilder dialogBuilder) {
        Dialog dialog =
                new AlertDialog.Builder(dialogBuilder.getContext()).setView(R.layout.comm_dialog_loading)
                        .create();
        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;
    }

}
