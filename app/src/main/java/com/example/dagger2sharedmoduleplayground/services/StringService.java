package com.example.dagger2sharedmoduleplayground.services;

import com.example.shared.BestStringProvider;

/** Gives you the best string. */
public class StringService {
    private final BestStringProvider bestStringProvider;

    public StringService(BestStringProvider bestStringProvider) {
        this.bestStringProvider = bestStringProvider;
    }

    public String getTheBestString() {
        return bestStringProvider.getTheBestString();
    }
}
