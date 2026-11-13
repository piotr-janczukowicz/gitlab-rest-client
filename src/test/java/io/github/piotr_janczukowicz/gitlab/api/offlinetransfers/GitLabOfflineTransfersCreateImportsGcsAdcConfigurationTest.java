package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateImportsGcsAdcConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenGoogleProjectIsNullable() {
        final GitLabOfflineTransfersCreateImportsGcsAdcConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsGcsAdcConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsAdcConfiguration())
                        .googleProject(null);

        final GitLabOfflineTransfersCreateImportsGcsAdcConfiguration built = builder.build();

        assertThat(built.googleProject()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateImportsGcsAdcConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsAdcConfiguration();

        assertThat(value.googleProject()).isEqualTo("google_project");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateImportsGcsAdcConfiguration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsAdcConfiguration();

        final GitLabOfflineTransfersCreateImportsGcsAdcConfiguration rebuilt =
                GitLabOfflineTransfersCreateImportsGcsAdcConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateImportsGcsAdcConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("googleProject");
    }
}
