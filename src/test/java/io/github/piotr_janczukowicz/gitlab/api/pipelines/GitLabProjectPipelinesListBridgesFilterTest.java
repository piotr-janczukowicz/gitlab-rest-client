package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesListBridgesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectPipelinesListBridgesFilterBuilder builder =
                GitLabProjectPipelinesListBridgesFilterBuilder.builder(
                                GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                                        .scope(List.of("text"))
                                        .build())
                        .scope(null);

        final GitLabProjectPipelinesListBridgesFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesListBridgesFilter value = GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                .scope(List.of("text"))
                .build();

        assertThat(value.scope()).isEqualTo(List.of("text"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesListBridgesFilter original =
                GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                        .scope(List.of("text"))
                        .build();

        final GitLabProjectPipelinesListBridgesFilter rebuilt =
                GitLabProjectPipelinesListBridgesFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopeSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("text"));
        final GitLabProjectPipelinesListBridgesFilter built = GitLabProjectPipelinesListBridgesFilterBuilder.builder(
                        GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                                .scope(List.of("text"))
                                .build())
                .scope(source)
                .build();
        source.clear();

        assertThat(built.scope()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopeIsRead() {
        final GitLabProjectPipelinesListBridgesFilter built = GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                .scope(List.of("text"))
                .build();
        final List<String> values = built.scope();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesListBridgesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPipelinesListBridgesFilter empty = GitLabProjectPipelinesListBridgesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPipelinesListBridgesFilter filter = GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                .scope(List.of("text"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "text"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPipelinesListBridgesFilter filter = GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                .scope(List.of("text"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "text"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPipelinesListBridgesFilter filter = GitLabProjectPipelinesListBridgesFilterBuilder.builder()
                .scope(List.of("text"))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
