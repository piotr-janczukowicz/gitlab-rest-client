package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupClusterUserCreatePlatformKubernetesAttributesTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes())
                        .apiUrl(null);

        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes())
                        .token(null);

        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes())
                        .caCert(null);

        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes())
                        .namespace(null);

        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorizationTypeIsNullable() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder builder =
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes())
                        .authorizationType(null);

        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes built = builder.build();

        assertThat(built.authorizationType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes value =
                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
            softly.assertThat(value.authorizationType())
                    .isEqualTo(
                            GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType
                                    .UNKNOWN_AUTHORIZATION);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes original =
                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes();

        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes rebuilt =
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributes value =
                GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupClusterUserCreatePlatformKubernetesAttributes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "caCert", "namespace", "authorizationType");
    }
}
