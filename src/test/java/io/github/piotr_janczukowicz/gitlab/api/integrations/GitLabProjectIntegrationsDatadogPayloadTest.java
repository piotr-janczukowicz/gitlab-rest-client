package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDatadogPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatadogSiteIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .datadogSite(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogSite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .apiUrl(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .apiKey(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogCiVisibilityIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .datadogCiVisibility(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogCiVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveTraceEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .archiveTraceEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.archiveTraceEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogServiceIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .datadogService(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogService()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogEnvIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .datadogEnv(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogEnv()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogTagsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .datadogTags(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogTags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .buildEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.buildEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .subgroupEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.subgroupEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .projectEvents(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.projectEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDatadogPayloadBuilder builder =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDatadogPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDatadogPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.datadogSite()).isEqualTo("datadog_site");
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.apiKey()).isEqualTo("api_key");
            softly.assertThat(value.datadogCiVisibility()).isEqualTo(true);
            softly.assertThat(value.archiveTraceEvents()).isEqualTo(true);
            softly.assertThat(value.datadogService()).isEqualTo("datadog_service");
            softly.assertThat(value.datadogEnv()).isEqualTo("datadog_env");
            softly.assertThat(value.datadogTags()).isEqualTo("datadog_tags");
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.buildEvents()).isEqualTo(true);
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.subgroupEvents()).isEqualTo(true);
            softly.assertThat(value.projectEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsDatadogPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDatadogPayload();

        final GitLabProjectIntegrationsDatadogPayload rebuilt =
                GitLabProjectIntegrationsDatadogPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsDatadogPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "datadogSite",
                        "apiUrl",
                        "apiKey",
                        "datadogCiVisibility",
                        "archiveTraceEvents",
                        "datadogService",
                        "datadogEnv",
                        "datadogTags",
                        "pipelineEvents",
                        "buildEvents",
                        "pushEvents",
                        "mergeRequestsEvents",
                        "noteEvents",
                        "tagPushEvents",
                        "subgroupEvents",
                        "projectEvents",
                        "useInheritedSettings");
    }
}
