package mobile.app.qybae.demo.helper;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobile.app.qybae.demo.R;

/**
 * Created by marif_s.i on 13/01/2018.
 */

public class dataBuah implements Parcelable {

    private int imagebuah;
    private int suarabuah;
    private String namabuah;

//pake parcelable buat ngirim ke activity lainnya

     @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.imagebuah);
        dest.writeInt(this.suarabuah);
        dest.writeString(this.namabuah);
    }

    public dataBuah() {
    }

    public dataBuah(int imagebuah, int suarabuah, String namabuah) {
        this.imagebuah = imagebuah;
        this.suarabuah = suarabuah;
        this.namabuah = namabuah;
    }

    protected dataBuah(Parcel in) {
        this.imagebuah = in.readInt();
        this.suarabuah = in.readInt();

        this.namabuah = in.readString();
    }

    public static final Parcelable.Creator<dataBuah> CREATOR = new Parcelable.Creator<dataBuah>() {
        @Override
        public dataBuah createFromParcel(Parcel source) {
            return new dataBuah(source);
        }

        @Override
        public dataBuah[] newArray(int size) {
            return new dataBuah[size];
        }
    };

}





