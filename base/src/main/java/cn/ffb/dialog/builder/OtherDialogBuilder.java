package cn.ffb.dialog.builder;

import android.content.Context;

import cn.ffb.dialog.core.DialogBuilder;
import cn.ffb.dialog.core.DialogType;

/**
 * @author lingfei  2017/6/4.
 */

public class OtherDialogBuilder extends DialogBuilder<OtherDialogBuilder> {

    public OtherDialogBuilder(Context context) {
        super(context, DialogType.DIALOG_OTHER);
    }

}
