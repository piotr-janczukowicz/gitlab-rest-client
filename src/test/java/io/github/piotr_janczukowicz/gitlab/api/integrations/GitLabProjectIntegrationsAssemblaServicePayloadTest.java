package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsAssemblaServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsAssemblaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsAssemblaServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubdomainIsNullable() {
        final GitLabProjectIntegrationsAssemblaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload())
                        .subdomain(null);

        final GitLabProjectIntegrationsAssemblaServicePayload built = builder.build();

        assertThat(built.subdomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsAssemblaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsAssemblaServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsAssemblaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAssemblaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsAssemblaServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsAssemblaServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.subdomain()).isEqualTo("subdomain");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsAssemblaServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload();

        final GitLabProjectIntegrationsAssemblaServicePayload rebuilt =
                GitLabProjectIntegrationsAssemblaServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsAssemblaServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAssemblaServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsAssemblaServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "subdomain", "pushEvents", "useInheritedSettings");
    }
}
