package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsGetPackagesNugetQueryFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenQIsNullable() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder builder =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder(
                                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .q(null);

        final GitLabGroupGroupsGetPackagesNugetQueryFilter built = builder.build();

        assertThat(built.q()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipIsNullable() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder builder =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder(
                                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .skip(null);

        final GitLabGroupGroupsGetPackagesNugetQueryFilter built = builder.build();

        assertThat(built.skip()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTakeIsNullable() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder builder =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder(
                                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .take(null);

        final GitLabGroupGroupsGetPackagesNugetQueryFilter built = builder.build();

        assertThat(built.take()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrereleaseIsNullable() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder builder =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder(
                                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
                                        .q("q")
                                        .skip(1)
                                        .take(1)
                                        .prerelease(true)
                                        .build())
                        .prerelease(null);

        final GitLabGroupGroupsGetPackagesNugetQueryFilter built = builder.build();

        assertThat(built.prerelease()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilter value =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
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
        final GitLabGroupGroupsGetPackagesNugetQueryFilter original =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
                        .q("q")
                        .skip(1)
                        .take(1)
                        .prerelease(true)
                        .build();

        final GitLabGroupGroupsGetPackagesNugetQueryFilter rebuilt =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsGetPackagesNugetQueryFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("q", "skip", "take", "prerelease");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilter empty = GitLabGroupGroupsGetPackagesNugetQueryFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilter filter =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
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
        final GitLabGroupGroupsGetPackagesNugetQueryFilter filter =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
                        .q("q")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("q", "q"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsGetPackagesNugetQueryFilter filter =
                GitLabGroupGroupsGetPackagesNugetQueryFilterBuilder.builder()
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
