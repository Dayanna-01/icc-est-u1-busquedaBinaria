//Dayanna Chacha
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        System.out.print("Ingrese cantidad de Personas del listado: ");
        int n = sc.nextInt();
        sc.nextLine();  

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese Persona " + (i + 1) + ":");
            System.out.print("    Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("    Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();  
            System.out.println();

            if (edad < 0) {
                System.out.println("Edad no válida. Intente nuevamente.");
                i--;
                continue;
            }

            personas.add(new Persona(nombre, edad));
        }

        Persona.ordenarPorEdad(personas);

        System.out.print("Ingrese el valor de la edad que desea buscar: ");
        int objetivo = sc.nextInt();

        int resultado = Persona.buscarPorEdad(personas, objetivo);

        System.out.println("\n--- RESULTADOS ---");
        if (resultado != -1) {
            System.out.println("La persona con la edad " + objetivo + " es: " + personas.get(resultado).getNombre());
        } else {
            System.out.println("No se encontró una persona con la edad ingresada " + objetivo);
        }
    }
}
