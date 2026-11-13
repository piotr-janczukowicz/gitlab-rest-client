package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateImportsImportAllTest {

    @Test
    void constructor_shouldAcceptNull_whenDestinationNamespaceIsNullable() {
        final GitLabOfflineTransfersCreateImportsImportAllBuilder builder =
                GitLabOfflineTransfersCreateImportsImportAllBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsImportAll())
                        .destinationNamespace(null);

        final GitLabOfflineTransfersCreateImportsImportAll built = builder.build();

        assertThat(built.destinationNamespace()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateImportsImportAll value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsImportAll();

        assertThat(value.destinationNamespace()).isEqualTo("destination-group/subgroup");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateImportsImportAll original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsImportAll();

        final GitLabOfflineTransfersCreateImportsImportAll rebuilt =
                GitLabOfflineTransfersCreateImportsImportAllBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOfflineTransfersCreateImportsImportAll.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("destinationNamespace");
    }
}
