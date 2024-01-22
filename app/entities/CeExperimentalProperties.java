package entities;

public class CeExperimentalProperties {
    private int ceExpPropId;
    private int buffer;
    private int temperature;
    private int ionizationMode;
    private int polarity;
    private String created;
    private String lastUpdated;


    public CeExperimentalProperties() {
        this.ceExpPropId = 0;
        this.buffer = 0;
        this.temperature = 0;
        this.ionizationMode = 0;
        this.polarity = 0;
        this.created = "";
        this.lastUpdated = "";
    }


    public CeExperimentalProperties(int ceExpPropId, int buffer, int temperature, int ionizationMode, int polarity, String created, String lastUpdated) {
        this.ceExpPropId = ceExpPropId;
        this.buffer = buffer;
        this.temperature = temperature;
        this.ionizationMode = ionizationMode;
        this.polarity = polarity;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    // Getters and setters
    public int getCeExpPropId() { return ceExpPropId; }
    public void setCeExpPropId(int ceExpPropId) { this.ceExpPropId = ceExpPropId; }
    public int getBuffer() { return buffer; }
    public void setBuffer(int buffer) { this.buffer = buffer; }
    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }
    public int getIonizationMode() { return ionizationMode; }
    public void setIonizationMode(int ionizationMode) { this.ionizationMode = ionizationMode; }
    public int getPolarity() { return polarity; }
    public void setPolarity(int polarity) { this.polarity = polarity; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }
    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }

    // toString method
    @Override
    public String toString() {
        return "CeExperimentalProperties{" +
                "ceExpPropId=" + ceExpPropId +
                ", buffer=" + buffer +
                ", temperature=" + temperature +
                ", ionizationMode=" + ionizationMode +
                ", polarity=" + polarity +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
