package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateDependencyManagementSettingsTest {

    @Test
    void constructor_shouldAcceptNull_whenSecurityUpdateSchedulerMaxConcurrencyIsNullable() {
        final GitLabSettingsUpdateDependencyManagementSettingsBuilder builder =
                GitLabSettingsUpdateDependencyManagementSettingsBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDependencyManagementSettings())
                        .securityUpdateSchedulerMaxConcurrency(null);

        final GitLabSettingsUpdateDependencyManagementSettings built = builder.build();

        assertThat(built.securityUpdateSchedulerMaxConcurrency()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateDependencyManagementSettings value =
                SettingsCatalogFixtures.settingsUpdateDependencyManagementSettings();

        assertThat(value.securityUpdateSchedulerMaxConcurrency()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateDependencyManagementSettings original =
                SettingsCatalogFixtures.settingsUpdateDependencyManagementSettings();

        final GitLabSettingsUpdateDependencyManagementSettings rebuilt =
                GitLabSettingsUpdateDependencyManagementSettingsBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabSettingsUpdateDependencyManagementSettings.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("securityUpdateSchedulerMaxConcurrency");
    }
}
