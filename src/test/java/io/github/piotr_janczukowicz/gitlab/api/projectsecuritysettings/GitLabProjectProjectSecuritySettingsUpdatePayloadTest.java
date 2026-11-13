package io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectSecuritySettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionEnabledIsNullable() {
        final GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder builder =
                GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder.builder(
                                ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload())
                        .secretPushProtectionEnabled(null);

        final GitLabProjectProjectSecuritySettingsUpdatePayload built = builder.build();

        assertThat(built.secretPushProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreReceiveSecretDetectionEnabledIsNullable() {
        final GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder builder =
                GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder.builder(
                                ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload())
                        .preReceiveSecretDetectionEnabled(null);

        final GitLabProjectProjectSecuritySettingsUpdatePayload built = builder.build();

        assertThat(built.preReceiveSecretDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFastDependencyPathsEnabledIsNullable() {
        final GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder builder =
                GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder.builder(
                                ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload())
                        .fastDependencyPathsEnabled(null);

        final GitLabProjectProjectSecuritySettingsUpdatePayload built = builder.build();

        assertThat(built.fastDependencyPathsEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectSecuritySettingsUpdatePayload value =
                ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.secretPushProtectionEnabled()).isEqualTo(true);
            softly.assertThat(value.preReceiveSecretDetectionEnabled()).isEqualTo(true);
            softly.assertThat(value.fastDependencyPathsEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectSecuritySettingsUpdatePayload original =
                ProjectsecuritysettingsCatalogFixtures.projectProjectSecuritySettingsUpdatePayload();

        final GitLabProjectProjectSecuritySettingsUpdatePayload rebuilt =
                GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectSecuritySettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "secretPushProtectionEnabled",
                        "preReceiveSecretDetectionEnabled",
                        "fastDependencyPathsEnabled");
    }
}
