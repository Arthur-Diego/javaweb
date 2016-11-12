package clienteservlet;

public class Cliente {

	
	private String email;

	public String getEmail() {
		if(email == null){
			email = ""; 
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
