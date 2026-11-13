package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEnvironmentsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEnvironmentsListFilterBuilder builder = GitLabProjectEnvironmentsListFilterBuilder.builder(
                        GitLabProjectEnvironmentsListFilterBuilder.builder()
                                .name("name")
                                .search("search")
                                .states(GitLabProjectEnvironmentsListStates.STOPPED)
                                .build())
                .name(null);

        final GitLabProjectEnvironmentsListFilter built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectEnvironmentsListFilterBuilder builder = GitLabProjectEnvironmentsListFilterBuilder.builder(
                        GitLabProjectEnvironmentsListFilterBuilder.builder()
                                .name("name")
                                .search("search")
                                .states(GitLabProjectEnvironmentsListStates.STOPPED)
                                .build())
                .search(null);

        final GitLabProjectEnvironmentsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatesIsNullable() {
        final GitLabProjectEnvironmentsListFilterBuilder builder = GitLabProjectEnvironmentsListFilterBuilder.builder(
                        GitLabProjectEnvironmentsListFilterBuilder.builder()
                                .name("name")
                                .search("search")
                                .states(GitLabProjectEnvironmentsListStates.STOPPED)
                                .build())
                .states(null);

        final GitLabProjectEnvironmentsListFilter built = builder.build();

        assertThat(built.states()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEnvironmentsListFilter value = GitLabProjectEnvironmentsListFilterBuilder.builder()
                .name("name")
                .search("search")
                .states(GitLabProjectEnvironmentsListStates.STOPPED)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.states()).isEqualTo(GitLabProjectEnvironmentsListStates.STOPPED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEnvironmentsListFilter original = GitLabProjectEnvironmentsListFilterBuilder.builder()
                .name("name")
                .search("search")
                .states(GitLabProjectEnvironmentsListStates.STOPPED)
                .build();

        final GitLabProjectEnvironmentsListFilter rebuilt =
                GitLabProjectEnvironmentsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEnvironmentsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "search", "states");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectEnvironmentsListFilter empty = GitLabProjectEnvironmentsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectEnvironmentsListFilter filter = GitLabProjectEnvironmentsListFilterBuilder.builder()
                .name("name")
                .search("search")
                .states(GitLabProjectEnvironmentsListStates.STOPPED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("name", "name"), Map.entry("search", "search"), Map.entry("states", "stopped"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectEnvironmentsListFilter filter = GitLabProjectEnvironmentsListFilterBuilder.builder()
                .name("name")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("name", "name"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectEnvironmentsListFilter filter = GitLabProjectEnvironmentsListFilterBuilder.builder()
                .name("name")
                .search("search")
                .states(GitLabProjectEnvironmentsListStates.STOPPED)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
