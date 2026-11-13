package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsZentaoPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupGroupIntegrationsZentaoPayloadBuilder builder =
                GitLabGroupGroupIntegrationsZentaoPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload())
                        .url(null);

        final GitLabGroupGroupIntegrationsZentaoPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabGroupGroupIntegrationsZentaoPayloadBuilder builder =
                GitLabGroupGroupIntegrationsZentaoPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload())
                        .apiUrl(null);

        final GitLabGroupGroupIntegrationsZentaoPayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiTokenIsNullable() {
        final GitLabGroupGroupIntegrationsZentaoPayloadBuilder builder =
                GitLabGroupGroupIntegrationsZentaoPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload())
                        .apiToken(null);

        final GitLabGroupGroupIntegrationsZentaoPayload built = builder.build();

        assertThat(built.apiToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZentaoProductXidIsNullable() {
        final GitLabGroupGroupIntegrationsZentaoPayloadBuilder builder =
                GitLabGroupGroupIntegrationsZentaoPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload())
                        .zentaoProductXid(null);

        final GitLabGroupGroupIntegrationsZentaoPayload built = builder.build();

        assertThat(built.zentaoProductXid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsZentaoPayloadBuilder builder =
                GitLabGroupGroupIntegrationsZentaoPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsZentaoPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsZentaoPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload();

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
        final GitLabGroupGroupIntegrationsZentaoPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload();

        final GitLabGroupGroupIntegrationsZentaoPayload rebuilt =
                GitLabGroupGroupIntegrationsZentaoPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenApiTokenIsACredential() {
        final GitLabGroupGroupIntegrationsZentaoPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsZentaoPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsZentaoPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "apiUrl", "apiToken", "zentaoProductXid", "useInheritedSettings");
    }
}
