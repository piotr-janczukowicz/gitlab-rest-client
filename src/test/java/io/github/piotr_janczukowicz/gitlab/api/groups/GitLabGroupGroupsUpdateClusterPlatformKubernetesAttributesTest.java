package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder builder =
                GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes())
                        .apiUrl(null);

        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder builder =
                GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes())
                        .token(null);

        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder builder =
                GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes())
                        .caCert(null);

        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder builder =
                GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes())
                        .namespace(null);

        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes value =
                GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes original =
                GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes();

        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes rebuilt =
                GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributesBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes value =
                GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsUpdateClusterPlatformKubernetesAttributes.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "caCert", "namespace");
    }
}
