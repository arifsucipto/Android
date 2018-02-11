package mobile.app.qybae.demo.PojoStudents;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseStudents{

	@SerializedName("success")
	private boolean success;

	@SerializedName("students")
	private List<StudentsItem> students;

	@SerializedName("message")
	private String message;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setStudents(List<StudentsItem> students){
		this.students = students;
	}

	public List<StudentsItem> getStudents(){
		return students;
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
			"ResponseStudents{" + 
			"success = '" + success + '\'' + 
			",students = '" + students + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}