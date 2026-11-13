package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerManagerTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .id(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSystemIdIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .systemId(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.systemId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .version(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .revision(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .platform(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.platform()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitectureIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .architecture(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.architecture()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .createdAt(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContactedAtIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .contactedAt(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.contactedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIpAddressIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .ipAddress(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.ipAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .status(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobExecutionStatusIsNullable() {
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .jobExecutionStatus(null);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.jobExecutionStatus()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerManager value = CommonCatalogFixtures.ciRunnerManager();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.systemId()).isEqualTo("runner-1");
            softly.assertThat(value.version()).isEqualTo("16.11.0");
            softly.assertThat(value.revision()).isEqualTo("91a27b2a");
            softly.assertThat(value.platform()).isEqualTo("linux");
            softly.assertThat(value.architecture()).isEqualTo("amd64");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.contactedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.ipAddress()).isEqualTo("127.0.0.1");
            softly.assertThat(value.status()).isEqualTo("online");
            softly.assertThat(value.jobExecutionStatus()).isEqualTo(GitLabCiRunnerManagerJobExecutionStatus.ACTIVE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerManager original = CommonCatalogFixtures.ciRunnerManager();

        final GitLabCiRunnerManager rebuilt =
                GitLabCiRunnerManagerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .createdAt(instant);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenContactedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabCiRunnerManagerBuilder builder = GitLabCiRunnerManagerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerManager())
                .contactedAt(instant);

        final GitLabCiRunnerManager built = builder.build();

        assertThat(built.contactedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerManager.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "systemId",
                        "version",
                        "revision",
                        "platform",
                        "architecture",
                        "createdAt",
                        "contactedAt",
                        "ipAddress",
                        "status",
                        "jobExecutionStatus");
    }
}
