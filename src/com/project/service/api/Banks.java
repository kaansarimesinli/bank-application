package com.project.service.api;

public enum Banks {
    GARANTI("Garanti"),
    AKBANK("Akbank"),
    ZIRAAT("Ziraat"),
    QNB("QNB");

    private final String name;

    Banks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
