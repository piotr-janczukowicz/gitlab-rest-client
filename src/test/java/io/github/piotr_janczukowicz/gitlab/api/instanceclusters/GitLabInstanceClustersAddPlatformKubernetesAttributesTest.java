package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceClustersAddPlatformKubernetesAttributesTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes())
                        .apiUrl(null);

        final GitLabInstanceClustersAddPlatformKubernetesAttributes built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes())
                        .token(null);

        final GitLabInstanceClustersAddPlatformKubernetesAttributes built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes())
                        .caCert(null);

        final GitLabInstanceClustersAddPlatformKubernetesAttributes built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes())
                        .namespace(null);

        final GitLabInstanceClustersAddPlatformKubernetesAttributes built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorizationTypeIsNullable() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder builder =
                GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder.builder(
                                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes())
                        .authorizationType(null);

        final GitLabInstanceClustersAddPlatformKubernetesAttributes built = builder.build();

        assertThat(built.authorizationType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributes value =
                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
            softly.assertThat(value.authorizationType())
                    .isEqualTo(
                            GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType
                                    .UNKNOWN_AUTHORIZATION);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributes original =
                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes();

        final GitLabInstanceClustersAddPlatformKubernetesAttributes rebuilt =
                GitLabInstanceClustersAddPlatformKubernetesAttributesBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceClustersAddPlatformKubernetesAttributes value =
                InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabInstanceClustersAddPlatformKubernetesAttributes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "caCert", "namespace", "authorizationType");
    }
}
