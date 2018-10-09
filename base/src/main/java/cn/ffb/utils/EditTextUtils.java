package cn.ffb.utils;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.widget.EditText;

public class EditTextUtils {

    public static void onTextToEnd(EditText editText) {
        CharSequence text = editText.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());
        }
    }

    public static void clear(EditText editText) {
        setText(editText, "");
    }

    public static void setText(EditText editText, CharSequence text) {
        editText.setText(text);
    }

    public static void setTextKeepSelection(EditText editText, CharSequence text) {
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText(text);
        EditTextUtils.setSelection(editText, selectionStart, selectionEnd);
    }

    public static String getText(EditText editText) {
        return editText.getText().toString();
    }

    public static void setSelection(EditText editText, int selectionStart, int selectionEnd) {
        CharSequence text = editText.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, selectionStart, selectionEnd);
        }
    }

    public static void delete(EditText editText, int start, int count) {
        Editable editable = editText.getText();
        editable.delete(start, start + count);
    }

    public static void insert(EditText editText, CharSequence text) {
        int selectionStart = editText.getSelectionStart();
        Editable editable = editText.getText();
        editable.insert(selectionStart, text);
    }

}
