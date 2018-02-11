package mobile.app.qybae.demo.indonesia;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseProvince{

	@SerializedName("provinces")
	private List<ProvincesItem> provinces;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setProvinces(List<ProvincesItem> provinces){
		this.provinces = provinces;
	}

	public List<ProvincesItem> getProvinces(){
		return provinces;
	}

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

	@Override
 	public String toString(){
		return 
			"ResponseProvince{" + 
			"provinces = '" + provinces + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}