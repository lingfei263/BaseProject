package cn.ffb.dialog.core;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;

import cn.ffb.R;
import cn.ffb.dialog.builder.AlertDialogBuilder;
import cn.ffb.dialog.builder.BottomSheetDialogBuilder;
import cn.ffb.dialog.builder.EditTextDialogBuilder;
import cn.ffb.dialog.builder.ListDialogBuilder;
import cn.ffb.dialog.builder.LoadingDialogBuilder;
import cn.ffb.dialog.builder.MessageDialogBuilder;
import cn.ffb.dialog.builder.OtherDialogBuilder;
import cn.ffb.dialog.builder.ProgressDialogBuilder;


/**
 * 对话框builder
 *
 * @author   lingfei  2017/6/4
 */
public class DialogBuilder<T extends DialogBuilder<T>> {

    private int dialogType;

    private Context context;
    private String title;
    private String message;
    private String positiveButtonText;
    private String negativeButtonText;
    private DialogInterface.OnClickListener onPositiveButtonClickListener;
    private DialogInterface.OnClickListener onNegativeButtonClickListener;
    private boolean cancelable;
    private boolean canceledOnTouchOutside;

    private View contentView;
    private int contentViewResId;
    private FrameLayout.LayoutParams layoutParams;

    private DialogInterface.OnCancelListener onCancelListener;
    private DialogInterface.OnDismissListener onDismissListener;
    private DialogInterface.OnShowListener onShowListener;
    private OnStateChangeListener onStateChangeListener;

    public static <T extends DialogBuilder<T>> DialogBuilder<T> builder(Context context, int dialogType) {
        return new DialogBuilder(context, dialogType);
    }

    public static ProgressDialogBuilder progressDialog(Context context) {
        return ProgressDialogBuilder.getProgressDialogBuilder1(context);
    }

    public static ProgressDialogBuilder progressCircleDialog(Context context) {
        return ProgressDialogBuilder.getProgressDialogBuilder2(context);
    }

    public static MessageDialogBuilder messageDialog(Context context) {
        return new MessageDialogBuilder(context);
    }

    public static BottomSheetDialogBuilder bottomSheetDialog(Context context) {
        return new BottomSheetDialogBuilder(context);
    }

    public static AlertDialogBuilder alertDialog(Context context) {
        return new AlertDialogBuilder(context);
    }

    public static ListDialogBuilder listDialog(Context context) {
        return new ListDialogBuilder(context);
    }

    public static LoadingDialogBuilder loadingDialog0(Context context) {
        return LoadingDialogBuilder.getLoadingDialogBuilder0(context);
    }

    public static LoadingDialogBuilder loadingDialog1(Context context) {
        return LoadingDialogBuilder.getLoadingDialogBuilder1(context);
    }

    public static LoadingDialogBuilder loadingDialog2(Context context) {
        return LoadingDialogBuilder.getLoadingDialogBuilder2(context);
    }

    public static EditTextDialogBuilder editTextDialog(Context context) {
        return new EditTextDialogBuilder(context);
    }

    public static OtherDialogBuilder otherDialog(Context context) {
        return new OtherDialogBuilder(context);
    }

    public interface OnStateChangeListener {
        void onSaveInstanceState(IDialog dialog, Bundle bundle);

        void onRestoreInstanceState(IDialog dialog, Bundle bundle);
    }

    public DialogBuilder(Context context, int dialogType) {
        this.setContext(context);
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(true);
        this.setDialogType(dialogType);
    }

    public boolean isCanceledOnTouchOutside() {
        return canceledOnTouchOutside;
    }

    public T setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.canceledOnTouchOutside = canceledOnTouchOutside;
        return self();
    }

    public int getContentViewResId() {
        return contentViewResId;
    }

    public T setContentViewResId(int contentViewResId) {
        this.contentViewResId = contentViewResId;
        return self();
    }

    private T self() {
        return (T) this;
    }

    public T setContentViewResId(int contentViewResId,
                                 FrameLayout.LayoutParams layoutParams) {
        this.contentViewResId = contentViewResId;
        this.layoutParams = layoutParams;
        return self();
    }

    public View getContentView() {
        return contentView;
    }

    public T setContentView(View contentView) {
        this.contentView = contentView;
        return self();
    }

    public T setContentView(View contentView, FrameLayout.LayoutParams layoutParams) {
        this.contentView = contentView;
        this.layoutParams = layoutParams;
        return self();
    }

    public OnStateChangeListener getOnStateChangeListener() {
        return onStateChangeListener;
    }

    public T setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.onStateChangeListener = onStateChangeListener;
        return self();
    }

    /**
     * @return the onPositiveButtonClickListener
     */
    public DialogInterface.OnClickListener getOnPositiveButtonClickListener() {
        return onPositiveButtonClickListener;
    }

    /**
     * @param onPositiveButtonClickListener the onPositiveButtonClickListener to set
     */
    public T setOnPositiveButtonClickListener(
            DialogInterface.OnClickListener onPositiveButtonClickListener) {
        this.onPositiveButtonClickListener = onPositiveButtonClickListener;
        return self();
    }

    /**
     * @return the onNegativeButtonClickListener
     */
    public DialogInterface.OnClickListener getOnNegativeButtonClickListener() {
        return onNegativeButtonClickListener;
    }

    /**
     * @param onNegativeButtonClickListener the onNegativeButtonClickListener to set
     */
    public T setOnNegativeButtonClickListener(
            DialogInterface.OnClickListener onNegativeButtonClickListener) {
        this.onNegativeButtonClickListener = onNegativeButtonClickListener;
        return self();
    }

    /**
     * @return the cancelable
     */
    public boolean isCancelable() {
        return cancelable;
    }

    /**
     * @param cancelable the cancelable to set
     */
    public T setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return self();
    }

    /**
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public T setContext(Context context) {
        this.context = context;
        return self();
    }

    public FrameLayout.LayoutParams getLayoutParams() {
        return layoutParams;
    }

    public T setTitle(int title) {
        this.title = context.getString(title);
        return self();
    }

    public T setMessage(int message) {
        this.message = context.getString(message);
        return self();
    }

    public T setPositiveButtonText(int positiveButtonText) {
        this.positiveButtonText =
                positiveButtonText == 0 ? null : context.getString(positiveButtonText);
        return self();
    }

    public T setNegativeButtonText(int negativeButtonText) {
        this.negativeButtonText =
                negativeButtonText == 0 ? null : context.getString(negativeButtonText);
        return self();
    }

    public T setTitle(String title) {
        this.title = title;
        return self();
    }

    public T setMessage(String message) {
        this.message = message;
        return self();
    }

    public T setPositiveButtonText(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return self();
    }

    public T setNegativeButtonText(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return self();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the message
     */
    public CharSequence getMessage() {
        if (TextUtils.isEmpty(message)) {
            return message;
        }
        return Html.fromHtml(message);
    }

    /**
     * @return the positiveButtonText
     */
    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    /**
     * @return the negativeButtonText
     */
    public String getNegativeButtonText() {
        return negativeButtonText;
    }

    public T defaultButtonText() {
        if (TextUtils.isEmpty(this.getNegativeButtonText())) {
            this.setNegativeButtonText(R.string.cancel);
        }
        if (TextUtils.isEmpty(this.getPositiveButtonText())) {
            this.setPositiveButtonText(R.string.okay);
        }
        return self();
    }

    public DialogInterface.OnCancelListener getOnCancelListener() {
        return onCancelListener;
    }

    public T setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
        return self();
    }

    public DialogInterface.OnDismissListener getOnDismissListener() {
        return onDismissListener;
    }

    public T setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.onShowListener = onShowListener;
        return self();
    }

    public DialogInterface.OnShowListener getOnShowListener() {
        return onShowListener;
    }

    public T setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        return self();
    }

    public T setDialogType(int dialogType) {
        this.dialogType = dialogType;
        return self();
    }

    public final int getDialogType() {
        return this.dialogType;
    }

    public final IDialog create() {
        return DialogFactory.create(this);
    }

    public final IDialog show() {
        return create().show();
    }

}
