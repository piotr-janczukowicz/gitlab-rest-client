package io.github.piotr_janczukowicz.gitlab.api.metadata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMetadataKasTest {

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabMetadataKasBuilder builder = GitLabMetadataKasBuilder.builder(MetadataCatalogFixtures.metadataKas())
                .enabled(null);

        final GitLabMetadataKas built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabMetadataKasBuilder builder = GitLabMetadataKasBuilder.builder(MetadataCatalogFixtures.metadataKas())
                .externalUrl(null);

        final GitLabMetadataKas built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalK8sProxyUrlIsNullable() {
        final GitLabMetadataKasBuilder builder = GitLabMetadataKasBuilder.builder(MetadataCatalogFixtures.metadataKas())
                .externalK8sProxyUrl(null);

        final GitLabMetadataKas built = builder.build();

        assertThat(built.externalK8sProxyUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabMetadataKasBuilder builder = GitLabMetadataKasBuilder.builder(MetadataCatalogFixtures.metadataKas())
                .version(null);

        final GitLabMetadataKas built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMetadataKas value = MetadataCatalogFixtures.metadataKas();

        assertSoftly(softly -> {
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.externalUrl()).isEqualTo("grpc://gitlab.example.com:8150");
            softly.assertThat(value.externalK8sProxyUrl()).isEqualTo("https://gitlab.example.com:8150/k8s-proxy");
            softly.assertThat(value.version()).isEqualTo("15.0.0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMetadataKas original = MetadataCatalogFixtures.metadataKas();

        final GitLabMetadataKas rebuilt =
                GitLabMetadataKasBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMetadataKas.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("enabled", "externalUrl", "externalK8sProxyUrl", "version");
    }
}
