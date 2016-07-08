package com.example.dagger2sharedmoduleplayground.services;

import com.example.shared.BestStringProvider;
import com.example.shared.StringServiceApi;

/** Gives you the best string. */
public class StringService implements StringServiceApi {
    private final BestStringProvider bestStringProvider;

    public StringService(BestStringProvider bestStringProvider) {
        this.bestStringProvider = bestStringProvider;
    }

    @Override
    public String getTheBestString() {
        return bestStringProvider.getTheBestString();
    }
}
