package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPlatformKubernetesTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabPlatformKubernetesBuilder builder = GitLabPlatformKubernetesBuilder.builder(
                        CommonCatalogFixtures.platformKubernetes())
                .apiUrl(null);

        final GitLabPlatformKubernetes built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabPlatformKubernetesBuilder builder = GitLabPlatformKubernetesBuilder.builder(
                        CommonCatalogFixtures.platformKubernetes())
                .namespace(null);

        final GitLabPlatformKubernetes built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorizationTypeIsNullable() {
        final GitLabPlatformKubernetesBuilder builder = GitLabPlatformKubernetesBuilder.builder(
                        CommonCatalogFixtures.platformKubernetes())
                .authorizationType(null);

        final GitLabPlatformKubernetes built = builder.build();

        assertThat(built.authorizationType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabPlatformKubernetesBuilder builder = GitLabPlatformKubernetesBuilder.builder(
                        CommonCatalogFixtures.platformKubernetes())
                .caCert(null);

        final GitLabPlatformKubernetes built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPlatformKubernetes value = CommonCatalogFixtures.platformKubernetes();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
            softly.assertThat(value.authorizationType()).isEqualTo("authorization_type");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPlatformKubernetes original = CommonCatalogFixtures.platformKubernetes();

        final GitLabPlatformKubernetes rebuilt =
                GitLabPlatformKubernetesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPlatformKubernetes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "namespace", "authorizationType", "caCert");
    }
}
