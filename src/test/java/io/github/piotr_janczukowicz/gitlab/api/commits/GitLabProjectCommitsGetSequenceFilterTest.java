package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsGetSequenceFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFirstParentIsNullable() {
        final GitLabProjectCommitsGetSequenceFilterBuilder builder =
                GitLabProjectCommitsGetSequenceFilterBuilder.builder(
                                GitLabProjectCommitsGetSequenceFilterBuilder.builder()
                                        .firstParent(true)
                                        .build())
                        .firstParent(null);

        final GitLabProjectCommitsGetSequenceFilter built = builder.build();

        assertThat(built.firstParent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsGetSequenceFilter value = GitLabProjectCommitsGetSequenceFilterBuilder.builder()
                .firstParent(true)
                .build();

        assertThat(value.firstParent()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsGetSequenceFilter original = GitLabProjectCommitsGetSequenceFilterBuilder.builder()
                .firstParent(true)
                .build();

        final GitLabProjectCommitsGetSequenceFilter rebuilt =
                GitLabProjectCommitsGetSequenceFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsGetSequenceFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("firstParent");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectCommitsGetSequenceFilter empty = GitLabProjectCommitsGetSequenceFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectCommitsGetSequenceFilter filter = GitLabProjectCommitsGetSequenceFilterBuilder.builder()
                .firstParent(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("first_parent", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectCommitsGetSequenceFilter filter = GitLabProjectCommitsGetSequenceFilterBuilder.builder()
                .firstParent(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("first_parent", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectCommitsGetSequenceFilter filter = GitLabProjectCommitsGetSequenceFilterBuilder.builder()
                .firstParent(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
