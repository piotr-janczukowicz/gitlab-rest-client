package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOfflineTransfersCreateImportsGcsConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenGoogleProjectIsNullable() {
        final GitLabOfflineTransfersCreateImportsGcsConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsGcsConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsConfiguration())
                        .googleProject(null);

        final GitLabOfflineTransfersCreateImportsGcsConfiguration built = builder.build();

        assertThat(built.googleProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGoogleJsonKeyStringIsNullable() {
        final GitLabOfflineTransfersCreateImportsGcsConfigurationBuilder builder =
                GitLabOfflineTransfersCreateImportsGcsConfigurationBuilder.builder(
                                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsConfiguration())
                        .googleJsonKeyString(null);

        final GitLabOfflineTransfersCreateImportsGcsConfiguration built = builder.build();

        assertThat(built.googleJsonKeyString()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOfflineTransfersCreateImportsGcsConfiguration value =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsConfiguration();

        assertSoftly(softly -> {
            softly.assertThat(value.googleProject()).isEqualTo("google_project");
            softly.assertThat(value.googleJsonKeyString()).isEqualTo("google_json_key_string");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOfflineTransfersCreateImportsGcsConfiguration original =
                OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsConfiguration();

        final GitLabOfflineTransfersCreateImportsGcsConfiguration rebuilt =
                GitLabOfflineTransfersCreateImportsGcsConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabOfflineTransfersCreateImportsGcsConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("googleProject", "googleJsonKeyString");
    }
}
