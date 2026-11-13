package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoCreateFailuresPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenGeoNodeIdIsNullable() {
        final GitLabGeoCreateFailuresPayloadBuilder builder = GitLabGeoCreateFailuresPayloadBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresPayload())
                .geoNodeId(null);

        final GitLabGeoCreateFailuresPayload built = builder.build();

        assertThat(built.geoNodeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailuresIsNullable() {
        final GitLabGeoCreateFailuresPayloadBuilder builder = GitLabGeoCreateFailuresPayloadBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresPayload())
                .failures(null);

        final GitLabGeoCreateFailuresPayload built = builder.build();

        assertThat(built.failures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoCreateFailuresPayload value = GeoCatalogFixtures.geoCreateFailuresPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.geoNodeId()).isEqualTo(1L);
            softly.assertThat(value.failures()).isEqualTo(List.of(GeoCatalogFixtures.geoCreateFailuresFailure()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoCreateFailuresPayload original = GeoCatalogFixtures.geoCreateFailuresPayload();

        final GitLabGeoCreateFailuresPayload rebuilt =
                GitLabGeoCreateFailuresPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenFailuresSourceChangesLater() {
        final List<GitLabGeoCreateFailuresFailure> source =
                new ArrayList<>(List.of(GeoCatalogFixtures.geoCreateFailuresFailure()));
        final GitLabGeoCreateFailuresPayload built = GitLabGeoCreateFailuresPayloadBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresPayload())
                .failures(source)
                .build();
        source.clear();

        assertThat(built.failures()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFailuresIsRead() {
        final GitLabGeoCreateFailuresPayload built = GeoCatalogFixtures.geoCreateFailuresPayload();
        final List<GitLabGeoCreateFailuresFailure> values = built.failures();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoCreateFailuresPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("geoNodeId", "failures");
    }
}
