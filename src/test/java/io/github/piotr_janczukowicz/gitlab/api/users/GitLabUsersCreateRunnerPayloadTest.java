package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersCreateRunnerPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenRunnerTypeIsNull() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .runnerType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("runnerType");
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .groupId(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .projectId(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .description(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceNoteIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .maintenanceNote(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.maintenanceNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .paused(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .locked(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .accessLevel(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunUntaggedIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .runUntagged(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.runUntagged()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .tagList(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaximumTimeoutIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .maximumTimeout(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.maximumTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenExpiresAtIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .tokenExpiresAt(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.tokenExpiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenRotationDeadlineIsNullable() {
        final GitLabUsersCreateRunnerPayloadBuilder builder = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .tokenRotationDeadline(null);

        final GitLabUsersCreateRunnerPayload built = builder.build();

        assertThat(built.tokenRotationDeadline()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersCreateRunnerPayload value = UsersCatalogFixtures.usersCreateRunnerPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.runnerType()).isEqualTo(GitLabUsersCreateRunnerType.INSTANCE_TYPE);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.maintenanceNote()).isEqualTo("maintenance_note");
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.locked()).isEqualTo(true);
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabUsersCreateRunnerAccessLevel.NOT_PROTECTED);
            softly.assertThat(value.runUntagged()).isEqualTo(true);
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag_list"));
            softly.assertThat(value.maximumTimeout()).isEqualTo(1);
            softly.assertThat(value.tokenExpiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.tokenRotationDeadline()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersCreateRunnerPayload original = UsersCatalogFixtures.usersCreateRunnerPayload();

        final GitLabUsersCreateRunnerPayload rebuilt =
                GitLabUsersCreateRunnerPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagListSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("tag_list"));
        final GitLabUsersCreateRunnerPayload built = GitLabUsersCreateRunnerPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateRunnerPayload())
                .tagList(source)
                .build();
        source.clear();

        assertThat(built.tagList()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagListIsRead() {
        final GitLabUsersCreateRunnerPayload built = UsersCatalogFixtures.usersCreateRunnerPayload();
        final List<String> values = built.tagList();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersCreateRunnerPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "runnerType",
                        "groupId",
                        "projectId",
                        "description",
                        "maintenanceNote",
                        "paused",
                        "locked",
                        "accessLevel",
                        "runUntagged",
                        "tagList",
                        "maximumTimeout",
                        "tokenExpiresAt",
                        "tokenRotationDeadline");
    }
}
