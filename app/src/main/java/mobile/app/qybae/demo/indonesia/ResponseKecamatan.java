package mobile.app.qybae.demo.indonesia;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseKecamatan{

	@SerializedName("success")
	private boolean success;

	@SerializedName("kecamatan")
	private List<KecamatanItem> kecamatan;

	@SerializedName("message")
	private String message;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setKecamatan(List<KecamatanItem> kecamatan){
		this.kecamatan = kecamatan;
	}

	public List<KecamatanItem> getKecamatan(){
		return kecamatan;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseKecamatan{" + 
			"success = '" + success + '\'' + 
			",kecamatan = '" + kecamatan + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}