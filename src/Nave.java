import java.util.List;
import java.util.ArrayList;

public class Nave {
    private String nameShip;
    private int IDShip;
    private String nameCommandant;
    private Modulo [] modulos;
    private List <Planeta> planetasADescubrir;


    public Nave(String nameShip, int IDShip, String nameCommandant, Modulo [] modulos, List <Planeta> planetasADescubrir) {
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
        if (index <= 0 || index > modulos.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } 

        // verificación de que la posición este vacía para poder agregar un nuevo módulo
        if (modulos[index] != null) {
          throw new IllegalStateException("Este modulo ya se encuentra ocupado.");
        }

        // verificación de que el modulo a instalar posea info válida
        if (modulos == null) {
            throw new IllegalArgumentException("El módulo a instalar no puede ser nulo.");
        }

        // si pasa todas las verificaciones, se agrega el módulo al arreglo de módulos de la nave
        modulos[index] = modulo;
    }

    // MÉTODO PARA ELIMINAR MÓDULOS DE LA NAVE
    public void removeModulos (int index) {
        // verificación de límites del rango de arreglo de módulos de la nave
        if (index <= 0 && index > modulos.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // verificación de que la posición del módulo a eliminar no esté vacía
        if (modulos[index] == null) {
            throw new IllegalStateException("No hay módulo instalado en esta posición.");
        }

        modulos[index] = null; // se elimina el módulo de la nave al pasar verificaciones asignandole null
    }
}
