package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).id(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).description(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIpAddressIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).ipAddress(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.ipAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).active(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).paused(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsSharedIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).isShared(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.isShared()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerTypeIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).runnerType(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.runnerType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).name(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlineIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).online(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.online()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).createdBy(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.createdBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).createdAt(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).status(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobExecutionStatusIsNullable() {
        final GitLabCiRunnerBuilder builder =
                GitLabCiRunnerBuilder.builder(CommonCatalogFixtures.ciRunner()).jobExecutionStatus(null);

        final GitLabCiRunner built = builder.build();

        assertThat(built.jobExecutionStatus()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunner value = CommonCatalogFixtures.ciRunner();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("test-1-20150125");
            softly.assertThat(value.ipAddress()).isEqualTo("127.0.0.1");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.isShared()).isEqualTo(true);
            softly.assertThat(value.runnerType()).isEqualTo(GitLabCiRunnerType.INSTANCE_TYPE);
            softly.assertThat(value.name()).isEqualTo("test");
            softly.assertThat(value.online()).isEqualTo(true);
            softly.assertThat(value.createdBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.status()).isEqualTo("online");
            softly.assertThat(value.jobExecutionStatus()).isEqualTo(GitLabCiRunnerJobExecutionStatus.ACTIVE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunner original = CommonCatalogFixtures.ciRunner();

        final GitLabCiRunner rebuilt = GitLabCiRunnerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunner.class.getRecordComponents())
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
                        "jobExecutionStatus");
    }
}
