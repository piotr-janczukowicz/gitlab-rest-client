package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateCodeDropdownCustomClientTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabSettingsUpdateCodeDropdownCustomClientBuilder builder =
                GitLabSettingsUpdateCodeDropdownCustomClientBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateCodeDropdownCustomClient())
                        .name(null);

        final GitLabSettingsUpdateCodeDropdownCustomClient built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlTemplateIsNullable() {
        final GitLabSettingsUpdateCodeDropdownCustomClientBuilder builder =
                GitLabSettingsUpdateCodeDropdownCustomClientBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateCodeDropdownCustomClient())
                        .sshUrlTemplate(null);

        final GitLabSettingsUpdateCodeDropdownCustomClient built = builder.build();

        assertThat(built.sshUrlTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlTemplateIsNullable() {
        final GitLabSettingsUpdateCodeDropdownCustomClientBuilder builder =
                GitLabSettingsUpdateCodeDropdownCustomClientBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateCodeDropdownCustomClient())
                        .httpUrlTemplate(null);

        final GitLabSettingsUpdateCodeDropdownCustomClient built = builder.build();

        assertThat(built.httpUrlTemplate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateCodeDropdownCustomClient value =
                SettingsCatalogFixtures.settingsUpdateCodeDropdownCustomClient();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.sshUrlTemplate()).isEqualTo("ssh_url_template");
            softly.assertThat(value.httpUrlTemplate()).isEqualTo("http_url_template");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateCodeDropdownCustomClient original =
                SettingsCatalogFixtures.settingsUpdateCodeDropdownCustomClient();

        final GitLabSettingsUpdateCodeDropdownCustomClient rebuilt =
                GitLabSettingsUpdateCodeDropdownCustomClientBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateCodeDropdownCustomClient.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "sshUrlTemplate", "httpUrlTemplate");
    }
}
