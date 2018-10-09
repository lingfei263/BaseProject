package cn.ffb.dialog.provider;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;

import cn.ffb.dialog.builder.AlertDialogBuilder;
import cn.ffb.dialog.core.DialogProvider;


/**
 * Created by lingfei on 2017/6/8.
 */

public class AlertDialogProvider extends DialogProvider<AlertDialogBuilder> {

    @Override
    public Dialog createInnerDialog(AlertDialogBuilder dialogBuilder) {
        dialogBuilder.defaultButtonText();
        return new AlertDialog.Builder(dialogBuilder.getContext()).setTitle(dialogBuilder.getTitle())
                .setMessage(dialogBuilder.getMessage())
                .setNegativeButton(dialogBuilder.getNegativeButtonText(),
                        dialogBuilder.getOnNegativeButtonClickListener())
                .setPositiveButton(dialogBuilder.getPositiveButtonText(),
                        dialogBuilder.getOnPositiveButtonClickListener())
                .create();
    }

}
