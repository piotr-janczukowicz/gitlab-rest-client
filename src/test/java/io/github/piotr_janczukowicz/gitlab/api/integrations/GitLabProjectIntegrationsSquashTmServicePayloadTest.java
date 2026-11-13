package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsSquashTmServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectIntegrationsSquashTmServicePayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload())
                        .url(null);

        final GitLabProjectIntegrationsSquashTmServicePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsSquashTmServicePayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsSquashTmServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSquashTmServicePayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsSquashTmServicePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSquashTmServicePayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsSquashTmServicePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsSquashTmServicePayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsSquashTmServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsSquashTmServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsSquashTmServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload();

        final GitLabProjectIntegrationsSquashTmServicePayload rebuilt =
                GitLabProjectIntegrationsSquashTmServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsSquashTmServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsSquashTmServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsSquashTmServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("url", "token", "issuesEvents", "confidentialIssuesEvents", "useInheritedSettings");
    }
}
