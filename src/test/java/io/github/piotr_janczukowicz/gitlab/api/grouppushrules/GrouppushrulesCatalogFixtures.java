package io.github.piotr_janczukowicz.gitlab.api.grouppushrules;

import java.time.Instant;

public final class GrouppushrulesCatalogFixtures {

    private GrouppushrulesCatalogFixtures() {}

    public static GitLabGroupGroupPushRulesCreatePayload groupGroupPushRulesCreatePayload() {
        return GitLabGroupGroupPushRulesCreatePayloadBuilder.builder()
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

    public static GitLabGroupGroupPushRulesUpdatePayload groupGroupPushRulesUpdatePayload() {
        return GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder()
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

    public static GitLabGroupPushRule groupPushRule() {
        return GitLabGroupPushRuleBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .commitMessageRegex("[a-zA-Z]")
                .commitMessageNegativeRegex("[x+]")
                .branchNameRegex("[a-z]")
                .authorEmailRegex("^[A-Za-z0-9.]+@gitlab.com$")
                .fileNameRegex("(exe)$")
                .denyDeleteTag(true)
                .memberCheck(true)
                .preventSecrets(true)
                .maxFileSize(1L)
                .commitCommitterCheck(true)
                .commitCommitterNameCheck(true)
                .rejectUnsignedCommits(true)
                .rejectNonDcoCommits(true)
                .build();
    }
}
