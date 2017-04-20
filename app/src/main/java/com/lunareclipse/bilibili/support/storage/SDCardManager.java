package com.lunareclipse.bilibili.support.storage;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by YaeSakura on 16/8/17.
 */
public class SDCardManager
{
    private static File path = Environment.getExternalStorageDirectory();

    public static boolean isAvailable()
    {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static long totalStorage()
    {
        if (!isAvailable()) return 0;

        StatFs statFs = new StatFs(path.getPath());

        long blockSize, blockCount;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2)
        {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getBlockCountLong();
        }
        else
        {
            blockSize = statFs.getBlockSize();
            blockCount = statFs.getBlockCount();
        }

        return blockSize * blockCount;   //Bytes
    }

    public static long availableStorage()
    {
        if (!isAvailable()) return 0;

        StatFs statFs = new StatFs(path.getPath());

        long blockSize, blockCount;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2)
        {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getAvailableBlocksLong();
        }
        else
        {
            blockSize = statFs.getBlockSize();
            blockCount = statFs.getAvailableBlocks();
        }

        return blockSize * blockCount;   //Bytes
    }
}
