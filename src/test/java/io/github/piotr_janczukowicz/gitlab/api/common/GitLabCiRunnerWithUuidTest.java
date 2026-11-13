package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerWithUuidTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .id(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .description(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIpAddressIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .ipAddress(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.ipAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .active(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .paused(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsSharedIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .isShared(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.isShared()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerTypeIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .runnerType(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.runnerType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .name(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlineIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .online(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.online()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .createdBy(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.createdBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .createdAt(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .status(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobExecutionStatusIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .jobExecutionStatus(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.jobExecutionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUuidIsNullable() {
        final GitLabCiRunnerWithUuidBuilder builder = GitLabCiRunnerWithUuidBuilder.builder(
                        CommonCatalogFixtures.ciRunnerWithUuid())
                .uuid(null);

        final GitLabCiRunnerWithUuid built = builder.build();

        assertThat(built.uuid()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerWithUuid value = CommonCatalogFixtures.ciRunnerWithUuid();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("test-1-20150125");
            softly.assertThat(value.ipAddress()).isEqualTo("127.0.0.1");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.isShared()).isEqualTo(true);
            softly.assertThat(value.runnerType()).isEqualTo(GitLabCiRunnerWithUuidRunnerType.INSTANCE_TYPE);
            softly.assertThat(value.name()).isEqualTo("test");
            softly.assertThat(value.online()).isEqualTo(true);
            softly.assertThat(value.createdBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.status()).isEqualTo("online");
            softly.assertThat(value.jobExecutionStatus()).isEqualTo(GitLabCiRunnerWithUuidJobExecutionStatus.ACTIVE);
            softly.assertThat(value.uuid()).isEqualTo("01966aa0-f383-7a6b-b694-cd4f2f96cca1");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerWithUuid original = CommonCatalogFixtures.ciRunnerWithUuid();

        final GitLabCiRunnerWithUuid rebuilt =
                GitLabCiRunnerWithUuidBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerWithUuid.class.getRecordComponents())
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
                        "uuid");
    }
}
