package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoInfoRefsUploadPackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSecretTokenIsNullable() {
        final GitLabGeoInfoRefsUploadPackPayloadBuilder builder = GitLabGeoInfoRefsUploadPackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsUploadPackPayload())
                .secretToken(null);

        final GitLabGeoInfoRefsUploadPackPayload built = builder.build();

        assertThat(built.secretToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabGeoInfoRefsUploadPackPayloadBuilder builder = GitLabGeoInfoRefsUploadPackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsUploadPackPayload())
                .data(null);

        final GitLabGeoInfoRefsUploadPackPayload built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoInfoRefsUploadPackPayload value = GeoCatalogFixtures.geoInfoRefsUploadPackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.secretToken()).isEqualTo("secret_token");
            softly.assertThat(value.data()).isEqualTo(GeoCatalogFixtures.geoInfoRefsUploadPackData());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoInfoRefsUploadPackPayload original = GeoCatalogFixtures.geoInfoRefsUploadPackPayload();

        final GitLabGeoInfoRefsUploadPackPayload rebuilt =
                GitLabGeoInfoRefsUploadPackPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretTokenIsACredential() {
        final GitLabGeoInfoRefsUploadPackPayload value = GeoCatalogFixtures.geoInfoRefsUploadPackPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoInfoRefsUploadPackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("secretToken", "data");
    }
}
