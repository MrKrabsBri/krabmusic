package com.krabs.krabmusic.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features") //from spring actuator
public class FeatureEndpoint {

    private final Map<String,Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndpoint() {
        featureMap.put("Song", new Feature(true));
        featureMap.put("Album", new Feature(false));
        featureMap.put("Playlist", new Feature(false));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    @ReadOperation // exposina sita method kaip HTTP "GET" operation
    public Map<String, Feature> features(){
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName){// returns a feature based on its name
        //feature("User").isEnabled = true; // mano pvz kaip turbut keisis isEnabled values
        return featureMap.get(featureName);
    }

    @Data //getters setters
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {

        private boolean isEnabled;
    }
}
