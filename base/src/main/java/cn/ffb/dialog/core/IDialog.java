package cn.ffb.dialog.core;

/**
 * Created by lingfei on 2017/6/9.
 */

public interface IDialog {
    void dismiss();

    IDialog show();

    android.app.Dialog getInnerDialog();
}
