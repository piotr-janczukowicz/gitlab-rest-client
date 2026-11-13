package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateAiAgentAuditEventEventTest {

    @Test
    void constructor_shouldAcceptNull_whenEventNameIsNullable() {
        final GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder builder =
                GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent())
                        .eventName(null);

        final GitLabProjectProjectsCreateAiAgentAuditEventEvent built = builder.build();

        assertThat(built.eventName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloudEventIdIsNullable() {
        final GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder builder =
                GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent())
                        .cloudEventId(null);

        final GitLabProjectProjectsCreateAiAgentAuditEventEvent built = builder.build();

        assertThat(built.cloudEventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOccurredAtIsNullable() {
        final GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder builder =
                GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent())
                        .occurredAt(null);

        final GitLabProjectProjectsCreateAiAgentAuditEventEvent built = builder.build();

        assertThat(built.occurredAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailsIsNullable() {
        final GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder builder =
                GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent())
                        .details(null);

        final GitLabProjectProjectsCreateAiAgentAuditEventEvent built = builder.build();

        assertThat(built.details()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateAiAgentAuditEventEvent value =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.eventName()).isEqualTo("event_name");
            softly.assertThat(value.cloudEventId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000");
            softly.assertThat(value.occurredAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.details()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateAiAgentAuditEventEvent original =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent();

        final GitLabProjectProjectsCreateAiAgentAuditEventEvent rebuilt =
                GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenDetailsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsCreateAiAgentAuditEventEvent built =
                GitLabProjectProjectsCreateAiAgentAuditEventEventBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent())
                        .details(source)
                        .build();
        source.clear();

        assertThat(built.details()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateAiAgentAuditEventEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("eventName", "cloudEventId", "occurredAt", "details");
    }
}
