package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateExportsGcsHmacConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenGoogleStorageAccessKeyIdIsNullable() {
        final GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration())
                        .googleStorageAccessKeyId(null);

        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration built = builder.build();

        assertThat(built.googleStorageAccessKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGoogleStorageSecretAccessKeyIsNullable() {
        final GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration())
                        .googleStorageSecretAccessKey(null);

        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration built = builder.build();

        assertThat(built.googleStorageSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRegionIsNullable() {
        final GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration())
                        .region(null);

        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration built = builder.build();

        assertThat(built.region()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathStyleIsNullable() {
        final GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration())
                        .pathStyle(null);

        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration built = builder.build();

        assertThat(built.pathStyle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration();

        assertSoftly(softly -> {
            softly.assertThat(value.googleStorageAccessKeyId()).isEqualTo("google_storage_access_key_id");
            softly.assertThat(value.googleStorageSecretAccessKey()).isEqualTo("google_storage_secret_access_key");
            softly.assertThat(value.region()).isEqualTo("region");
            softly.assertThat(value.pathStyle()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration();

        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration rebuilt =
                GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenGoogleStorageSecretAccessKeyIsACredential() {
        final GitLabOfflineTransfersCreateExportsGcsHmacConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateExportsGcsHmacConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("googleStorageAccessKeyId", "googleStorageSecretAccessKey", "region", "pathStyle");
    }
}
