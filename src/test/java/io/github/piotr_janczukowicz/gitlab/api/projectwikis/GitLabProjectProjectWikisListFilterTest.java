package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWikisListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithContentIsNullable() {
        final GitLabProjectProjectWikisListFilterBuilder builder = GitLabProjectProjectWikisListFilterBuilder.builder(
                        GitLabProjectProjectWikisListFilterBuilder.builder()
                                .withContent(true)
                                .build())
                .withContent(null);

        final GitLabProjectProjectWikisListFilter built = builder.build();

        assertThat(built.withContent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWikisListFilter value = GitLabProjectProjectWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        assertThat(value.withContent()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWikisListFilter original = GitLabProjectProjectWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        final GitLabProjectProjectWikisListFilter rebuilt =
                GitLabProjectProjectWikisListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWikisListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("withContent");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectWikisListFilter empty = GitLabProjectProjectWikisListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectWikisListFilter filter = GitLabProjectProjectWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_content", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectWikisListFilter filter = GitLabProjectProjectWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_content", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectWikisListFilter filter = GitLabProjectProjectWikisListFilterBuilder.builder()
                .withContent(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
