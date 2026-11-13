package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLabelsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIncludeAncestorGroupsIsNullable() {
        final GitLabGroupGroupLabelsGetFilterBuilder builder = GitLabGroupGroupLabelsGetFilterBuilder.builder(
                        GitLabGroupGroupLabelsGetFilterBuilder.builder()
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .build())
                .includeAncestorGroups(null);

        final GitLabGroupGroupLabelsGetFilter built = builder.build();

        assertThat(built.includeAncestorGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeDescendantGroupsIsNullable() {
        final GitLabGroupGroupLabelsGetFilterBuilder builder = GitLabGroupGroupLabelsGetFilterBuilder.builder(
                        GitLabGroupGroupLabelsGetFilterBuilder.builder()
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .build())
                .includeDescendantGroups(null);

        final GitLabGroupGroupLabelsGetFilter built = builder.build();

        assertThat(built.includeDescendantGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyGroupLabelsIsNullable() {
        final GitLabGroupGroupLabelsGetFilterBuilder builder = GitLabGroupGroupLabelsGetFilterBuilder.builder(
                        GitLabGroupGroupLabelsGetFilterBuilder.builder()
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .onlyGroupLabels(true)
                                .build())
                .onlyGroupLabels(null);

        final GitLabGroupGroupLabelsGetFilter built = builder.build();

        assertThat(built.onlyGroupLabels()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLabelsGetFilter value = GitLabGroupGroupLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.includeAncestorGroups()).isEqualTo(true);
            softly.assertThat(value.includeDescendantGroups()).isEqualTo(true);
            softly.assertThat(value.onlyGroupLabels()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLabelsGetFilter original = GitLabGroupGroupLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .build();

        final GitLabGroupGroupLabelsGetFilter rebuilt =
                GitLabGroupGroupLabelsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupLabelsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("includeAncestorGroups", "includeDescendantGroups", "onlyGroupLabels");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupLabelsGetFilter empty = GitLabGroupGroupLabelsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupLabelsGetFilter filter = GitLabGroupGroupLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("include_ancestor_groups", "true"),
                        Map.entry("include_descendant_groups", "true"),
                        Map.entry("only_group_labels", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupLabelsGetFilter filter = GitLabGroupGroupLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_ancestor_groups", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupLabelsGetFilter filter = GitLabGroupGroupLabelsGetFilterBuilder.builder()
                .includeAncestorGroups(true)
                .includeDescendantGroups(true)
                .onlyGroupLabels(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
