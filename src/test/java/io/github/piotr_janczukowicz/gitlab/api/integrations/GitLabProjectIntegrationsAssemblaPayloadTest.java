package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsAssemblaPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsAssemblaPayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload())
                        .token(null);

        final GitLabProjectIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubdomainIsNullable() {
        final GitLabProjectIntegrationsAssemblaPayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload())
                        .subdomain(null);

        final GitLabProjectIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.subdomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsAssemblaPayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsAssemblaPayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsAssemblaPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.subdomain()).isEqualTo("subdomain");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsAssemblaPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload();

        final GitLabProjectIntegrationsAssemblaPayload rebuilt =
                GitLabProjectIntegrationsAssemblaPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsAssemblaPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAssemblaPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsAssemblaPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "subdomain", "pushEvents", "useInheritedSettings");
    }
}
