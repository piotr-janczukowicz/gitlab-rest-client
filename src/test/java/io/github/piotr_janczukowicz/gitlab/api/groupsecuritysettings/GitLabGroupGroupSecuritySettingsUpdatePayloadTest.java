package io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings;

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
class GitLabGroupGroupSecuritySettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionEnabledIsNullable() {
        final GitLabGroupGroupSecuritySettingsUpdatePayloadBuilder builder =
                GitLabGroupGroupSecuritySettingsUpdatePayloadBuilder.builder(
                                GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload())
                        .secretPushProtectionEnabled(null);

        final GitLabGroupGroupSecuritySettingsUpdatePayload built = builder.build();

        assertThat(built.secretPushProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsToExcludeIsNullable() {
        final GitLabGroupGroupSecuritySettingsUpdatePayloadBuilder builder =
                GitLabGroupGroupSecuritySettingsUpdatePayloadBuilder.builder(
                                GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload())
                        .projectsToExclude(null);

        final GitLabGroupGroupSecuritySettingsUpdatePayload built = builder.build();

        assertThat(built.projectsToExclude()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupSecuritySettingsUpdatePayload value =
                GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.secretPushProtectionEnabled()).isEqualTo(true);
            softly.assertThat(value.projectsToExclude()).isEqualTo(List.of(1));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupSecuritySettingsUpdatePayload original =
                GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload();

        final GitLabGroupGroupSecuritySettingsUpdatePayload rebuilt =
                GitLabGroupGroupSecuritySettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenProjectsToExcludeSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabGroupGroupSecuritySettingsUpdatePayload built =
                GitLabGroupGroupSecuritySettingsUpdatePayloadBuilder.builder(
                                GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload())
                        .projectsToExclude(source)
                        .build();
        source.clear();

        assertThat(built.projectsToExclude()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProjectsToExcludeIsRead() {
        final GitLabGroupGroupSecuritySettingsUpdatePayload built =
                GroupsecuritysettingsCatalogFixtures.groupGroupSecuritySettingsUpdatePayload();
        final List<Integer> values = built.projectsToExclude();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupSecuritySettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("secretPushProtectionEnabled", "projectsToExclude");
    }
}
