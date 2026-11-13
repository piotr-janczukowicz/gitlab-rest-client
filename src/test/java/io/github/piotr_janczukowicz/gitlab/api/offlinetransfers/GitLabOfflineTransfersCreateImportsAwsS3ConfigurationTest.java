package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateImportsAwsS3ConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenAwsAccessKeyIdIsNullable() {
        final GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration())
                        .awsAccessKeyId(null);

        final GitLabOfflineTransfersCreateImportsAwsS3Configuration built = builder.build();

        assertThat(built.awsAccessKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwsSecretAccessKeyIsNullable() {
        final GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration())
                        .awsSecretAccessKey(null);

        final GitLabOfflineTransfersCreateImportsAwsS3Configuration built = builder.build();

        assertThat(built.awsSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRegionIsNullable() {
        final GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration())
                        .region(null);

        final GitLabOfflineTransfersCreateImportsAwsS3Configuration built = builder.build();

        assertThat(built.region()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathStyleIsNullable() {
        final GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration())
                        .pathStyle(null);

        final GitLabOfflineTransfersCreateImportsAwsS3Configuration built = builder.build();

        assertThat(built.pathStyle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateImportsAwsS3Configuration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration();

        assertSoftly(softly -> {
            softly.assertThat(value.awsAccessKeyId()).isEqualTo("aws_access_key_id");
            softly.assertThat(value.awsSecretAccessKey()).isEqualTo("aws_secret_access_key");
            softly.assertThat(value.region()).isEqualTo("region");
            softly.assertThat(value.pathStyle()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateImportsAwsS3Configuration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration();

        final GitLabOfflineTransfersCreateImportsAwsS3Configuration rebuilt =
                GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAwsSecretAccessKeyIsACredential() {
        final GitLabOfflineTransfersCreateImportsAwsS3Configuration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateImportsAwsS3Configuration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("awsAccessKeyId", "awsSecretAccessKey", "region", "pathStyle");
    }
}
