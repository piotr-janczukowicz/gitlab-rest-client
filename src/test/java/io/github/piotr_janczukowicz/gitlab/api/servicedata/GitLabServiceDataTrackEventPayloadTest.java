package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabServiceDataTrackEventPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEventIsNullable() {
        final GitLabServiceDataTrackEventPayloadBuilder builder = GitLabServiceDataTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataTrackEventPayload())
                .event(null);

        final GitLabServiceDataTrackEventPayload built = builder.build();

        assertThat(built.event()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabServiceDataTrackEventPayloadBuilder builder = GitLabServiceDataTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataTrackEventPayload())
                .namespaceId(null);

        final GitLabServiceDataTrackEventPayload built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabServiceDataTrackEventPayloadBuilder builder = GitLabServiceDataTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataTrackEventPayload())
                .projectId(null);

        final GitLabServiceDataTrackEventPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectPathIsNullable() {
        final GitLabServiceDataTrackEventPayloadBuilder builder = GitLabServiceDataTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataTrackEventPayload())
                .projectPath(null);

        final GitLabServiceDataTrackEventPayload built = builder.build();

        assertThat(built.projectPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalPropertiesIsNullable() {
        final GitLabServiceDataTrackEventPayloadBuilder builder = GitLabServiceDataTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataTrackEventPayload())
                .additionalProperties(null);

        final GitLabServiceDataTrackEventPayload built = builder.build();

        assertThat(built.additionalProperties()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSendToSnowplowIsNullable() {
        final GitLabServiceDataTrackEventPayloadBuilder builder = GitLabServiceDataTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataTrackEventPayload())
                .sendToSnowplow(null);

        final GitLabServiceDataTrackEventPayload built = builder.build();

        assertThat(built.sendToSnowplow()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabServiceDataTrackEventPayload value = ServicedataCatalogFixtures.serviceDataTrackEventPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.event()).isEqualTo("i_quickactions_page");
            softly.assertThat(value.namespaceId()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.projectPath()).isEqualTo("namespace/project");
            softly.assertThat(value.additionalProperties()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.sendToSnowplow()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabServiceDataTrackEventPayload original = ServicedataCatalogFixtures.serviceDataTrackEventPayload();

        final GitLabServiceDataTrackEventPayload rebuilt =
                GitLabServiceDataTrackEventPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenAdditionalPropertiesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabServiceDataTrackEventPayload built = GitLabServiceDataTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataTrackEventPayload())
                .additionalProperties(source)
                .build();
        source.clear();

        assertThat(built.additionalProperties()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabServiceDataTrackEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "event", "namespaceId", "projectId", "projectPath", "additionalProperties", "sendToSnowplow");
    }
}
