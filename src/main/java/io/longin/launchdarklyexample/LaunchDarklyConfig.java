package io.longin.launchdarklyexample;

import com.launchdarkly.sdk.server.LDClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchDarklyConfig {
    @Value("${launchdarkly.sdkKey}")
    private String sdkKey;

    @Bean
    public LDClient ldClient() {
        return new LDClient(sdkKey);
    }
}