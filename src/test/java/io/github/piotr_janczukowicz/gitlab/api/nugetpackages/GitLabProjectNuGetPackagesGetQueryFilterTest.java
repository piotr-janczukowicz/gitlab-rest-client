package io.github.piotr_janczukowicz.gitlab.api.nugetpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNuGetPackagesGetQueryFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenQIsNullable() {
        final GitLabProjectNuGetPackagesGetQueryFilterBuilder builder =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder(
                                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .q(null);

        final GitLabProjectNuGetPackagesGetQueryFilter built = builder.build();

        assertThat(built.q()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipIsNullable() {
        final GitLabProjectNuGetPackagesGetQueryFilterBuilder builder =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder(
                                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .skip(null);

        final GitLabProjectNuGetPackagesGetQueryFilter built = builder.build();

        assertThat(built.skip()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTakeIsNullable() {
        final GitLabProjectNuGetPackagesGetQueryFilterBuilder builder =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder(
                                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .take(null);

        final GitLabProjectNuGetPackagesGetQueryFilter built = builder.build();

        assertThat(built.take()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrereleaseIsNullable() {
        final GitLabProjectNuGetPackagesGetQueryFilterBuilder builder =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder(
                                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .prerelease(null);

        final GitLabProjectNuGetPackagesGetQueryFilter built = builder.build();

        assertThat(built.prerelease()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNuGetPackagesGetQueryFilter value = GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                .q("q")
                .skip(1)
                .take(1)
                .prerelease(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.q()).isEqualTo("q");
            softly.assertThat(value.skip()).isEqualTo(1);
            softly.assertThat(value.take()).isEqualTo(1);
            softly.assertThat(value.prerelease()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNuGetPackagesGetQueryFilter original =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                        .q("q")
                        .skip(1)
                        .take(1)
                        .prerelease(true)
                        .build();

        final GitLabProjectNuGetPackagesGetQueryFilter rebuilt =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNuGetPackagesGetQueryFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("q", "skip", "take", "prerelease");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectNuGetPackagesGetQueryFilter empty = GitLabProjectNuGetPackagesGetQueryFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectNuGetPackagesGetQueryFilter filter =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                        .q("q")
                        .skip(1)
                        .take(1)
                        .prerelease(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("q", "q"),
                        Map.entry("skip", "1"),
                        Map.entry("take", "1"),
                        Map.entry("prerelease", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectNuGetPackagesGetQueryFilter filter =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder().q("q").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("q", "q"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectNuGetPackagesGetQueryFilter filter =
                GitLabProjectNuGetPackagesGetQueryFilterBuilder.builder()
                        .q("q")
                        .skip(1)
                        .take(1)
                        .prerelease(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
