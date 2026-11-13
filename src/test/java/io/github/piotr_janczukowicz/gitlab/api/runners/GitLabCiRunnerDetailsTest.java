package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .id(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .description(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIpAddressIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .ipAddress(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.ipAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .active(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .paused(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsSharedIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .isShared(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.isShared()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerTypeIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .runnerType(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.runnerType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .name(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlineIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .online(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.online()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .createdBy(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.createdBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .createdAt(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .status(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobExecutionStatusIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .jobExecutionStatus(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.jobExecutionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUuidIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .uuid(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.uuid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .tagList(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunUntaggedIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .runUntagged(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.runUntagged()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .locked(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaximumTimeoutIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .maximumTimeout(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.maximumTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .accessLevel(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenExpiresAtIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .tokenExpiresAt(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.tokenExpiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .version(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .revision(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .platform(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.platform()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitectureIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .architecture(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.architecture()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContactedAtIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .contactedAt(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.contactedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceNoteIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .maintenanceNote(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.maintenanceNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .projects(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.projects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .groups(null);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerDetails value = RunnersCatalogFixtures.ciRunnerDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("test-1-20150125");
            softly.assertThat(value.ipAddress()).isEqualTo("127.0.0.1");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.isShared()).isEqualTo(true);
            softly.assertThat(value.runnerType()).isEqualTo(GitLabCiRunnerDetailsRunnerType.INSTANCE_TYPE);
            softly.assertThat(value.name()).isEqualTo("test");
            softly.assertThat(value.online()).isEqualTo(true);
            softly.assertThat(value.createdBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.status()).isEqualTo("online");
            softly.assertThat(value.jobExecutionStatus()).isEqualTo(GitLabCiRunnerDetailsJobExecutionStatus.ACTIVE);
            softly.assertThat(value.uuid()).isEqualTo("01966aa0-f383-7a6b-b694-cd4f2f96cca1");
            softly.assertThat(value.tagList()).isEqualTo("tag_list");
            softly.assertThat(value.runUntagged()).isEqualTo("run_untagged");
            softly.assertThat(value.locked()).isEqualTo("locked");
            softly.assertThat(value.maximumTimeout()).isEqualTo("maximum_timeout");
            softly.assertThat(value.accessLevel()).isEqualTo("access_level");
            softly.assertThat(value.tokenExpiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.revision()).isEqualTo("revision");
            softly.assertThat(value.platform()).isEqualTo("platform");
            softly.assertThat(value.architecture()).isEqualTo("architecture");
            softly.assertThat(value.contactedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.maintenanceNote()).isEqualTo("maintenance_note");
            softly.assertThat(value.projects()).isEqualTo(List.of(CommonCatalogFixtures.basicProjectDetails()));
            softly.assertThat(value.groups()).isEqualTo(List.of(CommonCatalogFixtures.basicGroupDetails()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerDetails original = RunnersCatalogFixtures.ciRunnerDetails();

        final GitLabCiRunnerDetails rebuilt =
                GitLabCiRunnerDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenContactedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabCiRunnerDetailsBuilder builder = GitLabCiRunnerDetailsBuilder.builder(
                        RunnersCatalogFixtures.ciRunnerDetails())
                .contactedAt(instant);

        final GitLabCiRunnerDetails built = builder.build();

        assertThat(built.contactedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "description",
                        "ipAddress",
                        "active",
                        "paused",
                        "isShared",
                        "runnerType",
                        "name",
                        "online",
                        "createdBy",
                        "createdAt",
                        "status",
                        "jobExecutionStatus",
                        "uuid",
                        "tagList",
                        "runUntagged",
                        "locked",
                        "maximumTimeout",
                        "accessLevel",
                        "tokenExpiresAt",
                        "version",
                        "revision",
                        "platform",
                        "architecture",
                        "contactedAt",
                        "maintenanceNote",
                        "projects",
                        "groups");
    }
}
