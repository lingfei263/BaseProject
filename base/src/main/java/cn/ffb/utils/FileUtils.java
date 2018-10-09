package cn.ffb.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * （缓存）文件管理
 *
 * @author lingfei 2017-5-9
 *
 */
public class FileUtils {
    /**
     * 根路径
     **/
    public final static String ROOT_DEFAULT_PATH = "/yhq/";
    /**
     * 缓存子路径
     **/
    public final static String CACHE_PATH = "cache/";
    /**
     * 图片缓存子路径，为CACHE_PATH的子路径
     **/
    public final static String CACHE_IMAGE_PATH = "images/";
    /**
     * web缓存，为CACHE_PATH的子路径
     **/
    public final static String CACHE_WEB_PATH = "webs/";
    /**
     * 文件存放子路径
     **/
    public final static String FILE_PATH = "files/";
    /**
     * 日志存放子路径，为FILE_PATH的子路径
     **/
    public final static String LOG_PATH = "logs/";
    /**
     * 临时文件存放子路径，为FILE_PATH的子路径
     **/
    public final static String TEMP_PATH = "temp/";
    /**
     * 下载文件存放子路径，为FILE_PATH的子路径
     **/
    public final static String DOWNLOAD_PATH = "download/";
    /**
     * 数据库的存放路径，为FILE_PATH的子路径
     **/
    public final static String DATABASE_PATH = "database/";
    /**
     * 语音消息的存放路径，为FILE_PATH的子路径
     **/
    public final static String VOICE_PATH = "voice/";

    private static String ROOT_PATH = ROOT_DEFAULT_PATH;

    public static void setRootPath(String rootPath) {
        ROOT_PATH = rootPath;
    }

    /**
     * 获取缓存路径
     *
     * @return
     */
    public static String getCachePath(Context context) {
        return getFilePath(context, CACHE_PATH);
    }


    /**
     * 获取语音消息的路径
     *
     * @return
     */
    public static String getVoicePath(Context context) {
        return getFilePath(context, VOICE_PATH);
    }

    /**
     * 获取图片缓存路径
     *
     * @return
     */
    public static String getImageCachePath(Context context) {
        return getFilePath(context, CACHE_IMAGE_PATH);
    }

    /**
     * 获取web缓存路径
     *
     * @return
     */
    public static String getWebCachePath(Context context) {
        return getFilePath(context, CACHE_WEB_PATH);
    }

    /**
     * 获取日志文件目录
     *
     * @return
     */
    public static String getLogPath(Context context) {
        return getFilePath(context, LOG_PATH);
    }

    /**
     * 获取数据库目录
     *
     * @return
     */
    public static String getDatabasePath(Context context) {
        return getFilePath(context, DATABASE_PATH);
    }


    /**
     * 获取下载文件目录
     *
     * @return
     */
    public static String getDownloadPath(Context context) {
        return getFilePath(context, DOWNLOAD_PATH);
    }

    /**
     * 获取临时文件目录
     *
     * @return
     */
    public static String getTempPath(Context context) {
        return getFilePath(context, TEMP_PATH);
    }

    public static String getFilePath(Context context, String path) {
        File file = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            file = new File(Environment.getExternalStorageDirectory().getPath(),
                    new File(ROOT_PATH, path).getPath());
        } else {
            file = new File(context.getFilesDir().getPath(), path);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

}
