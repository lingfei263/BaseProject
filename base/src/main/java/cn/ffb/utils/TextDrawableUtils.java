package cn.ffb.utils;

import android.graphics.drawable.Drawable;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

/**
 * @author lingfei 2017-5-9
 */
public class TextDrawableUtils {

    public static Drawable getTextRoundDrawable(String text, int color) {
        // 下面的代码是随机的颜色
        // int color = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder().buildRound(text, color);
        return drawable;
    }

    public static Drawable getRandomColorRoundDrawable(String text, boolean random) {
        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        // 下面的代码同一个首字母生成的图片中的颜色是相同的
        int color = random ? generator.getRandomColor() : generator.getColor(text);
        return getTextRoundDrawable(text, color);
    }

    public static Drawable getColorRoundDrawable(String text) {
        return getRandomColorRoundDrawable(text, false);
    }

    public static Drawable getTextRectDrawable(String text, int color) {
        // 下面的代码是随机的颜色
        // int color = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder().buildRect(text, color);
        return drawable;
    }

    public static Drawable getRandomColorRectDrawable(String text, boolean random) {
        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        // 下面的代码同一个首字母生成的图片中的颜色是相同的
        int color = random ? generator.getRandomColor() : generator.getColor(text);
        return getTextRectDrawable(text, color);
    }

    public static Drawable getColorRectDrawable(String text) {
        return getRandomColorRectDrawable(text, false);
    }

}
