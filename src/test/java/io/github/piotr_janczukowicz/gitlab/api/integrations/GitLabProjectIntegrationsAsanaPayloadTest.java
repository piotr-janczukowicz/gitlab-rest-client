package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsAsanaPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabProjectIntegrationsAsanaPayloadBuilder builder =
                GitLabProjectIntegrationsAsanaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload())
                        .apiKey(null);

        final GitLabProjectIntegrationsAsanaPayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictToBranchIsNullable() {
        final GitLabProjectIntegrationsAsanaPayloadBuilder builder =
                GitLabProjectIntegrationsAsanaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload())
                        .restrictToBranch(null);

        final GitLabProjectIntegrationsAsanaPayload built = builder.build();

        assertThat(built.restrictToBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsAsanaPayloadBuilder builder =
                GitLabProjectIntegrationsAsanaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsAsanaPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsAsanaPayloadBuilder builder =
                GitLabProjectIntegrationsAsanaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsAsanaPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsAsanaPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.apiKey()).isEqualTo("api_key");
            softly.assertThat(value.restrictToBranch()).isEqualTo("restrict_to_branch");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsAsanaPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsAsanaPayload();

        final GitLabProjectIntegrationsAsanaPayload rebuilt =
                GitLabProjectIntegrationsAsanaPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsAsanaPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiKey", "restrictToBranch", "pushEvents", "useInheritedSettings");
    }
}
