package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDataManagementListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIdentifiersIsNullable() {
        final GitLabDataManagementListFilterBuilder builder = GitLabDataManagementListFilterBuilder.builder(
                        GitLabDataManagementListFilterBuilder.builder()
                                .identifiers(List.of("identifiers"))
                                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                                .cursor("cursor")
                                .sort(GitLabDataManagementListSort.ASC)
                                .build())
                .identifiers(null);

        final GitLabDataManagementListFilter built = builder.build();

        assertThat(built.identifiers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumStateIsNullable() {
        final GitLabDataManagementListFilterBuilder builder = GitLabDataManagementListFilterBuilder.builder(
                        GitLabDataManagementListFilterBuilder.builder()
                                .identifiers(List.of("identifiers"))
                                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                                .cursor("cursor")
                                .sort(GitLabDataManagementListSort.ASC)
                                .build())
                .checksumState(null);

        final GitLabDataManagementListFilter built = builder.build();

        assertThat(built.checksumState()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCursorIsNullable() {
        final GitLabDataManagementListFilterBuilder builder = GitLabDataManagementListFilterBuilder.builder(
                        GitLabDataManagementListFilterBuilder.builder()
                                .identifiers(List.of("identifiers"))
                                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                                .cursor("cursor")
                                .sort(GitLabDataManagementListSort.ASC)
                                .build())
                .cursor(null);

        final GitLabDataManagementListFilter built = builder.build();

        assertThat(built.cursor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabDataManagementListFilterBuilder builder = GitLabDataManagementListFilterBuilder.builder(
                        GitLabDataManagementListFilterBuilder.builder()
                                .identifiers(List.of("identifiers"))
                                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                                .cursor("cursor")
                                .sort(GitLabDataManagementListSort.ASC)
                                .build())
                .sort(null);

        final GitLabDataManagementListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDataManagementListFilter value = GitLabDataManagementListFilterBuilder.builder()
                .identifiers(List.of("identifiers"))
                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                .cursor("cursor")
                .sort(GitLabDataManagementListSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.identifiers()).isEqualTo(List.of("identifiers"));
            softly.assertThat(value.checksumState()).isEqualTo(GitLabDataManagementListChecksumState.PENDING);
            softly.assertThat(value.cursor()).isEqualTo("cursor");
            softly.assertThat(value.sort()).isEqualTo(GitLabDataManagementListSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDataManagementListFilter original = GitLabDataManagementListFilterBuilder.builder()
                .identifiers(List.of("identifiers"))
                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                .cursor("cursor")
                .sort(GitLabDataManagementListSort.ASC)
                .build();

        final GitLabDataManagementListFilter rebuilt =
                GitLabDataManagementListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenIdentifiersSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("identifiers"));
        final GitLabDataManagementListFilter built = GitLabDataManagementListFilterBuilder.builder(
                        GitLabDataManagementListFilterBuilder.builder()
                                .identifiers(List.of("identifiers"))
                                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                                .cursor("cursor")
                                .sort(GitLabDataManagementListSort.ASC)
                                .build())
                .identifiers(source)
                .build();
        source.clear();

        assertThat(built.identifiers()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenIdentifiersIsRead() {
        final GitLabDataManagementListFilter built = GitLabDataManagementListFilterBuilder.builder()
                .identifiers(List.of("identifiers"))
                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                .cursor("cursor")
                .sort(GitLabDataManagementListSort.ASC)
                .build();
        final List<String> values = built.identifiers();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDataManagementListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("identifiers", "checksumState", "cursor", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabDataManagementListFilter empty = GitLabDataManagementListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabDataManagementListFilter filter = GitLabDataManagementListFilterBuilder.builder()
                .identifiers(List.of("identifiers"))
                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                .cursor("cursor")
                .sort(GitLabDataManagementListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("identifiers", "identifiers"),
                        Map.entry("checksum_state", "pending"),
                        Map.entry("cursor", "cursor"),
                        Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabDataManagementListFilter filter = GitLabDataManagementListFilterBuilder.builder()
                .identifiers(List.of("identifiers"))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("identifiers", "identifiers"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabDataManagementListFilter filter = GitLabDataManagementListFilterBuilder.builder()
                .identifiers(List.of("identifiers"))
                .checksumState(GitLabDataManagementListChecksumState.PENDING)
                .cursor("cursor")
                .sort(GitLabDataManagementListSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
