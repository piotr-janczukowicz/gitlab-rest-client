package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

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
class GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent())
                        .id(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent())
                        .type(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent())
                        .source(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent())
                        .time(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent built = builder.build();

        assertThat(built.time()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent())
                        .data(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("id");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.source()).isEqualTo("source");
            softly.assertThat(value.time()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.data()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent();

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent rebuilt =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenDataSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent built =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEventBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent())
                        .data(source)
                        .build();
        source.clear();

        assertThat(built.data()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "type", "source", "time", "data");
    }
}
