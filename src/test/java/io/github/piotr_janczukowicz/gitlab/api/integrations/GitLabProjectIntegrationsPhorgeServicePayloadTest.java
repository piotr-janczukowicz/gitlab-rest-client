package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPhorgeServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsPhorgeServicePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgeServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsPhorgeServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsPhorgeServicePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgeServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsPhorgeServicePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPhorgeServicePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgeServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPhorgeServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPhorgeServicePayloadBuilder builder =
                GitLabProjectIntegrationsPhorgeServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPhorgeServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPhorgeServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsPhorgeServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPhorgeServicePayload();

        final GitLabProjectIntegrationsPhorgeServicePayload rebuilt =
                GitLabProjectIntegrationsPhorgeServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPhorgeServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}
