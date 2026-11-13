package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsClickupServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsClickupServicePayloadBuilder builder =
                GitLabProjectIntegrationsClickupServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsClickupServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsClickupServicePayloadBuilder builder =
                GitLabProjectIntegrationsClickupServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsClickupServicePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsClickupServicePayloadBuilder builder =
                GitLabProjectIntegrationsClickupServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsClickupServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsClickupServicePayloadBuilder builder =
                GitLabProjectIntegrationsClickupServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsClickupServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsClickupServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsClickupServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsClickupServicePayload();

        final GitLabProjectIntegrationsClickupServicePayload rebuilt =
                GitLabProjectIntegrationsClickupServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsClickupServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}
