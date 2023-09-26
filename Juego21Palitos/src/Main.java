import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int palitosRestantes = 21;

        System.out.println("Bienvenido al juego de los 21 palitos.");
        System.out.println("En cada turno, puedes coger de 1 a 4 palitos.");

        while (palitosRestantes > 0) {
            int palitosUsuario = 0;
            int palitosConsola = 0;

            // Este es el turno del usuario
            do {
                System.out.print("Palitos restantes: ");
                for (int i = 0; i < palitosRestantes; i++) {
                    System.out.print("| ");
                }
                System.out.println();
                System.out.print("¿Cuántos palitos quieres tomar (1-4)? ");
                palitosUsuario = scanner.nextInt();
            } while (palitosUsuario < 1 || palitosUsuario > 4 || palitosUsuario > palitosRestantes);

            palitosRestantes -= palitosUsuario;

            // Este codigo verifica que el usuario ha perdido
            if (palitosRestantes == 0) {
                System.out.println("¡Has perdido!.");
                break;
            }

            // Turno de la consola, este codigo se asegura de que la consola pierde
            palitosConsola = 5 - palitosUsuario;
            palitosRestantes -= palitosConsola;

            System.out.println("La consola toma " + palitosConsola + " palito(s).");
        }

        scanner.close();
    }
}