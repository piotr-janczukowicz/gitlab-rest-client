package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateImportsGcsHmacConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenGoogleStorageAccessKeyIdIsNullable() {
        final GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration())
                        .googleStorageAccessKeyId(null);

        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration built = builder.build();

        assertThat(built.googleStorageAccessKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGoogleStorageSecretAccessKeyIsNullable() {
        final GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration())
                        .googleStorageSecretAccessKey(null);

        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration built = builder.build();

        assertThat(built.googleStorageSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRegionIsNullable() {
        final GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration())
                        .region(null);

        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration built = builder.build();

        assertThat(built.region()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathStyleIsNullable() {
        final GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration())
                        .pathStyle(null);

        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration built = builder.build();

        assertThat(built.pathStyle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration();

        assertSoftly(softly -> {
            softly.assertThat(value.googleStorageAccessKeyId()).isEqualTo("google_storage_access_key_id");
            softly.assertThat(value.googleStorageSecretAccessKey()).isEqualTo("google_storage_secret_access_key");
            softly.assertThat(value.region()).isEqualTo("region");
            softly.assertThat(value.pathStyle()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration();

        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration rebuilt =
                GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenGoogleStorageSecretAccessKeyIsACredential() {
        final GitLabOfflineTransfersCreateImportsGcsHmacConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateImportsGcsHmacConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("googleStorageAccessKeyId", "googleStorageSecretAccessKey", "region", "pathStyle");
    }
}
