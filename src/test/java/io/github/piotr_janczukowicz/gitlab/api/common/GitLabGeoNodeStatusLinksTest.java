package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoNodeStatusLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabGeoNodeStatusLinksBuilder builder = GitLabGeoNodeStatusLinksBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusLinks())
                .self(null);

        final GitLabGeoNodeStatusLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNodeIsNullable() {
        final GitLabGeoNodeStatusLinksBuilder builder = GitLabGeoNodeStatusLinksBuilder.builder(
                        CommonCatalogFixtures.geoNodeStatusLinks())
                .node(null);

        final GitLabGeoNodeStatusLinks built = builder.build();

        assertThat(built.node()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoNodeStatusLinks value = CommonCatalogFixtures.geoNodeStatusLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.self()).isEqualTo("self");
            softly.assertThat(value.node()).isEqualTo("node");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoNodeStatusLinks original = CommonCatalogFixtures.geoNodeStatusLinks();

        final GitLabGeoNodeStatusLinks rebuilt =
                GitLabGeoNodeStatusLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoNodeStatusLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "node");
    }
}
