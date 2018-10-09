package cn.ffb.dialog.provider;

import android.app.Dialog;
import android.app.ProgressDialog;

import cn.ffb.R;
import cn.ffb.dialog.builder.LoadingDialogBuilder;
import cn.ffb.dialog.core.DialogProvider;

/**
 * Created by lingfei on 2017/6/2.
 */

public class LoadingDialogProvider1 extends DialogProvider<LoadingDialogBuilder> {

    @Override
    public Dialog createInnerDialog(LoadingDialogBuilder dialogBuilder) {
        final ProgressDialog dialog = new ProgressDialog(dialogBuilder.getContext());
        dialog.setIndeterminate(true);
        dialog.setProgressNumberFormat(null);
        dialog.setProgressPercentFormat(null);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        if (dialogBuilder.getMessage() != null) {
            dialog.setMessage(dialogBuilder.getMessage());
        } else {
            dialog.setMessage(dialogBuilder.getContext().getString(R.string.loading));
        }
        return dialog;
    }


}
