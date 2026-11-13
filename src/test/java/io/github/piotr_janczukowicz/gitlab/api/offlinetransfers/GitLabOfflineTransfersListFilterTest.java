package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabOfflineTransfersListFilterBuilder builder = GitLabOfflineTransfersListFilterBuilder.builder(
                        GitLabOfflineTransfersListFilterBuilder.builder()
                                .sort(GitLabOfflineTransfersListSort.ASC)
                                .status(GitLabOfflineTransfersListStatus.CREATED)
                                .build())
                .sort(null);

        final GitLabOfflineTransfersListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabOfflineTransfersListFilterBuilder builder = GitLabOfflineTransfersListFilterBuilder.builder(
                        GitLabOfflineTransfersListFilterBuilder.builder()
                                .sort(GitLabOfflineTransfersListSort.ASC)
                                .status(GitLabOfflineTransfersListStatus.CREATED)
                                .build())
                .status(null);

        final GitLabOfflineTransfersListFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersListFilter value = GitLabOfflineTransfersListFilterBuilder.builder()
                .sort(GitLabOfflineTransfersListSort.ASC)
                .status(GitLabOfflineTransfersListStatus.CREATED)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sort()).isEqualTo(GitLabOfflineTransfersListSort.ASC);
            softly.assertThat(value.status()).isEqualTo(GitLabOfflineTransfersListStatus.CREATED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersListFilter original = GitLabOfflineTransfersListFilterBuilder.builder()
                .sort(GitLabOfflineTransfersListSort.ASC)
                .status(GitLabOfflineTransfersListStatus.CREATED)
                .build();

        final GitLabOfflineTransfersListFilter rebuilt =
                GitLabOfflineTransfersListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOfflineTransfersListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sort", "status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabOfflineTransfersListFilter empty = GitLabOfflineTransfersListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabOfflineTransfersListFilter filter = GitLabOfflineTransfersListFilterBuilder.builder()
                .sort(GitLabOfflineTransfersListSort.ASC)
                .status(GitLabOfflineTransfersListStatus.CREATED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"), Map.entry("status", "created"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabOfflineTransfersListFilter filter = GitLabOfflineTransfersListFilterBuilder.builder()
                .sort(GitLabOfflineTransfersListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabOfflineTransfersListFilter filter = GitLabOfflineTransfersListFilterBuilder.builder()
                .sort(GitLabOfflineTransfersListSort.ASC)
                .status(GitLabOfflineTransfersListStatus.CREATED)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
