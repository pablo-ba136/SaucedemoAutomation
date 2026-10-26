package utils;

public class Config {
	// URL de la web que estamos probando
	public static final String URL = "https://www.saucedemo.com";
	// Credenciales válidas de usuario
	public static final String VALID_USER = "standard_user";
	public static final String VALID_PASSWORD = "secret_sauce";
	// Campos a rellenar del chekout
	public static final String FIRST_NAME = "Nombre";
	public static final String LAST_NAME = "Apellido";
	public static final String POSTAL_CODE = "12345";
	// Tiempo máximo de espera dinámica antes de lanzar un error
	public static final long DEFAULT_TIMEOUT = 10;
}
