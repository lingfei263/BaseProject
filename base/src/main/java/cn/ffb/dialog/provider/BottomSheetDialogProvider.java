package cn.ffb.dialog.provider;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.FrameLayout;

import cn.ffb.dialog.builder.BottomSheetDialogBuilder;
import cn.ffb.dialog.core.DialogProvider;

/**
 * Created by lingfei on 2016/10/20.
 */

public class BottomSheetDialogProvider extends DialogProvider<BottomSheetDialogBuilder> {

    @Override
    public Dialog createInnerDialog(BottomSheetDialogBuilder dialogBuilder) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(dialogBuilder.getContext());

        FrameLayout frameLayout = new FrameLayout(dialogBuilder.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));

        if (dialogBuilder.getContentViewResId() != 0) {
            dialogBuilder.setContentView(
                    View.inflate(dialogBuilder.getContext(), dialogBuilder.getContentViewResId(), null));
        }

        if (dialogBuilder.getContentView() != null) {
            FrameLayout.LayoutParams layoutParams = dialogBuilder.getLayoutParams();

            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);
            }
            frameLayout.addView(dialogBuilder.getContentView(), layoutParams);
        }

        bottomSheetDialog.setContentView(frameLayout);

        return bottomSheetDialog;
    }
}
