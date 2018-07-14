package com.fitness.fitrova.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.RelativeLayout;
import com.fitness.fitrova.R;
import com.fitness.fitrova.model.Config;
import com.fitness.fitrova.utils.Utils;
import com.toxsl.volley.Request;
import com.toxsl.volley.VolleyError;
import com.toxsl.volley.toolbox.SyncEventListner;
import org.json.JSONObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import simplecropimage.CropImage;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.fitness.fitrova.model.Config.CROP_IMAGE;
import static com.fitness.fitrova.model.Config.IMAGE_CAMERA;
import static com.fitness.fitrova.model.Config.IMAGE_GALLERY;

public class FTRegisterActivity extends FTBaseActivity implements SyncEventListner {

    private CircleImageView ivProfile;
    private AppCompatEditText etEmail;
    private AppCompatEditText etName;
    private AppCompatEditText etPassword;
    private AppCompatEditText etConfirm;

    private RelativeLayout rlRegister, rlLogin;

    public static FTRegisterActivity self;

    private Uri mUri;
    private String mImagePath;
    private boolean bShowPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftregister);

        self = this;
        init();
    }

    private void init(){

        ivProfile = (CircleImageView)findViewById(R.id.ivProfile);
        etEmail = (AppCompatEditText)findViewById(R.id.etEmail);
        etName = (AppCompatEditText)findViewById(R.id.etName);
        etPassword = (AppCompatEditText)findViewById(R.id.etPassword);
        etConfirm = (AppCompatEditText)findViewById(R.id.etConfirm);

        rlRegister = (RelativeLayout)findViewById(R.id.rlRegister);

        rlRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), FTWalletActivity.class);
                startActivity(i);
                self.finish();
            }
        });

        rlLogin = (RelativeLayout)findViewById(R.id.rlLogin);

        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i = new Intent(getBaseContext(), FTLoginActivity.class);
//                startActivity(i);
                self.finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_CAMERA && resultCode == Activity.RESULT_OK) {

            String path = mUri.getPath();
            try {
                int drigree_ = Utils.getImageOrientation(path);
                Utils.rotate(path, mUri, drigree_, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            startCropImage();

        }  else if (requestCode == IMAGE_GALLERY && resultCode == Activity.RESULT_OK) {

            try {

                ContentResolver mResolver = this.getContentResolver();
                InputStream inputStream = mResolver.openInputStream(data.getData());

                FileOutputStream fileOutputStream = new FileOutputStream(mUri.getPath());
                Utils.copyStream(inputStream, fileOutputStream);

                fileOutputStream.close();
                inputStream.close();

                startCropImage();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (requestCode == CROP_IMAGE && resultCode == Activity.RESULT_OK) {

            mImagePath = data.getStringExtra(CropImage.IMAGE_PATH);

            if (mImagePath == null) {
                return;
            }

            File imageFile = new File(mImagePath);
            if (imageFile.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                ivProfile.setImageBitmap(bitmap);
            }
        }
    }

    public void onProfileClicked(View V) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.choose_image));
        builder.setItems(new CharSequence[]{getString(R.string.gallery), getString(R.string.camera)}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                createPath();

                switch (which) {
                    case 0:
                        selectGalleryImage();
                        break;
                    case 1:
                        captureCameraImage();
                        break;
                }
            }
        });
        builder.show();
    }

    public void onRegisterClicked(View V) {

    }

    private void createPath(){

        File main_directory = new File(Environment.getExternalStorageDirectory() + Config.IMAGE_DIRECTORY );
        if (!main_directory.exists()) {
            main_directory.mkdirs();

        }

        File file = new File(main_directory.getAbsoluteFile() + "/profile.png");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mUri = Uri.fromFile(file);
    }

    private void selectGalleryImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_GALLERY);
    }

    private void captureCameraImage() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, IMAGE_CAMERA);
    }

    private void startCropImage() {

        Intent intent = new Intent(this, CropImage.class);
        intent.putExtra(CropImage.IMAGE_PATH, mUri.getPath());
        intent.putExtra(CropImage.SCALE, true);

        intent.putExtra(CropImage.ASPECT_X, 1);
        intent.putExtra(CropImage.ASPECT_Y, 1);

        startActivityForResult(intent, CROP_IMAGE);
    }

    @Override
    public void onSyncStart() {
        showProgress(getString(R.string.wait_message));
    }

    @Override
    public void onSyncFinish() {
        dismissProgress();
    }

    @Override
    public void onSyncFailure(VolleyError error, Request mRequest) {
        showToast(getString(R.string.failed));

    }

    @Override
    public void onSyncSuccess(String controller, String action, boolean status, JSONObject jsonObject) {
        System.out.println(jsonObject);
    }
}
