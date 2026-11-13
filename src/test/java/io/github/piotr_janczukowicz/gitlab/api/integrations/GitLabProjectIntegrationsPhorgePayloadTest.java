package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPhorgePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsPhorgePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsPhorgePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsPhorgePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsPhorgePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPhorgePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPhorgePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPhorgePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPhorgePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPhorgePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsPhorgePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPhorgePayload();

        final GitLabProjectIntegrationsPhorgePayload rebuilt =
                GitLabProjectIntegrationsPhorgePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPhorgePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}
