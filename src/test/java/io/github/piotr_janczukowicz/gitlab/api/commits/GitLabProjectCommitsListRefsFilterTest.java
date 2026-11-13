package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsListRefsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectCommitsListRefsFilterBuilder builder = GitLabProjectCommitsListRefsFilterBuilder.builder(
                        GitLabProjectCommitsListRefsFilterBuilder.builder()
                                .type(GitLabProjectCommitsListRefsType.BRANCH)
                                .build())
                .type(null);

        final GitLabProjectCommitsListRefsFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsListRefsFilter value = GitLabProjectCommitsListRefsFilterBuilder.builder()
                .type(GitLabProjectCommitsListRefsType.BRANCH)
                .build();

        assertThat(value.type()).isEqualTo(GitLabProjectCommitsListRefsType.BRANCH);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsListRefsFilter original = GitLabProjectCommitsListRefsFilterBuilder.builder()
                .type(GitLabProjectCommitsListRefsType.BRANCH)
                .build();

        final GitLabProjectCommitsListRefsFilter rebuilt =
                GitLabProjectCommitsListRefsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsListRefsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("type");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectCommitsListRefsFilter empty = GitLabProjectCommitsListRefsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectCommitsListRefsFilter filter = GitLabProjectCommitsListRefsFilterBuilder.builder()
                .type(GitLabProjectCommitsListRefsType.BRANCH)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("type", "branch"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectCommitsListRefsFilter filter = GitLabProjectCommitsListRefsFilterBuilder.builder()
                .type(GitLabProjectCommitsListRefsType.BRANCH)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("type", "branch"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectCommitsListRefsFilter filter = GitLabProjectCommitsListRefsFilterBuilder.builder()
                .type(GitLabProjectCommitsListRefsType.BRANCH)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
