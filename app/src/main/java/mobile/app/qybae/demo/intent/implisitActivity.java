package mobile.app.qybae.demo.intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mobile.app.qybae.demo.R;

public class implisitActivity extends AppCompatActivity {

    @BindView(R.id.btnCall)
    Button btnCall;
    @BindView(R.id.btncallfriend)
    Button btncallfriend;
    @BindView(R.id.btnweb)
    Button btnweb;
    @BindView(R.id.btnmap)
    Button btnmap;
    @BindView(R.id.btnCamera)
    Button btnCamera;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @BindView(R.id.imageview3)
    ImageView imageview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implisit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnCall)
    public void onBtnCallClicked() {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    @OnClick(R.id.btncallfriend)
    public void onBtncallfriendClicked() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:08131518898"));
        startActivity(intent);
    }

    @OnClick(R.id.btnweb)
    public void onBtnwebClicked() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://desaincasing.com"));
        startActivity(intent);
    }

    @OnClick(R.id.btnmap)
    public void onBtnmapClicked() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=kampung pulo makasar"));
        startActivity(intent);
    }

    @OnClick(R.id.btnCamera)
    public void onViewClicked() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageview3.setImageBitmap(imageBitmap);
        }
    }
}
