package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoInfoRefsReceivePackDataTest {

    @Test
    void constructor_shouldAcceptNull_whenGlIdIsNullable() {
        final GitLabGeoInfoRefsReceivePackDataBuilder builder = GitLabGeoInfoRefsReceivePackDataBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsReceivePackData())
                .glId(null);

        final GitLabGeoInfoRefsReceivePackData built = builder.build();

        assertThat(built.glId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrimaryRepoIsNullable() {
        final GitLabGeoInfoRefsReceivePackDataBuilder builder = GitLabGeoInfoRefsReceivePackDataBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsReceivePackData())
                .primaryRepo(null);

        final GitLabGeoInfoRefsReceivePackData built = builder.build();

        assertThat(built.primaryRepo()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoInfoRefsReceivePackData value = GeoCatalogFixtures.geoInfoRefsReceivePackData();

        assertSoftly(softly -> {
            softly.assertThat(value.glId()).isEqualTo("gl_id");
            softly.assertThat(value.primaryRepo()).isEqualTo("primary_repo");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoInfoRefsReceivePackData original = GeoCatalogFixtures.geoInfoRefsReceivePackData();

        final GitLabGeoInfoRefsReceivePackData rebuilt =
                GitLabGeoInfoRefsReceivePackDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoInfoRefsReceivePackData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("glId", "primaryRepo");
    }
}
