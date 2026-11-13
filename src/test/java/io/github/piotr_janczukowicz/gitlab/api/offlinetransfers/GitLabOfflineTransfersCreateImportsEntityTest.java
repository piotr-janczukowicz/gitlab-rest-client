package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateImportsEntityTest {

    @Test
    void constructor_shouldRefuseNull_whenSourceTypeIsNull() {
        final GitLabOfflineTransfersCreateImportsEntityBuilder builder =
                GitLabOfflineTransfersCreateImportsEntityBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity())
                        .sourceType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("sourceType");
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceFullPathIsNullable() {
        final GitLabOfflineTransfersCreateImportsEntityBuilder builder =
                GitLabOfflineTransfersCreateImportsEntityBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity())
                        .sourceFullPath(null);

        final GitLabOfflineTransfersCreateImportsEntity built = builder.build();

        assertThat(built.sourceFullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationNamespaceIsNullable() {
        final GitLabOfflineTransfersCreateImportsEntityBuilder builder =
                GitLabOfflineTransfersCreateImportsEntityBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity())
                        .destinationNamespace(null);

        final GitLabOfflineTransfersCreateImportsEntity built = builder.build();

        assertThat(built.destinationNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationSlugIsNullable() {
        final GitLabOfflineTransfersCreateImportsEntityBuilder builder =
                GitLabOfflineTransfersCreateImportsEntityBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity())
                        .destinationSlug(null);

        final GitLabOfflineTransfersCreateImportsEntity built = builder.build();

        assertThat(built.destinationSlug()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateImportsEntity value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceType())
                    .isEqualTo(GitLabOfflineTransfersCreateImportsEntitySourceType.GROUP_ENTITY);
            softly.assertThat(value.sourceFullPath()).isEqualTo("source_full_path");
            softly.assertThat(value.destinationNamespace()).isEqualTo("destination_namespace");
            softly.assertThat(value.destinationSlug()).isEqualTo("destination_slug");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateImportsEntity original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity();

        final GitLabOfflineTransfersCreateImportsEntity rebuilt =
                GitLabOfflineTransfersCreateImportsEntityBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOfflineTransfersCreateImportsEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceType", "sourceFullPath", "destinationNamespace", "destinationSlug");
    }
}
