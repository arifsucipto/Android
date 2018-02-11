package mobile.app.qybae.demo.PojoStudents;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentsItem implements Parcelable {

	@SerializedName("Alamat")
	private String alamat;

	@SerializedName("Nama")
	private String nama;

	@SerializedName("phone")
	private String phone;

	@SerializedName("Tanggal_Lahir")
	private String tanggalLahir;

	@SerializedName("id")
	private String id;

	@SerializedName("Umur")
	private String umur;

	@SerializedName("email")
	private String email;

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setTanggalLahir(String tanggalLahir){
		this.tanggalLahir = tanggalLahir;
	}

	public String getTanggalLahir(){
		return tanggalLahir;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUmur(String umur){
		this.umur = umur;
	}

	public String getUmur(){
		return umur;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"StudentsItem{" + 
			"alamat = '" + alamat + '\'' + 
			",nama = '" + nama + '\'' + 
			",phone = '" + phone + '\'' + 
			",tanggal_Lahir = '" + tanggalLahir + '\'' + 
			",id = '" + id + '\'' + 
			",umur = '" + umur + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.alamat);
		dest.writeString(this.nama);
		dest.writeString(this.phone);
		dest.writeString(this.tanggalLahir);
		dest.writeString(this.id);
		dest.writeString(this.umur);
		dest.writeString(this.email);
	}

	public StudentsItem() {
	}

	protected StudentsItem(Parcel in) {
		this.alamat = in.readString();
		this.nama = in.readString();
		this.phone = in.readString();
		this.tanggalLahir = in.readString();
		this.id = in.readString();
		this.umur = in.readString();
		this.email = in.readString();
	}

	public static final Parcelable.Creator<StudentsItem> CREATOR = new Parcelable.Creator<StudentsItem>() {
		@Override
		public StudentsItem createFromParcel(Parcel source) {
			return new StudentsItem(source);
		}

		@Override
		public StudentsItem[] newArray(int size) {
			return new StudentsItem[size];
		}
	};
}