package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsSquashTmPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectIntegrationsSquashTmPayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload())
                        .url(null);

        final GitLabProjectIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsSquashTmPayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload())
                        .token(null);

        final GitLabProjectIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSquashTmPayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload())
                        .issuesEvents(null);

        final GitLabProjectIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectIntegrationsSquashTmPayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsSquashTmPayloadBuilder builder =
                GitLabProjectIntegrationsSquashTmPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsSquashTmPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload();

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
        final GitLabProjectIntegrationsSquashTmPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload();

        final GitLabProjectIntegrationsSquashTmPayload rebuilt =
                GitLabProjectIntegrationsSquashTmPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsSquashTmPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsSquashTmPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsSquashTmPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("url", "token", "issuesEvents", "confidentialIssuesEvents", "useInheritedSettings");
    }
}
