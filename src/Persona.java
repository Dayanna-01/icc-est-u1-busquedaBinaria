//Dayanna Chacha
import java.util.List;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }

    // Ordenar por edad usando burbuja
    public static void ordenarPorEdad(List<Persona> personas) {
        for (int i = 0; i < personas.size() - 1; i++) {
            for (int j = 0; j < personas.size() - i - 1; j++) {
                if (personas.get(j).getEdad() > personas.get(j + 1).getEdad()) {
                    Persona temp = personas.get(j);
                    personas.set(j, personas.get(j + 1));
                    personas.set(j + 1, temp);
                }
            }
        }
    }

    
    public static int buscarPorEdad(List<Persona> personas, int objetivo) {
        int bajo = 0;
        int alto = personas.size() - 1;

        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;
            int valorCentro = personas.get(centro).getEdad();

            // Mostrar subarreglo
            for (int i = bajo; i <= alto; i++) {
                System.out.print(personas.get(i).getEdad() + " | ");
            }

            System.out.printf("\nbajo=%d  alto=%d  centro=%d  valorCentro=%d", 
                              bajo, alto, centro, valorCentro);

            if (valorCentro == objetivo) {
                System.out.println("  --> ENCONTRADO");
                return centro;
            } else if (valorCentro < objetivo) {
                System.out.println("  --> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println("  --> IZQUIERDA");
                alto = centro - 1;
            }
        }

        return -1;
    }
}
