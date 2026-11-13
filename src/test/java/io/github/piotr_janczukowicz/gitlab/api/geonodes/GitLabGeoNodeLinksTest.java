package io.github.piotr_janczukowicz.gitlab.api.geonodes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabGeoNodeLinksBuilder builder = GitLabGeoNodeLinksBuilder.builder(
                        GeonodesCatalogFixtures.geoNodeLinks())
                .self(null);

        final GitLabGeoNodeLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGeoNodeLinksBuilder builder = GitLabGeoNodeLinksBuilder.builder(
                        GeonodesCatalogFixtures.geoNodeLinks())
                .status(null);

        final GitLabGeoNodeLinks built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepairIsNullable() {
        final GitLabGeoNodeLinksBuilder builder = GitLabGeoNodeLinksBuilder.builder(
                        GeonodesCatalogFixtures.geoNodeLinks())
                .repair(null);

        final GitLabGeoNodeLinks built = builder.build();

        assertThat(built.repair()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeLinks value = GeonodesCatalogFixtures.geoNodeLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.self()).isEqualTo("self");
            softly.assertThat(value.status()).isEqualTo("status");
            softly.assertThat(value.repair()).isEqualTo("repair");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeLinks original = GeonodesCatalogFixtures.geoNodeLinks();

        final GitLabGeoNodeLinks rebuilt =
                GitLabGeoNodeLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "status", "repair");
    }
}
