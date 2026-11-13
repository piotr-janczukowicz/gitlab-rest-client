package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectClusterUserCreatePlatformKubernetesAttributesTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes())
                        .apiUrl(null);

        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes())
                        .token(null);

        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes())
                        .caCert(null);

        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes())
                        .namespace(null);

        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorizationTypeIsNullable() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes())
                        .authorizationType(null);

        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.authorizationType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes value =
                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
            softly.assertThat(value.authorizationType())
                    .isEqualTo(
                            GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType
                                    .UNKNOWN_AUTHORIZATION);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes original =
                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes();

        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes rebuilt =
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributes value =
                ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectClusterUserCreatePlatformKubernetesAttributes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "caCert", "namespace", "authorizationType");
    }
}
