package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsClickupPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsClickupPayloadBuilder builder =
                GitLabProjectIntegrationsClickupPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupPayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsClickupPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsClickupPayloadBuilder builder =
                GitLabProjectIntegrationsClickupPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupPayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsClickupPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsClickupPayloadBuilder builder =
                GitLabProjectIntegrationsClickupPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsClickupPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsClickupPayloadBuilder builder =
                GitLabProjectIntegrationsClickupPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsClickupPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsClickupPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsClickupPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsClickupPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsClickupPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsClickupPayload();

        final GitLabProjectIntegrationsClickupPayload rebuilt =
                GitLabProjectIntegrationsClickupPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsClickupPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}
