
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int vida = 15;
        int experiencia = 0;
        boolean veneno = false;


        System.out.println("Bienvenido Aventurero");

        do {
            System.out.println("Presiona Enter para lanzar el dado");
            scanner.nextLine();
            int dado = random.nextInt(12) + 1;

            System.out.println("Has sacado un " + dado);


            switch (dado) {
                case 1, 2 -> {
                    vida += 1;
                    System.out.println("Encuentras una fuente de vida, +1 punto de vida. Vida actual: " + vida);
                }
                case 3, 4, 5 -> {
                    vida -= 5;
                    System.out.println("Eres atacado brutalmente, -5 puntos de vida. Vida actual: " + vida);
                }
                case 6, 7 -> {
                    experiencia += 3;
                    System.out.println("Ganas experiencia en la aventura, +3 puntos de experiencia, experiencia actual: " + experiencia);
                }
                case 8, 9 -> {
                    experiencia -= 6;
                    System.out.println("Cometes un error grave, -6 puntos de experiencia, experiencia actual: " + experiencia);
                }
                case 10, 11 -> {
                    vida -= 8;
                    System.out.println("Caes en una trampa letal, -8 puntos de vida. Vida actual: " + vida);
                }
                case 12 -> {
                    int evento = random.nextInt(3) + 1;
                    switch (evento) {
                        case 1 -> {
                            experiencia += 10;
                            System.out.println("Encuentras un pergamino antiguo, +10 puntos de experiencia, xperiencia actual: " + experiencia);
                        }
                        case 2 -> {
                            veneno = true;
                            System.out.println("Te infectas con veneno, perderás -2 puntos de vida por turno");
                            if (veneno) {
                                vida -= 2;
                                System.out.println("El veneno te afecta, pierdes 2 puntos de vida, vida actual: " + vida);
                            }
                        }
                        case 3 -> {
                            vida /= 2;
                            System.out.println("Un demonio te ataca, tu vida se reduce a la mitad, vida actual: " + vida);
                        }
                    }
                }
            }



        } while (vida > 0 && experiencia < 50);

        if (vida <= 0) {
            System.out.println("Has muerto, fin del juego");
        } else {
            System.out.println("Has alcanzado 50 puntos de experiencia ");
        }

        scanner.close();
    }
}












