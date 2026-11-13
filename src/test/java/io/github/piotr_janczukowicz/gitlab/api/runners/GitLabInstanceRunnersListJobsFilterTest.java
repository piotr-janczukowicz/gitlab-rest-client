package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceRunnersListJobsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSystemIdIsNullable() {
        final GitLabInstanceRunnersListJobsFilterBuilder builder = GitLabInstanceRunnersListJobsFilterBuilder.builder(
                        GitLabInstanceRunnersListJobsFilterBuilder.builder()
                                .systemId("system_id")
                                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                                .cursor("cursor")
                                .build())
                .systemId(null);

        final GitLabInstanceRunnersListJobsFilter built = builder.build();

        assertThat(built.systemId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabInstanceRunnersListJobsFilterBuilder builder = GitLabInstanceRunnersListJobsFilterBuilder.builder(
                        GitLabInstanceRunnersListJobsFilterBuilder.builder()
                                .systemId("system_id")
                                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                                .cursor("cursor")
                                .build())
                .status(null);

        final GitLabInstanceRunnersListJobsFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorIsNullable() {
        final GitLabInstanceRunnersListJobsFilterBuilder builder = GitLabInstanceRunnersListJobsFilterBuilder.builder(
                        GitLabInstanceRunnersListJobsFilterBuilder.builder()
                                .systemId("system_id")
                                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                                .cursor("cursor")
                                .build())
                .cursor(null);

        final GitLabInstanceRunnersListJobsFilter built = builder.build();

        assertThat(built.cursor()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersListJobsFilter value = GitLabInstanceRunnersListJobsFilterBuilder.builder()
                .systemId("system_id")
                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                .cursor("cursor")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.systemId()).isEqualTo("system_id");
            softly.assertThat(value.status()).isEqualTo(GitLabInstanceRunnersListJobsStatus.CREATED);
            softly.assertThat(value.cursor()).isEqualTo("cursor");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersListJobsFilter original = GitLabInstanceRunnersListJobsFilterBuilder.builder()
                .systemId("system_id")
                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                .cursor("cursor")
                .build();

        final GitLabInstanceRunnersListJobsFilter rebuilt =
                GitLabInstanceRunnersListJobsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceRunnersListJobsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("systemId", "status", "cursor");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceRunnersListJobsFilter empty = GitLabInstanceRunnersListJobsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceRunnersListJobsFilter filter = GitLabInstanceRunnersListJobsFilterBuilder.builder()
                .systemId("system_id")
                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                .cursor("cursor")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("system_id", "system_id"),
                        Map.entry("status", "created"),
                        Map.entry("cursor", "cursor"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceRunnersListJobsFilter filter = GitLabInstanceRunnersListJobsFilterBuilder.builder()
                .systemId("system_id")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("system_id", "system_id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceRunnersListJobsFilter filter = GitLabInstanceRunnersListJobsFilterBuilder.builder()
                .systemId("system_id")
                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                .cursor("cursor")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
