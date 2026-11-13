package io.github.piotr_janczukowicz.gitlab.api.pullmirroring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPullMirroringCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .action(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullRequestNumberIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .pullRequestNumber(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.pullRequestNumber()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullRequestHeadRefIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .pullRequestHeadRef(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.pullRequestHeadRef()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullRequestHeadShaIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .pullRequestHeadSha(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.pullRequestHeadSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullRequestHeadRepoFullNameIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .pullRequestHeadRepoFullName(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.pullRequestHeadRepoFullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullRequestBaseRefIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .pullRequestBaseRef(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.pullRequestBaseRef()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullRequestBaseShaIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .pullRequestBaseSha(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.pullRequestBaseSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullRequestBaseRepoFullNameIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .pullRequestBaseRepoFullName(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.pullRequestBaseRepoFullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForceIsNullable() {
        final GitLabProjectPullMirroringCreatePayloadBuilder builder =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload())
                        .force(null);

        final GitLabProjectPullMirroringCreatePayload built = builder.build();

        assertThat(built.force()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPullMirroringCreatePayload value =
                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.action()).isEqualTo("action");
            softly.assertThat(value.pullRequestNumber()).isEqualTo(1);
            softly.assertThat(value.pullRequestHeadRef()).isEqualTo("pull_request.head.ref");
            softly.assertThat(value.pullRequestHeadSha()).isEqualTo("pull_request.head.sha");
            softly.assertThat(value.pullRequestHeadRepoFullName()).isEqualTo("pull_request.head.repo.full_name");
            softly.assertThat(value.pullRequestBaseRef()).isEqualTo("pull_request.base.ref");
            softly.assertThat(value.pullRequestBaseSha()).isEqualTo("pull_request.base.sha");
            softly.assertThat(value.pullRequestBaseRepoFullName()).isEqualTo("pull_request.base.repo.full_name");
            softly.assertThat(value.force()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPullMirroringCreatePayload original =
                PullmirroringCatalogFixtures.projectPullMirroringCreatePayload();

        final GitLabProjectPullMirroringCreatePayload rebuilt =
                GitLabProjectPullMirroringCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPullMirroringCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "action",
                        "pullRequestNumber",
                        "pullRequestHeadRef",
                        "pullRequestHeadSha",
                        "pullRequestHeadRepoFullName",
                        "pullRequestBaseRef",
                        "pullRequestBaseSha",
                        "pullRequestBaseRepoFullName",
                        "force");
    }
}
