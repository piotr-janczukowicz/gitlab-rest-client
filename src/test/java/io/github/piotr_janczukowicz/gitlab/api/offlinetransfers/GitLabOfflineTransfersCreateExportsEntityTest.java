package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateExportsEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabOfflineTransfersCreateExportsEntityBuilder builder =
                GitLabOfflineTransfersCreateExportsEntityBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsEntity())
                        .fullPath(null);

        final GitLabOfflineTransfersCreateExportsEntity built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateExportsEntity value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsEntity();

        assertThat(value.fullPath()).isEqualTo("'source/full/path' not 'https://example.com/source/full/path'");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateExportsEntity original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsEntity();

        final GitLabOfflineTransfersCreateExportsEntity rebuilt =
                GitLabOfflineTransfersCreateExportsEntityBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOfflineTransfersCreateExportsEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fullPath");
    }
}
