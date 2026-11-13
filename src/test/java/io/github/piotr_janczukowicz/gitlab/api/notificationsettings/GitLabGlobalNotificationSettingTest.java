package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGlobalNotificationSettingTest {

    @Test
    void constructor_shouldAcceptNull_whenLevelIsNullable() {
        final GitLabGlobalNotificationSettingBuilder builder = GitLabGlobalNotificationSettingBuilder.builder(
                        NotificationsettingsCatalogFixtures.globalNotificationSetting())
                .level(null);

        final GitLabGlobalNotificationSetting built = builder.build();

        assertThat(built.level()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventsIsNullable() {
        final GitLabGlobalNotificationSettingBuilder builder = GitLabGlobalNotificationSettingBuilder.builder(
                        NotificationsettingsCatalogFixtures.globalNotificationSetting())
                .events(null);

        final GitLabGlobalNotificationSetting built = builder.build();

        assertThat(built.events()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotificationEmailIsNullable() {
        final GitLabGlobalNotificationSettingBuilder builder = GitLabGlobalNotificationSettingBuilder.builder(
                        NotificationsettingsCatalogFixtures.globalNotificationSetting())
                .notificationEmail(null);

        final GitLabGlobalNotificationSetting built = builder.build();

        assertThat(built.notificationEmail()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGlobalNotificationSetting value = NotificationsettingsCatalogFixtures.globalNotificationSetting();

        assertSoftly(softly -> {
            softly.assertThat(value.level()).isEqualTo("level");
            softly.assertThat(value.events()).isEqualTo("events");
            softly.assertThat(value.notificationEmail()).isEqualTo("notification_email");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGlobalNotificationSetting original =
                NotificationsettingsCatalogFixtures.globalNotificationSetting();

        final GitLabGlobalNotificationSetting rebuilt =
                GitLabGlobalNotificationSettingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGlobalNotificationSetting.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("level", "events", "notificationEmail");
    }
}
