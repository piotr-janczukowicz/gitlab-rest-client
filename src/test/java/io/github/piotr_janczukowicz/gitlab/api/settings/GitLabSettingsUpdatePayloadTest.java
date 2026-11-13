package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDefaultValueIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .defaultValue(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.defaultValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .max(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.max()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .project(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .allow(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.allow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .user(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .users(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .runner(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.runner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .group(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .ci(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.ci()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .external(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.external()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .lock(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.lock()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThrottleIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .throttle(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.throttle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .elasticsearch(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.elasticsearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .duo(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.duo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalValueIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .globalValue(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.globalValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .zoekt(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.zoekt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOtherIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .other(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.other()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOtherMoreIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .otherMore(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.otherMore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOtherFurtherIsNullable() {
        final GitLabSettingsUpdatePayloadBuilder builder = GitLabSettingsUpdatePayloadBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdatePayload())
                .otherFurther(null);

        final GitLabSettingsUpdatePayload built = builder.build();

        assertThat(built.otherFurther()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdatePayload value = SettingsCatalogFixtures.settingsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.defaultValue()).isEqualTo(SettingsCatalogFixtures.settingsUpdateDefault());
            softly.assertThat(value.max()).isEqualTo(SettingsCatalogFixtures.settingsUpdateMax());
            softly.assertThat(value.project()).isEqualTo(SettingsCatalogFixtures.settingsUpdateProject());
            softly.assertThat(value.allow()).isEqualTo(SettingsCatalogFixtures.settingsUpdateAllow());
            softly.assertThat(value.user()).isEqualTo(SettingsCatalogFixtures.settingsUpdateUser());
            softly.assertThat(value.users()).isEqualTo(SettingsCatalogFixtures.settingsUpdateUsers());
            softly.assertThat(value.runner()).isEqualTo(SettingsCatalogFixtures.settingsUpdateRunner());
            softly.assertThat(value.group()).isEqualTo(SettingsCatalogFixtures.settingsUpdateGroup());
            softly.assertThat(value.ci()).isEqualTo(SettingsCatalogFixtures.settingsUpdateCi());
            softly.assertThat(value.external()).isEqualTo(SettingsCatalogFixtures.settingsUpdateExternal());
            softly.assertThat(value.lock()).isEqualTo(SettingsCatalogFixtures.settingsUpdateLock());
            softly.assertThat(value.throttle()).isEqualTo(SettingsCatalogFixtures.settingsUpdateThrottle());
            softly.assertThat(value.elasticsearch()).isEqualTo(SettingsCatalogFixtures.settingsUpdateElasticsearch());
            softly.assertThat(value.duo()).isEqualTo(SettingsCatalogFixtures.settingsUpdateDuo());
            softly.assertThat(value.globalValue()).isEqualTo(SettingsCatalogFixtures.settingsUpdateGlobal());
            softly.assertThat(value.zoekt()).isEqualTo(SettingsCatalogFixtures.settingsUpdateZoekt());
            softly.assertThat(value.other()).isEqualTo(SettingsCatalogFixtures.settingsUpdateOther());
            softly.assertThat(value.otherMore()).isEqualTo(SettingsCatalogFixtures.settingsUpdateOtherMore());
            softly.assertThat(value.otherFurther()).isEqualTo(SettingsCatalogFixtures.settingsUpdateOtherFurther());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdatePayload original = SettingsCatalogFixtures.settingsUpdatePayload();

        final GitLabSettingsUpdatePayload rebuilt =
                GitLabSettingsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "defaultValue",
                        "max",
                        "project",
                        "allow",
                        "user",
                        "users",
                        "runner",
                        "group",
                        "ci",
                        "external",
                        "lock",
                        "throttle",
                        "elasticsearch",
                        "duo",
                        "globalValue",
                        "zoekt",
                        "other",
                        "otherMore",
                        "otherFurther");
    }
}
