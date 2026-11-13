package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNotificationSettingTest {

    @Test
    void constructor_shouldAcceptNull_whenLevelIsNullable() {
        final GitLabNotificationSettingBuilder builder = GitLabNotificationSettingBuilder.builder(
                        NotificationsettingsCatalogFixtures.notificationSetting())
                .level(null);

        final GitLabNotificationSetting built = builder.build();

        assertThat(built.level()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventsIsNullable() {
        final GitLabNotificationSettingBuilder builder = GitLabNotificationSettingBuilder.builder(
                        NotificationsettingsCatalogFixtures.notificationSetting())
                .events(null);

        final GitLabNotificationSetting built = builder.build();

        assertThat(built.events()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNotificationSetting value = NotificationsettingsCatalogFixtures.notificationSetting();

        assertSoftly(softly -> {
            softly.assertThat(value.level()).isEqualTo("level");
            softly.assertThat(value.events()).isEqualTo("events");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNotificationSetting original = NotificationsettingsCatalogFixtures.notificationSetting();

        final GitLabNotificationSetting rebuilt =
                GitLabNotificationSettingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNotificationSetting.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("level", "events");
    }
}
