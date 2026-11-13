package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateDuoNamespaceAccessRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenThroughNamespaceIsNullable() {
        final GitLabSettingsUpdateDuoNamespaceAccessRuleBuilder builder =
                GitLabSettingsUpdateDuoNamespaceAccessRuleBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule())
                        .throughNamespace(null);

        final GitLabSettingsUpdateDuoNamespaceAccessRule built = builder.build();

        assertThat(built.throughNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeaturesIsNullable() {
        final GitLabSettingsUpdateDuoNamespaceAccessRuleBuilder builder =
                GitLabSettingsUpdateDuoNamespaceAccessRuleBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule())
                        .features(null);

        final GitLabSettingsUpdateDuoNamespaceAccessRule built = builder.build();

        assertThat(built.features()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateDuoNamespaceAccessRule value =
                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule();

        assertSoftly(softly -> {
            softly.assertThat(value.throughNamespace())
                    .isEqualTo(SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRuleThroughNamespace());
            softly.assertThat(value.features()).isEqualTo(List.of("features"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateDuoNamespaceAccessRule original =
                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule();

        final GitLabSettingsUpdateDuoNamespaceAccessRule rebuilt =
                GitLabSettingsUpdateDuoNamespaceAccessRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenFeaturesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("features"));
        final GitLabSettingsUpdateDuoNamespaceAccessRule built =
                GitLabSettingsUpdateDuoNamespaceAccessRuleBuilder.builder(
                                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule())
                        .features(source)
                        .build();
        source.clear();

        assertThat(built.features()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFeaturesIsRead() {
        final GitLabSettingsUpdateDuoNamespaceAccessRule built =
                SettingsCatalogFixtures.settingsUpdateDuoNamespaceAccessRule();
        final List<String> values = built.features();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateDuoNamespaceAccessRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("throughNamespace", "features");
    }
}
