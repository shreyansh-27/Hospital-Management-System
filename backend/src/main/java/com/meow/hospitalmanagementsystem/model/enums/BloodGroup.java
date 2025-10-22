package com.meow.hospitalmanagementsystem.model.enums;

public enum BloodGroup {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-"),
    ;

    private final String s;

    BloodGroup(String s) {
        this.s = s;
    }

    public String getBloodGroup(){
        return s;
    }
}
