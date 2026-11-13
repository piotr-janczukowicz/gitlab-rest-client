package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMobilePushSubscriptionsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDeviceTokenIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .deviceToken(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.deviceToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .platform(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.platform()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApnsEnvironmentIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .apnsEnvironment(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.apnsEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBundleIdIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .bundleId(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.bundleId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeviceNameIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .deviceName(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.deviceName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppVersionIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .appVersion(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.appVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocaleIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .locale(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.locale()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPayloadModeIsNullable() {
        final GitLabMobilePushSubscriptionsCreatePayloadBuilder builder =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(
                                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload())
                        .payloadMode(null);

        final GitLabMobilePushSubscriptionsCreatePayload built = builder.build();

        assertThat(built.payloadMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMobilePushSubscriptionsCreatePayload value =
                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.deviceToken()).isEqualTo("device_token");
            softly.assertThat(value.platform()).isEqualTo(GitLabMobilePushSubscriptionsCreatePlatform.IOS);
            softly.assertThat(value.apnsEnvironment())
                    .isEqualTo(GitLabMobilePushSubscriptionsCreateApnsEnvironment.PRODUCTION);
            softly.assertThat(value.bundleId()).isEqualTo("bundle_id");
            softly.assertThat(value.deviceName()).isEqualTo("device_name");
            softly.assertThat(value.appVersion()).isEqualTo("app_version");
            softly.assertThat(value.locale()).isEqualTo("locale");
            softly.assertThat(value.payloadMode()).isEqualTo(GitLabMobilePushSubscriptionsCreatePayloadMode.FULL);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMobilePushSubscriptionsCreatePayload original =
                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload();

        final GitLabMobilePushSubscriptionsCreatePayload rebuilt =
                GitLabMobilePushSubscriptionsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenDeviceTokenIsACredential() {
        final GitLabMobilePushSubscriptionsCreatePayload value =
                MobilepushsubscriptionsCatalogFixtures.mobilePushSubscriptionsCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMobilePushSubscriptionsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "deviceToken",
                        "platform",
                        "apnsEnvironment",
                        "bundleId",
                        "deviceName",
                        "appVersion",
                        "locale",
                        "payloadMode");
    }
}
