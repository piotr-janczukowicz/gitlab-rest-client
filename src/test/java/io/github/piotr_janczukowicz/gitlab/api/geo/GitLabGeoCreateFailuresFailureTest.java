package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoCreateFailuresFailureTest {

    @Test
    void constructor_shouldAcceptNull_whenErrorTypeIsNullable() {
        final GitLabGeoCreateFailuresFailureBuilder builder = GitLabGeoCreateFailuresFailureBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresFailure())
                .errorType(null);

        final GitLabGeoCreateFailuresFailure built = builder.build();

        assertThat(built.errorType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicableNameIsNullable() {
        final GitLabGeoCreateFailuresFailureBuilder builder = GitLabGeoCreateFailuresFailureBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresFailure())
                .replicableName(null);

        final GitLabGeoCreateFailuresFailure built = builder.build();

        assertThat(built.replicableName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReplicableIdIsNullable() {
        final GitLabGeoCreateFailuresFailureBuilder builder = GitLabGeoCreateFailuresFailureBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresFailure())
                .replicableId(null);

        final GitLabGeoCreateFailuresFailure built = builder.build();

        assertThat(built.replicableId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerificationRetryCountIsNullable() {
        final GitLabGeoCreateFailuresFailureBuilder builder = GitLabGeoCreateFailuresFailureBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresFailure())
                .verificationRetryCount(null);

        final GitLabGeoCreateFailuresFailure built = builder.build();

        assertThat(built.verificationRetryCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextIsNullable() {
        final GitLabGeoCreateFailuresFailureBuilder builder = GitLabGeoCreateFailuresFailureBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresFailure())
                .context(null);

        final GitLabGeoCreateFailuresFailure built = builder.build();

        assertThat(built.context()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoCreateFailuresFailure value = GeoCatalogFixtures.geoCreateFailuresFailure();

        assertSoftly(softly -> {
            softly.assertThat(value.errorType()).isEqualTo("checksum_mismatch");
            softly.assertThat(value.replicableName()).isEqualTo("upload");
            softly.assertThat(value.replicableId()).isEqualTo(1L);
            softly.assertThat(value.verificationRetryCount()).isEqualTo(1);
            softly.assertThat(value.context()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoCreateFailuresFailure original = GeoCatalogFixtures.geoCreateFailuresFailure();

        final GitLabGeoCreateFailuresFailure rebuilt =
                GitLabGeoCreateFailuresFailureBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenContextSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabGeoCreateFailuresFailure built = GitLabGeoCreateFailuresFailureBuilder.builder(
                        GeoCatalogFixtures.geoCreateFailuresFailure())
                .context(source)
                .build();
        source.clear();

        assertThat(built.context()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoCreateFailuresFailure.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("errorType", "replicableName", "replicableId", "verificationRetryCount", "context");
    }
}
