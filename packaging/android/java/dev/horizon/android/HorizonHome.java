package dev.horizon.android;

import android.content.Context;
import java.io.File;

/**
 * Decides where Horizon keeps its data: always the app's private folder.
 * No "All files access" or storage permission is requested.
 */
final class HorizonHome {
    /** Rust reads the chosen folder from this file inside the private folder. */
    static final String POINTER_FILE = "home-path.txt";

    private HorizonHome() {}

    static File dir(Context context) {
        return context.getFilesDir();
    }

    /** Called before the native code starts so Rust and the DocumentsProvider agree. */
    static void publish(Context context) {
        try {
            File pointer = new File(context.getFilesDir(), POINTER_FILE);
            try (java.io.FileOutputStream out = new java.io.FileOutputStream(pointer, false)) {
                out.write(dir(context).getAbsolutePath().getBytes(java.nio.charset.StandardCharsets.UTF_8));
            }
        } catch (java.io.IOException ignored) {
            // Rust falls back to the private folder when the pointer is missing.
        }
    }
}
