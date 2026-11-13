package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceDeployTokensListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabInstanceDeployTokensListFilterBuilder builder = GitLabInstanceDeployTokensListFilterBuilder.builder(
                        GitLabInstanceDeployTokensListFilterBuilder.builder()
                                .active(true)
                                .build())
                .active(null);

        final GitLabInstanceDeployTokensListFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceDeployTokensListFilter value = GitLabInstanceDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        assertThat(value.active()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceDeployTokensListFilter original = GitLabInstanceDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        final GitLabInstanceDeployTokensListFilter rebuilt =
                GitLabInstanceDeployTokensListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceDeployTokensListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("active");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceDeployTokensListFilter empty = GitLabInstanceDeployTokensListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceDeployTokensListFilter filter = GitLabInstanceDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("active", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceDeployTokensListFilter filter = GitLabInstanceDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("active", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceDeployTokensListFilter filter = GitLabInstanceDeployTokensListFilterBuilder.builder()
                .active(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
