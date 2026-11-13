package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsCampfirePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsCampfirePayloadBuilder builder =
                GitLabGroupGroupIntegrationsCampfirePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsCampfirePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubdomainIsNullable() {
        final GitLabGroupGroupIntegrationsCampfirePayloadBuilder builder =
                GitLabGroupGroupIntegrationsCampfirePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload())
                        .subdomain(null);

        final GitLabGroupGroupIntegrationsCampfirePayload built = builder.build();

        assertThat(built.subdomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabGroupGroupIntegrationsCampfirePayloadBuilder builder =
                GitLabGroupGroupIntegrationsCampfirePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload())
                        .room(null);

        final GitLabGroupGroupIntegrationsCampfirePayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsCampfirePayloadBuilder builder =
                GitLabGroupGroupIntegrationsCampfirePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsCampfirePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsCampfirePayloadBuilder builder =
                GitLabGroupGroupIntegrationsCampfirePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsCampfirePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsCampfirePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.subdomain()).isEqualTo("subdomain");
            softly.assertThat(value.room()).isEqualTo("room");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsCampfirePayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload();

        final GitLabGroupGroupIntegrationsCampfirePayload rebuilt =
                GitLabGroupGroupIntegrationsCampfirePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsCampfirePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsCampfirePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsCampfirePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "subdomain", "room", "pushEvents", "useInheritedSettings");
    }
}
