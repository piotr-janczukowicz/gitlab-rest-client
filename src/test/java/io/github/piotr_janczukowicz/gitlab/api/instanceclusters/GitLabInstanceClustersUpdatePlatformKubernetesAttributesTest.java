package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceClustersUpdatePlatformKubernetesAttributesTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes())
                        .apiUrl(null);

        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes())
                        .token(null);

        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes())
                        .caCert(null);

        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes())
                        .namespace(null);

        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes value =
                InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes original =
                InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes();

        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes rebuilt =
                GitLabInstanceClustersUpdatePlatformKubernetesAttributesBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceClustersUpdatePlatformKubernetesAttributes value =
                InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabInstanceClustersUpdatePlatformKubernetesAttributes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "caCert", "namespace");
    }
}
