package cn.ffb.dialog.core;


import android.os.Bundle;

/**
 * Created by lingfei on 2017/6/9.
 */

public interface IDialogCreator {
    IDialog createDialog(int id, Bundle args);
}
