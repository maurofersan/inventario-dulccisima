package com.dulccisima.inventario.util;

public class Validator {
	private Validator() {
		super();
	}

	/**
	 * Valida que la cadena pasada por parametro sea un email valido.
	 * 
	 * <br>
	 * + : Una o mas veces <br>
	 * * : 0 o mas veces <br>
	 * ? : 0 o 1 vez
	 * 
	 * @param mail
	 * @return true si el email es valido, caso contratio false
	 */
	public static boolean isMailValido(String mail) {
		/*boolean tienePunto = mail.contains("."); boolean tieneArroba =
		mail.contains("@"); return tieneArroba && tienePunto;*/
		return mail.matches("[_0-9a-zA-Z\\.\\-]+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+");
	}

	public static boolean isValidDecimal(String cadenaDecimal) {
		return cadenaDecimal.matches("\\d+\\.?\\d+"); // Expresion regular
	}

	public static boolean isValidInteger(String cadenaEntero) {
		return cadenaEntero.matches("\\d+"); // Expresion regular
	}

}
