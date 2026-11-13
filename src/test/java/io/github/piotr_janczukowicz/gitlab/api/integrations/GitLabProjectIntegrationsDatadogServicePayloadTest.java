package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDatadogServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatadogSiteIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .datadogSite(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.datadogSite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .apiUrl(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .apiKey(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogCiVisibilityIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .datadogCiVisibility(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.datadogCiVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveTraceEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .archiveTraceEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.archiveTraceEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogServiceIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .datadogService(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.datadogService()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogEnvIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .datadogEnv(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.datadogEnv()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogTagsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .datadogTags(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.datadogTags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .buildEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.buildEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .noteEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .subgroupEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.subgroupEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectEventsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .projectEvents(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.projectEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDatadogServicePayloadBuilder builder =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDatadogServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDatadogServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload();

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
        final GitLabProjectIntegrationsDatadogServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDatadogServicePayload();

        final GitLabProjectIntegrationsDatadogServicePayload rebuilt =
                GitLabProjectIntegrationsDatadogServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsDatadogServicePayload.class.getRecordComponents())
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
