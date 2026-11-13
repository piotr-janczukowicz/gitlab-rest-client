package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesListTreeFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .ref(null);

        final GitLabProjectRepositoriesListTreeFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenRefIsTooLong() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .ref("x".repeat(1025));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenRefHasTheMaximumLength() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .ref("x".repeat(1024));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .path(null);

        final GitLabProjectRepositoriesListTreeFilter built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenPathIsTooLong() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .path("x".repeat(1025));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenPathHasTheMaximumLength() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .path("x".repeat(1024));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecursiveIsNullable() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .recursive(null);

        final GitLabProjectRepositoriesListTreeFilter built = builder.build();

        assertThat(built.recursive()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithLastCommitIsNullable() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .withLastCommit(null);

        final GitLabProjectRepositoriesListTreeFilter built = builder.build();

        assertThat(built.withLastCommit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectRepositoriesListTreeFilterBuilder builder =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(
                                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                                        .ref("ref")
                                        .path("path")
                                        .recursive(true)
                                        .withLastCommit(true)
                                        .pageToken("page_token")
                                        .build())
                        .pageToken(null);

        final GitLabProjectRepositoriesListTreeFilter built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesListTreeFilter value = GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                .ref("ref")
                .path("path")
                .recursive(true)
                .withLastCommit(true)
                .pageToken("page_token")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.path()).isEqualTo("path");
            softly.assertThat(value.recursive()).isEqualTo(true);
            softly.assertThat(value.withLastCommit()).isEqualTo(true);
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesListTreeFilter original =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                        .ref("ref")
                        .path("path")
                        .recursive(true)
                        .withLastCommit(true)
                        .pageToken("page_token")
                        .build();

        final GitLabProjectRepositoriesListTreeFilter rebuilt =
                GitLabProjectRepositoriesListTreeFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectRepositoriesListTreeFilter value = GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                .ref("ref")
                .path("path")
                .recursive(true)
                .withLastCommit(true)
                .pageToken("page_token")
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoriesListTreeFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ref", "path", "recursive", "withLastCommit", "pageToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesListTreeFilter empty = GitLabProjectRepositoriesListTreeFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesListTreeFilter filter = GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                .ref("ref")
                .path("path")
                .recursive(true)
                .withLastCommit(true)
                .pageToken("page_token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("ref", "ref"),
                        Map.entry("path", "path"),
                        Map.entry("recursive", "true"),
                        Map.entry("with_last_commit", "true"),
                        Map.entry("page_token", "page_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesListTreeFilter filter = GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                .ref("ref")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesListTreeFilter filter = GitLabProjectRepositoriesListTreeFilterBuilder.builder()
                .ref("ref")
                .path("path")
                .recursive(true)
                .withLastCommit(true)
                .pageToken("page_token")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
