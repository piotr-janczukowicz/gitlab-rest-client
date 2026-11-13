package io.github.piotr_janczukowicz.gitlab.api.projectpushrules;

import java.time.Instant;

public final class ProjectpushrulesCatalogFixtures {

    private ProjectpushrulesCatalogFixtures() {}

    public static GitLabProjectProjectPushRulesCreatePayload projectProjectPushRulesCreatePayload() {
        return GitLabProjectProjectPushRulesCreatePayloadBuilder.builder()
                .denyDeleteTag(true)
                .memberCheck(true)
                .preventSecrets(true)
                .commitMessageRegex("Fixed \\d+\\..*")
                .commitMessageNegativeRegex("ssh\\:\\/\\/")
                .branchNameRegex("(feature|hotfix)\\/.*")
                .authorEmailRegex("@my-company.com$")
                .fileNameRegex("(jar|exe)$")
                .maxFileSize(1L)
                .commitCommitterCheck(true)
                .commitCommitterNameCheck(true)
                .rejectUnsignedCommits(true)
                .rejectNonDcoCommits(true)
                .build();
    }

    public static GitLabProjectProjectPushRulesUpdatePayload projectProjectPushRulesUpdatePayload() {
        return GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder()
                .denyDeleteTag(true)
                .memberCheck(true)
                .preventSecrets(true)
                .commitMessageRegex("Fixed \\d+\\..*")
                .commitMessageNegativeRegex("ssh\\:\\/\\/")
                .branchNameRegex("(feature|hotfix)\\/.*")
                .authorEmailRegex("@my-company.com$")
                .fileNameRegex("(jar|exe)$")
                .maxFileSize(1L)
                .commitCommitterCheck(true)
                .commitCommitterNameCheck(true)
                .rejectUnsignedCommits(true)
                .rejectNonDcoCommits(true)
                .build();
    }

    public static GitLabProjectPushRule projectPushRule() {
        return GitLabProjectPushRuleBuilder.builder()
                .id(1L)
                .projectId(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .commitMessageRegex("Fixed \\d+\\..*")
                .commitMessageNegativeRegex("ssh\\:\\/\\/")
                .branchNameRegex("(feature|hotfix)\\/.*")
                .denyDeleteTag(true)
                .memberCheck(true)
                .preventSecrets(true)
                .authorEmailRegex("@my-company.com$")
                .fileNameRegex("(jar|exe)$")
                .maxFileSize(1L)
                .commitCommitterCheck(true)
                .commitCommitterNameCheck(true)
                .rejectUnsignedCommits(true)
                .rejectNonDcoCommits(true)
                .build();
    }
}
