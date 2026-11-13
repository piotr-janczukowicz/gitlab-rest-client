package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoUploadPackDataTest {

    @Test
    void constructor_shouldAcceptNull_whenGlIdIsNullable() {
        final GitLabGeoUploadPackDataBuilder builder = GitLabGeoUploadPackDataBuilder.builder(
                        GeoCatalogFixtures.geoUploadPackData())
                .glId(null);

        final GitLabGeoUploadPackData built = builder.build();

        assertThat(built.glId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrimaryRepoIsNullable() {
        final GitLabGeoUploadPackDataBuilder builder = GitLabGeoUploadPackDataBuilder.builder(
                        GeoCatalogFixtures.geoUploadPackData())
                .primaryRepo(null);

        final GitLabGeoUploadPackData built = builder.build();

        assertThat(built.primaryRepo()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoUploadPackData value = GeoCatalogFixtures.geoUploadPackData();

        assertSoftly(softly -> {
            softly.assertThat(value.glId()).isEqualTo("gl_id");
            softly.assertThat(value.primaryRepo()).isEqualTo("primary_repo");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoUploadPackData original = GeoCatalogFixtures.geoUploadPackData();

        final GitLabGeoUploadPackData rebuilt =
                GitLabGeoUploadPackDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoUploadPackData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("glId", "primaryRepo");
    }
}
