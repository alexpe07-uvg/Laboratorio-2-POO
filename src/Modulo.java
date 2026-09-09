public class Modulo {
    private int IDModule;
    private String nameModule;
    private TipoModulo type;
    private float energyConsumption;
    private EstadoModulo state;



    public Modulo(int IDModule, String nameModule, TipoModulo type, float energyConsumption, EstadoModulo state) {
        this.IDModule = IDModule;
        this.nameModule = nameModule;
        this.type = type;
        setEnergyConsumption(energyConsumption); // Llamada al setter para validar el consumo de energía
        this.state = state;
    }

    // Getters y setters para cada módulo ingresado al arreglo
    public int getIDModule() {
        return IDModule;
    }


    public String getNameModule() {
        return nameModule;
    }

    
    public TipoModulo getType() {
        return type;
    }


    public float getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(float energyConsumption) {
       if (energyConsumption <= 0 ) {
            throw new IllegalArgumentException("Valor de consumo de energía no válido.");
       }
       this.energyConsumption = energyConsumption;

    }

    public EstadoModulo getState() {
        return state;
    }

    public void setState(EstadoModulo state) {
        this.state = state;
    }

    @Override
public String toString() {
    return "ID: " + IDModule + 
           " | Nombre: " + nameModule + 
           " | Tipo: " + type + 
           " | Consumo: " + energyConsumption + " kW" + 
           " | Estado: " + state;
}

}
