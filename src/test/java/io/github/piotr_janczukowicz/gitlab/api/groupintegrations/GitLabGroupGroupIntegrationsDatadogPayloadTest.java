package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsDatadogPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDatadogSiteIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .datadogSite(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogSite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .apiUrl(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .apiKey(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogCiVisibilityIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .datadogCiVisibility(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogCiVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveTraceEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .archiveTraceEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.archiveTraceEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogServiceIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .datadogService(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogService()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogEnvIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .datadogEnv(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogEnv()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDatadogTagsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .datadogTags(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.datadogTags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .buildEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.buildEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .noteEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .subgroupEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.subgroupEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .projectEvents(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.projectEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsDatadogPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsDatadogPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsDatadogPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload();

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
        final GitLabGroupGroupIntegrationsDatadogPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDatadogPayload();

        final GitLabGroupGroupIntegrationsDatadogPayload rebuilt =
                GitLabGroupGroupIntegrationsDatadogPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsDatadogPayload.class.getRecordComponents())
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
