package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateExportsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBucketIsNullable() {
        final GitLabOfflineTransfersCreateExportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .bucket(null);

        final GitLabOfflineTransfersCreateExportsPayload built = builder.build();

        assertThat(built.bucket()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwsS3ConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateExportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .awsS3Configuration(null);

        final GitLabOfflineTransfersCreateExportsPayload built = builder.build();

        assertThat(built.awsS3Configuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenS3CompatibleConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateExportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .s3CompatibleConfiguration(null);

        final GitLabOfflineTransfersCreateExportsPayload built = builder.build();

        assertThat(built.s3CompatibleConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGcsConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateExportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .gcsConfiguration(null);

        final GitLabOfflineTransfersCreateExportsPayload built = builder.build();

        assertThat(built.gcsConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGcsHmacConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateExportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .gcsHmacConfiguration(null);

        final GitLabOfflineTransfersCreateExportsPayload built = builder.build();

        assertThat(built.gcsHmacConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGcsAdcConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateExportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .gcsAdcConfiguration(null);

        final GitLabOfflineTransfersCreateExportsPayload built = builder.build();

        assertThat(built.gcsAdcConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntitiesIsNullable() {
        final GitLabOfflineTransfersCreateExportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .entities(null);

        final GitLabOfflineTransfersCreateExportsPayload built = builder.build();

        assertThat(built.entities()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateExportsPayload value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.bucket()).isEqualTo("bucket");
            softly.assertThat(value.awsS3Configuration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration());
            softly.assertThat(value.s3CompatibleConfiguration())
                    .isEqualTo(
                            OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsS3CompatibleConfiguration());
            softly.assertThat(value.gcsConfiguration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsConfiguration());
            softly.assertThat(value.gcsHmacConfiguration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration());
            softly.assertThat(value.gcsAdcConfiguration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsAdcConfiguration());
            softly.assertThat(value.entities())
                    .isEqualTo(List.of(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsEntity()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateExportsPayload original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload();

        final GitLabOfflineTransfersCreateExportsPayload rebuilt =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEntitiesSourceChangesLater() {
        final List<GitLabOfflineTransfersCreateExportsEntity> source =
                new ArrayList<>(List.of(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsEntity()));
        final GitLabOfflineTransfersCreateExportsPayload built =
                GitLabOfflineTransfersCreateExportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload())
                        .entities(source)
                        .build();
        source.clear();

        assertThat(built.entities()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEntitiesIsRead() {
        final GitLabOfflineTransfersCreateExportsPayload built =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsPayload();
        final List<GitLabOfflineTransfersCreateExportsEntity> values = built.entities();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOfflineTransfersCreateExportsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "bucket",
                        "awsS3Configuration",
                        "s3CompatibleConfiguration",
                        "gcsConfiguration",
                        "gcsHmacConfiguration",
                        "gcsAdcConfiguration",
                        "entities");
    }
}
