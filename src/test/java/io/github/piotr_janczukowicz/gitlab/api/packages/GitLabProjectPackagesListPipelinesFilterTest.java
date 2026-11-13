package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesListPipelinesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenCursorIsNullable() {
        final GitLabProjectPackagesListPipelinesFilterBuilder builder =
                GitLabProjectPackagesListPipelinesFilterBuilder.builder(
                                GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                                        .cursor("cursor")
                                        .build())
                        .cursor(null);

        final GitLabProjectPackagesListPipelinesFilter built = builder.build();

        assertThat(built.cursor()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesListPipelinesFilter value = GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                .cursor("cursor")
                .build();

        assertThat(value.cursor()).isEqualTo("cursor");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesListPipelinesFilter original =
                GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                        .cursor("cursor")
                        .build();

        final GitLabProjectPackagesListPipelinesFilter rebuilt =
                GitLabProjectPackagesListPipelinesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPackagesListPipelinesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cursor");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPackagesListPipelinesFilter empty = GitLabProjectPackagesListPipelinesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPackagesListPipelinesFilter filter =
                GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                        .cursor("cursor")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("cursor", "cursor"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPackagesListPipelinesFilter filter =
                GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                        .cursor("cursor")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("cursor", "cursor"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPackagesListPipelinesFilter filter =
                GitLabProjectPackagesListPipelinesFilterBuilder.builder()
                        .cursor("cursor")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
