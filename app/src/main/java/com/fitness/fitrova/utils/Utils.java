package com.fitness.fitrova.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Display;
import android.view.WindowManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by lion on 4/14/16.
 */
public class Utils {

    private static Utils    instance;
    private Context mContext;

    public static Utils getInstance(Context context) {
        if (instance == null) {
            instance = new Utils(context);
        }

        instance.setContext(context);

        return instance;
    }

    private Utils(Context context) {
        mContext = context;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public static boolean isNullOrEmpty(String string) {
        if (string == null || string.isEmpty())
            return true;

        return false;
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        }else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static String createFilename(String prefix, String fileExtension){
        return prefix+ System.currentTimeMillis() +fileExtension;
    }

    public static String getFileExtension(String filePath){
        String filenameArray[] = filePath.split("\\.");
        String extension = filenameArray[filenameArray.length - 1];
        return extension;
    }

    /**
     *
     * check image orientation
     *
     * @param target
     * @return
     * @throws Exception
     */

    public static int getImageOrientation(String target) throws Exception {

        int degree = 0;
        Matrix matrix = new Matrix();
        ExifInterface exif = new ExifInterface(target);
        String orientation = exif.getAttribute(ExifInterface.TAG_ORIENTATION);

        if (orientation.equals(ExifInterface.ORIENTATION_NORMAL)) {
            degree = 0;
        } else if (orientation.equals(ExifInterface.ORIENTATION_ROTATE_90 + "")) {
            matrix.postRotate(90);
            degree = 90;
        } else if (orientation
                .equals(ExifInterface.ORIENTATION_ROTATE_180 + "")) {
            matrix.postRotate(180);
            degree = 180;
        } else if (orientation
                .equals(ExifInterface.ORIENTATION_ROTATE_270 + "")) {
            matrix.postRotate(270);
            degree = 270;
        }

        return degree;
    }

    /**
     *
     * rotate Image
     *
     * @param path
     * @param uri
     * @param degrees
     * @param context
     */

    public static void rotate(String path, Uri uri, int degrees, Context context) {
        Bitmap b = null;
        InputStream inputStream;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTempStorage = new byte[16 * 1024];
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory
                    .decodeStream(new FileInputStream(path), null, options);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        int IMAGE_MAX_SIZE = 700;
        int scale = 1;
        if (options.outHeight > IMAGE_MAX_SIZE
                || options.outWidth > IMAGE_MAX_SIZE) {
            scale = (int) Math.pow(
                    2,
                    (int) Math.round(Math.log(IMAGE_MAX_SIZE
                            / (double) Math.max(options.outHeight,
                            options.outWidth))
                            / Math.log(0.5)));
        }
        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        o2.inPurgeable = true;
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        o2.outHeight = display.getHeight();
        o2.outWidth = display.getWidth();
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            b = BitmapFactory.decodeStream(inputStream, null, o2);
            inputStream.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (degrees != 0 && b != null) {
            Matrix m = new Matrix();

            m.setRotate(degrees, (float) b.getWidth() / 2,
                    (float) b.getHeight() / 2);
            try {
                Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(),
                        b.getHeight(), m, true);
                if (b != b2) {
                    b.recycle();
                    b = b2;
                }
            } catch (OutOfMemoryError ex) {
                throw ex;
            }
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        if (file.exists()) {

        } else {
            try {
                file.createNewFile();
                FileOutputStream stream = new FileOutputStream(file.getPath());
                b.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                stream.flush();
                stream.close();
                b.recycle();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    /**
     *
     * copy file from one directory to another
     *
     * @param input
     * @param output
     * @throws IOException
     */
    public static void copyStream(InputStream input, OutputStream output)
            throws IOException {

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
    }

    public static byte[] getPNGByteArray(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //You can set quality between 0 ~ 100(0 : min, 100 : max)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    public static ProgressDialog openNewDialog(Context context, String msg, boolean cancelable, boolean outsideTouchCancelable) {
        ProgressDialog dialog = null;
        try {
            dialog = new ProgressDialog(context);

            dialog.setMessage(msg);
            dialog.setIndeterminate(true);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(cancelable);
            dialog.setCanceledOnTouchOutside(outsideTouchCancelable);
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dialog;
    }

    public boolean isOnline() {
        ConnectivityManager conManager  = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo         = conManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public static int indexOf(String name, ArrayList<String> mList) {

        int index = -1;
        if (mList == null) return index;

        for (int i=0; i<mList.size(); i++) {
            if (mList.get(i).equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        return index;
    }
}
