package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestResponseTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .id(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .token(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowGitFetchIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .allowGitFetch(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.allowGitFetch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobInfoIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .jobInfo(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.jobInfo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitInfoIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .gitInfo(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.gitInfo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerInfoIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .runnerInfo(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.runnerInfo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .inputs(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariablesIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .variables(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.variables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStepsIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .steps(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.steps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHooksIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .hooks(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.hooks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .image(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.image()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServicesIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .services(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.services()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactsIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .artifacts(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.artifacts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCacheIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .cache(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.cache()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCredentialsIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .credentials(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.credentials()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeaturesIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .features(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.features()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependenciesIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .dependencies(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.dependencies()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .run(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.run()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuspendOptionsIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .suspendOptions(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.suspendOptions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretsIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .secrets(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.secrets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPolicyOptionsIsNullable() {
        final GitLabCiJobRequestResponseBuilder builder = GitLabCiJobRequestResponseBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestResponse())
                .policyOptions(null);

        final GitLabCiJobRequestResponse built = builder.build();

        assertThat(built.policyOptions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestResponse value = JobsCatalogFixtures.ciJobRequestResponse();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("id");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.allowGitFetch()).isEqualTo("allow_git_fetch");
            softly.assertThat(value.jobInfo()).isEqualTo(JobsCatalogFixtures.ciJobRequestJobInfo());
            softly.assertThat(value.gitInfo()).isEqualTo(JobsCatalogFixtures.ciJobRequestGitInfo());
            softly.assertThat(value.runnerInfo()).isEqualTo(JobsCatalogFixtures.ciJobRequestRunnerInfo());
            softly.assertThat(value.inputs()).isEqualTo("inputs");
            softly.assertThat(value.variables()).isEqualTo("variables");
            softly.assertThat(value.steps()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestStep()));
            softly.assertThat(value.hooks()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestHook()));
            softly.assertThat(value.image()).isEqualTo(JobsCatalogFixtures.ciJobRequestImage());
            softly.assertThat(value.services()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestService()));
            softly.assertThat(value.artifacts()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestArtifacts()));
            softly.assertThat(value.cache()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestCache()));
            softly.assertThat(value.credentials()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestCredentials()));
            softly.assertThat(value.features()).isEqualTo("features");
            softly.assertThat(value.dependencies()).isEqualTo("dependencies");
            softly.assertThat(value.run()).isEqualTo("run");
            softly.assertThat(value.suspendOptions()).isEqualTo("suspend_options");
            softly.assertThat(value.secrets()).isEqualTo("secrets");
            softly.assertThat(value.policyOptions()).isEqualTo("policy_options");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestResponse original = JobsCatalogFixtures.ciJobRequestResponse();

        final GitLabCiJobRequestResponse rebuilt =
                GitLabCiJobRequestResponseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabCiJobRequestResponse value = JobsCatalogFixtures.ciJobRequestResponse();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretsIsACredential() {
        final GitLabCiJobRequestResponse value = JobsCatalogFixtures.ciJobRequestResponse();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestResponse.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "token",
                        "allowGitFetch",
                        "jobInfo",
                        "gitInfo",
                        "runnerInfo",
                        "inputs",
                        "variables",
                        "steps",
                        "hooks",
                        "image",
                        "services",
                        "artifacts",
                        "cache",
                        "credentials",
                        "features",
                        "dependencies",
                        "run",
                        "suspendOptions",
                        "secrets",
                        "policyOptions");
    }
}
