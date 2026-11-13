package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoReceivePackDataTest {

    @Test
    void constructor_shouldAcceptNull_whenGlIdIsNullable() {
        final GitLabGeoReceivePackDataBuilder builder = GitLabGeoReceivePackDataBuilder.builder(
                        GeoCatalogFixtures.geoReceivePackData())
                .glId(null);

        final GitLabGeoReceivePackData built = builder.build();

        assertThat(built.glId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrimaryRepoIsNullable() {
        final GitLabGeoReceivePackDataBuilder builder = GitLabGeoReceivePackDataBuilder.builder(
                        GeoCatalogFixtures.geoReceivePackData())
                .primaryRepo(null);

        final GitLabGeoReceivePackData built = builder.build();

        assertThat(built.primaryRepo()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoReceivePackData value = GeoCatalogFixtures.geoReceivePackData();

        assertSoftly(softly -> {
            softly.assertThat(value.glId()).isEqualTo("gl_id");
            softly.assertThat(value.primaryRepo()).isEqualTo("primary_repo");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoReceivePackData original = GeoCatalogFixtures.geoReceivePackData();

        final GitLabGeoReceivePackData rebuilt =
                GitLabGeoReceivePackDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoReceivePackData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("glId", "primaryRepo");
    }
}
