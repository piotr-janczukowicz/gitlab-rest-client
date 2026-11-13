package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoUploadPackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSecretTokenIsNullable() {
        final GitLabGeoUploadPackPayloadBuilder builder = GitLabGeoUploadPackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoUploadPackPayload())
                .secretToken(null);

        final GitLabGeoUploadPackPayload built = builder.build();

        assertThat(built.secretToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabGeoUploadPackPayloadBuilder builder = GitLabGeoUploadPackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoUploadPackPayload())
                .data(null);

        final GitLabGeoUploadPackPayload built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutputIsNullable() {
        final GitLabGeoUploadPackPayloadBuilder builder = GitLabGeoUploadPackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoUploadPackPayload())
                .output(null);

        final GitLabGeoUploadPackPayload built = builder.build();

        assertThat(built.output()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoUploadPackPayload value = GeoCatalogFixtures.geoUploadPackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.secretToken()).isEqualTo("secret_token");
            softly.assertThat(value.data()).isEqualTo(GeoCatalogFixtures.geoUploadPackData());
            softly.assertThat(value.output()).isEqualTo("output");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoUploadPackPayload original = GeoCatalogFixtures.geoUploadPackPayload();

        final GitLabGeoUploadPackPayload rebuilt =
                GitLabGeoUploadPackPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretTokenIsACredential() {
        final GitLabGeoUploadPackPayload value = GeoCatalogFixtures.geoUploadPackPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoUploadPackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("secretToken", "data", "output");
    }
}
