package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

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
class GitLabCodeSnippetsListAllFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabCodeSnippetsListAllFilterBuilder builder = GitLabCodeSnippetsListAllFilterBuilder.builder(
                        GitLabCodeSnippetsListAllFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .repositoryStorage("repository_storage")
                                .build())
                .createdAfter(null);

        final GitLabCodeSnippetsListAllFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabCodeSnippetsListAllFilterBuilder builder = GitLabCodeSnippetsListAllFilterBuilder.builder(
                        GitLabCodeSnippetsListAllFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .repositoryStorage("repository_storage")
                                .build())
                .createdBefore(null);

        final GitLabCodeSnippetsListAllFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabCodeSnippetsListAllFilterBuilder builder = GitLabCodeSnippetsListAllFilterBuilder.builder(
                        GitLabCodeSnippetsListAllFilterBuilder.builder()
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .repositoryStorage("repository_storage")
                                .build())
                .repositoryStorage(null);

        final GitLabCodeSnippetsListAllFilter built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSnippetsListAllFilter value = GitLabCodeSnippetsListAllFilterBuilder.builder()
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .repositoryStorage("repository_storage")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.repositoryStorage()).isEqualTo("repository_storage");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSnippetsListAllFilter original = GitLabCodeSnippetsListAllFilterBuilder.builder()
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .repositoryStorage("repository_storage")
                .build();

        final GitLabCodeSnippetsListAllFilter rebuilt =
                GitLabCodeSnippetsListAllFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSnippetsListAllFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("createdAfter", "createdBefore", "repositoryStorage");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabCodeSnippetsListAllFilter empty = GitLabCodeSnippetsListAllFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabCodeSnippetsListAllFilter filter = GitLabCodeSnippetsListAllFilterBuilder.builder()
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .repositoryStorage("repository_storage")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("repository_storage", "repository_storage"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabCodeSnippetsListAllFilter filter = GitLabCodeSnippetsListAllFilterBuilder.builder()
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("created_after", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabCodeSnippetsListAllFilter filter = GitLabCodeSnippetsListAllFilterBuilder.builder()
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .repositoryStorage("repository_storage")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
