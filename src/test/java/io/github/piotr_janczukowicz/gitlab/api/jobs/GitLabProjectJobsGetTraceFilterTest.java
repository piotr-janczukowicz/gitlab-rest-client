package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsGetTraceFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenByteOffsetIsNullable() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteOffset(null);

        final GitLabProjectJobsGetTraceFilter built = builder.build();

        assertThat(built.byteOffset()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenByteOffsetIsBelowTheMinimum() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteOffset(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenByteOffsetIsTheMinimum() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteOffset(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenByteLimitIsNullable() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteLimit(null);

        final GitLabProjectJobsGetTraceFilter built = builder.build();

        assertThat(built.byteLimit()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenByteLimitIsBelowTheMinimum() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteLimit(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenByteLimitIsTheMinimum() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteLimit(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenByteLimitIsAboveTheMaximum() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteLimit(512_001);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenByteLimitIsTheMaximum() {
        final GitLabProjectJobsGetTraceFilterBuilder builder = GitLabProjectJobsGetTraceFilterBuilder.builder(
                        GitLabProjectJobsGetTraceFilterBuilder.builder()
                                .byteOffset(1)
                                .byteLimit(1)
                                .build())
                .byteLimit(512_000);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsGetTraceFilter value = GitLabProjectJobsGetTraceFilterBuilder.builder()
                .byteOffset(1)
                .byteLimit(1)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.byteOffset()).isEqualTo(1);
            softly.assertThat(value.byteLimit()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsGetTraceFilter original = GitLabProjectJobsGetTraceFilterBuilder.builder()
                .byteOffset(1)
                .byteLimit(1)
                .build();

        final GitLabProjectJobsGetTraceFilter rebuilt =
                GitLabProjectJobsGetTraceFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsGetTraceFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("byteOffset", "byteLimit");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsGetTraceFilter empty = GitLabProjectJobsGetTraceFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsGetTraceFilter filter = GitLabProjectJobsGetTraceFilterBuilder.builder()
                .byteOffset(1)
                .byteLimit(1)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("byte_offset", "1"), Map.entry("byte_limit", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsGetTraceFilter filter =
                GitLabProjectJobsGetTraceFilterBuilder.builder().byteOffset(1).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("byte_offset", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsGetTraceFilter filter = GitLabProjectJobsGetTraceFilterBuilder.builder()
                .byteOffset(1)
                .byteLimit(1)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
