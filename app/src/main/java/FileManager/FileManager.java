package FileManager;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.File;

/**
 * Created by Mai Thanh Hiep on 4/22/2016.
 */

public class FileManager {
    private static File getAvailableRoot(File file) {
        if (file == null)
            return null;

        File root = file;
        while (Environment.getStorageState(root.getParentFile()).equals(Environment.MEDIA_MOUNTED))
            root = root.getParentFile();

        return root;
    }

    // Get All Available External Storage on your device
    public static File[] getAllAvailableSDCards(Context context) {
        File []files = context.getExternalCacheDirs();
        for (int i = 0; i < files.length; ++i) {
            files[i] = getAvailableRoot(files[i]);
        }
        return files;
    }

    public static File getExternalSDCard(Context context) {
        File files[] = getAllAvailableSDCards(context);
        if (files == null)
            return null;

        if (files.length == 1)
            return files[0]; //Internal SDCard
        else if (files.length == 2)
            return files[1]; //External SDCard
        return null;
    }
}
