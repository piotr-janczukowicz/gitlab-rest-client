package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDeployTokensListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabGroupDeployTokensListFilterBuilder builder = GitLabGroupDeployTokensListFilterBuilder.builder(
                        GitLabGroupDeployTokensListFilterBuilder.builder()
                                .active(true)
                                .build())
                .active(null);

        final GitLabGroupDeployTokensListFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDeployTokensListFilter value =
                GitLabGroupDeployTokensListFilterBuilder.builder().active(true).build();

        assertThat(value.active()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDeployTokensListFilter original =
                GitLabGroupDeployTokensListFilterBuilder.builder().active(true).build();

        final GitLabGroupDeployTokensListFilter rebuilt =
                GitLabGroupDeployTokensListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupDeployTokensListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("active");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupDeployTokensListFilter empty = GitLabGroupDeployTokensListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupDeployTokensListFilter filter =
                GitLabGroupDeployTokensListFilterBuilder.builder().active(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("active", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupDeployTokensListFilter filter =
                GitLabGroupDeployTokensListFilterBuilder.builder().active(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("active", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupDeployTokensListFilter filter =
                GitLabGroupDeployTokensListFilterBuilder.builder().active(true).build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
