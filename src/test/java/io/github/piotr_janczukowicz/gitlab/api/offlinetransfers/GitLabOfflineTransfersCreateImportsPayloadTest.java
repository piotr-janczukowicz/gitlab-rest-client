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
class GitLabOfflineTransfersCreateImportsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBucketIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .bucket(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.bucket()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAwsS3ConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .awsS3Configuration(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.awsS3Configuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenS3CompatibleConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .s3CompatibleConfiguration(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.s3CompatibleConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGcsConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .gcsConfiguration(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.gcsConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGcsHmacConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .gcsHmacConfiguration(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.gcsHmacConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGcsAdcConfigurationIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .gcsAdcConfiguration(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.gcsAdcConfiguration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExportPrefixIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .exportPrefix(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.exportPrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntitiesIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .entities(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.entities()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportAllIsNullable() {
        final GitLabOfflineTransfersCreateImportsPayloadBuilder builder =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .importAll(null);

        final GitLabOfflineTransfersCreateImportsPayload built = builder.build();

        assertThat(built.importAll()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateImportsPayload value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.bucket()).isEqualTo("bucket");
            softly.assertThat(value.awsS3Configuration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration());
            softly.assertThat(value.s3CompatibleConfiguration())
                    .isEqualTo(
                            OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsS3CompatibleConfiguration());
            softly.assertThat(value.gcsConfiguration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsConfiguration());
            softly.assertThat(value.gcsHmacConfiguration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration());
            softly.assertThat(value.gcsAdcConfiguration())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsAdcConfiguration());
            softly.assertThat(value.exportPrefix()).isEqualTo("export_prefix");
            softly.assertThat(value.entities())
                    .isEqualTo(List.of(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity()));
            softly.assertThat(value.importAll())
                    .isEqualTo(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsImportAll());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateImportsPayload original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload();

        final GitLabOfflineTransfersCreateImportsPayload rebuilt =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEntitiesSourceChangesLater() {
        final List<GitLabOfflineTransfersCreateImportsEntity> source =
                new ArrayList<>(List.of(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity()));
        final GitLabOfflineTransfersCreateImportsPayload built =
                GitLabOfflineTransfersCreateImportsPayloadBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload())
                        .entities(source)
                        .build();
        source.clear();

        assertThat(built.entities()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEntitiesIsRead() {
        final GitLabOfflineTransfersCreateImportsPayload built =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsPayload();
        final List<GitLabOfflineTransfersCreateImportsEntity> values = built.entities();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOfflineTransfersCreateImportsPayload.class.getRecordComponents())
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
                        "exportPrefix",
                        "entities",
                        "importAll");
    }
}
