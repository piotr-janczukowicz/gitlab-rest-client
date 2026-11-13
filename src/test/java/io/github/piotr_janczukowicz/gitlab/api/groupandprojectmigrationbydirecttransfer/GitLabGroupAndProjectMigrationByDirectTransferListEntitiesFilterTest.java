package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder(
                                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                                        .status(
                                                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus
                                                        .CREATED)
                                        .build())
                        .sort(null);

        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder(
                                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                                        .status(
                                                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus
                                                        .CREATED)
                                        .build())
                        .status(null);

        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter value =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.CREATED)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sort())
                    .isEqualTo(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC);
            softly.assertThat(value.status())
                    .isEqualTo(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.CREATED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter original =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.CREATED)
                        .build();

        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter rebuilt =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sort", "status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter empty =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter filter =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.CREATED)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"), Map.entry("status", "created"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter filter =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilter filter =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.CREATED)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
