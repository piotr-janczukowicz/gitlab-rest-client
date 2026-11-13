package io.github.piotr_janczukowicz.gitlab.api.pullmirroring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPullMirroringUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .enabled(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .url(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthUserIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .authUser(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.authUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthPasswordIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .authPassword(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.authPassword()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorTriggerBuildsIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .mirrorTriggerBuilds(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.mirrorTriggerBuilds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyMirrorProtectedBranchesIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .onlyMirrorProtectedBranches(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.onlyMirrorProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorOverwritesDivergedBranchesIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .mirrorOverwritesDivergedBranches(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.mirrorOverwritesDivergedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorBranchRegexIsNullable() {
        final GitLabProjectPullMirroringUpdatePayloadBuilder builder =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(
                                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload())
                        .mirrorBranchRegex(null);

        final GitLabProjectPullMirroringUpdatePayload built = builder.build();

        assertThat(built.mirrorBranchRegex()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPullMirroringUpdatePayload value =
                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.authUser()).isEqualTo("auth_user");
            softly.assertThat(value.authPassword()).isEqualTo("auth_password");
            softly.assertThat(value.mirrorTriggerBuilds()).isEqualTo(true);
            softly.assertThat(value.onlyMirrorProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.mirrorOverwritesDivergedBranches()).isEqualTo(true);
            softly.assertThat(value.mirrorBranchRegex()).isEqualTo("mirror_branch_regex");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPullMirroringUpdatePayload original =
                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload();

        final GitLabProjectPullMirroringUpdatePayload rebuilt =
                GitLabProjectPullMirroringUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAuthPasswordIsACredential() {
        final GitLabProjectPullMirroringUpdatePayload value =
                PullmirroringCatalogFixtures.projectPullMirroringUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPullMirroringUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "enabled",
                        "url",
                        "authUser",
                        "authPassword",
                        "mirrorTriggerBuilds",
                        "onlyMirrorProtectedBranches",
                        "mirrorOverwritesDivergedBranches",
                        "mirrorBranchRegex");
    }
}
