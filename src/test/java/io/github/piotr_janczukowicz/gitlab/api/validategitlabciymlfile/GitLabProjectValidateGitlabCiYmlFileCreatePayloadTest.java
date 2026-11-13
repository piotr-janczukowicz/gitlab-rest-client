package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectValidateGitlabCiYmlFileCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder.builder(
                                ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload())
                        .content(null);

        final GitLabProjectValidateGitlabCiYmlFileCreatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDryRunIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder.builder(
                                ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload())
                        .dryRun(null);

        final GitLabProjectValidateGitlabCiYmlFileCreatePayload built = builder.build();

        assertThat(built.dryRun()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeJobsIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder.builder(
                                ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload())
                        .includeJobs(null);

        final GitLabProjectValidateGitlabCiYmlFileCreatePayload built = builder.build();

        assertThat(built.includeJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder.builder(
                                ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload())
                        .ref(null);

        final GitLabProjectValidateGitlabCiYmlFileCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectValidateGitlabCiYmlFileCreatePayload value =
                ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.dryRun()).isEqualTo(true);
            softly.assertThat(value.includeJobs()).isEqualTo(true);
            softly.assertThat(value.ref()).isEqualTo("ref");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectValidateGitlabCiYmlFileCreatePayload original =
                ValidategitlabciymlfileCatalogFixtures.projectValidateGitlabCiYmlFileCreatePayload();

        final GitLabProjectValidateGitlabCiYmlFileCreatePayload rebuilt =
                GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectValidateGitlabCiYmlFileCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("content", "dryRun", "includeJobs", "ref");
    }
}
