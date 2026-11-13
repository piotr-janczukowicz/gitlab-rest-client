package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import java.util.List;
import java.util.Map;

public final class ServicedataCatalogFixtures {

    private ServicedataCatalogFixtures() {}

    public static GitLabServiceDataCreateIncrementUniqueUserPayload serviceDataCreateIncrementUniqueUserPayload() {
        return GitLabServiceDataCreateIncrementUniqueUserPayloadBuilder.builder()
                .event("i_quickactions_page")
                .build();
    }

    public static GitLabServiceDataCreateTrackEventPayload serviceDataCreateTrackEventPayload() {
        return GitLabServiceDataCreateTrackEventPayloadBuilder.builder()
                .events(List.of(Map.of("key", "value")))
                .build();
    }

    public static GitLabServiceDataIncrementCounterPayload serviceDataIncrementCounterPayload() {
        return GitLabServiceDataIncrementCounterPayloadBuilder.builder()
                .event("i_quickactions_page")
                .build();
    }

    public static GitLabServiceDataTrackEventPayload serviceDataTrackEventPayload() {
        return GitLabServiceDataTrackEventPayloadBuilder.builder()
                .event("i_quickactions_page")
                .namespaceId(1L)
                .projectId(1L)
                .projectPath("namespace/project")
                .additionalProperties(Map.of("key", "value"))
                .sendToSnowplow(true)
                .build();
    }
}
