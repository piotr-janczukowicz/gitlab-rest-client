package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenMaxResultsIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                                        .maxResults(1)
                                        .pageToken("page_token")
                                        .build())
                        .maxResults(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter built = builder.build();

        assertThat(built.maxResults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                                        .maxResults(1)
                                        .pageToken("page_token")
                                        .build())
                        .pageToken(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter value =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                        .maxResults(1)
                        .pageToken("page_token")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.maxResults()).isEqualTo(1);
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter original =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                        .maxResults(1)
                        .pageToken("page_token")
                        .build();

        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter rebuilt =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter value =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                        .maxResults(1)
                        .pageToken("page_token")
                        .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("maxResults", "pageToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter empty =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                        .maxResults(1)
                        .pageToken("page_token")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("max_results", "1"), Map.entry("page_token", "page_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                        .maxResults(1)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("max_results", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowExperimentsListFilterBuilder.builder()
                        .maxResults(1)
                        .pageToken("page_token")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
