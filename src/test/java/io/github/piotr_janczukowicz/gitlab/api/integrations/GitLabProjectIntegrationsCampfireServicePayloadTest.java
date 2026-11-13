package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsCampfireServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsCampfireServicePayloadBuilder builder =
                GitLabProjectIntegrationsCampfireServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsCampfireServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubdomainIsNullable() {
        final GitLabProjectIntegrationsCampfireServicePayloadBuilder builder =
                GitLabProjectIntegrationsCampfireServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload())
                        .subdomain(null);

        final GitLabProjectIntegrationsCampfireServicePayload built = builder.build();

        assertThat(built.subdomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRoomIsNullable() {
        final GitLabProjectIntegrationsCampfireServicePayloadBuilder builder =
                GitLabProjectIntegrationsCampfireServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload())
                        .room(null);

        final GitLabProjectIntegrationsCampfireServicePayload built = builder.build();

        assertThat(built.room()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsCampfireServicePayloadBuilder builder =
                GitLabProjectIntegrationsCampfireServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsCampfireServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsCampfireServicePayloadBuilder builder =
                GitLabProjectIntegrationsCampfireServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsCampfireServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsCampfireServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload();

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
        final GitLabProjectIntegrationsCampfireServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload();

        final GitLabProjectIntegrationsCampfireServicePayload rebuilt =
                GitLabProjectIntegrationsCampfireServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsCampfireServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCampfireServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsCampfireServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "subdomain", "room", "pushEvents", "useInheritedSettings");
    }
}
