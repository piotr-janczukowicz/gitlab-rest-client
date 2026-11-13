package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateExportsAwsS3ConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenAwsAccessKeyIdIsNullable() {
        final GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration())
                        .awsAccessKeyId(null);

        final GitLabOfflineTransfersCreateExportsAwsS3Configuration built = builder.build();

        assertThat(built.awsAccessKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwsSecretAccessKeyIsNullable() {
        final GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration())
                        .awsSecretAccessKey(null);

        final GitLabOfflineTransfersCreateExportsAwsS3Configuration built = builder.build();

        assertThat(built.awsSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRegionIsNullable() {
        final GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration())
                        .region(null);

        final GitLabOfflineTransfersCreateExportsAwsS3Configuration built = builder.build();

        assertThat(built.region()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathStyleIsNullable() {
        final GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration())
                        .pathStyle(null);

        final GitLabOfflineTransfersCreateExportsAwsS3Configuration built = builder.build();

        assertThat(built.pathStyle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateExportsAwsS3Configuration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration();

        assertSoftly(softly -> {
            softly.assertThat(value.awsAccessKeyId()).isEqualTo("aws_access_key_id");
            softly.assertThat(value.awsSecretAccessKey()).isEqualTo("aws_secret_access_key");
            softly.assertThat(value.region()).isEqualTo("region");
            softly.assertThat(value.pathStyle()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateExportsAwsS3Configuration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration();

        final GitLabOfflineTransfersCreateExportsAwsS3Configuration rebuilt =
                GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAwsSecretAccessKeyIsACredential() {
        final GitLabOfflineTransfersCreateExportsAwsS3Configuration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateExportsAwsS3Configuration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("awsAccessKeyId", "awsSecretAccessKey", "region", "pathStyle");
    }
}
