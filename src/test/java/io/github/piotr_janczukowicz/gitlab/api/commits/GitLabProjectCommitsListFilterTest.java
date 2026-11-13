package io.github.piotr_janczukowicz.gitlab.api.commits;

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
class GitLabProjectCommitsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefNameIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .refName(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.refName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSinceIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .since(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.since()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUntilIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .until(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.until()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .path(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .follow(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.follow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .author(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .all(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.all()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithStatsIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .withStats(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.withStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFirstParentIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .firstParent(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.firstParent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .order(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.order()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrailersIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .trailers(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.trailers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectCommitsListFilterBuilder builder = GitLabProjectCommitsListFilterBuilder.builder(
                        GitLabProjectCommitsListFilterBuilder.builder()
                                .refName("ref_name")
                                .since(Instant.parse("2026-01-01T00:00:00Z"))
                                .until(Instant.parse("2026-01-01T00:00:00Z"))
                                .path("path")
                                .follow(true)
                                .author("author")
                                .all(true)
                                .withStats(true)
                                .firstParent(true)
                                .order(GitLabProjectCommitsListOrder.DEFAULT)
                                .trailers(true)
                                .pageToken("page_token")
                                .build())
                .pageToken(null);

        final GitLabProjectCommitsListFilter built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsListFilter value = GitLabProjectCommitsListFilterBuilder.builder()
                .refName("ref_name")
                .since(Instant.parse("2026-01-01T00:00:00Z"))
                .until(Instant.parse("2026-01-01T00:00:00Z"))
                .path("path")
                .follow(true)
                .author("author")
                .all(true)
                .withStats(true)
                .firstParent(true)
                .order(GitLabProjectCommitsListOrder.DEFAULT)
                .trailers(true)
                .pageToken("page_token")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.refName()).isEqualTo("ref_name");
            softly.assertThat(value.since()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.until()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.path()).isEqualTo("path");
            softly.assertThat(value.follow()).isEqualTo(true);
            softly.assertThat(value.author()).isEqualTo("author");
            softly.assertThat(value.all()).isEqualTo(true);
            softly.assertThat(value.withStats()).isEqualTo(true);
            softly.assertThat(value.firstParent()).isEqualTo(true);
            softly.assertThat(value.order()).isEqualTo(GitLabProjectCommitsListOrder.DEFAULT);
            softly.assertThat(value.trailers()).isEqualTo(true);
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsListFilter original = GitLabProjectCommitsListFilterBuilder.builder()
                .refName("ref_name")
                .since(Instant.parse("2026-01-01T00:00:00Z"))
                .until(Instant.parse("2026-01-01T00:00:00Z"))
                .path("path")
                .follow(true)
                .author("author")
                .all(true)
                .withStats(true)
                .firstParent(true)
                .order(GitLabProjectCommitsListOrder.DEFAULT)
                .trailers(true)
                .pageToken("page_token")
                .build();

        final GitLabProjectCommitsListFilter rebuilt =
                GitLabProjectCommitsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectCommitsListFilter value = GitLabProjectCommitsListFilterBuilder.builder()
                .refName("ref_name")
                .since(Instant.parse("2026-01-01T00:00:00Z"))
                .until(Instant.parse("2026-01-01T00:00:00Z"))
                .path("path")
                .follow(true)
                .author("author")
                .all(true)
                .withStats(true)
                .firstParent(true)
                .order(GitLabProjectCommitsListOrder.DEFAULT)
                .trailers(true)
                .pageToken("page_token")
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "refName",
                        "since",
                        "until",
                        "path",
                        "follow",
                        "author",
                        "all",
                        "withStats",
                        "firstParent",
                        "order",
                        "trailers",
                        "pageToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectCommitsListFilter empty = GitLabProjectCommitsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectCommitsListFilter filter = GitLabProjectCommitsListFilterBuilder.builder()
                .refName("ref_name")
                .since(Instant.parse("2026-01-01T00:00:00Z"))
                .until(Instant.parse("2026-01-01T00:00:00Z"))
                .path("path")
                .follow(true)
                .author("author")
                .all(true)
                .withStats(true)
                .firstParent(true)
                .order(GitLabProjectCommitsListOrder.DEFAULT)
                .trailers(true)
                .pageToken("page_token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("ref_name", "ref_name"),
                        Map.entry("since", "2026-01-01T00:00:00Z"),
                        Map.entry("until", "2026-01-01T00:00:00Z"),
                        Map.entry("path", "path"),
                        Map.entry("follow", "true"),
                        Map.entry("author", "author"),
                        Map.entry("all", "true"),
                        Map.entry("with_stats", "true"),
                        Map.entry("first_parent", "true"),
                        Map.entry("order", "default"),
                        Map.entry("trailers", "true"),
                        Map.entry("page_token", "page_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectCommitsListFilter filter = GitLabProjectCommitsListFilterBuilder.builder()
                .refName("ref_name")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref_name", "ref_name"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectCommitsListFilter filter = GitLabProjectCommitsListFilterBuilder.builder()
                .refName("ref_name")
                .since(Instant.parse("2026-01-01T00:00:00Z"))
                .until(Instant.parse("2026-01-01T00:00:00Z"))
                .path("path")
                .follow(true)
                .author("author")
                .all(true)
                .withStats(true)
                .firstParent(true)
                .order(GitLabProjectCommitsListOrder.DEFAULT)
                .trailers(true)
                .pageToken("page_token")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
