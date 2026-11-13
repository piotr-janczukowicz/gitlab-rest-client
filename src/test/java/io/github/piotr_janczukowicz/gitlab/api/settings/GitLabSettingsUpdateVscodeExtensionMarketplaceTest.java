package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateVscodeExtensionMarketplaceTest {

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder builder =
                GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateVscodeExtensionMarketplace())
                        .enabled(null);

        final GitLabSettingsUpdateVscodeExtensionMarketplace built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPresetIsNullable() {
        final GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder builder =
                GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateVscodeExtensionMarketplace())
                        .preset(null);

        final GitLabSettingsUpdateVscodeExtensionMarketplace built = builder.build();

        assertThat(built.preset()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomValuesIsNullable() {
        final GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder builder =
                GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateVscodeExtensionMarketplace())
                        .customValues(null);

        final GitLabSettingsUpdateVscodeExtensionMarketplace built = builder.build();

        assertThat(built.customValues()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateVscodeExtensionMarketplace value =
                SettingsCatalogFixtures.settingsUpdateVscodeExtensionMarketplace();

        assertSoftly(softly -> {
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.preset()).isEqualTo("preset");
            softly.assertThat(value.customValues()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateVscodeExtensionMarketplace original =
                SettingsCatalogFixtures.settingsUpdateVscodeExtensionMarketplace();

        final GitLabSettingsUpdateVscodeExtensionMarketplace rebuilt =
                GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomValuesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabSettingsUpdateVscodeExtensionMarketplace built =
                GitLabSettingsUpdateVscodeExtensionMarketplaceBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateVscodeExtensionMarketplace())
                        .customValues(source)
                        .build();
        source.clear();

        assertThat(built.customValues()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateVscodeExtensionMarketplace.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("enabled", "preset", "customValues");
    }
}
