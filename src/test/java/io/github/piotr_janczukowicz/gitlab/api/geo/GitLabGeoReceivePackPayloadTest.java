package io.github.piotr_janczukowicz.gitlab.api.geo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoReceivePackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSecretTokenIsNullable() {
        final GitLabGeoReceivePackPayloadBuilder builder = GitLabGeoReceivePackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoReceivePackPayload())
                .secretToken(null);

        final GitLabGeoReceivePackPayload built = builder.build();

        assertThat(built.secretToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabGeoReceivePackPayloadBuilder builder = GitLabGeoReceivePackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoReceivePackPayload())
                .data(null);

        final GitLabGeoReceivePackPayload built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutputIsNullable() {
        final GitLabGeoReceivePackPayloadBuilder builder = GitLabGeoReceivePackPayloadBuilder.builder(
                        GeoCatalogFixtures.geoReceivePackPayload())
                .output(null);

        final GitLabGeoReceivePackPayload built = builder.build();

        assertThat(built.output()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGeoReceivePackPayload value = GeoCatalogFixtures.geoReceivePackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.secretToken()).isEqualTo("secret_token");
            softly.assertThat(value.data()).isEqualTo(GeoCatalogFixtures.geoReceivePackData());
            softly.assertThat(value.output()).isEqualTo("output");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGeoReceivePackPayload original = GeoCatalogFixtures.geoReceivePackPayload();

        final GitLabGeoReceivePackPayload rebuilt =
                GitLabGeoReceivePackPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretTokenIsACredential() {
        final GitLabGeoReceivePackPayload value = GeoCatalogFixtures.geoReceivePackPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGeoReceivePackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("secretToken", "data", "output");
    }
}
