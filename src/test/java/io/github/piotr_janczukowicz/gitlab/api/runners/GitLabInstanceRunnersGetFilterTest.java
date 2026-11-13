package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceRunnersGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIncludeProjectsIsNullable() {
        final GitLabInstanceRunnersGetFilterBuilder builder = GitLabInstanceRunnersGetFilterBuilder.builder(
                        GitLabInstanceRunnersGetFilterBuilder.builder()
                                .includeProjects(true)
                                .build())
                .includeProjects(null);

        final GitLabInstanceRunnersGetFilter built = builder.build();

        assertThat(built.includeProjects()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersGetFilter value = GitLabInstanceRunnersGetFilterBuilder.builder()
                .includeProjects(true)
                .build();

        assertThat(value.includeProjects()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersGetFilter original = GitLabInstanceRunnersGetFilterBuilder.builder()
                .includeProjects(true)
                .build();

        final GitLabInstanceRunnersGetFilter rebuilt =
                GitLabInstanceRunnersGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceRunnersGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("includeProjects");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceRunnersGetFilter empty = GitLabInstanceRunnersGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceRunnersGetFilter filter = GitLabInstanceRunnersGetFilterBuilder.builder()
                .includeProjects(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_projects", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceRunnersGetFilter filter = GitLabInstanceRunnersGetFilterBuilder.builder()
                .includeProjects(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("include_projects", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceRunnersGetFilter filter = GitLabInstanceRunnersGetFilterBuilder.builder()
                .includeProjects(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
