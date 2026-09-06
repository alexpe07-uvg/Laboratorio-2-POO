public class Planeta {
    private int IDPlanet;
    private float distanceFromShip;
    private float temperature;
    private float habitabilityLevel;

    public Planeta(int IDPlanet, float distanceFromShip, float temperature, float habitabilityLevel) {
        this.IDPlanet = IDPlanet;
        this.distanceFromShip = distanceFromShip;
        this.temperature = temperature;
        this.habitabilityLevel = habitabilityLevel;
    }

    // Getters para cada dato del planeta
    public int getIDPlanet() {
        return IDPlanet;
    }

    public float getDistanceFromShip() {
        return distanceFromShip;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHabitabilityLevel() {
        return habitabilityLevel;
    }

    
}


