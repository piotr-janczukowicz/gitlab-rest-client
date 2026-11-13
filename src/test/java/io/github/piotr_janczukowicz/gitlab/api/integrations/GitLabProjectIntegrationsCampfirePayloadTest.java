package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsCampfirePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsCampfirePayloadBuilder builder =
                GitLabProjectIntegrationsCampfirePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload())
                        .token(null);

        final GitLabProjectIntegrationsCampfirePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubdomainIsNullable() {
        final GitLabProjectIntegrationsCampfirePayloadBuilder builder =
                GitLabProjectIntegrationsCampfirePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload())
                        .subdomain(null);

        final GitLabProjectIntegrationsCampfirePayload built = builder.build();

        assertThat(built.subdomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabProjectIntegrationsCampfirePayloadBuilder builder =
                GitLabProjectIntegrationsCampfirePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload())
                        .room(null);

        final GitLabProjectIntegrationsCampfirePayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsCampfirePayloadBuilder builder =
                GitLabProjectIntegrationsCampfirePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsCampfirePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsCampfirePayloadBuilder builder =
                GitLabProjectIntegrationsCampfirePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsCampfirePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsCampfirePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload();

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
        final GitLabProjectIntegrationsCampfirePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload();

        final GitLabProjectIntegrationsCampfirePayload rebuilt =
                GitLabProjectIntegrationsCampfirePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsCampfirePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCampfirePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsCampfirePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "subdomain", "room", "pushEvents", "useInheritedSettings");
    }
}
