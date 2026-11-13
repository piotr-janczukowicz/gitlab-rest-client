package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAPIVsCodeSettingsEntitiesVsCodeSettingTest {

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting())
                        .content(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSetting built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMachinesIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting())
                        .machines(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSetting built = builder.build();

        assertThat(built.machines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting())
                        .version(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSetting built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMachineIdIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting())
                        .machineId(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSetting built = builder.build();

        assertThat(built.machineId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSetting value =
                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting();

        assertSoftly(softly -> {
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.machines()).isEqualTo("machines");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.machineId()).isEqualTo("machineId");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSetting original =
                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSetting();

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSetting rebuilt =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAPIVsCodeSettingsEntitiesVsCodeSetting.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("content", "machines", "version", "machineId");
    }
}
