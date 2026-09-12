import java.util.InputMismatchException;
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
        Nave nave = null;
        boolean salir = false;

        
     
        while (!salir) {
            try {
           
            printMenu();
            System.out.println("Ingrese una opción: ");
            int option = sc.nextInt();
            
            sc.nextLine(); // Limpiar el buffer
            
            // verificación de que se haya creado una nave antes de pasar a las opciones (2-12)
            if (option >= 2 && option <= 12 && nave == null) {
                System.out.println("Primero debe crear una nave antes de pasar a las opciones (2-12).");
                continue;
            }

            switch (option) {
                case 1:
                    // Lógica para crear una nueva nave
                    System.out.println("\n==========CREACIÓN DE NUEVA NAVE=========\n");
                    System.out.println("\nIngrese el nombre de la nave:");
                    String nameShip = sc.nextLine();

                    System.out.print("\nID de la nave: ");
                    int idShip = sc.nextInt();
                    sc.nextLine();

                    System.out.print("\nNombre del comandante: ");
                    String commandant = sc.nextLine();

                    // se instancia una nueva nave
                    nave = new Nave(nameShip, idShip, commandant);

                    System.out.println("\nLa nave " + nameShip + " ha sido creada con éxito.\n");

                    break;


                case 2:
                    //Lógica para instalar un módulo
                
                        try {
                           
                            System.out.println("\n==========INSTALACIÓN DE MÓDULO=========\n");
                            System.out.println("¿En que posición le gustaría instalar el módulo? (0-4):");
                            int position = sc.nextInt();
                            sc.nextLine(); 

                            System.out.print("\nID del módulo a instalar: ");
                            int idMod = sc.nextInt();
                            sc.nextLine();

                            System.out.print("\nNombre del módulo a instalar: ");
                            String nameMod = sc.nextLine();

                            System.out.println("\nTipos disponibles:");
                            System.out.println("1. Observacion | 2.Ataque | 3. Defensa | 4.PotenciadorDeEnergía | 5.Laboratorio | 6. Localizacion | 7. GeneradorDeEnergía");
                            System.out.print("Seleccione tipo (1-7): ");
                            int tipoMod = sc.nextInt();

                            TipoModulo tipo;
                            switch (tipoMod) {
                                case 1: tipo = TipoModulo.Observacion; break;
                                case 2: tipo = TipoModulo.Ataque; break;
                                case 3: tipo = TipoModulo.Defensa; break;
                                case 4: tipo = TipoModulo.PotenciadorDeEnergía; break;
                                case 5: tipo = TipoModulo.Laboratorio; break;
                                case 6: tipo = TipoModulo.Localizacion; break;
                                case 7: tipo = TipoModulo.GeneradorDeEnergía; break;
                                default: throw new IllegalArgumentException("Opción de tipo inválida.");
                            }

                    
                            //Selección del estado del módulo
                            System.out.println("\nEstados disponibles:");
                            System.out.println("1. EnTierra | 2. EnProcesoDeDespegue | 3. EnVuelo | 4. EnOrbita | 5. EnProcesoDeAterrizaje | 6. Aterrizado");
                            System.out.println("Seleccione estado (1-6): ");
                            int estadoMod = sc.nextInt();
                            sc.nextLine();

                            EstadoModulo estado;
                            switch (estadoMod) {
                                case 1: estado = EstadoModulo.EnTierra; break;
                                case 2: estado = EstadoModulo.EnProcesoDeDespegue; break;
                                case 3: estado = EstadoModulo.EnVuelo; break;
                                case 4: estado = EstadoModulo.EnOrbita; break;
                                case 5: estado = EstadoModulo.EnProcesoDeAterrizaje; break;
                                case 6: estado = EstadoModulo.Aterrizado; break;
                                default: throw new IllegalArgumentException("Opción de estado inválida.");
                            }

                            System.out.print("\nConsumo de energía del módulo (kW) > 0: ");
                            float energyConsumption = sc.nextFloat();

                            Modulo nuevoModulo = new Modulo(idMod, nameMod, tipo, energyConsumption, estado);
                            nave.addModulos(position, nuevoModulo);
                            System.out.println("\nMódulo instalado con éxito en la posición " + position + ".\n");

                        } catch(IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Entrada inválida. Por favor, ingrese un número válido de opcion.");
                            sc.nextLine(); // Limpiar el buffer
                        }finally {
                            System.out.println("Proceso intento de instalación de módulo cerrado.\n");
                        }
                        break;
                    

                case 3:
                    // Lógica para consultar módulos

                    System.out.println("\n=====MODULOS INSTALADOS HASTA AHORA EN LA NAVE=====\n");
                    System.out.println(nave.consultarTodosLosModulos());

                    break;
                
                    
                case 4:
                    // Lógica para consultar un módulo
                    System.out.println("\n==========CONSULTA DE MÓDULO POR POSICIÓN==========\n");
                    System.out.println("¿Qué posición del arreglo de modulos desea consultar? (0-4):"); 
                    int positionToConsult = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    Modulo moduloConsultado = nave.consultarModuloPorPosición(positionToConsult);
                    System.out.println("\nInformación del modulo en esta posición: " + moduloConsultado.toString());

                    break;


                case 5:
                    // Lógica para modificar un módulo
                    System.out.println("\n==========MODIFICACIÓN DE MÓDULO==========\n");
                    System.out.println("¿Qué posición del arreglo de módulos desea modificar? (0-4):");
                    int positionToModify = sc.nextInt();

                    System.out.println("\nEl módulo seleccionado es: " + nave.consultarModuloPorPosición(positionToModify).toString());
                    
                    // se piden datos a modificar
                    System.out.println("\n¿Cuál sería el nuevo consumo de energía del módulo (kW) > 0?");
                    float newEnergyConsumption = sc.nextFloat();

                    System.out.println("\nSelecciona un nuevo estado para el módulo:");
                    System.out.println("1. EnTierra | 2. EnProcesoDeDespegue | 3. EnVuelo | 4. EnOrbita | 5. EnProcesoDeAterrizaje | 6. Aterrizado");
                    int opNewEstado = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    EstadoModulo newEstadoEnum;
                    switch (opNewEstado) {
                        case 1: newEstadoEnum = EstadoModulo.EnTierra; break;
                        case 2: newEstadoEnum = EstadoModulo.EnProcesoDeDespegue; break;
                        case 3: newEstadoEnum = EstadoModulo.EnVuelo; break;
                        case 4: newEstadoEnum = EstadoModulo.EnOrbita; break;
                        case 5: newEstadoEnum = EstadoModulo.EnProcesoDeAterrizaje; break;
                        case 6: newEstadoEnum = EstadoModulo.Aterrizado; break;
                        default: throw new IllegalArgumentException("Opción de estado inválida.");
                    }

                    nave.modificarModulo(positionToModify, newEnergyConsumption, newEstadoEnum);
                    System.out.println("\nModificación realizada exitosamente!");

                    break;

                    
                case 6:
                    // Lógica para retirar un módulo
                    System.out.println("\n==========RETIRO DE MÓDULO==========\n");
                    System.out.println("¿Qué posición del arreglo de módulos desea retirar? (0-4):");
                    int positionToRemove = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    nave.removeModulos(positionToRemove); //vuleve a asignar el valor de la posición a null
                    System.out.println("\nMódulo retirado exitosamente!");

                    break;


                case 7:
                    // Lógica para registrar un planeta
                    System.out.println("\n==========REGISTRO DE PLANETA==========\n");
                    

                    System.out.println("ID del planeta a registrar: ");
                    int idPlaneta = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    System.out.println("\nNombre del planeta a registrar: ");
                    String nombrePlaneta = sc.nextLine();

                    System.out.println("\n¿A qué distancia se encuentra el planeta de la nave (>0) en millones de km?: ");
                    float distanciaPlaneta = sc.nextFloat();
                    sc.nextLine(); // Limpiar el buffer

                    System.out.println("\nTemperatura del planeta (°C): ");
                    float temperaturaPlaneta = sc.nextFloat();
                    sc.nextLine(); // Limpiar el buffer

                    System.out.println("\nNivel de habitabilidad del planeta (0-100): ");
                    float habitabilidadPlaneta = sc.nextFloat();
                    sc.nextLine(); // Limpiar el buffer

                    Planeta nuevoPlaneta = new Planeta(idPlaneta, nombrePlaneta, distanciaPlaneta, temperaturaPlaneta, habitabilidadPlaneta);
                    nave.addPlanetaDescubierto(nuevoPlaneta);
                    System.out.println("\nPlaneta registrado exitosamente!");

                    break;


                case 8:
                    // Lógica para consultar planetas

                    System.out.println("\n=====PLANETAS REGISTRADOS HASTA AHORA EN LA NAVE=====\n");
                    System.out.println(nave.consultarTodosLosPlanetas());

                    break;

                case 9:
                    // Lógica para buscar un planeta
                    System.out.println("\n==========BÚSQUEDA DE PLANETA POR CÓDIGO==========\n");

                    System.out.println("ID del planeta que quiere buscar: ");
                    int idPlanetaABuscar = sc.nextInt();
                    sc.nextLine();

                    Planeta planetaEncontrado = nave.buscarPlanetaPorID(idPlanetaABuscar);
                    if (planetaEncontrado!= null) {
                        System.out.println("\nInformación del planeta encontrado: " + planetaEncontrado.toString());
                    } else {
                        System.out.println("\nNo se encontro ningún planeta con el ID ingresado");
                    }
                    

                    break;


                case 10:
                    // Lógica para modificar un planeta
                    System.out.println("\n==========MODIFICACIÓN DE PLANETA==========\n");

                    System.out.println("ID del planeta que se desea modificar: ");
                    int idPlanetaAModificar = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    Planeta planetaAModificar = nave.buscarPlanetaPorID(idPlanetaAModificar);
                    if (planetaAModificar == null) {
                        System.out.println("\nNo se encontró ningún planeta con el ID ingresado.");
                        break;
                    }

                    System.out.println("\nEl planeta seleccionado es: " + planetaAModificar.toString());

                    System.out.println("\nID nuevo del planeta: ");
                    int nuevoIDPlaneta = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    System.out.println("\nNombre nuevo del planeta: ");
                    String nuevoNombrePlaneta = sc.nextLine();

                    System.out.println("\nDistancia nueva del planeta (>0) en millones de km: ");
                    float nuevaDistanciaPlaneta = sc.nextFloat();
                    sc.nextLine();

                    System.out.println("\nTemperatura nueva del planeta (°C): ");
                    float nuevaTemperaturaPlaneta = sc.nextFloat();
                    sc.nextLine(); // Limpiar el buffer

                    System.out.println("\nNivel de habitabilidad nuevo del planeta (0-100): ");
                    float nuevoNivelHabitabilidadPlaneta = sc.nextFloat();
                    sc.nextLine();

                    nave.modificarPlaneta(nuevoIDPlaneta,nuevoNombrePlaneta, nuevaDistanciaPlaneta, nuevaTemperaturaPlaneta, nuevoNivelHabitabilidadPlaneta);
                    System.out.println("\nPlaneta modificado exitosamente!");

                    break;


                case 11:
                    // Lógica para eliminar un planeta

                    System.out.println("\n==========ELIMINACIÓN DE PLANETA==========\n");

                    System.out.println("ID del planeta que desea eliminar: ");
                    int idPlanetaAEliminar = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    nave.removePlaneta(idPlanetaAEliminar);
                    System.out.println("\nPlaneta eliminado exitosamente!");

                    break;


                case 12:
                    // Lógica para mostrar reporte de misión
                    System.out.println("\n==========REPORTE DE MISION==========\n");
                    System.out.println(nave.generarEstadisticasDeLaMision());

                    break;


                case 13:
                    // Lógica para salir del sistema
                    salir = true;
                    System.out.println("Saliendo del sistema de exploración espacial. Misión finalizada. ¡Hasta luego!");
                    return; // Salir del programa

                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 13.");
                    

            }
            
            //Bloque que permite imprimir todas las excepciones que se pueden generar en el programa con el fin de que no caiga el sistema
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número válido del 1 al 13.");
                sc.nextLine(); // Limpiar el buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            } 
            
        } 

        sc.close(); // Cerrar el scanner al final del programa
    } 
}


