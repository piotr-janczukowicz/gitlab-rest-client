package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingTest {

    @Test
    void constructor_shouldRefuseNull_whenAllowIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .allow(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("allow");
    }

    @Test
    void constructor_shouldRefuseNull_whenCiIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .ci(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("ci");
    }

    @Test
    void constructor_shouldRefuseNull_whenContainerIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .container(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("container");
    }

    @Test
    void constructor_shouldRefuseNull_whenDefaultValueIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .defaultValue(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("defaultValue");
    }

    @Test
    void constructor_shouldRefuseNull_whenExternalIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .external(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("external");
    }

    @Test
    void constructor_shouldRefuseNull_whenLockIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .lock(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("lock");
    }

    @Test
    void constructor_shouldRefuseNull_whenMaxIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .max(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("max");
    }

    @Test
    void constructor_shouldRefuseNull_whenProjectIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .project(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("project");
    }

    @Test
    void constructor_shouldRefuseNull_whenThrottleIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .throttle(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("throttle");
    }

    @Test
    void constructor_shouldRefuseNull_whenUserIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .user(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("user");
    }

    @Test
    void constructor_shouldRefuseNull_whenGroupIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .group(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("group");
    }

    @Test
    void constructor_shouldRefuseNull_whenUsersIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .users(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("users");
    }

    @Test
    void constructor_shouldRefuseNull_whenRunnerIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .runner(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("runner");
    }

    @Test
    void constructor_shouldRefuseNull_whenGlobalValueIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .globalValue(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("globalValue");
    }

    @Test
    void constructor_shouldRefuseNull_whenDuoIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .duo(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("duo");
    }

    @Test
    void constructor_shouldRefuseNull_whenElasticsearchIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .elasticsearch(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("elasticsearch");
    }

    @Test
    void constructor_shouldRefuseNull_whenZoektIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .zoekt(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("zoekt");
    }

    @Test
    void constructor_shouldRefuseNull_whenOtherIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .other(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("other");
    }

    @Test
    void constructor_shouldRefuseNull_whenOtherMoreIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .otherMore(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("otherMore");
    }

    @Test
    void constructor_shouldRefuseNull_whenOtherFurtherIsNull() {
        final GitLabApplicationSettingBuilder builder = GitLabApplicationSettingBuilder.builder(
                        SettingsCatalogFixtures.applicationSetting())
                .otherFurther(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("otherFurther");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSetting value = SettingsCatalogFixtures.applicationSetting();

        assertSoftly(softly -> {
            softly.assertThat(value.allow()).isEqualTo(SettingsCatalogFixtures.applicationSettingAllow());
            softly.assertThat(value.ci()).isEqualTo(SettingsCatalogFixtures.applicationSettingCi());
            softly.assertThat(value.container()).isEqualTo(SettingsCatalogFixtures.applicationSettingContainer());
            softly.assertThat(value.defaultValue()).isEqualTo(SettingsCatalogFixtures.applicationSettingDefault());
            softly.assertThat(value.external()).isEqualTo(SettingsCatalogFixtures.applicationSettingExternal());
            softly.assertThat(value.lock()).isEqualTo(SettingsCatalogFixtures.applicationSettingLock());
            softly.assertThat(value.max()).isEqualTo(SettingsCatalogFixtures.applicationSettingMax());
            softly.assertThat(value.project()).isEqualTo(SettingsCatalogFixtures.applicationSettingProject());
            softly.assertThat(value.throttle()).isEqualTo(SettingsCatalogFixtures.applicationSettingThrottle());
            softly.assertThat(value.user()).isEqualTo(SettingsCatalogFixtures.applicationSettingUser());
            softly.assertThat(value.group()).isEqualTo(SettingsCatalogFixtures.applicationSettingGroup());
            softly.assertThat(value.users()).isEqualTo(SettingsCatalogFixtures.applicationSettingUsers());
            softly.assertThat(value.runner()).isEqualTo(SettingsCatalogFixtures.applicationSettingRunner());
            softly.assertThat(value.globalValue()).isEqualTo(SettingsCatalogFixtures.applicationSettingGlobal());
            softly.assertThat(value.duo()).isEqualTo(SettingsCatalogFixtures.applicationSettingDuo());
            softly.assertThat(value.elasticsearch())
                    .isEqualTo(SettingsCatalogFixtures.applicationSettingElasticsearch());
            softly.assertThat(value.zoekt()).isEqualTo(SettingsCatalogFixtures.applicationSettingZoekt());
            softly.assertThat(value.other()).isEqualTo(SettingsCatalogFixtures.applicationSettingOther());
            softly.assertThat(value.otherMore()).isEqualTo(SettingsCatalogFixtures.applicationSettingOtherMore());
            softly.assertThat(value.otherFurther()).isEqualTo(SettingsCatalogFixtures.applicationSettingOtherFurther());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSetting original = SettingsCatalogFixtures.applicationSetting();

        final GitLabApplicationSetting rebuilt =
                GitLabApplicationSettingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSetting.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "allow",
                        "ci",
                        "container",
                        "defaultValue",
                        "external",
                        "lock",
                        "max",
                        "project",
                        "throttle",
                        "user",
                        "group",
                        "users",
                        "runner",
                        "globalValue",
                        "duo",
                        "elasticsearch",
                        "zoekt",
                        "other",
                        "otherMore",
                        "otherFurther");
    }
}
