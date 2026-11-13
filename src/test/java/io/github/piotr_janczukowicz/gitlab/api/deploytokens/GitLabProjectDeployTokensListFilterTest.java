package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDeployTokensListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabProjectDeployTokensListFilterBuilder builder = GitLabProjectDeployTokensListFilterBuilder.builder(
                        GitLabProjectDeployTokensListFilterBuilder.builder()
                                .active(true)
                                .build())
                .active(null);

        final GitLabProjectDeployTokensListFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeployTokensListFilter value = GitLabProjectDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        assertThat(value.active()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeployTokensListFilter original = GitLabProjectDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        final GitLabProjectDeployTokensListFilter rebuilt =
                GitLabProjectDeployTokensListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeployTokensListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("active");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectDeployTokensListFilter empty = GitLabProjectDeployTokensListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectDeployTokensListFilter filter = GitLabProjectDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("active", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectDeployTokensListFilter filter = GitLabProjectDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("active", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectDeployTokensListFilter filter = GitLabProjectDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
