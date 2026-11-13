package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsZentaoPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectIntegrationsZentaoPayloadBuilder builder =
                GitLabProjectIntegrationsZentaoPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload())
                        .url(null);

        final GitLabProjectIntegrationsZentaoPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectIntegrationsZentaoPayloadBuilder builder =
                GitLabProjectIntegrationsZentaoPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload())
                        .apiUrl(null);

        final GitLabProjectIntegrationsZentaoPayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiTokenIsNullable() {
        final GitLabProjectIntegrationsZentaoPayloadBuilder builder =
                GitLabProjectIntegrationsZentaoPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload())
                        .apiToken(null);

        final GitLabProjectIntegrationsZentaoPayload built = builder.build();

        assertThat(built.apiToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZentaoProductXidIsNullable() {
        final GitLabProjectIntegrationsZentaoPayloadBuilder builder =
                GitLabProjectIntegrationsZentaoPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload())
                        .zentaoProductXid(null);

        final GitLabProjectIntegrationsZentaoPayload built = builder.build();

        assertThat(built.zentaoProductXid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsZentaoPayloadBuilder builder =
                GitLabProjectIntegrationsZentaoPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsZentaoPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsZentaoPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.apiToken()).isEqualTo("api_token");
            softly.assertThat(value.zentaoProductXid()).isEqualTo("zentao_product_xid");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsZentaoPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload();

        final GitLabProjectIntegrationsZentaoPayload rebuilt =
                GitLabProjectIntegrationsZentaoPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenApiTokenIsACredential() {
        final GitLabProjectIntegrationsZentaoPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsZentaoPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsZentaoPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "apiUrl", "apiToken", "zentaoProductXid", "useInheritedSettings");
    }
}
