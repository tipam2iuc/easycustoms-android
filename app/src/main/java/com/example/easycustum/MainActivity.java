package com.example.easycustum;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
ImageView mImgshaligram;
ImageView mImageView_add;
static final int REQUEST_IMAGE_CAPTURE = 1;
static final int REQUEST_TAKE_PHOTO = 1;

    private static final int SELECT_PHOTO = 1;
    private static final int CAPTURE_PHOTO = 2;
    Bitmap thumbnail;

String currentPhotoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgshaligram= (ImageView) findViewById(R.id.Imgshaligram);
        mImageView_add=(ImageView) findViewById(R.id.imageView2);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            mImgshaligram.setEnabled(false);
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE  },SELECT_PHOTO);
        }else {
            mImgshaligram.setEnabled(true);
        }

        mImageView_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.imageView2:
                        new MaterialDialog.Builder(MainActivity.this)
                                .title("Set Your Image")
                                .items(R.array.uploadImages)
                                .itemsIds(R.array.itemsId)
                                .itemsCallback(new MaterialDialog.ListCallback() {
                                    @Override
                                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                                        switch (position){
                                            case 0:
                                                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                                                photoPickerIntent.setType("image/*");
                                                startActivityForResult(photoPickerIntent,SELECT_PHOTO);
                                                break;
                                            case 1:
                                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                                startActivityForResult(intent, CAPTURE_PHOTO);
                                                break;
                                            case 2:
                                                mImgshaligram.setImageResource(R.drawable.ic_account_circle_black_24dp);
                                                break;
                                        }
                                    }
                                })
                                .show();
                        break;

                }
                //dispatchTakePictureIntent();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECT_PHOTO){
            if (resultCode == RESULT_OK){
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectImage = BitmapFactory.decodeStream(imageStream);

                    //setProgressBar();

                    mImgshaligram.setImageBitmap(selectImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }else if (requestCode == CAPTURE_PHOTO){
            if (resultCode == RESULT_OK){
                onCaptureImageResult(data);
            }
        }
    }
//   private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Ensure that there's a camera activity to handle the intent
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            // Create the File where the photo should go
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                // Error occurred while creating the File
//
//            }
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(this,
//                        "com.example.android.fileprovider",
//                        photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
//            }
//        }
//        }
//
//
//
//    private File createImageFile() throws IOException {
//        // Create an image file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );
//
//        // Save a file: path for use with ACTION_VIEW intents
//        currentPhotoPath = image.getAbsolutePath();
//        return image;
//    }
//    //galerie
//    private void galleryAddPic() {
//        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        File f = new File(currentPhotoPath);
//        Uri contentUri = Uri.fromFile(f);
//        mediaScanIntent.setData(contentUri);
//        this.sendBroadcast(mediaScanIntent);
//    }
  /*  private void setPic() {
        // Get the dimensions of the View
        int targetW = mImgshaligram.getWidth();
        int targetH = mImgshaligram.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(currentPhotoPath, boptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, boptions);
        mImgshaligram.setImageBitmap(bitmap);
    }*/

    private void onCaptureImageResult(Intent data) {
        thumbnail = (Bitmap) data.getExtras().get("data");

        //setProgressBar();

        mImgshaligram.setMaxWidth(200);
        mImgshaligram.setImageBitmap(thumbnail);
    }

    public void addImageToDb(View view){
        mImgshaligram.setDrawingCacheEnabled(true);
        mImgshaligram.buildDrawingCache();
        Bitmap bitmap = mImgshaligram.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 200, baos);
        byte[] data = baos.toByteArray();
//        dbHelper.addToDb(data);
//        Toast.makeText(EditProfile.this, "Image Save successfull", Toast.LENGTH_SHORT).show();
    }
}
