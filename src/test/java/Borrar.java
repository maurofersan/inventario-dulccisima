import java.util.Scanner;

public class Borrar {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int resultado[];
		System.out.println("Ingrese cantidad de digitos: ");
		final int DIGITOS = entrada.nextInt();
		resultado = new int[DIGITOS];
		System.out.println("Ingrese un numero: ");

		int numero = entrada.nextInt();

		for (int i = 0; i < DIGITOS; i++) {
			resultado[i] = (int) (numero / Math.pow(10, i)) % 10;
		}

		entrada.close();

		for (int value : resultado) {
			System.out.println(value);
		}

	}
}
