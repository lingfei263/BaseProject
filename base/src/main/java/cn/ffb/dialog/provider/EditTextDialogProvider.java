package cn.ffb.dialog.provider;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import cn.ffb.R;
import cn.ffb.dialog.builder.EditTextDialogBuilder;
import cn.ffb.dialog.core.DialogProvider;
import cn.ffb.utils.EditTextUtils;


/**
 * Created by lingfei on 2017/6/8.
 */

public class EditTextDialogProvider extends DialogProvider<EditTextDialogBuilder> {

    @SuppressLint("InflateParams")
    @Override
    public Dialog createInnerDialog(final EditTextDialogBuilder dialogBuilder) {
        dialogBuilder.defaultButtonText();

        View contentView = LayoutInflater.from(dialogBuilder.getContext())
                .inflate(R.layout.comm_dialog_edittext, null, false);
        final EditText editText = (EditText) contentView.findViewById(R.id.edittext);
        AlertDialog.Builder builder = new AlertDialog.Builder(dialogBuilder.getContext())
                .setTitle(dialogBuilder.getTitle()).setMessage(dialogBuilder.getMessage())
                .setNegativeButton(dialogBuilder.getNegativeButtonText(),
                        dialogBuilder.getOnNegativeButtonClickListener())
                .setPositiveButton(dialogBuilder.getPositiveButtonText(), null).setView(contentView);
        // 调用控件初始化接口
        if (dialogBuilder.getOnEditTextDialogListener() != null) {
            dialogBuilder.getOnEditTextDialogListener().onEditTextCreated(editText);
        }
        // 因为checkbox的文本是用textview控件实现，所以这里需要转换一下。
//    TextView checkboxTextView = (TextView) contentView.findViewById(R.id.checkbox_text);
//    checkboxTextView.setText(checkBox.getText());
//    checkBox.setText("");
//    checkBoxLayout.setVisibility(checkBox.getVisibility());
        EditTextUtils.onTextToEnd(editText);
        AlertDialog innerDialog = builder.create();
        final DialogInterface.OnShowListener onShowListener = dialogBuilder.getOnShowListener();
        dialogBuilder.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                if (onShowListener != null) {
                    onShowListener.onShow(dialog);
                }
                // 对话框show后才可以获取到button的对象
                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE)
                        .setOnClickListener(new PositiveButtonClickListener(dialog, dialogBuilder, editText));
            }
        });
        return innerDialog;
    }

    static class PositiveButtonClickListener implements View.OnClickListener {
        DialogInterface dialog;
        EditText editText;
        EditTextDialogBuilder dialogBuilder;

        public PositiveButtonClickListener(DialogInterface dialog, EditTextDialogBuilder dialogBuilder, EditText editText) {
            this.dialog = dialog;
            this.editText = editText;
            this.dialogBuilder = dialogBuilder;
        }

        @Override
        public void onClick(View view) {
            // 如果返回true不会关闭对话框
            boolean result = dialogBuilder.getOnEditTextDialogListener().onEditTextSelected(editText, editText.getText().toString());
            if (!result) {
                dialog.dismiss();
            }
        }
    }

}
