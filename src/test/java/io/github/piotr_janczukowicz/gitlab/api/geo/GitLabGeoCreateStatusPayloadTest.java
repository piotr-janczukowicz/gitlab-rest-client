package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoCreateStatusPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabGeoCreateStatusPayloadBuilder builder = GitLabGeoCreateStatusPayloadBuilder.builder(
                        GeoCatalogFixtures.geoCreateStatusPayload())
                .data(null);

        final GitLabGeoCreateStatusPayload built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoCreateStatusPayload value = GeoCatalogFixtures.geoCreateStatusPayload();

        assertThat(value.data()).isEqualTo(GeoCatalogFixtures.geoCreateStatusData());
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoCreateStatusPayload original = GeoCatalogFixtures.geoCreateStatusPayload();

        final GitLabGeoCreateStatusPayload rebuilt =
                GitLabGeoCreateStatusPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoCreateStatusPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("data");
    }
}
