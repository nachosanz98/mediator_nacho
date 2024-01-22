package entities;

public class ClassyfireClassificationDictionary {

    private int classyfireId;

    private String nodeId;
    private String kingdom;
    private String superClass;
    private String mainClass;
    private String subClass;
    private String directParent;
    private String level7;
    private String level8;
    private String level9;
    private String level10;
    private String level11;
    private String created;
    private String lastUpdated;
    private String nodeName;
    private String createdDictionary;
    private String lastUpdatedDictionary;

    public ClassyfireClassificationDictionary() {
        this.classyfireId = 0;
        this.nodeId = "";
        this.kingdom = "";
        this.superClass = "";
        this.mainClass = "";
        this.subClass = "";
        this.directParent = "";
        this.level7 = "";
        this.level8 = "";
        this.level9 = "";
        this.level10 = "";
        this.level11 = "";
        this.created = "";
        this.lastUpdated = "";
        this.nodeName = "";
        this.createdDictionary = "";
        this.lastUpdatedDictionary = "";
    }

    public ClassyfireClassificationDictionary(int classyfireId, String nodeId, String kingdom, String superClass, String mainClass,
                                              String subClass, String directParent, String level7, String level8, String level9,
                                              String level10, String level11, String created, String lastUpdated, String nodeName,
                                              String createdDictionary, String lastUpdatedDictionary) {
        this.classyfireId = classyfireId;
        this.nodeId = nodeId;
        this.kingdom = kingdom;
        this.superClass = superClass;
        this.mainClass = mainClass;
        this.subClass = subClass;
        this.directParent = directParent;
        this.level7 = level7;
        this.level8 = level8;
        this.level9 = level9;
        this.level10 = level10;
        this.level11 = level11;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.nodeName = nodeName;
        this.createdDictionary = createdDictionary;
        this.lastUpdatedDictionary = lastUpdatedDictionary;
    }


    public int getClassyfireId() {
        return classyfireId;
    }

    public void setClassyfireId(int classyfireId) {
        this.classyfireId = classyfireId;
    }
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getSuperClass() {
        return superClass;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }

    public String getDirectParent() {
        return directParent;
    }

    public void setDirectParent(String directParent) {
        this.directParent = directParent;
    }

    public String getLevel7() {
        return level7;
    }

    public void setLevel7(String level7) {
        this.level7 = level7;
    }

    public String getLevel8() {
        return level8;
    }

    public void setLevel8(String level8) {
        this.level8 = level8;
    }

    public String getLevel9() {
        return level9;
    }

    public void setLevel9(String level9) {
        this.level9 = level9;
    }

    public String getLevel10() {
        return level10;
    }

    public void setLevel10(String level10) {
        this.level10 = level10;
    }

    public String getLevel11() {
        return level11;
    }

    public void setLevel11(String level11) {
        this.level11 = level11;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getCreatedDictionary() {
        return createdDictionary;
    }

    public void setCreatedDictionary(String createdDictionary) {
        this.createdDictionary = createdDictionary;
    }

    public String getLastUpdatedDictionary() {
        return lastUpdatedDictionary;
    }

    public void setLastUpdatedDictionary(String lastUpdatedDictionary) {
        this.lastUpdatedDictionary = lastUpdatedDictionary;
    }

    @Override
    public String toString() {
        return "ClassyfireClassification{" +
                "nodeId='" + nodeId + '\'' +
                ", kingdom='" + kingdom + '\'' +
                ", superClass='" + superClass + '\'' +
                ", mainClass='" + mainClass + '\'' +
                ", subClass='" + subClass + '\'' +
                ", directParent='" + directParent + '\'' +
                ", level7='" + level7 + '\'' +
                ", level8='" + level8 + '\'' +
                ", level9='" + level9 + '\'' +
                ", level10='" + level10 + '\'' +
                ", level11='" + level11 + '\'' +
                ", created=" + created + '\'' +
                ", lastUpdated=" + lastUpdated + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", createdDictionary=" + createdDictionary + '\'' +
                ", lastUpdatedDictionary=" + lastUpdatedDictionary +
                '}';
    }
}
