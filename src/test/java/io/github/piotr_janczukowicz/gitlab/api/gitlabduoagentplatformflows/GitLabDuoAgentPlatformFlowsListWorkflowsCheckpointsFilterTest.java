package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenAcceptCompressedIsNullable() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                                        .acceptCompressed(true)
                                        .checkpointNs("checkpoint_ns")
                                        .channels(List.of("channels"))
                                        .build())
                        .acceptCompressed(null);

        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter built = builder.build();

        assertThat(built.acceptCompressed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckpointNsIsNullable() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                                        .acceptCompressed(true)
                                        .checkpointNs("checkpoint_ns")
                                        .channels(List.of("channels"))
                                        .build())
                        .checkpointNs(null);

        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter built = builder.build();

        assertThat(built.checkpointNs()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenCheckpointNsIsTooLong() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                                        .acceptCompressed(true)
                                        .checkpointNs("checkpoint_ns")
                                        .channels(List.of("channels"))
                                        .build())
                        .checkpointNs("x".repeat(4097));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenCheckpointNsHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                                        .acceptCompressed(true)
                                        .checkpointNs("checkpoint_ns")
                                        .channels(List.of("channels"))
                                        .build())
                        .checkpointNs("x".repeat(4096));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelsIsNullable() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder builder =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                                        .acceptCompressed(true)
                                        .checkpointNs("checkpoint_ns")
                                        .channels(List.of("channels"))
                                        .build())
                        .channels(null);

        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter built = builder.build();

        assertThat(built.channels()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter value =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                        .acceptCompressed(true)
                        .checkpointNs("checkpoint_ns")
                        .channels(List.of("channels"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.acceptCompressed()).isEqualTo(true);
            softly.assertThat(value.checkpointNs()).isEqualTo("checkpoint_ns");
            softly.assertThat(value.channels()).isEqualTo(List.of("channels"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter original =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                        .acceptCompressed(true)
                        .checkpointNs("checkpoint_ns")
                        .channels(List.of("channels"))
                        .build();

        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter rebuilt =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenChannelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("channels"));
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter built =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder(
                                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                                        .acceptCompressed(true)
                                        .checkpointNs("checkpoint_ns")
                                        .channels(List.of("channels"))
                                        .build())
                        .channels(source)
                        .build();
        source.clear();

        assertThat(built.channels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenChannelsIsRead() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter built =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                        .acceptCompressed(true)
                        .checkpointNs("checkpoint_ns")
                        .channels(List.of("channels"))
                        .build();
        final List<String> values = built.channels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("acceptCompressed", "checkpointNs", "channels");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter empty =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter filter =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                        .acceptCompressed(true)
                        .checkpointNs("checkpoint_ns")
                        .channels(List.of("channels"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("accept_compressed", "true"),
                        Map.entry("checkpoint_ns", "checkpoint_ns"),
                        Map.entry("channels", "channels"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter filter =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                        .acceptCompressed(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("accept_compressed", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilter filter =
                GitLabDuoAgentPlatformFlowsListWorkflowsCheckpointsFilterBuilder.builder()
                        .acceptCompressed(true)
                        .checkpointNs("checkpoint_ns")
                        .channels(List.of("channels"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
