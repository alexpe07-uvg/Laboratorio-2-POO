public class Planeta {
    private int IDPlanet;
    private String namePlanet;
    private float distanceFromShip;
    private float temperature;
    private float habitabilityLevel;

    public Planeta(int IDPlanet, String namePlanet, float distanceFromShip, float temperature, float habitabilityLevel) {
        this.IDPlanet = IDPlanet;
        this.namePlanet = namePlanet;
        setDistanceFromShip(distanceFromShip); // Llamada al setter para validar la distancia
        this.temperature = temperature;
        setHabitabilityLevel(habitabilityLevel); // Llamada al setter para validar el nivel de habitabilidad
    }

    // Getters para cada dato del planeta
    public String getNamePlanet() {
        return namePlanet;
    }

    public void setNamePlanet(String namePlanet) {
        this.namePlanet = namePlanet;
    }

    
    public int getIDPlanet() {
        return IDPlanet;
    }

    public void setIDPlanet(int IDPlanet) {
        this.IDPlanet = IDPlanet;
    }

    public float getDistanceFromShip() {
        return distanceFromShip;
    }

    public void setDistanceFromShip(float distanceFromShip) {
        if (distanceFromShip <= 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }
        this.distanceFromShip = distanceFromShip;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHabitabilityLevel() {
        return habitabilityLevel;
    }

    public void setHabitabilityLevel(float habitabilityLevel) {
        if (habitabilityLevel < 0 || habitabilityLevel > 100) {
            throw new IllegalArgumentException("El nivel de habitabilidad debe estar entre 0 y 100.");
        }
        this.habitabilityLevel = habitabilityLevel;
    }

    @Override
    public String toString() {
        return "ID Planeta: " + IDPlanet +
                " | Nombre: " + namePlanet +
               " | Distancia: " + distanceFromShip +
               " | Temperatura: " + temperature + " °C" +
               " | Habitabilidad: " + habitabilityLevel + "%";
    }

}


