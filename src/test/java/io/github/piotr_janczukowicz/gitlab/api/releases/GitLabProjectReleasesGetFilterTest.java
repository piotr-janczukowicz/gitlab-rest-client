package io.github.piotr_janczukowicz.gitlab.api.releases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectReleasesGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIncludeHtmlDescriptionIsNullable() {
        final GitLabProjectReleasesGetFilterBuilder builder = GitLabProjectReleasesGetFilterBuilder.builder(
                        GitLabProjectReleasesGetFilterBuilder.builder()
                                .includeHtmlDescription(true)
                                .build())
                .includeHtmlDescription(null);

        final GitLabProjectReleasesGetFilter built = builder.build();

        assertThat(built.includeHtmlDescription()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleasesGetFilter value = GitLabProjectReleasesGetFilterBuilder.builder()
                .includeHtmlDescription(true)
                .build();

        assertThat(value.includeHtmlDescription()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleasesGetFilter original = GitLabProjectReleasesGetFilterBuilder.builder()
                .includeHtmlDescription(true)
                .build();

        final GitLabProjectReleasesGetFilter rebuilt =
                GitLabProjectReleasesGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleasesGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("includeHtmlDescription");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectReleasesGetFilter empty = GitLabProjectReleasesGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectReleasesGetFilter filter = GitLabProjectReleasesGetFilterBuilder.builder()
                .includeHtmlDescription(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_html_description", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectReleasesGetFilter filter = GitLabProjectReleasesGetFilterBuilder.builder()
                .includeHtmlDescription(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_html_description", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectReleasesGetFilter filter = GitLabProjectReleasesGetFilterBuilder.builder()
                .includeHtmlDescription(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
