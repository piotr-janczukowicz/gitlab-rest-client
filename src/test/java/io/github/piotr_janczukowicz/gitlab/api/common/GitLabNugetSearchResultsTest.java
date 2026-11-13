package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetSearchResultsTest {

    @Test
    void constructor_shouldAcceptNull_whenTotalHitsIsNullable() {
        final GitLabNugetSearchResultsBuilder builder = GitLabNugetSearchResultsBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResults())
                .totalHits(null);

        final GitLabNugetSearchResults built = builder.build();

        assertThat(built.totalHits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabNugetSearchResultsBuilder builder = GitLabNugetSearchResultsBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResults())
                .data(null);

        final GitLabNugetSearchResults built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetSearchResults value = CommonCatalogFixtures.nugetSearchResults();

        assertSoftly(softly -> {
            softly.assertThat(value.totalHits()).isEqualTo(1);
            softly.assertThat(value.data()).isEqualTo(List.of(CommonCatalogFixtures.nugetSearchResult()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetSearchResults original = CommonCatalogFixtures.nugetSearchResults();

        final GitLabNugetSearchResults rebuilt =
                GitLabNugetSearchResultsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetSearchResults.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("totalHits", "data");
    }
}
