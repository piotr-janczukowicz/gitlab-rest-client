package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectFeatureFlagsListFilterBuilder builder = GitLabProjectFeatureFlagsListFilterBuilder.builder(
                        GitLabProjectFeatureFlagsListFilterBuilder.builder()
                                .scope(GitLabProjectFeatureFlagsListScope.ENABLED)
                                .build())
                .scope(null);

        final GitLabProjectFeatureFlagsListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsListFilter value = GitLabProjectFeatureFlagsListFilterBuilder.builder()
                .scope(GitLabProjectFeatureFlagsListScope.ENABLED)
                .build();

        assertThat(value.scope()).isEqualTo(GitLabProjectFeatureFlagsListScope.ENABLED);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsListFilter original = GitLabProjectFeatureFlagsListFilterBuilder.builder()
                .scope(GitLabProjectFeatureFlagsListScope.ENABLED)
                .build();

        final GitLabProjectFeatureFlagsListFilter rebuilt =
                GitLabProjectFeatureFlagsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectFeatureFlagsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectFeatureFlagsListFilter empty = GitLabProjectFeatureFlagsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectFeatureFlagsListFilter filter = GitLabProjectFeatureFlagsListFilterBuilder.builder()
                .scope(GitLabProjectFeatureFlagsListScope.ENABLED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "enabled"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectFeatureFlagsListFilter filter = GitLabProjectFeatureFlagsListFilterBuilder.builder()
                .scope(GitLabProjectFeatureFlagsListScope.ENABLED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "enabled"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectFeatureFlagsListFilter filter = GitLabProjectFeatureFlagsListFilterBuilder.builder()
                .scope(GitLabProjectFeatureFlagsListScope.ENABLED)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
