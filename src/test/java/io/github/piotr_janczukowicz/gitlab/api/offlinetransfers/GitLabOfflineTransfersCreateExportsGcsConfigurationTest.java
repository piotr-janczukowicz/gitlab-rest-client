package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateExportsGcsConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenGoogleProjectIsNullable() {
        final GitLabOfflineTransfersCreateExportsGcsConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsGcsConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsConfiguration())
                        .googleProject(null);

        final GitLabOfflineTransfersCreateExportsGcsConfiguration built = builder.build();

        assertThat(built.googleProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGoogleJsonKeyStringIsNullable() {
        final GitLabOfflineTransfersCreateExportsGcsConfigurationBuilder builder =
                GitLabOfflineTransfersCreateExportsGcsConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsConfiguration())
                        .googleJsonKeyString(null);

        final GitLabOfflineTransfersCreateExportsGcsConfiguration built = builder.build();

        assertThat(built.googleJsonKeyString()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateExportsGcsConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsConfiguration();

        assertSoftly(softly -> {
            softly.assertThat(value.googleProject()).isEqualTo("google_project");
            softly.assertThat(value.googleJsonKeyString()).isEqualTo("google_json_key_string");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateExportsGcsConfiguration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsConfiguration();

        final GitLabOfflineTransfersCreateExportsGcsConfiguration rebuilt =
                GitLabOfflineTransfersCreateExportsGcsConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateExportsGcsConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("googleProject", "googleJsonKeyString");
    }
}
