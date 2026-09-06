public class Modulo {
    private int IDModulo;
    private String nameModule;
    private TipoModulo type;
    private float energyConsumption;
    private EstadoModulo state;


    public Modulo(int IDModulo, String nameModule, TipoModulo type, float energyConsumption, EstadoModulo state) {
        this.IDModulo = IDModulo;
        this.nameModule = nameModule;
        this.type = type;
        this.energyConsumption = energyConsumption;
        this.state = state;
    }

    // Getters y setters para cada módulo ingresado al arreglo
    public int getIDModulo() {
        return IDModulo;
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

    }

    public EstadoModulo getState() {
        return state;
    }

    public void setState(EstadoModulo state) {
        this.state = state;
    }

}
