package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoInfoRefsReceivePackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSecretTokenIsNullable() {
        final GitLabGeoInfoRefsReceivePackPayloadBuilder builder = GitLabGeoInfoRefsReceivePackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsReceivePackPayload())
                .secretToken(null);

        final GitLabGeoInfoRefsReceivePackPayload built = builder.build();

        assertThat(built.secretToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabGeoInfoRefsReceivePackPayloadBuilder builder = GitLabGeoInfoRefsReceivePackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoInfoRefsReceivePackPayload())
                .data(null);

        final GitLabGeoInfoRefsReceivePackPayload built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoInfoRefsReceivePackPayload value = GeoCatalogFixtures.geoInfoRefsReceivePackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.secretToken()).isEqualTo("secret_token");
            softly.assertThat(value.data()).isEqualTo(GeoCatalogFixtures.geoInfoRefsReceivePackData());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoInfoRefsReceivePackPayload original = GeoCatalogFixtures.geoInfoRefsReceivePackPayload();

        final GitLabGeoInfoRefsReceivePackPayload rebuilt =
                GitLabGeoInfoRefsReceivePackPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretTokenIsACredential() {
        final GitLabGeoInfoRefsReceivePackPayload value = GeoCatalogFixtures.geoInfoRefsReceivePackPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoInfoRefsReceivePackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("secretToken", "data");
    }
}
