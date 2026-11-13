package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoInfoRefsUploadPackDataTest {

    @Test
    void constructor_shouldAcceptNull_whenGlIdIsNullable() {
        final GitLabGeoInfoRefsUploadPackDataBuilder builder = GitLabGeoInfoRefsUploadPackDataBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsUploadPackData())
                .glId(null);

        final GitLabGeoInfoRefsUploadPackData built = builder.build();

        assertThat(built.glId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrimaryRepoIsNullable() {
        final GitLabGeoInfoRefsUploadPackDataBuilder builder = GitLabGeoInfoRefsUploadPackDataBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsUploadPackData())
                .primaryRepo(null);

        final GitLabGeoInfoRefsUploadPackData built = builder.build();

        assertThat(built.primaryRepo()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoInfoRefsUploadPackData value = GeoCatalogFixtures.geoInfoRefsUploadPackData();

        assertSoftly(softly -> {
            softly.assertThat(value.glId()).isEqualTo("gl_id");
            softly.assertThat(value.primaryRepo()).isEqualTo("primary_repo");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoInfoRefsUploadPackData original = GeoCatalogFixtures.geoInfoRefsUploadPackData();

        final GitLabGeoInfoRefsUploadPackData rebuilt =
                GitLabGeoInfoRefsUploadPackDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoInfoRefsUploadPackData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("glId", "primaryRepo");
    }
}
