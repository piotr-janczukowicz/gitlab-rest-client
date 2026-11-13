package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures
                                        .projectProjectClustersUpdatePlatformKubernetesAttributes())
                        .apiUrl(null);

        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures
                                        .projectProjectClustersUpdatePlatformKubernetesAttributes())
                        .token(null);

        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures
                                        .projectProjectClustersUpdatePlatformKubernetesAttributes())
                        .caCert(null);

        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures
                                        .projectProjectClustersUpdatePlatformKubernetesAttributes())
                        .namespace(null);

        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes value =
                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePlatformKubernetesAttributes();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes original =
                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePlatformKubernetesAttributes();

        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes rebuilt =
                GitLabProjectProjectClustersUpdatePlatformKubernetesAttributesBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes value =
                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePlatformKubernetesAttributes();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectClustersUpdatePlatformKubernetesAttributes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "caCert", "namespace");
    }
}
