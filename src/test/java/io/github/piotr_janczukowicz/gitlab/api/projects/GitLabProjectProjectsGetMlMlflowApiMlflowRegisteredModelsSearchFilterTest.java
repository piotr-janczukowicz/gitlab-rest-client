package io.github.piotr_janczukowicz.gitlab.api.projects;

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
class GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFilterIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                                        .filter("filter")
                                        .maxResults(1)
                                        .orderBy(List.of("text"))
                                        .pageToken("page_token")
                                        .build())
                        .filter(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter built = builder.build();

        assertThat(built.filter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxResultsIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                                        .filter("filter")
                                        .maxResults(1)
                                        .orderBy(List.of("text"))
                                        .pageToken("page_token")
                                        .build())
                        .maxResults(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter built = builder.build();

        assertThat(built.maxResults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                                        .filter("filter")
                                        .maxResults(1)
                                        .orderBy(List.of("text"))
                                        .pageToken("page_token")
                                        .build())
                        .orderBy(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder builder =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                                        .filter("filter")
                                        .maxResults(1)
                                        .orderBy(List.of("text"))
                                        .pageToken("page_token")
                                        .build())
                        .pageToken(null);

        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter value =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                        .filter("filter")
                        .maxResults(1)
                        .orderBy(List.of("text"))
                        .pageToken("page_token")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.filter()).isEqualTo("filter");
            softly.assertThat(value.maxResults()).isEqualTo(1);
            softly.assertThat(value.orderBy()).isEqualTo(List.of("text"));
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter original =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                        .filter("filter")
                        .maxResults(1)
                        .orderBy(List.of("text"))
                        .pageToken("page_token")
                        .build();

        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter rebuilt =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenOrderBySourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("text"));
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter built =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder(
                                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                                        .filter("filter")
                                        .maxResults(1)
                                        .orderBy(List.of("text"))
                                        .pageToken("page_token")
                                        .build())
                        .orderBy(source)
                        .build();
        source.clear();

        assertThat(built.orderBy()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenOrderByIsRead() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter built =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                        .filter("filter")
                        .maxResults(1)
                        .orderBy(List.of("text"))
                        .pageToken("page_token")
                        .build();
        final List<String> values = built.orderBy();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter value =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                        .filter("filter")
                        .maxResults(1)
                        .orderBy(List.of("text"))
                        .pageToken("page_token")
                        .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filter", "maxResults", "orderBy", "pageToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter empty =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                        .filter("filter")
                        .maxResults(1)
                        .orderBy(List.of("text"))
                        .pageToken("page_token")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("filter", "filter"),
                        Map.entry("max_results", "1"),
                        Map.entry("order_by", "text"),
                        Map.entry("page_token", "page_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                        .filter("filter")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("filter", "filter"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilter filter =
                GitLabProjectProjectsGetMlMlflowApiMlflowRegisteredModelsSearchFilterBuilder.builder()
                        .filter("filter")
                        .maxResults(1)
                        .orderBy(List.of("text"))
                        .pageToken("page_token")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
