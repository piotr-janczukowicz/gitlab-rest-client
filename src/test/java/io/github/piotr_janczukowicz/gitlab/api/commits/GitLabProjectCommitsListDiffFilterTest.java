package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsListDiffFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUnidiffIsNullable() {
        final GitLabProjectCommitsListDiffFilterBuilder builder = GitLabProjectCommitsListDiffFilterBuilder.builder(
                        GitLabProjectCommitsListDiffFilterBuilder.builder()
                                .unidiff(true)
                                .build())
                .unidiff(null);

        final GitLabProjectCommitsListDiffFilter built = builder.build();

        assertThat(built.unidiff()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsListDiffFilter value = GitLabProjectCommitsListDiffFilterBuilder.builder()
                .unidiff(true)
                .build();

        assertThat(value.unidiff()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsListDiffFilter original = GitLabProjectCommitsListDiffFilterBuilder.builder()
                .unidiff(true)
                .build();

        final GitLabProjectCommitsListDiffFilter rebuilt =
                GitLabProjectCommitsListDiffFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsListDiffFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("unidiff");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectCommitsListDiffFilter empty = GitLabProjectCommitsListDiffFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectCommitsListDiffFilter filter = GitLabProjectCommitsListDiffFilterBuilder.builder()
                .unidiff(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectCommitsListDiffFilter filter = GitLabProjectCommitsListDiffFilterBuilder.builder()
                .unidiff(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectCommitsListDiffFilter filter = GitLabProjectCommitsListDiffFilterBuilder.builder()
                .unidiff(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
