package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesCreateChangelogPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenFromValueIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .fromValue(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.fromValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .to(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.to()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDateIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .date(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.date()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrailerIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .trailer(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.trailer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfigFileIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .configFile(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.configFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfigFileRefIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .configFileRef(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.configFileRef()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .branch(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .file(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.file()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabProjectRepositoriesCreateChangelogPayloadBuilder builder =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload())
                        .message(null);

        final GitLabProjectRepositoriesCreateChangelogPayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesCreateChangelogPayload value =
                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.fromValue()).isEqualTo("ed899a2f4b50b4370feeea94676502b42383c746");
            softly.assertThat(value.to()).isEqualTo("6104942438c14ec7bd21c6cd5bd995272b3faff6");
            softly.assertThat(value.date()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.trailer()).isEqualTo("Changelog");
            softly.assertThat(value.configFile()).isEqualTo(".gitlab/changelog_config.yml");
            softly.assertThat(value.configFileRef()).isEqualTo("main");
            softly.assertThat(value.branch()).isEqualTo("main");
            softly.assertThat(value.file()).isEqualTo("CHANGELOG.md");
            softly.assertThat(value.message()).isEqualTo("Initial commit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesCreateChangelogPayload original =
                RepositoriesCatalogFixtures.projectRepositoriesCreateChangelogPayload();

        final GitLabProjectRepositoriesCreateChangelogPayload rebuilt =
                GitLabProjectRepositoriesCreateChangelogPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectRepositoriesCreateChangelogPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "fromValue",
                        "to",
                        "date",
                        "trailer",
                        "configFile",
                        "configFileRef",
                        "branch",
                        "file",
                        "message");
    }
}
