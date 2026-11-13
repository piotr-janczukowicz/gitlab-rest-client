package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsAsanaServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabProjectIntegrationsAsanaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAsanaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload())
                        .apiKey(null);

        final GitLabProjectIntegrationsAsanaServicePayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictToBranchIsNullable() {
        final GitLabProjectIntegrationsAsanaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAsanaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload())
                        .restrictToBranch(null);

        final GitLabProjectIntegrationsAsanaServicePayload built = builder.build();

        assertThat(built.restrictToBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsAsanaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAsanaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsAsanaServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsAsanaServicePayloadBuilder builder =
                GitLabProjectIntegrationsAsanaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsAsanaServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsAsanaServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.apiKey()).isEqualTo("api_key");
            softly.assertThat(value.restrictToBranch()).isEqualTo("restrict_to_branch");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsAsanaServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsAsanaServicePayload();

        final GitLabProjectIntegrationsAsanaServicePayload rebuilt =
                GitLabProjectIntegrationsAsanaServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsAsanaServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiKey", "restrictToBranch", "pushEvents", "useInheritedSettings");
    }
}
