package txvin;

public class UserException extends RuntimeException {
String str  = null;
	public UserException(String str){
		super(str);
		this.str =str;
	}
	
	public String toString(){
		System.out.println(str);
		return str;
	}
	
}
