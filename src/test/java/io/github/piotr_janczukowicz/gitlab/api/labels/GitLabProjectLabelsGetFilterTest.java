package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorGroupsIsNullable() {
        final GitLabProjectLabelsGetFilterBuilder builder = GitLabProjectLabelsGetFilterBuilder.builder(
                        GitLabProjectLabelsGetFilterBuilder.builder()
                                .includeAncestorGroups(true)
                                .build())
                .includeAncestorGroups(null);

        final GitLabProjectLabelsGetFilter built = builder.build();

        assertThat(built.includeAncestorGroups()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabelsGetFilter value = GitLabProjectLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .build();

        assertThat(value.includeAncestorGroups()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabelsGetFilter original = GitLabProjectLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .build();

        final GitLabProjectLabelsGetFilter rebuilt =
                GitLabProjectLabelsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabelsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("includeAncestorGroups");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectLabelsGetFilter empty = GitLabProjectLabelsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectLabelsGetFilter filter = GitLabProjectLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_ancestor_groups", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectLabelsGetFilter filter = GitLabProjectLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_ancestor_groups", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectLabelsGetFilter filter = GitLabProjectLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
