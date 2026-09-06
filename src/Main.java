import java.util.Scanner;

// try - catch y finally en main
public class Main {

    //OPCIONES DEL MENU
    private static void printMenu() {
        System.out.println("Bienvenido al sistema para la misión de exploración en nuestra nave espacial! ¿Que gestión te gustaría realizar?");
        System.out.println("""
                ==========MENU PRINCIPAL==========
                1. Nueva nave
                2. Instalar módulo
                3. Consultar módulos
                4. Consultar un módulo
                5. Modificar módulo
                6. Retirar módulo
                7. Registrar planeta
                8. Consultar planetas
                9. Buscar planeta
                10. Modificar planeta
                11. Eliminar planeta
                12. Mostrar reporte de misión
                13. Salir
                ====================================
                """);
                
    }

    
    // EJECUCIÓN POR CADA OPCIÓN DEL MENU
    public static void main (String [] args) {

        //INSTANCIAS DE CLASES O DATOS QUE SERVIRÁN EN MÁS DE UNA OPCION DEL PROGRAMA
        Scanner sc = new Scanner(System.in);
    

        while (true) {
            printMenu();
            System.out.println("Ingrese una opción: ");
            int option = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    // Lógica para crear una nueva nave
                






                    break;
                case 2:
                    // Lógica para instalar un módulo
                    break;
                case 3:
                    // Lógica para consultar módulos
                    break;
                case 4:
                    // Lógica para consultar un módulo
                    break;
                case 5:
                    // Lógica para modificar un módulo
                    break;
                case 6:
                    // Lógica para retirar un módulo
                    break;
                case 7:
                    // Lógica para registrar un planeta
                    break;
                case 8:
                    // Lógica para consultar planetas
                    break;
                case 9:
                    // Lógica para buscar un planeta
                    break;
                case 10:
                    // Lógica para modificar un planeta
                    break;
                case 11:
                    // Lógica para eliminar un planeta
                    break;
                case 12:
                    // Lógica para mostrar reporte de misión
                    break;
                case 13:
                    // Lógica para salir del sistema
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    return; // Salir del programa
                    
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 13.");
            }
            sc.close();
                    System.exit(0);
        }
        

    }
}