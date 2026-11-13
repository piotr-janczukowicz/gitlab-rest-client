package io.github.piotr_janczukowicz.gitlab.api.repositories;

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
class GitLabProjectRepositoriesCallArchiveFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectRepositoriesCallArchiveFilterBuilder builder =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(
                                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                        .sha("sha")
                                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                        .format("format")
                                        .path("path")
                                        .includeLfsBlobs(true)
                                        .excludePaths(List.of("exclude_paths"))
                                        .build())
                        .sha(null);

        final GitLabProjectRepositoriesCallArchiveFilter built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefTypeIsNullable() {
        final GitLabProjectRepositoriesCallArchiveFilterBuilder builder =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(
                                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                        .sha("sha")
                                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                        .format("format")
                                        .path("path")
                                        .includeLfsBlobs(true)
                                        .excludePaths(List.of("exclude_paths"))
                                        .build())
                        .refType(null);

        final GitLabProjectRepositoriesCallArchiveFilter built = builder.build();

        assertThat(built.refType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabProjectRepositoriesCallArchiveFilterBuilder builder =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(
                                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                        .sha("sha")
                                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                        .format("format")
                                        .path("path")
                                        .includeLfsBlobs(true)
                                        .excludePaths(List.of("exclude_paths"))
                                        .build())
                        .format(null);

        final GitLabProjectRepositoriesCallArchiveFilter built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectRepositoriesCallArchiveFilterBuilder builder =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(
                                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                        .sha("sha")
                                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                        .format("format")
                                        .path("path")
                                        .includeLfsBlobs(true)
                                        .excludePaths(List.of("exclude_paths"))
                                        .build())
                        .path(null);

        final GitLabProjectRepositoriesCallArchiveFilter built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeLfsBlobsIsNullable() {
        final GitLabProjectRepositoriesCallArchiveFilterBuilder builder =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(
                                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                        .sha("sha")
                                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                        .format("format")
                                        .path("path")
                                        .includeLfsBlobs(true)
                                        .excludePaths(List.of("exclude_paths"))
                                        .build())
                        .includeLfsBlobs(null);

        final GitLabProjectRepositoriesCallArchiveFilter built = builder.build();

        assertThat(built.includeLfsBlobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludePathsIsNullable() {
        final GitLabProjectRepositoriesCallArchiveFilterBuilder builder =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(
                                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                        .sha("sha")
                                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                        .format("format")
                                        .path("path")
                                        .includeLfsBlobs(true)
                                        .excludePaths(List.of("exclude_paths"))
                                        .build())
                        .excludePaths(null);

        final GitLabProjectRepositoriesCallArchiveFilter built = builder.build();

        assertThat(built.excludePaths()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesCallArchiveFilter value =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                        .sha("sha")
                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                        .format("format")
                        .path("path")
                        .includeLfsBlobs(true)
                        .excludePaths(List.of("exclude_paths"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.refType()).isEqualTo(GitLabProjectRepositoriesCallArchiveRefType.HEADS);
            softly.assertThat(value.format()).isEqualTo("format");
            softly.assertThat(value.path()).isEqualTo("path");
            softly.assertThat(value.includeLfsBlobs()).isEqualTo(true);
            softly.assertThat(value.excludePaths()).isEqualTo(List.of("exclude_paths"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesCallArchiveFilter original =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                        .sha("sha")
                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                        .format("format")
                        .path("path")
                        .includeLfsBlobs(true)
                        .excludePaths(List.of("exclude_paths"))
                        .build();

        final GitLabProjectRepositoriesCallArchiveFilter rebuilt =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenExcludePathsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("exclude_paths"));
        final GitLabProjectRepositoriesCallArchiveFilter built =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder(
                                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                                        .sha("sha")
                                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                                        .format("format")
                                        .path("path")
                                        .includeLfsBlobs(true)
                                        .excludePaths(List.of("exclude_paths"))
                                        .build())
                        .excludePaths(source)
                        .build();
        source.clear();

        assertThat(built.excludePaths()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenExcludePathsIsRead() {
        final GitLabProjectRepositoriesCallArchiveFilter built =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                        .sha("sha")
                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                        .format("format")
                        .path("path")
                        .includeLfsBlobs(true)
                        .excludePaths(List.of("exclude_paths"))
                        .build();
        final List<String> values = built.excludePaths();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoriesCallArchiveFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sha", "refType", "format", "path", "includeLfsBlobs", "excludePaths");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesCallArchiveFilter empty = GitLabProjectRepositoriesCallArchiveFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesCallArchiveFilter filter =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                        .sha("sha")
                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                        .format("format")
                        .path("path")
                        .includeLfsBlobs(true)
                        .excludePaths(List.of("exclude_paths"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("sha", "sha"),
                        Map.entry("ref_type", "heads"),
                        Map.entry("format", "format"),
                        Map.entry("path", "path"),
                        Map.entry("include_lfs_blobs", "true"),
                        Map.entry("exclude_paths", "exclude_paths"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesCallArchiveFilter filter =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                        .sha("sha")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sha", "sha"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesCallArchiveFilter filter =
                GitLabProjectRepositoriesCallArchiveFilterBuilder.builder()
                        .sha("sha")
                        .refType(GitLabProjectRepositoriesCallArchiveRefType.HEADS)
                        .format("format")
                        .path("path")
                        .includeLfsBlobs(true)
                        .excludePaths(List.of("exclude_paths"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
