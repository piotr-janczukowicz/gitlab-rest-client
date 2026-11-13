package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateExportsGcsAdcConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenGoogleProjectIsNullable() {
        final GitLabOfflineTransfersCreateExportsGcsAdcConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsGcsAdcConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsAdcConfiguration())
                        .googleProject(null);

        final GitLabOfflineTransfersCreateExportsGcsAdcConfiguration built = builder.build();

        assertThat(built.googleProject()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateExportsGcsAdcConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsAdcConfiguration();

        assertThat(value.googleProject()).isEqualTo("google_project");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateExportsGcsAdcConfiguration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsAdcConfiguration();

        final GitLabOfflineTransfersCreateExportsGcsAdcConfiguration rebuilt =
                GitLabOfflineTransfersCreateExportsGcsAdcConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateExportsGcsAdcConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("googleProject");
    }
}
