import java.util.ArrayList;
import java.util.List;

public class Nave {
    private String nameShip;
    private int IDShip;
    private String nameCommandant;
    private Modulo [] modulos;
    private List <Planeta> planetasADescubrir;


    public Nave(String nameShip, int IDShip, String nameCommandant) {
        this.nameShip = nameShip;
        this.IDShip = IDShip;
        this.nameCommandant = nameCommandant;
        this.modulos = new Modulo [5]; // arreglo de módulos con tamaño fijo de 5
        this.planetasADescubrir = new ArrayList <> (); //lista dinámica para almacenar planetas a descubrir
    }


    //getters para cada dato de la nave
    public String getNameShip() {
        return nameShip;
    }


    public int getIDShip() {
        return IDShip;
    }


    public String getNameCommandant() {
        return nameCommandant;
    }


    public Modulo [] getModulos() {
        return modulos;
    }


    public List <Planeta> getPlanetasADescubrir() {
        return planetasADescubrir;
    }


    // MÉTODO PARA INSERTAR NUEVOS MÓDULOS EN LA NAVE
    public void addModulos (int index, Modulo modulo) {
        //verificación de límites del rango de arreglo de módulos de la nave
        if (index < 0 || index >= modulos.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } 

        // verificación de que la posición este vacía para poder agregar un nuevo módulo
        if (modulos[index] != null) {
          throw new IllegalStateException("Este modulo ya se encuentra ocupado.");
        }

        // verificación de que el modulo a instalar posea info válida
        if (modulo == null) {
            throw new IllegalArgumentException("El módulo a instalar no puede ser nulo.");
        }

        // si pasa todas las verificaciones, se agrega el módulo al arreglo de módulos de la nave
        modulos[index] = modulo;
    }

    // MÉTODO PARA ELIMINAR MÓDULOS DE LA NAVE
    public void removeModulos (int index) {
        // verificación de límites del rango de arreglo de módulos de la nave
        if (index < 0 || index >= modulos.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // verificación de que la posición del módulo a eliminar no esté vacía
        if (modulos[index] == null) {
            throw new IllegalStateException("No hay módulo instalado en esta posición.");
        }

        modulos[index] = null; // se elimina el módulo de la nave al pasar verificaciones asignandole null
    }

    //MÉTODO PARA IMPRIMIR TODOS LOS MÓDULOS DE LA NAVE QUE NO INCLUYAN NULL
    public String consultarTodosLosModulos() {
        StringBuilder result = new StringBuilder();
        boolean hayModulos = false;

        // recorre todo el arreglo buscando que no haya posiciones vacías
        for (Modulo modulo : modulos) {
            if (modulo != null) {
                hayModulos = true;
                result.append(modulo.toString()).append("\n"); // imprime la info de cada módulo que no sea null
                
            }
        }
        if (!hayModulos) {
                result.append("No hay módulos instalados en la nave aún."); // imprime mensaje si todas las posiciones son null aún
            }
            
        return result.toString();

    }

    // MÉTODO PARA CONSULTAR UN MÓDULO POR POSICIÓN
    public Modulo consultarModuloPorPosición(int index) {
        // validación posición no válida
        if (index <0 || index >= modulos.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");

        }

        // validación posición vacía
        if (modulos[index] == null) {
            throw new IllegalStateException("No hay módulo instalado en esta posición.");
        }

        return modulos[index];
       
    }

    // MÉTODO PARA MODIFICAR ESTADO O CONSUMO DE ENERGÍA DE UN MÓDULO
public void modificarModulo(int index, float EnergyConsumption, EstadoModulo state) {
    // verificación de límites
    if (index < 0 || index >= modulos.length) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    // verificación modificación con null
    if (modulos[index] == null) {
        throw new IllegalStateException("No hay módulo instalado en esta posición.");
    }

    // verificación que el nuevo consumo no sea menor o igual a 0 en setter en clase Modulo
    
    modulos[index].setEnergyConsumption(EnergyConsumption);
    modulos[index].setState(state);

}


// MÉTODO PARA BUSCAR UN PLANETA POR ID
public Planeta buscarPlanetaPorID(int IDPlanet) {
    

    for (Planeta planeta : planetasADescubrir) {
        if (planeta.getIDPlanet() == IDPlanet) {// si se encuentra un planeta con el ID ingresado, se imprime su info
            return planeta;
        } 
        
    }
    return null; // si no se encuentra un planeta con el ID ingresado, se retorna null
}

    //MÉTODO PARA AGREGAR PLANETAS A DESCUBRIR A LA NAVE
public void addPlanetaDescubierto (Planeta nuevoPlaneta) {
    if (nuevoPlaneta == null) {
        throw new IllegalArgumentException("El planeta a agregar no puede ser nulo.");
    }

    // verificar si ya existe un planeta con el mismo ID
    if (buscarPlanetaPorID(nuevoPlaneta.getIDPlanet()) != null) {
        throw new IllegalStateException("Ya existe un planeta con el mismo ID.");
    }

    planetasADescubrir.add(nuevoPlaneta);
}

// MÉTODO PARA CONSULTAR TODOS LOS PLANETAS REGISTRADOS EN LA NAVE
public String consultarTodosLosPlanetas() {
    StringBuilder result = new StringBuilder();
    boolean hayPlanetas = false;

    for (Planeta planeta : planetasADescubrir) {
        if (planeta != null) {
            hayPlanetas = true;
            result.append(planeta.toString()).append("\n");
        }
    }

    // si no se encuentran planetas, se imprime el mensaje:
    if (!hayPlanetas) {
        result.append("No hay planetas registrados en la nave aún.");
    }

    return result.toString();
}
 
// MÉTODO PARA MODIFICAR UN PLANETA POR ID
public void modificarPlaneta (int IDPlanet, String newNamePlanet, float newDistance, float newTemperature, float newHabitability) {
    Planeta planeta = buscarPlanetaPorID(IDPlanet);
    if (planeta == null) {
        throw new IllegalArgumentException("El planeta no fue encontrado por lo que no se puede modificar.");
    }

    // los setters ejecutan las mismas validaciones que se hicieron al crear el planeta, por lo que no es necesario repetirlas aquí
    planeta.setDistanceFromShip(newDistance);
    planeta.setHabitabilityLevel(newHabitability);
    
}

// MÉTODO PARA ELIMINAR UN PLANETA POR ID
public void removePlaneta (int IDPlanet) {
    Planeta planeta = buscarPlanetaPorID(IDPlanet);
    if (planeta == null) {
        throw new IllegalArgumentException("El planeta no fue encontrado por lo que no se puede eliminar.");
    }

    planetasADescubrir.remove(planeta);

}

// MÉTODO PARA OBTENER ESTADÍSTICAS DE LA MISIÓN
public String generarEstadisticasDeLaMision() {
    StringBuilder result = new StringBuilder();
    result.append("=====Estadísticas de la misión:=====\n");

    // Cálculos módulos
    int modulosInstalados = 0;
    Modulo moduloMayorConsumo = null;

    for (Modulo modulo : modulos) {
        if (modulo != null) {
            modulosInstalados++; // comienza a incrementar el contador de módulos instalados

            // actualiza al modulo con mayor consumo de energía
            if (moduloMayorConsumo == null || modulo.getEnergyConsumption() > moduloMayorConsumo.getEnergyConsumption()) {
                moduloMayorConsumo = modulo;
            }

        }
    }
    //a. Módulos instalados
    result.append("a. Módulos instalados: ").append(modulosInstalados).append("\n");

    //b. Espacios aún disponibles para módulos
    int espaciosDisponibles = modulos.length - modulosInstalados;
    result.append("b. Espacios aún disponibles para módulos: ").append(espaciosDisponibles).append("\n");

    //c. Módulo con mayor consumo de energía
    if (moduloMayorConsumo != null) {
        result.append("c. El módulo con mayor consumo de energía es:").append(moduloMayorConsumo.toString()).append("\n");
    }
    

    // Cálculos planetas

    //d. Cantidad planetas descubiertos sin importar si están vacíos o no
    result.append("d. Cantidad de planetas descubiertos: ").append(planetasADescubrir.size()).append("\n");

    // lista vacía, se evita hacer cálculos que requieran de elementos existentes
    if (planetasADescubrir.isEmpty()) {
        result.append("e Planetas con mayor nivel de habitabilidad: No aplica (no hay planetas registrados aún).\n");
        result.append("f. Planeta con menor habitabilidad: No aplica (no hay planetas registrados aún).\n");
        result.append("g. Promedio de nivel de habitabilidad: No aplica (no hay planetas registrados aún). \n");

    } else { // si no, se establecen variables de referencia para realizar los cálculos de habitabilidad y promedio
        Planeta planetaMayorHabitabilidad = planetasADescubrir.get(0);
        Planeta planetaMenorHabitabilidad = planetasADescubrir.get(0);
        float sumaHabitabilidad = 0;

        for (Planeta planeta : planetasADescubrir) {
                if (planeta.getHabitabilityLevel() > planetaMayorHabitabilidad.getHabitabilityLevel()) {
                    planetaMayorHabitabilidad = planeta;
                }

                if (planeta.getHabitabilityLevel() < planetaMenorHabitabilidad.getHabitabilityLevel()) {
                    planetaMenorHabitabilidad = planeta;
                }

                sumaHabitabilidad += planeta.getHabitabilityLevel();
            }

            float promedio = sumaHabitabilidad / planetasADescubrir.size();

            result.append("e. Planeta con mayor nivel de habitabilidad: ").append(planetaMayorHabitabilidad.toString()).append("\n");
            result.append("f. Planeta con menor nivel de habitabilidad: ").append(planetaMenorHabitabilidad.toString()).append("\n");
            result.append("g. Promedio de nivel de habitabilidad: ").append(promedio).append("\n");
        }

        return result.toString();

}

}





