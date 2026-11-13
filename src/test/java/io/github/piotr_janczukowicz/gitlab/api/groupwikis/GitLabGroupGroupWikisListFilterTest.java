package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWikisListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWithContentIsNullable() {
        final GitLabGroupGroupWikisListFilterBuilder builder = GitLabGroupGroupWikisListFilterBuilder.builder(
                        GitLabGroupGroupWikisListFilterBuilder.builder()
                                .withContent(true)
                                .build())
                .withContent(null);

        final GitLabGroupGroupWikisListFilter built = builder.build();

        assertThat(built.withContent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWikisListFilter value = GitLabGroupGroupWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        assertThat(value.withContent()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWikisListFilter original = GitLabGroupGroupWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        final GitLabGroupGroupWikisListFilter rebuilt =
                GitLabGroupGroupWikisListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWikisListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("withContent");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupWikisListFilter empty = GitLabGroupGroupWikisListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupWikisListFilter filter = GitLabGroupGroupWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_content", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupWikisListFilter filter = GitLabGroupGroupWikisListFilterBuilder.builder()
                .withContent(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("with_content", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupWikisListFilter filter = GitLabGroupGroupWikisListFilterBuilder.builder()
                .withContent(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
