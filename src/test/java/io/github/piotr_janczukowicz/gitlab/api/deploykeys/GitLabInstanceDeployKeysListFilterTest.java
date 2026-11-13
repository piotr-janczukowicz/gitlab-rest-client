package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceDeployKeysListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenPublicValueIsNullable() {
        final GitLabInstanceDeployKeysListFilterBuilder builder = GitLabInstanceDeployKeysListFilterBuilder.builder(
                        GitLabInstanceDeployKeysListFilterBuilder.builder()
                                .publicValue(true)
                                .build())
                .publicValue(null);

        final GitLabInstanceDeployKeysListFilter built = builder.build();

        assertThat(built.publicValue()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceDeployKeysListFilter value = GitLabInstanceDeployKeysListFilterBuilder.builder()
                .publicValue(true)
                .build();

        assertThat(value.publicValue()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceDeployKeysListFilter original = GitLabInstanceDeployKeysListFilterBuilder.builder()
                .publicValue(true)
                .build();

        final GitLabInstanceDeployKeysListFilter rebuilt =
                GitLabInstanceDeployKeysListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceDeployKeysListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("publicValue");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceDeployKeysListFilter empty = GitLabInstanceDeployKeysListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceDeployKeysListFilter filter = GitLabInstanceDeployKeysListFilterBuilder.builder()
                .publicValue(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("public", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceDeployKeysListFilter filter = GitLabInstanceDeployKeysListFilterBuilder.builder()
                .publicValue(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("public", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceDeployKeysListFilter filter = GitLabInstanceDeployKeysListFilterBuilder.builder()
                .publicValue(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
