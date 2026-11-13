package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSiteStatusLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabGeoSiteStatusLinksBuilder builder = GitLabGeoSiteStatusLinksBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLinks())
                .self(null);

        final GitLabGeoSiteStatusLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSiteIsNullable() {
        final GitLabGeoSiteStatusLinksBuilder builder = GitLabGeoSiteStatusLinksBuilder.builder(
                        GeositesCatalogFixtures.geoSiteStatusLinks())
                .site(null);

        final GitLabGeoSiteStatusLinks built = builder.build();

        assertThat(built.site()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoSiteStatusLinks value = GeositesCatalogFixtures.geoSiteStatusLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.self()).isEqualTo("self");
            softly.assertThat(value.site()).isEqualTo("site");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoSiteStatusLinks original = GeositesCatalogFixtures.geoSiteStatusLinks();

        final GitLabGeoSiteStatusLinks rebuilt =
                GitLabGeoSiteStatusLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoSiteStatusLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "site");
    }
}
