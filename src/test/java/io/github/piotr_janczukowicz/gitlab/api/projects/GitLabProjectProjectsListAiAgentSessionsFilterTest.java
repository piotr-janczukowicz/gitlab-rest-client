package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsListAiAgentSessionsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenAgentTypeIsNullable() {
        final GitLabProjectProjectsListAiAgentSessionsFilterBuilder builder =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder(
                                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .agentType(null);

        final GitLabProjectProjectsListAiAgentSessionsFilter built = builder.build();

        assertThat(built.agentType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectProjectsListAiAgentSessionsFilterBuilder builder =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder(
                                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .status(null);

        final GitLabProjectProjectsListAiAgentSessionsFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabProjectProjectsListAiAgentSessionsFilterBuilder builder =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder(
                                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdAfter(null);

        final GitLabProjectProjectsListAiAgentSessionsFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabProjectProjectsListAiAgentSessionsFilterBuilder builder =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder(
                                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdBefore(null);

        final GitLabProjectProjectsListAiAgentSessionsFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsListAiAgentSessionsFilter value =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.agentType())
                    .isEqualTo(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE);
            softly.assertThat(value.status()).isEqualTo(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsListAiAgentSessionsFilter original =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final GitLabProjectProjectsListAiAgentSessionsFilter rebuilt =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsListAiAgentSessionsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("agentType", "status", "createdAfter", "createdBefore");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsListAiAgentSessionsFilter empty =
                GitLabProjectProjectsListAiAgentSessionsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsListAiAgentSessionsFilter filter =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("agent_type", "claude-code"),
                        Map.entry("status", "created"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsListAiAgentSessionsFilter filter =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("agent_type", "claude-code"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsListAiAgentSessionsFilter filter =
                GitLabProjectProjectsListAiAgentSessionsFilterBuilder.builder()
                        .agentType(GitLabProjectProjectsListAiAgentSessionsAgentType.CLAUDE_CODE)
                        .status(GitLabProjectProjectsListAiAgentSessionsStatus.CREATED)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
