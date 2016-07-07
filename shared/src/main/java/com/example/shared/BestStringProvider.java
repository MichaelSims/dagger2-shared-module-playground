package com.example.shared;

import javax.inject.Inject;

public class BestStringProvider {

    private String bestString;

    @Inject
    public BestStringProvider(String bestString) {
        this.bestString = bestString;
    }

    public String getTheBestString() {
        return bestString;
    }
}
