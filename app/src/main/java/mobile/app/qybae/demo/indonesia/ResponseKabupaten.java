package mobile.app.qybae.demo.indonesia;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseKabupaten{

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	@SerializedName("kabupaten")
	private List<KabupatenItem> kabupaten;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setKabupaten(List<KabupatenItem> kabupaten){
		this.kabupaten = kabupaten;
	}

	public List<KabupatenItem> getKabupaten(){
		return kabupaten;
	}

	@Override
 	public String toString(){
		return 
			"ResponseKabupaten{" + 
			"success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			",kabupaten = '" + kabupaten + '\'' + 
			"}";
		}
}