package io.github.piotr_janczukowicz.gitlab.api.users;

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
class GitLabUsersUpdatePreferencePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenViewDiffsFileByFileIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .viewDiffsFileByFile(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.viewDiffsFileByFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowWhitespaceInDiffsIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .showWhitespaceInDiffs(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.showWhitespaceInDiffs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPassUserIdentitiesToCiJwtIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .passUserIdentitiesToCiJwt(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.passUserIdentitiesToCiJwt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPolicyAdvancedEditorIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .policyAdvancedEditor(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.policyAdvancedEditor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiSkinToneIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .emojiSkinTone(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.emojiSkinTone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursEnabledIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursEnabled(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.mobilePushWorkingHoursEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursStartIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursStart(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.mobilePushWorkingHoursStart()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMobilePushWorkingHoursStartIsBelowTheMinimum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursStart(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMobilePushWorkingHoursStartIsTheMinimum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursStart(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMobilePushWorkingHoursStartIsAboveTheMaximum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursStart(1440);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMobilePushWorkingHoursStartIsTheMaximum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursStart(1439);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursEndIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursEnd(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.mobilePushWorkingHoursEnd()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMobilePushWorkingHoursEndIsBelowTheMinimum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursEnd(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMobilePushWorkingHoursEndIsTheMinimum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursEnd(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMobilePushWorkingHoursEndIsAboveTheMaximum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursEnd(1440);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMobilePushWorkingHoursEndIsTheMaximum() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursEnd(1439);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingDaysIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingDays(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.mobilePushWorkingDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMobilePushWorkingHoursTimeZoneIsNullable() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursTimeZone(null);

        final GitLabUsersUpdatePreferencePayload built = builder.build();

        assertThat(built.mobilePushWorkingHoursTimeZone()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMobilePushWorkingHoursTimeZoneIsTooLong() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursTimeZone("x".repeat(65));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMobilePushWorkingHoursTimeZoneHasTheMaximumLength() {
        final GitLabUsersUpdatePreferencePayloadBuilder builder = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingHoursTimeZone("x".repeat(64));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersUpdatePreferencePayload value = UsersCatalogFixtures.usersUpdatePreferencePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.viewDiffsFileByFile()).isEqualTo(true);
            softly.assertThat(value.showWhitespaceInDiffs()).isEqualTo(true);
            softly.assertThat(value.passUserIdentitiesToCiJwt()).isEqualTo(true);
            softly.assertThat(value.policyAdvancedEditor()).isEqualTo(true);
            softly.assertThat(value.emojiSkinTone()).isEqualTo(GitLabUsersUpdatePreferenceEmojiSkinTone.DEFAULT);
            softly.assertThat(value.mobilePushWorkingHoursEnabled()).isEqualTo(true);
            softly.assertThat(value.mobilePushWorkingHoursStart()).isEqualTo(1);
            softly.assertThat(value.mobilePushWorkingHoursEnd()).isEqualTo(1);
            softly.assertThat(value.mobilePushWorkingDays())
                    .isEqualTo(List.of(GitLabUsersUpdatePreferenceMobilePushWorkingDays.MONDAY));
            softly.assertThat(value.mobilePushWorkingHoursTimeZone()).isEqualTo("mobile_push_working_hours_time_zone");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersUpdatePreferencePayload original = UsersCatalogFixtures.usersUpdatePreferencePayload();

        final GitLabUsersUpdatePreferencePayload rebuilt =
                GitLabUsersUpdatePreferencePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenMobilePushWorkingDaysSourceChangesLater() {
        final List<GitLabUsersUpdatePreferenceMobilePushWorkingDays> source =
                new ArrayList<>(List.of(GitLabUsersUpdatePreferenceMobilePushWorkingDays.MONDAY));
        final GitLabUsersUpdatePreferencePayload built = GitLabUsersUpdatePreferencePayloadBuilder.builder(
                        UsersCatalogFixtures.usersUpdatePreferencePayload())
                .mobilePushWorkingDays(source)
                .build();
        source.clear();

        assertThat(built.mobilePushWorkingDays()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenMobilePushWorkingDaysIsRead() {
        final GitLabUsersUpdatePreferencePayload built = UsersCatalogFixtures.usersUpdatePreferencePayload();
        final List<GitLabUsersUpdatePreferenceMobilePushWorkingDays> values = built.mobilePushWorkingDays();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersUpdatePreferencePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
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
