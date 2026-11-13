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
class GitLabGroupAndProjectMigrationByDirectTransferListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder(
                                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                                        .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                                        .build())
                        .sort(null);

        final GitLabGroupAndProjectMigrationByDirectTransferListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder(
                                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                                        .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                                        .build())
                        .status(null);

        final GitLabGroupAndProjectMigrationByDirectTransferListFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilter value =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC);
            softly.assertThat(value.status())
                    .isEqualTo(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilter original =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                        .build();

        final GitLabGroupAndProjectMigrationByDirectTransferListFilter rebuilt =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupAndProjectMigrationByDirectTransferListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sort", "status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilter empty =
                GitLabGroupAndProjectMigrationByDirectTransferListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilter filter =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"), Map.entry("status", "created"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilter filter =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupAndProjectMigrationByDirectTransferListFilter filter =
                GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                        .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                        .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
