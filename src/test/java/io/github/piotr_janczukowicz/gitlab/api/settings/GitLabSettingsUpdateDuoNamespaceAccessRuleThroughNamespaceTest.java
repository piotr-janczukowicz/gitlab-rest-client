package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceBuilder builder =
                GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRuleThroughNamespace())
                        .id(null);

        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceBuilder builder =
                GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRuleThroughNamespace())
                        .name(null);

        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceBuilder builder =
                GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRuleThroughNamespace())
                        .fullPath(null);

        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace value =
                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRuleThroughNamespace();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.fullPath()).isEqualTo("full_path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace original =
                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRuleThroughNamespace();

        final GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace rebuilt =
                GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespaceBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "fullPath");
    }
}
