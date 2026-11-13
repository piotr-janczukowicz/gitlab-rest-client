package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import java.util.List;
import java.util.Map;

public final class ValidategitlabciymlfileCatalogFixtures {

    private ValidategitlabciymlfileCatalogFixtures() {}

    public static GitLabCiLintResult ciLintResult() {
        return GitLabCiLintResultBuilder.builder()
                .valid(true)
                .errors(List.of("variables config should be a hash of key value pairs"))
                .warnings(List.of("jobs:job may allow multiple pipelines ..."))
                .mergedYaml(
                        "---\\n:another_test:\\n  :stage: test\\n\n          :script: echo 2\\n:test:\\n  :stage: test\\n  :script: echo 1\\n")
                .includes(List.of(ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude()))
                .jobs(List.of(Map.of("key", "value")))
                .build();
    }

    public static GitLabCiLintResultInclude ciLintResultInclude() {
        return GitLabCiLintResultIncludeBuilder.builder()
                .type("local")
                .location(".gitlab/ci/build-images.gitlab-ci.yml")
                .blob(
                        "https://gitlab.com/gitlab-org/gitlab/-/blob/e52d6d0246d7375291850e61f0abc101fbda9dc2/.gitlab/ci/build-images.gitlab-ci.yml")
                .raw(
                        "https://gitlab.com/gitlab-org/gitlab/-/raw/e52d6d0246d7375291850e61f0abc101fbda9dc2/.gitlab/ci/build-images.gitlab-ci.yml")
                .extra(Map.of("key", "value"))
                .contextProject("gitlab-org/gitlab")
                .contextSha("e52d6d0246d7375291850e61f0abc101fbda9dc2")
                .build();
    }

    public static GitLabProjectValidateGitlabCiYmlFileCreatePayload projectValidateGitlabCiYmlFileCreatePayload() {
        return GitLabProjectValidateGitlabCiYmlFileCreatePayloadBuilder.builder()
                .content("content")
                .dryRun(true)
                .includeJobs(true)
                .ref("ref")
                .build();
    }
}
