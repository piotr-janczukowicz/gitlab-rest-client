package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespacesGetExistsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabNamespacesGetExistsFilterBuilder builder = GitLabNamespacesGetExistsFilterBuilder.builder(
                        GitLabNamespacesGetExistsFilterBuilder.builder()
                                .parentId(1L)
                                .build())
                .parentId(null);

        final GitLabNamespacesGetExistsFilter built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespacesGetExistsFilter value =
                GitLabNamespacesGetExistsFilterBuilder.builder().parentId(1L).build();

        assertThat(value.parentId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespacesGetExistsFilter original =
                GitLabNamespacesGetExistsFilterBuilder.builder().parentId(1L).build();

        final GitLabNamespacesGetExistsFilter rebuilt =
                GitLabNamespacesGetExistsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespacesGetExistsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("parentId");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabNamespacesGetExistsFilter empty = GitLabNamespacesGetExistsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabNamespacesGetExistsFilter filter =
                GitLabNamespacesGetExistsFilterBuilder.builder().parentId(1L).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("parent_id", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabNamespacesGetExistsFilter filter =
                GitLabNamespacesGetExistsFilterBuilder.builder().parentId(1L).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("parent_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabNamespacesGetExistsFilter filter =
                GitLabNamespacesGetExistsFilterBuilder.builder().parentId(1L).build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
