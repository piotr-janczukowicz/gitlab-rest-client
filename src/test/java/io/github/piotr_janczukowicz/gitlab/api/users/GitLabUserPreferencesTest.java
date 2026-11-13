package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserPreferencesTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .id(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .userId(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenViewDiffsFileByFileIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .viewDiffsFileByFile(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.viewDiffsFileByFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowWhitespaceInDiffsIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .showWhitespaceInDiffs(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.showWhitespaceInDiffs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPassUserIdentitiesToCiJwtIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .passUserIdentitiesToCiJwt(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.passUserIdentitiesToCiJwt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPolicyAdvancedEditorIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .policyAdvancedEditor(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.policyAdvancedEditor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiSkinToneIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .emojiSkinTone(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.emojiSkinTone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursEnabledIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .mobilePushWorkingHoursEnabled(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.mobilePushWorkingHoursEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursStartIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .mobilePushWorkingHoursStart(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.mobilePushWorkingHoursStart()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursEndIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .mobilePushWorkingHoursEnd(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.mobilePushWorkingHoursEnd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingDaysIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .mobilePushWorkingDays(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.mobilePushWorkingDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursTimeZoneIsNullable() {
        final GitLabUserPreferencesBuilder builder = GitLabUserPreferencesBuilder.builder(
                        UsersCatalogFixtures.userPreferences())
                .mobilePushWorkingHoursTimeZone(null);

        final GitLabUserPreferences built = builder.build();

        assertThat(built.mobilePushWorkingHoursTimeZone()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserPreferences value = UsersCatalogFixtures.userPreferences();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.viewDiffsFileByFile()).isEqualTo(true);
            softly.assertThat(value.showWhitespaceInDiffs()).isEqualTo(true);
            softly.assertThat(value.passUserIdentitiesToCiJwt()).isEqualTo(true);
            softly.assertThat(value.policyAdvancedEditor()).isEqualTo(true);
            softly.assertThat(value.emojiSkinTone()).isEqualTo("emoji_skin_tone");
            softly.assertThat(value.mobilePushWorkingHoursEnabled()).isEqualTo(true);
            softly.assertThat(value.mobilePushWorkingHoursStart()).isEqualTo(1);
            softly.assertThat(value.mobilePushWorkingHoursEnd()).isEqualTo(1);
            softly.assertThat(value.mobilePushWorkingDays()).isEqualTo(List.of("monday"));
            softly.assertThat(value.mobilePushWorkingHoursTimeZone()).isEqualTo("Europe/Berlin");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserPreferences original = UsersCatalogFixtures.userPreferences();

        final GitLabUserPreferences rebuilt =
                GitLabUserPreferencesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserPreferences.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "userId",
                        "viewDiffsFileByFile",
                        "showWhitespaceInDiffs",
                        "passUserIdentitiesToCiJwt",
                        "policyAdvancedEditor",
                        "emojiSkinTone",
                        "mobilePushWorkingHoursEnabled",
                        "mobilePushWorkingHoursStart",
                        "mobilePushWorkingHoursEnd",
                        "mobilePushWorkingDays",
                        "mobilePushWorkingHoursTimeZone");
    }
}
