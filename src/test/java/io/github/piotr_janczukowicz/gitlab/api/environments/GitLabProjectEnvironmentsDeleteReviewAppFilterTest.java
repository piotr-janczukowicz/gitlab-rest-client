package io.github.piotr_janczukowicz.gitlab.api.environments;

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
class GitLabProjectEnvironmentsDeleteReviewAppFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenBeforeIsNullable() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder builder =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(
                                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                                        .limit(1)
                                        .dryRun(true)
                                        .build())
                        .before(null);

        final GitLabProjectEnvironmentsDeleteReviewAppFilter built = builder.build();

        assertThat(built.before()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLimitIsNullable() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder builder =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(
                                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                                        .limit(1)
                                        .dryRun(true)
                                        .build())
                        .limit(null);

        final GitLabProjectEnvironmentsDeleteReviewAppFilter built = builder.build();

        assertThat(built.limit()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenLimitIsBelowTheMinimum() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder builder =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(
                                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                                        .limit(1)
                                        .dryRun(true)
                                        .build())
                        .limit(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenLimitIsTheMinimum() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder builder =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(
                                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                                        .limit(1)
                                        .dryRun(true)
                                        .build())
                        .limit(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenLimitIsAboveTheMaximum() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder builder =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(
                                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                                        .limit(1)
                                        .dryRun(true)
                                        .build())
                        .limit(1001);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenLimitIsTheMaximum() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder builder =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(
                                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                                        .limit(1)
                                        .dryRun(true)
                                        .build())
                        .limit(1000);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDryRunIsNullable() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder builder =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(
                                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                                        .limit(1)
                                        .dryRun(true)
                                        .build())
                        .dryRun(null);

        final GitLabProjectEnvironmentsDeleteReviewAppFilter built = builder.build();

        assertThat(built.dryRun()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilter value =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                        .limit(1)
                        .dryRun(true)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.before()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.limit()).isEqualTo(1);
            softly.assertThat(value.dryRun()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilter original =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                        .limit(1)
                        .dryRun(true)
                        .build();

        final GitLabProjectEnvironmentsDeleteReviewAppFilter rebuilt =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEnvironmentsDeleteReviewAppFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("before", "limit", "dryRun");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilter empty =
                GitLabProjectEnvironmentsDeleteReviewAppFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilter filter =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                        .limit(1)
                        .dryRun(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("before", "2026-01-01T00:00:00Z"),
                        Map.entry("limit", "1"),
                        Map.entry("dry_run", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilter filter =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("before", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectEnvironmentsDeleteReviewAppFilter filter =
                GitLabProjectEnvironmentsDeleteReviewAppFilterBuilder.builder()
                        .before(Instant.parse("2026-01-01T00:00:00Z"))
                        .limit(1)
                        .dryRun(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
