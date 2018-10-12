package com.wei.cityinfo.model;

public class Type {
    private int id;
    private int typeSign;
    private String typeName;
    private String typeIntro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeSign() {
        return typeSign;
    }

    public void setTypeSign(int typeSign) {
        this.typeSign = typeSign;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeIntro() {
        return typeIntro;
    }

    public void setTypeIntro(String typeIntro) {
        this.typeIntro = typeIntro;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typeSign=" + typeSign +
                ", typeName='" + typeName + '\'' +
                ", typeIntro='" + typeIntro + '\'' +
                '}';
    }
}
