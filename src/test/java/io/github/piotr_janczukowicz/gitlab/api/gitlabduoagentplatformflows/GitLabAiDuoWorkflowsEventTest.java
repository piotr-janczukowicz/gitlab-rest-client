package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiDuoWorkflowsEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiDuoWorkflowsEventBuilder builder = GitLabAiDuoWorkflowsEventBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent())
                .id(null);

        final GitLabAiDuoWorkflowsEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCorrelationIdIsNullable() {
        final GitLabAiDuoWorkflowsEventBuilder builder = GitLabAiDuoWorkflowsEventBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent())
                .correlationId(null);

        final GitLabAiDuoWorkflowsEvent built = builder.build();

        assertThat(built.correlationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventTypeIsNullable() {
        final GitLabAiDuoWorkflowsEventBuilder builder = GitLabAiDuoWorkflowsEventBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent())
                .eventType(null);

        final GitLabAiDuoWorkflowsEvent built = builder.build();

        assertThat(built.eventType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventStatusIsNullable() {
        final GitLabAiDuoWorkflowsEventBuilder builder = GitLabAiDuoWorkflowsEventBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent())
                .eventStatus(null);

        final GitLabAiDuoWorkflowsEvent built = builder.build();

        assertThat(built.eventStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabAiDuoWorkflowsEventBuilder builder = GitLabAiDuoWorkflowsEventBuilder.builder(
                        GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent())
                .message(null);

        final GitLabAiDuoWorkflowsEvent built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiDuoWorkflowsEvent value = GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.correlationId()).isEqualTo("correlation_id");
            softly.assertThat(value.eventType()).isEqualTo("event_type");
            softly.assertThat(value.eventStatus()).isEqualTo("event_status");
            softly.assertThat(value.message()).isEqualTo("message");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiDuoWorkflowsEvent original = GitlabduoagentplatformflowsCatalogFixtures.aiDuoWorkflowsEvent();

        final GitLabAiDuoWorkflowsEvent rebuilt =
                GitLabAiDuoWorkflowsEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiDuoWorkflowsEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "correlationId", "eventType", "eventStatus", "message");
    }
}
