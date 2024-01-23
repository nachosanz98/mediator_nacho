package entities;

public class CompoundChain {
    private int compoundId;
    private int chainId;
    private int numberChains;
    private String created;
    private String lastUpdated;

    public CompoundChain() {
        this.compoundId = 0;
        this.chainId = 0;
        this.numberChains = 0;
        this.created = "";
        this.lastUpdated = "";
    }

    public CompoundChain(int compoundId, int chainId, int numberChains, String created, String lastUpdated) {
        this.compoundId = compoundId;
        this.chainId = chainId;
        this.numberChains = numberChains;
        this.created = created;
        this.lastUpdated = lastUpdated;
    }

    public int getCompoundId() { return compoundId; }
    public void setCompoundId(int compoundId) { this.compoundId = compoundId; }
    public int getChainId() { return chainId; }
    public void setChainId(int chainId) { this.chainId = chainId; }
    public int getNumberChains() { return numberChains; }
    public void setNumberChains(int numberChains) { this.numberChains = numberChains; }
    public String getCreated() { return created; }
    public void setCreated(String created) { this.created = created; }
    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String lastUpdated) { this.lastUpdated = lastUpdated; }

    @Override
    public String toString() {
        return "CompoundChain{" +
                "compoundId=" + compoundId +
                ", chainId=" + chainId +
                ", numberChains=" + numberChains +
                ", created='" + created + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}

