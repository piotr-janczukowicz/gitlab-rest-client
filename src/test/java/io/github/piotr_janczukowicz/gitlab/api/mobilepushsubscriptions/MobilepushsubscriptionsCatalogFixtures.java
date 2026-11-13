package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import java.time.Instant;

public final class MobilepushsubscriptionsCatalogFixtures {

    private MobilepushsubscriptionsCatalogFixtures() {}

    public static GitLabMobilePushSubscription mobilePushSubscription() {
        return GitLabMobilePushSubscriptionBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabMobilePushSubscriptionsCreatePayload mobilePushSubscriptionsCreatePayload() {
        return GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder()
                .deviceToken("device_token")
                .platform(GitLabMobilePushSubscriptionsCreatePlatform.IOS)
                .apnsEnvironment(GitLabMobilePushSubscriptionsCreateApnsEnvironment.PRODUCTION)
                .bundleId("bundle_id")
                .deviceName("device_name")
                .appVersion("app_version")
                .locale("locale")
                .payloadMode(GitLabMobilePushSubscriptionsCreatePayloadMode.FULL)
                .build();
    }
}
