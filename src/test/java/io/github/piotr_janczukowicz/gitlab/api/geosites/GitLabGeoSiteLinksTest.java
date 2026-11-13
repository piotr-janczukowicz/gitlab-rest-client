package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabGeoSiteLinksBuilder builder = GitLabGeoSiteLinksBuilder.builder(
                        GeositesCatalogFixtures.geoSiteLinks())
                .self(null);

        final GitLabGeoSiteLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGeoSiteLinksBuilder builder = GitLabGeoSiteLinksBuilder.builder(
                        GeositesCatalogFixtures.geoSiteLinks())
                .status(null);

        final GitLabGeoSiteLinks built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepairIsNullable() {
        final GitLabGeoSiteLinksBuilder builder = GitLabGeoSiteLinksBuilder.builder(
                        GeositesCatalogFixtures.geoSiteLinks())
                .repair(null);

        final GitLabGeoSiteLinks built = builder.build();

        assertThat(built.repair()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteLinks value = GeositesCatalogFixtures.geoSiteLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.self()).isEqualTo("self");
            softly.assertThat(value.status()).isEqualTo("status");
            softly.assertThat(value.repair()).isEqualTo("repair");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteLinks original = GeositesCatalogFixtures.geoSiteLinks();

        final GitLabGeoSiteLinks rebuilt =
                GitLabGeoSiteLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "status", "repair");
    }
}
