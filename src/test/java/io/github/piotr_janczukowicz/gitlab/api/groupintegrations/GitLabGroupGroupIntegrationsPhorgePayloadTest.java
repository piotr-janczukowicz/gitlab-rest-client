package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsPhorgePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabGroupGroupIntegrationsPhorgePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPhorgePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload())
                        .projectUrl(null);

        final GitLabGroupGroupIntegrationsPhorgePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabGroupGroupIntegrationsPhorgePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPhorgePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload())
                        .issuesUrl(null);

        final GitLabGroupGroupIntegrationsPhorgePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPhorgePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPhorgePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsPhorgePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsPhorgePayloadBuilder builder =
                GitLabGroupGroupIntegrationsPhorgePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsPhorgePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsPhorgePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsPhorgePayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPhorgePayload();

        final GitLabGroupGroupIntegrationsPhorgePayload rebuilt =
                GitLabGroupGroupIntegrationsPhorgePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsPhorgePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}
