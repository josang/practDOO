package mastermind.controllers;

public enum Error {

    INVALID_CODE("El código introducido no cumple los requisitos especificados");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
