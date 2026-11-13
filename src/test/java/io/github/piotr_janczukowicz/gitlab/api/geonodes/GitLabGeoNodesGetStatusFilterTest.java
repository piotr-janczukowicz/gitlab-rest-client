package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodesGetStatusFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefreshIsNullable() {
        final GitLabGeoNodesGetStatusFilterBuilder builder = GitLabGeoNodesGetStatusFilterBuilder.builder(
                        GitLabGeoNodesGetStatusFilterBuilder.builder()
                                .refresh(true)
                                .build())
                .refresh(null);

        final GitLabGeoNodesGetStatusFilter built = builder.build();

        assertThat(built.refresh()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodesGetStatusFilter value =
                GitLabGeoNodesGetStatusFilterBuilder.builder().refresh(true).build();

        assertThat(value.refresh()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodesGetStatusFilter original =
                GitLabGeoNodesGetStatusFilterBuilder.builder().refresh(true).build();

        final GitLabGeoNodesGetStatusFilter rebuilt =
                GitLabGeoNodesGetStatusFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodesGetStatusFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("refresh");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGeoNodesGetStatusFilter empty = GitLabGeoNodesGetStatusFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGeoNodesGetStatusFilter filter =
                GitLabGeoNodesGetStatusFilterBuilder.builder().refresh(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("refresh", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGeoNodesGetStatusFilter filter =
                GitLabGeoNodesGetStatusFilterBuilder.builder().refresh(true).build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("refresh", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGeoNodesGetStatusFilter filter =
                GitLabGeoNodesGetStatusFilterBuilder.builder().refresh(true).build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
