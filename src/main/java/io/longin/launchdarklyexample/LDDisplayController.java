package io.longin.launchdarklyexample;


import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LDDisplayController {

    private final LDClient ldClient;

    public LDDisplayController(LDClient ldClient) {
        this.ldClient = ldClient;
    }

    @GetMapping("/feature")
    public String getFeatureStatus() {
        LDUser user = new LDUser("");

        boolean featureEnabled = ldClient.boolVariation("LDExampleFlag", user, false);

        if (featureEnabled) {
            return "New feature is enabled!";
        } else {
            return "New feature is disabled.";
        }
    }
}
