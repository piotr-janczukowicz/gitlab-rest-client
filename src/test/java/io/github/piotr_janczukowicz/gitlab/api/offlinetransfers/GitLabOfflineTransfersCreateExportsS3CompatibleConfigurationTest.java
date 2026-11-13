package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenAwsAccessKeyIdIsNullable() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures
                                        .offlineTransfersCreateExportsS3CompatibleConfiguration())
                        .awsAccessKeyId(null);

        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration built = builder.build();

        assertThat(built.awsAccessKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwsSecretAccessKeyIsNullable() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures
                                        .offlineTransfersCreateExportsS3CompatibleConfiguration())
                        .awsSecretAccessKey(null);

        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration built = builder.build();

        assertThat(built.awsSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRegionIsNullable() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures
                                        .offlineTransfersCreateExportsS3CompatibleConfiguration())
                        .region(null);

        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration built = builder.build();

        assertThat(built.region()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndpointIsNullable() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures
                                        .offlineTransfersCreateExportsS3CompatibleConfiguration())
                        .endpoint(null);

        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration built = builder.build();

        assertThat(built.endpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathStyleIsNullable() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures
                                        .offlineTransfersCreateExportsS3CompatibleConfiguration())
                        .pathStyle(null);

        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration built = builder.build();

        assertThat(built.pathStyle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsS3CompatibleConfiguration();

        assertSoftly(softly -> {
            softly.assertThat(value.awsAccessKeyId()).isEqualTo("aws_access_key_id");
            softly.assertThat(value.awsSecretAccessKey()).isEqualTo("aws_secret_access_key");
            softly.assertThat(value.region()).isEqualTo("region");
            softly.assertThat(value.endpoint()).isEqualTo("endpoint");
            softly.assertThat(value.pathStyle()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsS3CompatibleConfiguration();

        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration rebuilt =
                GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAwsSecretAccessKeyIsACredential() {
        final GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsS3CompatibleConfiguration();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("awsAccessKeyId", "awsSecretAccessKey", "region", "endpoint", "pathStyle");
    }
}
