package io.github.piotr_janczukowicz.gitlab.api.common;

import io.github.piotr_janczukowicz.gitlab.api.releaselinks.ReleaselinksCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class CommonCatalogFixtures {

    private CommonCatalogFixtures() {}

    public static GitLabApplication application() {
        return GitLabApplicationBuilder.builder()
                .id(1L)
                .applicationId("5832fc6e14300a0d962240a8144466eef4ee93ef0d218477e55f11cf12fc3737")
                .applicationName("MyApplication")
                .callbackUrl("https://redirect.uri")
                .confidential(true)
                .scopes(List.of("api"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .build();
    }

    public static GitLabApplicationWithSecret applicationWithSecret() {
        return GitLabApplicationWithSecretBuilder.builder()
                .id(1L)
                .applicationId("5832fc6e14300a0d962240a8144466eef4ee93ef0d218477e55f11cf12fc3737")
                .applicationName("MyApplication")
                .callbackUrl("https://redirect.uri")
                .confidential(true)
                .scopes(List.of("api"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .secret("ee1dd64b6adc89cf7e2c23099301ccc2c61b441064e9324d963c46902a85ec34")
                .warnings(List.of(
                        "Tokens cannot use the MCP server without a user-level scope granting execute_mcp_tool."))
                .build();
    }

    public static GitLabApprovalRuleShort approvalRuleShort() {
        return GitLabApprovalRuleShortBuilder.builder()
                .id(1L)
                .name("QA")
                .ruleType("regular")
                .build();
    }

    public static GitLabApprovals approvals() {
        return GitLabApprovalsBuilder.builder()
                .user(CommonCatalogFixtures.userBasic())
                .approvedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabAuditEvent auditEvent() {
        return GitLabAuditEventBuilder.builder()
                .id(1L)
                .authorId(1L)
                .entityId(1L)
                .entityType("entity_type")
                .eventName("event_name")
                .details(Map.of("key", "value"))
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabAwardEmoji awardEmoji() {
        return GitLabAwardEmojiBuilder.builder()
                .id(1L)
                .name("lizard")
                .user(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .awardableId(1L)
                .awardableType("Issue")
                .url("https://example.com/emojis/example.gif")
                .build();
    }

    public static GitLabBadge badge() {
        return GitLabBadgeBuilder.builder()
                .name("Pipeline Status")
                .linkUrl("https://example.gitlab.com")
                .imageUrl("https://example.gitlab.com")
                .renderedLinkUrl("https://example.gitlab.com")
                .renderedImageUrl("https://example.gitlab.com")
                .id(1L)
                .kind("project")
                .build();
    }

    public static GitLabBasicBadgeDetails basicBadgeDetails() {
        return GitLabBasicBadgeDetailsBuilder.builder()
                .name("Pipeline Status")
                .linkUrl("https://example.gitlab.com")
                .imageUrl("https://example.gitlab.com")
                .renderedLinkUrl("https://example.gitlab.com")
                .renderedImageUrl("https://example.gitlab.com")
                .build();
    }

    public static GitLabBasicGroupDetails basicGroupDetails() {
        return GitLabBasicGroupDetailsBuilder.builder()
                .id(1L)
                .webUrl("http://gitlab.example.com/groups/diaspora")
                .name("Diaspora")
                .build();
    }

    public static GitLabBasicProjectDetails basicProjectDetails() {
        return GitLabBasicProjectDetailsBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .defaultBranch("main")
                .tagList(List.of("tag"))
                .topics(List.of("topic"))
                .sshUrlToRepo("git@gitlab.example.com:gitlab/gitlab.git")
                .httpUrlToRepo("https://gitlab.example.com/gitlab/gitlab.git")
                .webUrl("https://gitlab.example.com/gitlab/gitlab")
                .readmeUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/README.md")
                .forksCount(1)
                .licenseUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/LICENCE")
                .license(CommonCatalogFixtures.licenseBasic())
                .avatarUrl("http://example.com/uploads/project/avatar/3/uploads/avatar.png")
                .starCount(1)
                .lastActivityAt(Instant.parse("2026-01-01T00:00:00Z"))
                .visibility("public")
                .namespace(CommonCatalogFixtures.namespaceBasic())
                .customAttributes(CommonCatalogFixtures.customAttribute())
                .repositoryStorage("default")
                .build();
    }

    public static GitLabBasicSnippet basicSnippet() {
        return GitLabBasicSnippetBuilder.builder()
                .id(1L)
                .title("test")
                .description("Ruby test snippet")
                .visibility("public")
                .author(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .webUrl("http://example.com/example/example/snippets/1")
                .rawUrl("http://example.com/example/example/snippets/1/raw")
                .sshUrlToRepo("ssh://user@gitlab.example.com/snippets/65.git")
                .httpUrlToRepo("https://gitlab.example.com/snippets/65.git")
                .build();
    }

    public static GitLabBasicSuccess basicSuccess() {
        return GitLabBasicSuccessBuilder.builder()
                .success(Map.of("key", "value"))
                .build();
    }

    public static GitLabBoard board() {
        return GitLabBoardBuilder.builder()
                .id(1L)
                .name("Development")
                .hideBacklogList(true)
                .hideClosedList(true)
                .project(CommonCatalogFixtures.basicProjectDetails())
                .lists(List.of(CommonCatalogFixtures.list()))
                .group(CommonCatalogFixtures.basicGroupDetails())
                .milestone(Map.of("key", "value"))
                .assignee(CommonCatalogFixtures.userBasic())
                .labels(List.of(CommonCatalogFixtures.labelBasic()))
                .weight(1)
                .build();
    }

    public static GitLabBulkImport bulkImport() {
        return GitLabBulkImportBuilder.builder()
                .id(1L)
                .status(GitLabBulkImportStatus.CREATED)
                .sourceType("gitlab")
                .sourceUrl("https://source.gitlab.com/")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .hasFailures(true)
                .build();
    }

    public static GitLabBulkImportsExportBatchStatus bulkImportsExportBatchStatus() {
        return GitLabBulkImportsExportBatchStatusBuilder.builder()
                .status(GitLabBulkImportsExportBatchStatusStatus.STARTED)
                .batchNumber(1)
                .objectsCount(1)
                .error("Error message")
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabBulkImportsExportStatus bulkImportsExportStatus() {
        return GitLabBulkImportsExportStatusBuilder.builder()
                .relation("issues")
                .status(GitLabBulkImportsExportStatusStatus.PENDING)
                .error("Error message")
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .batched(true)
                .batchesCount(1)
                .totalObjectsCount(1)
                .batches(List.of(CommonCatalogFixtures.bulkImportsExportBatchStatus()))
                .build();
    }

    public static GitLabCiJob ciJob() {
        return GitLabCiJobBuilder.builder()
                .id(1L)
                .status("waiting_for_resource")
                .stage("deploy")
                .name("deploy_to_production")
                .ref("main")
                .tag(true)
                .coverage(1.5)
                .allowFailure(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .erasedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .duration(1.5)
                .queuedDuration(1.5)
                .user(CommonCatalogFixtures.user())
                .commit(CommonCatalogFixtures.commit())
                .pipeline(CommonCatalogFixtures.ciPipelineBasic())
                .failureReason("script_failure")
                .webUrl("https://example.com/foo/bar/-/jobs/1")
                .project(CommonCatalogFixtures.ciJobProject())
                .artifactsFile(CommonCatalogFixtures.ciJobArtifactFile())
                .artifacts(List.of(CommonCatalogFixtures.ciJobArtifact()))
                .runner(CommonCatalogFixtures.ciRunner())
                .runnerManager(CommonCatalogFixtures.ciRunnerManager())
                .artifactsExpireAt(Instant.parse("2026-01-01T00:00:00Z"))
                .archived(true)
                .tagList(List.of("ubuntu18"))
                .build();
    }

    public static GitLabCiJobArtifact ciJobArtifact() {
        return GitLabCiJobArtifactBuilder.builder()
                .fileType(GitLabCiJobArtifactFileType.ARCHIVE)
                .size(1L)
                .filename("artifacts.zip")
                .fileFormat(GitLabCiJobArtifactFileFormat.RAW)
                .build();
    }

    public static GitLabCiJobArtifactFile ciJobArtifactFile() {
        return GitLabCiJobArtifactFileBuilder.builder()
                .filename("artifacts.zip")
                .size(1L)
                .build();
    }

    public static GitLabCiJobBasic ciJobBasic() {
        return GitLabCiJobBasicBuilder.builder()
                .id(1L)
                .status("waiting_for_resource")
                .stage("deploy")
                .name("deploy_to_production")
                .ref("main")
                .tag(true)
                .coverage(1.5)
                .allowFailure(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .erasedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .duration(1.5)
                .queuedDuration(1.5)
                .user(CommonCatalogFixtures.user())
                .commit(CommonCatalogFixtures.commit())
                .pipeline(CommonCatalogFixtures.ciPipelineBasic())
                .failureReason("script_failure")
                .webUrl("https://example.com/foo/bar/-/jobs/1")
                .project(CommonCatalogFixtures.ciJobBasicProject())
                .build();
    }

    public static GitLabCiJobBasicProject ciJobBasicProject() {
        return GitLabCiJobBasicProjectBuilder.builder()
                .ciJobTokenScopeEnabled("ci_job_token_scope_enabled")
                .build();
    }

    public static GitLabCiJobProject ciJobProject() {
        return GitLabCiJobProjectBuilder.builder().ciJobTokenScopeEnabled(true).build();
    }

    public static GitLabCiPipeline ciPipeline() {
        return GitLabCiPipelineBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .sha("0ec9e58fdfca6cdd6652c083c9edb53abc0bad52")
                .ref("feature-branch")
                .status("success")
                .source("push")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .webUrl("https://gitlab.example.com/gitlab-org/gitlab-foss/-/pipelines/61")
                .beforeSha("a91957a858320c0e17f3a0eca7cfacbff50ea29a")
                .tag(true)
                .yamlErrors("widgets:build: needs 'widgets:test'")
                .user(CommonCatalogFixtures.userBasic())
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .committedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .duration(1)
                .queuedDuration(1)
                .coverage(1.5)
                .detailedStatus(CommonCatalogFixtures.detailedStatusEntity())
                .archived(true)
                .build();
    }

    public static GitLabCiPipelineBasic ciPipelineBasic() {
        return GitLabCiPipelineBasicBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .sha("0ec9e58fdfca6cdd6652c083c9edb53abc0bad52")
                .ref("feature-branch")
                .status("success")
                .source("push")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .webUrl("https://gitlab.example.com/gitlab-org/gitlab-foss/-/pipelines/61")
                .build();
    }

    public static GitLabCiResetTokenResult ciResetTokenResult() {
        return GitLabCiResetTokenResultBuilder.builder()
                .token("token")
                .tokenExpiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabCiRunner ciRunner() {
        return GitLabCiRunnerBuilder.builder()
                .id(1L)
                .description("test-1-20150125")
                .ipAddress("127.0.0.1")
                .active(true)
                .paused(true)
                .isShared(true)
                .runnerType(GitLabCiRunnerType.INSTANCE_TYPE)
                .name("test")
                .online(true)
                .createdBy(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .status("online")
                .jobExecutionStatus(GitLabCiRunnerJobExecutionStatus.ACTIVE)
                .build();
    }

    public static GitLabCiRunnerController ciRunnerController() {
        return GitLabCiRunnerControllerBuilder.builder()
                .id(1L)
                .description("Controller for managing runner")
                .state("enabled")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabCiRunnerManager ciRunnerManager() {
        return GitLabCiRunnerManagerBuilder.builder()
                .id(1L)
                .systemId("runner-1")
                .version("16.11.0")
                .revision("91a27b2a")
                .platform("linux")
                .architecture("amd64")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .contactedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .ipAddress("127.0.0.1")
                .status("online")
                .jobExecutionStatus(GitLabCiRunnerManagerJobExecutionStatus.ACTIVE)
                .build();
    }

    public static GitLabCiRunnerRegistrationDetails ciRunnerRegistrationDetails() {
        return GitLabCiRunnerRegistrationDetailsBuilder.builder()
                .id("id")
                .token("token")
                .tokenExpiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabCiRunnerWithUuid ciRunnerWithUuid() {
        return GitLabCiRunnerWithUuidBuilder.builder()
                .id(1L)
                .description("test-1-20150125")
                .ipAddress("127.0.0.1")
                .active(true)
                .paused(true)
                .isShared(true)
                .runnerType(GitLabCiRunnerWithUuidRunnerType.INSTANCE_TYPE)
                .name("test")
                .online(true)
                .createdBy(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .status("online")
                .jobExecutionStatus(GitLabCiRunnerWithUuidJobExecutionStatus.ACTIVE)
                .uuid("01966aa0-f383-7a6b-b694-cd4f2f96cca1")
                .build();
    }

    public static GitLabCiVariable ciVariable() {
        return GitLabCiVariableBuilder.builder()
                .variableType("env_var")
                .key("TEST_VARIABLE_1")
                .value("TEST_1")
                .hidden(true)
                .protectedValue(true)
                .masked(true)
                .raw(true)
                .environmentScope("*")
                .description("This variable is being used for ...")
                .build();
    }

    public static GitLabCluster cluster() {
        return GitLabClusterBuilder.builder()
                .id("id")
                .name("name")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .domain("domain")
                .enabled("enabled")
                .managed("managed")
                .providerType("provider_type")
                .platformType("platform_type")
                .environmentScope("environment_scope")
                .clusterType("cluster_type")
                .namespacePerEnvironment("namespace_per_environment")
                .user(CommonCatalogFixtures.userBasic())
                .platformKubernetes(CommonCatalogFixtures.platformKubernetes())
                .providerGcp(CommonCatalogFixtures.providerGcp())
                .managementProject(CommonCatalogFixtures.projectIdentity())
                .build();
    }

    public static GitLabClusterAgent clusterAgent() {
        return GitLabClusterAgentBuilder.builder()
                .id(1L)
                .name("name")
                .configProject(CommonCatalogFixtures.projectIdentity())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdByUserId(1L)
                .isReceptive(true)
                .build();
    }

    public static GitLabCommit commit() {
        return GitLabCommitBuilder.builder()
                .id("2695effb5807a22ff3d138d593fd856244e155e7")
                .shortId("2695effb")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .parentIds(List.of("2a4b78934375d7f53875269ffd4f45fd83a84ebe"))
                .title("Initial commit")
                .message("Initial commit")
                .authorName("John Smith")
                .authorEmail("john@example.com")
                .authoredDate(Instant.parse("2026-01-01T00:00:00Z"))
                .committerName("Jack Smith")
                .committerEmail("jack@example.com")
                .committedDate(Instant.parse("2026-01-01T00:00:00Z"))
                .trailers(Map.of("key", "value"))
                .extendedTrailers(Map.of("key", "value"))
                .webUrl(
                        "https://gitlab.example.com/janedoe/gitlab-foss/-/commit/ed899a2f4b50b4370feeea94676502b42383c746")
                .build();
    }

    public static GitLabCommitDetail commitDetail() {
        return GitLabCommitDetailBuilder.builder()
                .id("2695effb5807a22ff3d138d593fd856244e155e7")
                .shortId("2695effb")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .parentIds(List.of("2a4b78934375d7f53875269ffd4f45fd83a84ebe"))
                .title("Initial commit")
                .message("Initial commit")
                .authorName("John Smith")
                .authorEmail("john@example.com")
                .authoredDate(Instant.parse("2026-01-01T00:00:00Z"))
                .committerName("Jack Smith")
                .committerEmail("jack@example.com")
                .committedDate(Instant.parse("2026-01-01T00:00:00Z"))
                .trailers(Map.of("key", "value"))
                .extendedTrailers(Map.of("key", "value"))
                .webUrl(
                        "https://gitlab.example.com/janedoe/gitlab-foss/-/commit/ed899a2f4b50b4370feeea94676502b42383c746")
                .stats(CommonCatalogFixtures.commitStats())
                .status("success")
                .projectId(1L)
                .lastPipeline(Map.of("key", "value"))
                .build();
    }

    public static GitLabCommitStats commitStats() {
        return GitLabCommitStatsBuilder.builder()
                .additions(1)
                .deletions(1)
                .total(1)
                .build();
    }

    public static GitLabContainerExpirationPolicy containerExpirationPolicy() {
        return GitLabContainerExpirationPolicyBuilder.builder()
                .cadence("7d")
                .enabled(true)
                .keepN(1)
                .olderThan("90d")
                .nameRegex(".*")
                .nameRegexKeep("name_regex_keep")
                .nextRunAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabContainerRegistryRepository containerRegistryRepository() {
        return GitLabContainerRegistryRepositoryBuilder.builder()
                .id(1L)
                .name("releases")
                .path("group/project/releases")
                .projectId(1L)
                .location("gitlab.example.com/group/project/releases")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .cleanupPolicyStartedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .tagsCount(1)
                .tags(List.of(CommonCatalogFixtures.containerRegistryTag()))
                .deleteApiPath("delete/api/path")
                .size(1L)
                .status("delete_scheduled")
                .build();
    }

    public static GitLabContainerRegistryTag containerRegistryTag() {
        return GitLabContainerRegistryTagBuilder.builder()
                .name("latest")
                .path("namespace1/project1/test_image_1:latest")
                .location("registry.dev/namespace1/project1/test_image_1:latest")
                .build();
    }

    public static GitLabCustomAttribute customAttribute() {
        return GitLabCustomAttributeBuilder.builder().key("foo").value("bar").build();
    }

    public static GitLabDeployKey deployKey() {
        return GitLabDeployKeyBuilder.builder()
                .id(1L)
                .title("Sample key 25")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .key(
                        "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQDNJAkI3Wdf0r13c8a5pEExB2YowPWCSVzfZV22pNBc1CuEbyYLHpUyaD0GwpGvFdx2aP7lMEk35k6Rz3ccBF6jRaVJyhsn5VNnW92PMpBJ/P1UebhXwsFHdQf5rTt082cSxWuk61kGWRQtk4ozt/J2DF/dIUVaLvc+z4HomT41fQ==")
                .usageType("auth")
                .fingerprint("4a:9d:64:15:ed:3a:e6:07:6e:89:36:b3:3b:03:05:d9")
                .fingerprintSha256("Jrs3LD1Ji30xNLtTVf9NDCj7kkBgPBb2pjvTZ3HfIgU")
                .projectsWithWriteAccess(List.of(CommonCatalogFixtures.projectIdentity()))
                .projectsWithReadonlyAccess(List.of(CommonCatalogFixtures.projectIdentity()))
                .build();
    }

    public static GitLabDeployment deployment() {
        return GitLabDeploymentBuilder.builder()
                .id(1L)
                .iid(1L)
                .ref("main")
                .sha("99d03678b90d914dbb1b109132516d71a4a03ea8")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .user(CommonCatalogFixtures.userBasic())
                .environment(CommonCatalogFixtures.environmentBasic())
                .deployable(CommonCatalogFixtures.ciJob())
                .status("created")
                .build();
    }

    public static GitLabDetailedStatusEntity detailedStatusEntity() {
        return GitLabDetailedStatusEntityBuilder.builder()
                .icon("status_success")
                .text("passed")
                .label("passed")
                .group("success")
                .tooltip("passed")
                .hasDetails(true)
                .detailsPath("/test-group/test-project/-/pipelines/287")
                .illustration(Map.of("key", "value"))
                .favicon("/assets/ci_favicons/favicon_status_success.png")
                .action(CommonCatalogFixtures.detailedStatusEntityAction())
                .build();
    }

    public static GitLabDetailedStatusEntityAction detailedStatusEntityAction() {
        return GitLabDetailedStatusEntityActionBuilder.builder()
                .icon("cancel")
                .title("Cancel")
                .path("/namespace1/project1/-/jobs/2/cancel")
                .method("post")
                .buttonTitle("Cancel this job")
                .confirmationMessage("Are you sure?")
                .build();
    }

    public static GitLabDiff diff() {
        return GitLabDiffBuilder.builder()
                .diff("@@ -71,6 +71,8 @@\\n...")
                .collapsed(true)
                .tooLarge(true)
                .newPath("doc/update/5.4-to-6.0.md")
                .oldPath("doc/update/5.4-to-6.0.md")
                .aMode("100755")
                .bMode("100644")
                .newFile(true)
                .renamedFile(true)
                .deletedFile(true)
                .generatedFile(true)
                .build();
    }

    public static GitLabDiffRefs diffRefs() {
        return GitLabDiffRefsBuilder.builder()
                .baseSha("b83d6e391c22777fca1ed3012fce84f633d7fed0")
                .headSha("b83d6e391c22777fca1ed3012fce84f633d7fed0")
                .startSha("b83d6e391c22777fca1ed3012fce84f633d7fed0")
                .build();
    }

    public static GitLabElasticIndexSetting elasticIndexSetting() {
        return GitLabElasticIndexSettingBuilder.builder()
                .aliasName("gitlab-production")
                .numberOfShards(1)
                .numberOfReplicas(1)
                .build();
    }

    public static GitLabEmail email() {
        return GitLabEmailBuilder.builder()
                .id(1L)
                .email("user@example.com")
                .confirmedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabEnvironmentBasic environmentBasic() {
        return GitLabEnvironmentBasicBuilder.builder()
                .id(1L)
                .name("deploy")
                .slug("deploy")
                .externalUrl("https://deploy.gitlab.example.com")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabEpic epic() {
        return GitLabEpicBuilder.builder()
                .id(1L)
                .workItemId(1L)
                .iid(1L)
                .color("#1068bf")
                .textColor("#1068bf")
                .groupId(1L)
                .parentId(1L)
                .parentIid(1L)
                .imported(true)
                .importedFrom("github")
                .title("My Epic")
                .description("Epic description")
                .confidential(true)
                .author(CommonCatalogFixtures.userBasic())
                .startDate(LocalDate.parse("2026-01-01"))
                .startDateIsFixed(true)
                .startDateFixed(LocalDate.parse("2026-01-01"))
                .startDateFromInheritedSource(Instant.parse("2026-01-01T00:00:00Z"))
                .startDateFromMilestones(Instant.parse("2026-01-01T00:00:00Z"))
                .endDate(LocalDate.parse("2026-01-01"))
                .dueDate(LocalDate.parse("2026-01-01"))
                .dueDateIsFixed(true)
                .dueDateFixed(LocalDate.parse("2026-01-01"))
                .dueDateFromInheritedSource(Instant.parse("2026-01-01T00:00:00Z"))
                .dueDateFromMilestones(Instant.parse("2026-01-01T00:00:00Z"))
                .state("opened")
                .webEditUrl("http://gitlab.example.com/groups/test/-/epics/4/edit")
                .webUrl("http://gitlab.example.com/groups/test/-/epics/4")
                .references(CommonCatalogFixtures.issuableReferences())
                .reference("&1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .labels(List.of("labels"))
                .upvotes(1)
                .downvotes(1)
                .subscribed(true)
                .links(CommonCatalogFixtures.epicLinks())
                .build();
    }

    public static GitLabEpicBaseEntity epicBaseEntity() {
        return GitLabEpicBaseEntityBuilder.builder()
                .id(1L)
                .iid(1L)
                .title("title")
                .url("url")
                .groupId(1L)
                .humanReadableEndDate("human_readable_end_date")
                .humanReadableTimestamp("human_readable_timestamp")
                .build();
    }

    public static GitLabEpicIssue epicIssue() {
        return GitLabEpicIssueBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedBy(CommonCatalogFixtures.userBasic())
                .labels(List.of("bug"))
                .milestone(CommonCatalogFixtures.milestone())
                .assignees(List.of(CommonCatalogFixtures.userBasic()))
                .author(CommonCatalogFixtures.userBasic())
                .type(GitLabEpicIssueType.ISSUE)
                .assignee(CommonCatalogFixtures.userBasic())
                .userNotesCount(1)
                .mergeRequestsCount(1)
                .upvotes(1)
                .downvotes(1)
                .startDate(LocalDate.parse("2026-01-01"))
                .dueDate(LocalDate.parse("2026-01-01"))
                .confidential(true)
                .discussionLocked(true)
                .issueType("issue")
                .webUrl("http://example.com/example/example/issues/14")
                .timeStats(CommonCatalogFixtures.issuableTimeStats())
                .taskCompletionStatus(CommonCatalogFixtures.taskCompletionStatus())
                .weight(1)
                .blockingIssuesCount(1)
                .hasTasks(true)
                .taskStatus("2 of 4 tasks completed")
                .links(CommonCatalogFixtures.epicIssueLinks())
                .references(CommonCatalogFixtures.issuableReferences())
                .severity(GitLabEpicIssueSeverity.UNKNOWN)
                .subscribed(true)
                .movedToId(1L)
                .imported(true)
                .importedFrom("github")
                .serviceDeskReplyTo("user@example.com")
                .epicIid("epic_iid")
                .epic(CommonCatalogFixtures.epicBaseEntity())
                .iteration(CommonCatalogFixtures.iteration())
                .healthStatus("health_status")
                .epicIssueId(1L)
                .relativePosition(1)
                .build();
    }

    public static GitLabEpicIssueLinks epicIssueLinks() {
        return GitLabEpicIssueLinksBuilder.builder()
                .self("http://example.com/api/v4/projects/1/issues/2")
                .notes("http://example.com/api/v4/projects/1/issues/2/notes")
                .awardEmoji("http://example.com/api/v4/projects/1/issues/2/award_emoji")
                .project("http://example.com/api/v4/projects/1")
                .closedAsDuplicateOf("http://example.com/api/v4/projects/1/issues/75")
                .build();
    }

    public static GitLabEpicLinks epicLinks() {
        return GitLabEpicLinksBuilder.builder()
                .self("http://gitlab.example.com/api/v4/groups/7/epics/5")
                .epicIssues("http://gitlab.example.com/api/v4/groups/7/epics/5/issues")
                .group("http://gitlab.example.com/api/v4/groups/7")
                .parent("http://gitlab.example.com/api/v4/groups/7/epics/4")
                .build();
    }

    public static GitLabFeatureDefinition featureDefinition() {
        return GitLabFeatureDefinitionBuilder.builder()
                .name("name")
                .featureIssueUrl("feature_issue_url")
                .introducedByUrl("introduced_by_url")
                .rolloutIssueUrl("rollout_issue_url")
                .milestone("milestone")
                .logStateChanges(true)
                .type("type")
                .group("group")
                .defaultEnabled(true)
                .intendedToRolloutBy("intended_to_rollout_by")
                .build();
    }

    public static GitLabFeatureGate featureGate() {
        return GitLabFeatureGateBuilder.builder()
                .key("percentage_of_actors")
                .value(1)
                .build();
    }

    public static GitLabGeoNodeStatus geoNodeStatus() {
        return GitLabGeoNodeStatusBuilder.builder()
                .container(CommonCatalogFixtures.geoNodeStatusContainer())
                .abuse(CommonCatalogFixtures.geoNodeStatusAbuse())
                .achievement(CommonCatalogFixtures.geoNodeStatusAchievement())
                .alert(CommonCatalogFixtures.geoNodeStatusAlert())
                .appearance(CommonCatalogFixtures.geoNodeStatusAppearance())
                .bulk(CommonCatalogFixtures.geoNodeStatusBulk())
                .ci(CommonCatalogFixtures.geoNodeStatusCi())
                .dependency(CommonCatalogFixtures.geoNodeStatusDependency())
                .design(CommonCatalogFixtures.geoNodeStatusDesign())
                .group(CommonCatalogFixtures.geoNodeStatusGroup())
                .importValue(CommonCatalogFixtures.geoNodeStatusImport())
                .issuable(CommonCatalogFixtures.geoNodeStatusIssuable())
                .job(CommonCatalogFixtures.geoNodeStatusJob())
                .lfs(CommonCatalogFixtures.geoNodeStatusLfs())
                .merge(CommonCatalogFixtures.geoNodeStatusMerge())
                .organization(CommonCatalogFixtures.geoNodeStatusOrganization())
                .packageValue(CommonCatalogFixtures.geoNodeStatusPackage())
                .packages(CommonCatalogFixtures.geoNodeStatusPackages())
                .pages(CommonCatalogFixtures.geoNodeStatusPages())
                .personal(CommonCatalogFixtures.geoNodeStatusPersonal())
                .pipeline(CommonCatalogFixtures.geoNodeStatusPipeline())
                .project(CommonCatalogFixtures.geoNodeStatusProject())
                .snippet(CommonCatalogFixtures.geoNodeStatusSnippet())
                .supply(CommonCatalogFixtures.geoNodeStatusSupply())
                .terraform(CommonCatalogFixtures.geoNodeStatusTerraform())
                .uploads(CommonCatalogFixtures.geoNodeStatusUploads())
                .user(CommonCatalogFixtures.geoNodeStatusUser())
                .vulnerability(CommonCatalogFixtures.geoNodeStatusVulnerability())
                .ai(CommonCatalogFixtures.geoNodeStatusAi())
                .other(CommonCatalogFixtures.geoNodeStatusOther())
                .build();
    }

    public static GitLabGeoNodeStatusAbuse geoNodeStatusAbuse() {
        return GitLabGeoNodeStatusAbuseBuilder.builder()
                .abuseReportUploadsCount("abuse_report_uploads_count")
                .abuseReportUploadsChecksumTotalCount("abuse_report_uploads_checksum_total_count")
                .abuseReportUploadsChecksummedCount("abuse_report_uploads_checksummed_count")
                .abuseReportUploadsChecksumFailedCount("abuse_report_uploads_checksum_failed_count")
                .abuseReportUploadsSyncedCount("abuse_report_uploads_synced_count")
                .abuseReportUploadsFailedCount("abuse_report_uploads_failed_count")
                .abuseReportUploadsRegistryCount("abuse_report_uploads_registry_count")
                .abuseReportUploadsVerificationTotalCount("abuse_report_uploads_verification_total_count")
                .abuseReportUploadsVerifiedCount("abuse_report_uploads_verified_count")
                .abuseReportUploadsVerificationFailedCount("abuse_report_uploads_verification_failed_count")
                .abuseReportUploadsOldestUnsyncedTime("abuse_report_uploads_oldest_unsynced_time")
                .abuseReportUploadsSyncedInPercentage("abuse_report_uploads_synced_in_percentage")
                .abuseReportUploadsVerifiedInPercentage("abuse_report_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusAchievement geoNodeStatusAchievement() {
        return GitLabGeoNodeStatusAchievementBuilder.builder()
                .achievementUploadsCount("achievement_uploads_count")
                .achievementUploadsChecksumTotalCount("achievement_uploads_checksum_total_count")
                .achievementUploadsChecksummedCount("achievement_uploads_checksummed_count")
                .achievementUploadsChecksumFailedCount("achievement_uploads_checksum_failed_count")
                .achievementUploadsSyncedCount("achievement_uploads_synced_count")
                .achievementUploadsFailedCount("achievement_uploads_failed_count")
                .achievementUploadsRegistryCount("achievement_uploads_registry_count")
                .achievementUploadsVerificationTotalCount("achievement_uploads_verification_total_count")
                .achievementUploadsVerifiedCount("achievement_uploads_verified_count")
                .achievementUploadsVerificationFailedCount("achievement_uploads_verification_failed_count")
                .achievementUploadsOldestUnsyncedTime("achievement_uploads_oldest_unsynced_time")
                .achievementUploadsSyncedInPercentage("achievement_uploads_synced_in_percentage")
                .achievementUploadsVerifiedInPercentage("achievement_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusAi geoNodeStatusAi() {
        return GitLabGeoNodeStatusAiBuilder.builder()
                .aiVectorizableFileUploadsCount(1)
                .aiVectorizableFileUploadsChecksumTotalCount(1)
                .aiVectorizableFileUploadsChecksummedCount(1)
                .aiVectorizableFileUploadsChecksumFailedCount(1)
                .aiVectorizableFileUploadsSyncedCount(1)
                .aiVectorizableFileUploadsFailedCount(1)
                .aiVectorizableFileUploadsRegistryCount(1)
                .aiVectorizableFileUploadsVerificationTotalCount(1)
                .aiVectorizableFileUploadsVerifiedCount(1)
                .aiVectorizableFileUploadsVerificationFailedCount(1)
                .aiVectorizableFileUploadsOldestUnsyncedTime(1)
                .aiVectorizableFileUploadsSyncedInPercentage("0.00%")
                .aiVectorizableFileUploadsVerifiedInPercentage("0.00%")
                .build();
    }

    public static GitLabGeoNodeStatusAlert geoNodeStatusAlert() {
        return GitLabGeoNodeStatusAlertBuilder.builder()
                .alertManagementMetricImageUploadsCount("alert_management_metric_image_uploads_count")
                .alertManagementMetricImageUploadsChecksumTotalCount(
                        "alert_management_metric_image_uploads_checksum_total_count")
                .alertManagementMetricImageUploadsChecksummedCount(
                        "alert_management_metric_image_uploads_checksummed_count")
                .alertManagementMetricImageUploadsChecksumFailedCount(
                        "alert_management_metric_image_uploads_checksum_failed_count")
                .alertManagementMetricImageUploadsSyncedCount("alert_management_metric_image_uploads_synced_count")
                .alertManagementMetricImageUploadsFailedCount("alert_management_metric_image_uploads_failed_count")
                .alertManagementMetricImageUploadsRegistryCount("alert_management_metric_image_uploads_registry_count")
                .alertManagementMetricImageUploadsVerificationTotalCount(
                        "alert_management_metric_image_uploads_verification_total_count")
                .alertManagementMetricImageUploadsVerifiedCount("alert_management_metric_image_uploads_verified_count")
                .alertManagementMetricImageUploadsVerificationFailedCount(
                        "alert_management_metric_image_uploads_verification_failed_count")
                .alertManagementMetricImageUploadsOldestUnsyncedTime(
                        "alert_management_metric_image_uploads_oldest_unsynced_time")
                .alertManagementMetricImageUploadsSyncedInPercentage(
                        "alert_management_metric_image_uploads_synced_in_percentage")
                .alertManagementMetricImageUploadsVerifiedInPercentage(
                        "alert_management_metric_image_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusAppearance geoNodeStatusAppearance() {
        return GitLabGeoNodeStatusAppearanceBuilder.builder()
                .appearanceUploadsCount("appearance_uploads_count")
                .appearanceUploadsChecksumTotalCount("appearance_uploads_checksum_total_count")
                .appearanceUploadsChecksummedCount("appearance_uploads_checksummed_count")
                .appearanceUploadsChecksumFailedCount("appearance_uploads_checksum_failed_count")
                .appearanceUploadsSyncedCount("appearance_uploads_synced_count")
                .appearanceUploadsFailedCount("appearance_uploads_failed_count")
                .appearanceUploadsRegistryCount("appearance_uploads_registry_count")
                .appearanceUploadsVerificationTotalCount("appearance_uploads_verification_total_count")
                .appearanceUploadsVerifiedCount("appearance_uploads_verified_count")
                .appearanceUploadsVerificationFailedCount("appearance_uploads_verification_failed_count")
                .appearanceUploadsOldestUnsyncedTime("appearance_uploads_oldest_unsynced_time")
                .appearanceUploadsSyncedInPercentage("appearance_uploads_synced_in_percentage")
                .appearanceUploadsVerifiedInPercentage("appearance_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusBulk geoNodeStatusBulk() {
        return GitLabGeoNodeStatusBulkBuilder.builder()
                .bulkImportExportUploadUploadsCount("bulk_import_export_upload_uploads_count")
                .bulkImportExportUploadUploadsChecksumTotalCount(
                        "bulk_import_export_upload_uploads_checksum_total_count")
                .bulkImportExportUploadUploadsChecksummedCount("bulk_import_export_upload_uploads_checksummed_count")
                .bulkImportExportUploadUploadsChecksumFailedCount(
                        "bulk_import_export_upload_uploads_checksum_failed_count")
                .bulkImportExportUploadUploadsSyncedCount("bulk_import_export_upload_uploads_synced_count")
                .bulkImportExportUploadUploadsFailedCount("bulk_import_export_upload_uploads_failed_count")
                .bulkImportExportUploadUploadsRegistryCount("bulk_import_export_upload_uploads_registry_count")
                .bulkImportExportUploadUploadsVerificationTotalCount(
                        "bulk_import_export_upload_uploads_verification_total_count")
                .bulkImportExportUploadUploadsVerifiedCount("bulk_import_export_upload_uploads_verified_count")
                .bulkImportExportUploadUploadsVerificationFailedCount(
                        "bulk_import_export_upload_uploads_verification_failed_count")
                .bulkImportExportUploadUploadsOldestUnsyncedTime(
                        "bulk_import_export_upload_uploads_oldest_unsynced_time")
                .bulkImportExportUploadUploadsSyncedInPercentage(
                        "bulk_import_export_upload_uploads_synced_in_percentage")
                .bulkImportExportUploadUploadsVerifiedInPercentage(
                        "bulk_import_export_upload_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusCi geoNodeStatusCi() {
        return GitLabGeoNodeStatusCiBuilder.builder()
                .ciSecureFilesCount("ci_secure_files_count")
                .ciSecureFilesChecksumTotalCount("ci_secure_files_checksum_total_count")
                .ciSecureFilesChecksummedCount("ci_secure_files_checksummed_count")
                .ciSecureFilesChecksumFailedCount("ci_secure_files_checksum_failed_count")
                .ciSecureFilesSyncedCount("ci_secure_files_synced_count")
                .ciSecureFilesFailedCount("ci_secure_files_failed_count")
                .ciSecureFilesRegistryCount("ci_secure_files_registry_count")
                .ciSecureFilesVerificationTotalCount("ci_secure_files_verification_total_count")
                .ciSecureFilesVerifiedCount("ci_secure_files_verified_count")
                .ciSecureFilesVerificationFailedCount("ci_secure_files_verification_failed_count")
                .ciSecureFilesOldestUnsyncedTime("ci_secure_files_oldest_unsynced_time")
                .ciSecureFilesSyncedInPercentage("ci_secure_files_synced_in_percentage")
                .ciSecureFilesVerifiedInPercentage("ci_secure_files_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusContainer geoNodeStatusContainer() {
        return GitLabGeoNodeStatusContainerBuilder.builder()
                .containerRepositoriesReplicationEnabled("container_repositories_replication_enabled")
                .containerRepositoriesCount("container_repositories_count")
                .containerRepositoriesChecksumTotalCount("container_repositories_checksum_total_count")
                .containerRepositoriesChecksummedCount("container_repositories_checksummed_count")
                .containerRepositoriesChecksumFailedCount("container_repositories_checksum_failed_count")
                .containerRepositoriesSyncedCount("container_repositories_synced_count")
                .containerRepositoriesFailedCount("container_repositories_failed_count")
                .containerRepositoriesRegistryCount("container_repositories_registry_count")
                .containerRepositoriesVerificationTotalCount("container_repositories_verification_total_count")
                .containerRepositoriesVerifiedCount("container_repositories_verified_count")
                .containerRepositoriesVerificationFailedCount("container_repositories_verification_failed_count")
                .containerRepositoriesOldestUnsyncedTime("container_repositories_oldest_unsynced_time")
                .containerRepositoriesSyncedInPercentage("container_repositories_synced_in_percentage")
                .containerRepositoriesVerifiedInPercentage("container_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusDependency geoNodeStatusDependency() {
        return GitLabGeoNodeStatusDependencyBuilder.builder()
                .dependencyListExportPartUploadsCount("dependency_list_export_part_uploads_count")
                .dependencyListExportPartUploadsChecksumTotalCount(
                        "dependency_list_export_part_uploads_checksum_total_count")
                .dependencyListExportPartUploadsChecksummedCount(
                        "dependency_list_export_part_uploads_checksummed_count")
                .dependencyListExportPartUploadsChecksumFailedCount(
                        "dependency_list_export_part_uploads_checksum_failed_count")
                .dependencyListExportPartUploadsSyncedCount("dependency_list_export_part_uploads_synced_count")
                .dependencyListExportPartUploadsFailedCount("dependency_list_export_part_uploads_failed_count")
                .dependencyListExportPartUploadsRegistryCount("dependency_list_export_part_uploads_registry_count")
                .dependencyListExportPartUploadsVerificationTotalCount(
                        "dependency_list_export_part_uploads_verification_total_count")
                .dependencyListExportPartUploadsVerifiedCount("dependency_list_export_part_uploads_verified_count")
                .dependencyListExportPartUploadsVerificationFailedCount(
                        "dependency_list_export_part_uploads_verification_failed_count")
                .dependencyListExportPartUploadsOldestUnsyncedTime(
                        "dependency_list_export_part_uploads_oldest_unsynced_time")
                .dependencyListExportUploadsCount("dependency_list_export_uploads_count")
                .dependencyListExportUploadsChecksumTotalCount("dependency_list_export_uploads_checksum_total_count")
                .dependencyListExportUploadsChecksummedCount("dependency_list_export_uploads_checksummed_count")
                .dependencyListExportUploadsChecksumFailedCount("dependency_list_export_uploads_checksum_failed_count")
                .dependencyListExportUploadsSyncedCount("dependency_list_export_uploads_synced_count")
                .dependencyListExportUploadsFailedCount("dependency_list_export_uploads_failed_count")
                .dependencyListExportUploadsRegistryCount("dependency_list_export_uploads_registry_count")
                .dependencyListExportUploadsVerificationTotalCount(
                        "dependency_list_export_uploads_verification_total_count")
                .dependencyListExportUploadsVerifiedCount("dependency_list_export_uploads_verified_count")
                .dependencyListExportUploadsVerificationFailedCount(
                        "dependency_list_export_uploads_verification_failed_count")
                .dependencyListExportUploadsOldestUnsyncedTime("dependency_list_export_uploads_oldest_unsynced_time")
                .dependencyProxyBlobsCount("dependency_proxy_blobs_count")
                .dependencyProxyBlobsChecksumTotalCount("dependency_proxy_blobs_checksum_total_count")
                .dependencyProxyBlobsChecksummedCount("dependency_proxy_blobs_checksummed_count")
                .dependencyProxyBlobsChecksumFailedCount("dependency_proxy_blobs_checksum_failed_count")
                .dependencyProxyBlobsSyncedCount("dependency_proxy_blobs_synced_count")
                .dependencyProxyBlobsFailedCount("dependency_proxy_blobs_failed_count")
                .dependencyProxyBlobsRegistryCount("dependency_proxy_blobs_registry_count")
                .dependencyProxyBlobsVerificationTotalCount("dependency_proxy_blobs_verification_total_count")
                .dependencyProxyBlobsVerifiedCount("dependency_proxy_blobs_verified_count")
                .dependencyProxyBlobsVerificationFailedCount("dependency_proxy_blobs_verification_failed_count")
                .dependencyProxyBlobsOldestUnsyncedTime("dependency_proxy_blobs_oldest_unsynced_time")
                .dependencyProxyManifestsCount("dependency_proxy_manifests_count")
                .dependencyProxyManifestsChecksumTotalCount("dependency_proxy_manifests_checksum_total_count")
                .dependencyProxyManifestsChecksummedCount("dependency_proxy_manifests_checksummed_count")
                .dependencyProxyManifestsChecksumFailedCount("dependency_proxy_manifests_checksum_failed_count")
                .dependencyProxyManifestsSyncedCount("dependency_proxy_manifests_synced_count")
                .dependencyProxyManifestsFailedCount("dependency_proxy_manifests_failed_count")
                .dependencyProxyManifestsRegistryCount("dependency_proxy_manifests_registry_count")
                .dependencyProxyManifestsVerificationTotalCount("dependency_proxy_manifests_verification_total_count")
                .dependencyProxyManifestsVerifiedCount("dependency_proxy_manifests_verified_count")
                .dependencyProxyManifestsVerificationFailedCount("dependency_proxy_manifests_verification_failed_count")
                .dependencyProxyManifestsOldestUnsyncedTime("dependency_proxy_manifests_oldest_unsynced_time")
                .dependencyListExportPartUploadsSyncedInPercentage(
                        "dependency_list_export_part_uploads_synced_in_percentage")
                .dependencyListExportPartUploadsVerifiedInPercentage(
                        "dependency_list_export_part_uploads_verified_in_percentage")
                .dependencyListExportUploadsSyncedInPercentage("dependency_list_export_uploads_synced_in_percentage")
                .dependencyListExportUploadsVerifiedInPercentage(
                        "dependency_list_export_uploads_verified_in_percentage")
                .dependencyProxyBlobsSyncedInPercentage("dependency_proxy_blobs_synced_in_percentage")
                .dependencyProxyBlobsVerifiedInPercentage("dependency_proxy_blobs_verified_in_percentage")
                .dependencyProxyManifestsSyncedInPercentage("dependency_proxy_manifests_synced_in_percentage")
                .dependencyProxyManifestsVerifiedInPercentage("dependency_proxy_manifests_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusDesign geoNodeStatusDesign() {
        return GitLabGeoNodeStatusDesignBuilder.builder()
                .designManagementActionUploadsCount("design_management_action_uploads_count")
                .designManagementActionUploadsChecksumTotalCount(
                        "design_management_action_uploads_checksum_total_count")
                .designManagementActionUploadsChecksummedCount("design_management_action_uploads_checksummed_count")
                .designManagementActionUploadsChecksumFailedCount(
                        "design_management_action_uploads_checksum_failed_count")
                .designManagementActionUploadsSyncedCount("design_management_action_uploads_synced_count")
                .designManagementActionUploadsFailedCount("design_management_action_uploads_failed_count")
                .designManagementActionUploadsRegistryCount("design_management_action_uploads_registry_count")
                .designManagementActionUploadsVerificationTotalCount(
                        "design_management_action_uploads_verification_total_count")
                .designManagementActionUploadsVerifiedCount("design_management_action_uploads_verified_count")
                .designManagementActionUploadsVerificationFailedCount(
                        "design_management_action_uploads_verification_failed_count")
                .designManagementActionUploadsOldestUnsyncedTime(
                        "design_management_action_uploads_oldest_unsynced_time")
                .designManagementRepositoriesCount("design_management_repositories_count")
                .designManagementRepositoriesChecksumTotalCount("design_management_repositories_checksum_total_count")
                .designManagementRepositoriesChecksummedCount("design_management_repositories_checksummed_count")
                .designManagementRepositoriesChecksumFailedCount("design_management_repositories_checksum_failed_count")
                .designManagementRepositoriesSyncedCount("design_management_repositories_synced_count")
                .designManagementRepositoriesFailedCount("design_management_repositories_failed_count")
                .designManagementRepositoriesRegistryCount("design_management_repositories_registry_count")
                .designManagementRepositoriesVerificationTotalCount(
                        "design_management_repositories_verification_total_count")
                .designManagementRepositoriesVerifiedCount("design_management_repositories_verified_count")
                .designManagementRepositoriesVerificationFailedCount(
                        "design_management_repositories_verification_failed_count")
                .designManagementRepositoriesOldestUnsyncedTime("design_management_repositories_oldest_unsynced_time")
                .designManagementActionUploadsSyncedInPercentage(
                        "design_management_action_uploads_synced_in_percentage")
                .designManagementActionUploadsVerifiedInPercentage(
                        "design_management_action_uploads_verified_in_percentage")
                .designManagementRepositoriesSyncedInPercentage("design_management_repositories_synced_in_percentage")
                .designManagementRepositoriesVerifiedInPercentage(
                        "design_management_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusGroup geoNodeStatusGroup() {
        return GitLabGeoNodeStatusGroupBuilder.builder()
                .groupUploadsCount("group_uploads_count")
                .groupUploadsChecksumTotalCount("group_uploads_checksum_total_count")
                .groupUploadsChecksummedCount("group_uploads_checksummed_count")
                .groupUploadsChecksumFailedCount("group_uploads_checksum_failed_count")
                .groupUploadsSyncedCount("group_uploads_synced_count")
                .groupUploadsFailedCount("group_uploads_failed_count")
                .groupUploadsRegistryCount("group_uploads_registry_count")
                .groupUploadsVerificationTotalCount("group_uploads_verification_total_count")
                .groupUploadsVerifiedCount("group_uploads_verified_count")
                .groupUploadsVerificationFailedCount("group_uploads_verification_failed_count")
                .groupUploadsOldestUnsyncedTime("group_uploads_oldest_unsynced_time")
                .groupWikiRepositoriesCount("group_wiki_repositories_count")
                .groupWikiRepositoriesChecksumTotalCount("group_wiki_repositories_checksum_total_count")
                .groupWikiRepositoriesChecksummedCount("group_wiki_repositories_checksummed_count")
                .groupWikiRepositoriesChecksumFailedCount("group_wiki_repositories_checksum_failed_count")
                .groupWikiRepositoriesSyncedCount("group_wiki_repositories_synced_count")
                .groupWikiRepositoriesFailedCount("group_wiki_repositories_failed_count")
                .groupWikiRepositoriesRegistryCount("group_wiki_repositories_registry_count")
                .groupWikiRepositoriesVerificationTotalCount("group_wiki_repositories_verification_total_count")
                .groupWikiRepositoriesVerifiedCount("group_wiki_repositories_verified_count")
                .groupWikiRepositoriesVerificationFailedCount("group_wiki_repositories_verification_failed_count")
                .groupWikiRepositoriesOldestUnsyncedTime("group_wiki_repositories_oldest_unsynced_time")
                .groupUploadsSyncedInPercentage("group_uploads_synced_in_percentage")
                .groupUploadsVerifiedInPercentage("group_uploads_verified_in_percentage")
                .groupWikiRepositoriesSyncedInPercentage("group_wiki_repositories_synced_in_percentage")
                .groupWikiRepositoriesVerifiedInPercentage("group_wiki_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusImport geoNodeStatusImport() {
        return GitLabGeoNodeStatusImportBuilder.builder()
                .importExportUploadUploadsCount("import_export_upload_uploads_count")
                .importExportUploadUploadsChecksumTotalCount("import_export_upload_uploads_checksum_total_count")
                .importExportUploadUploadsChecksummedCount("import_export_upload_uploads_checksummed_count")
                .importExportUploadUploadsChecksumFailedCount("import_export_upload_uploads_checksum_failed_count")
                .importExportUploadUploadsSyncedCount("import_export_upload_uploads_synced_count")
                .importExportUploadUploadsFailedCount("import_export_upload_uploads_failed_count")
                .importExportUploadUploadsRegistryCount("import_export_upload_uploads_registry_count")
                .importExportUploadUploadsVerificationTotalCount(
                        "import_export_upload_uploads_verification_total_count")
                .importExportUploadUploadsVerifiedCount("import_export_upload_uploads_verified_count")
                .importExportUploadUploadsVerificationFailedCount(
                        "import_export_upload_uploads_verification_failed_count")
                .importExportUploadUploadsOldestUnsyncedTime("import_export_upload_uploads_oldest_unsynced_time")
                .importExportUploadUploadsSyncedInPercentage("import_export_upload_uploads_synced_in_percentage")
                .importExportUploadUploadsVerifiedInPercentage("import_export_upload_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusIssuable geoNodeStatusIssuable() {
        return GitLabGeoNodeStatusIssuableBuilder.builder()
                .issuableMetricImageUploadsCount("issuable_metric_image_uploads_count")
                .issuableMetricImageUploadsChecksumTotalCount("issuable_metric_image_uploads_checksum_total_count")
                .issuableMetricImageUploadsChecksummedCount("issuable_metric_image_uploads_checksummed_count")
                .issuableMetricImageUploadsChecksumFailedCount("issuable_metric_image_uploads_checksum_failed_count")
                .issuableMetricImageUploadsSyncedCount("issuable_metric_image_uploads_synced_count")
                .issuableMetricImageUploadsFailedCount("issuable_metric_image_uploads_failed_count")
                .issuableMetricImageUploadsRegistryCount("issuable_metric_image_uploads_registry_count")
                .issuableMetricImageUploadsVerificationTotalCount(
                        "issuable_metric_image_uploads_verification_total_count")
                .issuableMetricImageUploadsVerifiedCount("issuable_metric_image_uploads_verified_count")
                .issuableMetricImageUploadsVerificationFailedCount(
                        "issuable_metric_image_uploads_verification_failed_count")
                .issuableMetricImageUploadsOldestUnsyncedTime("issuable_metric_image_uploads_oldest_unsynced_time")
                .issuableMetricImageUploadsSyncedInPercentage("issuable_metric_image_uploads_synced_in_percentage")
                .issuableMetricImageUploadsVerifiedInPercentage("issuable_metric_image_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusJob geoNodeStatusJob() {
        return GitLabGeoNodeStatusJobBuilder.builder()
                .jobArtifactsCount("job_artifacts_count")
                .jobArtifactsChecksumTotalCount("job_artifacts_checksum_total_count")
                .jobArtifactsChecksummedCount("job_artifacts_checksummed_count")
                .jobArtifactsChecksumFailedCount("job_artifacts_checksum_failed_count")
                .jobArtifactsSyncedCount("job_artifacts_synced_count")
                .jobArtifactsFailedCount("job_artifacts_failed_count")
                .jobArtifactsRegistryCount("job_artifacts_registry_count")
                .jobArtifactsVerificationTotalCount("job_artifacts_verification_total_count")
                .jobArtifactsVerifiedCount("job_artifacts_verified_count")
                .jobArtifactsVerificationFailedCount("job_artifacts_verification_failed_count")
                .jobArtifactsOldestUnsyncedTime("job_artifacts_oldest_unsynced_time")
                .jobArtifactsSyncedInPercentage("job_artifacts_synced_in_percentage")
                .jobArtifactsVerifiedInPercentage("job_artifacts_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusLfs geoNodeStatusLfs() {
        return GitLabGeoNodeStatusLfsBuilder.builder()
                .lfsObjectsCount("lfs_objects_count")
                .lfsObjectsChecksumTotalCount("lfs_objects_checksum_total_count")
                .lfsObjectsChecksummedCount("lfs_objects_checksummed_count")
                .lfsObjectsChecksumFailedCount("lfs_objects_checksum_failed_count")
                .lfsObjectsSyncedCount("lfs_objects_synced_count")
                .lfsObjectsFailedCount("lfs_objects_failed_count")
                .lfsObjectsRegistryCount("lfs_objects_registry_count")
                .lfsObjectsVerificationTotalCount("lfs_objects_verification_total_count")
                .lfsObjectsVerifiedCount("lfs_objects_verified_count")
                .lfsObjectsVerificationFailedCount("lfs_objects_verification_failed_count")
                .lfsObjectsOldestUnsyncedTime("lfs_objects_oldest_unsynced_time")
                .lfsObjectsSyncedInPercentage("lfs_objects_synced_in_percentage")
                .lfsObjectsVerifiedInPercentage("lfs_objects_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusLinks geoNodeStatusLinks() {
        return GitLabGeoNodeStatusLinksBuilder.builder()
                .self("self")
                .node("node")
                .build();
    }

    public static GitLabGeoNodeStatusMerge geoNodeStatusMerge() {
        return GitLabGeoNodeStatusMergeBuilder.builder()
                .mergeRequestDiffsCount("merge_request_diffs_count")
                .mergeRequestDiffsChecksumTotalCount("merge_request_diffs_checksum_total_count")
                .mergeRequestDiffsChecksummedCount("merge_request_diffs_checksummed_count")
                .mergeRequestDiffsChecksumFailedCount("merge_request_diffs_checksum_failed_count")
                .mergeRequestDiffsSyncedCount("merge_request_diffs_synced_count")
                .mergeRequestDiffsFailedCount("merge_request_diffs_failed_count")
                .mergeRequestDiffsRegistryCount("merge_request_diffs_registry_count")
                .mergeRequestDiffsVerificationTotalCount("merge_request_diffs_verification_total_count")
                .mergeRequestDiffsVerifiedCount("merge_request_diffs_verified_count")
                .mergeRequestDiffsVerificationFailedCount("merge_request_diffs_verification_failed_count")
                .mergeRequestDiffsOldestUnsyncedTime("merge_request_diffs_oldest_unsynced_time")
                .mergeRequestDiffsSyncedInPercentage("merge_request_diffs_synced_in_percentage")
                .mergeRequestDiffsVerifiedInPercentage("merge_request_diffs_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusOrganization geoNodeStatusOrganization() {
        return GitLabGeoNodeStatusOrganizationBuilder.builder()
                .organizationDetailUploadsCount("organization_detail_uploads_count")
                .organizationDetailUploadsChecksumTotalCount("organization_detail_uploads_checksum_total_count")
                .organizationDetailUploadsChecksummedCount("organization_detail_uploads_checksummed_count")
                .organizationDetailUploadsChecksumFailedCount("organization_detail_uploads_checksum_failed_count")
                .organizationDetailUploadsSyncedCount("organization_detail_uploads_synced_count")
                .organizationDetailUploadsFailedCount("organization_detail_uploads_failed_count")
                .organizationDetailUploadsRegistryCount("organization_detail_uploads_registry_count")
                .organizationDetailUploadsVerificationTotalCount("organization_detail_uploads_verification_total_count")
                .organizationDetailUploadsVerifiedCount("organization_detail_uploads_verified_count")
                .organizationDetailUploadsVerificationFailedCount(
                        "organization_detail_uploads_verification_failed_count")
                .organizationDetailUploadsOldestUnsyncedTime("organization_detail_uploads_oldest_unsynced_time")
                .organizationDetailUploadsSyncedInPercentage("organization_detail_uploads_synced_in_percentage")
                .organizationDetailUploadsVerifiedInPercentage("organization_detail_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusOther geoNodeStatusOther() {
        return GitLabGeoNodeStatusOtherBuilder.builder()
                .geoNodeId("geo_node_id")
                .projectsCount("projects_count")
                .gitFetchEventCountWeekly("git_fetch_event_count_weekly")
                .gitPushEventCountWeekly("git_push_event_count_weekly")
                .proxyRemoteRequestsEventCountWeekly("proxy_remote_requests_event_count_weekly")
                .proxyLocalRequestsEventCountWeekly("proxy_local_requests_event_count_weekly")
                .repositoriesCheckedInPercentage("repositories_checked_in_percentage")
                .repositoriesCount("repositories_count")
                .repositoriesCheckedCount("repositories_checked_count")
                .repositoriesCheckedFailedCount("repositories_checked_failed_count")
                .replicationSlotsUsedInPercentage("replication_slots_used_in_percentage")
                .replicationSlotsCount("replication_slots_count")
                .replicationSlotsUsedCount("replication_slots_used_count")
                .replicationSlotsMaxRetainedWalBytes("replication_slots_max_retained_wal_bytes")
                .healthy("healthy")
                .health("health")
                .healthStatus("health_status")
                .missingOauthApplication("missing_oauth_application")
                .dbReplicationLagSeconds("db_replication_lag_seconds")
                .lastEventId("last_event_id")
                .lastEventTimestamp("last_event_timestamp")
                .lastSuccessfulStatusCheckTimestamp("last_successful_status_check_timestamp")
                .cursorLastEventId("cursor_last_event_id")
                .cursorLastEventTimestamp("cursor_last_event_timestamp")
                .version("version")
                .revision("revision")
                .selectiveSyncType("selective_sync_type")
                .namespaces(CommonCatalogFixtures.namespaceBasic())
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .storageShards(CommonCatalogFixtures.storageShardEntity())
                .storageShardsMatch("storage_shards_match")
                .links(CommonCatalogFixtures.geoNodeStatusLinks())
                .build();
    }

    public static GitLabGeoNodeStatusPackage geoNodeStatusPackage() {
        return GitLabGeoNodeStatusPackageBuilder.builder()
                .packageFilesCount("package_files_count")
                .packageFilesChecksumTotalCount("package_files_checksum_total_count")
                .packageFilesChecksummedCount("package_files_checksummed_count")
                .packageFilesChecksumFailedCount("package_files_checksum_failed_count")
                .packageFilesSyncedCount("package_files_synced_count")
                .packageFilesFailedCount("package_files_failed_count")
                .packageFilesRegistryCount("package_files_registry_count")
                .packageFilesVerificationTotalCount("package_files_verification_total_count")
                .packageFilesVerifiedCount("package_files_verified_count")
                .packageFilesVerificationFailedCount("package_files_verification_failed_count")
                .packageFilesOldestUnsyncedTime("package_files_oldest_unsynced_time")
                .packageFilesSyncedInPercentage("package_files_synced_in_percentage")
                .packageFilesVerifiedInPercentage("package_files_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusPackages geoNodeStatusPackages() {
        return GitLabGeoNodeStatusPackagesBuilder.builder()
                .packagesDebianProjectComponentFilesCount("packages_debian_project_component_files_count")
                .packagesDebianProjectComponentFilesChecksumTotalCount(
                        "packages_debian_project_component_files_checksum_total_count")
                .packagesDebianProjectComponentFilesChecksummedCount(
                        "packages_debian_project_component_files_checksummed_count")
                .packagesDebianProjectComponentFilesChecksumFailedCount(
                        "packages_debian_project_component_files_checksum_failed_count")
                .packagesDebianProjectComponentFilesSyncedCount("packages_debian_project_component_files_synced_count")
                .packagesDebianProjectComponentFilesFailedCount("packages_debian_project_component_files_failed_count")
                .packagesDebianProjectComponentFilesRegistryCount(
                        "packages_debian_project_component_files_registry_count")
                .packagesDebianProjectComponentFilesVerificationTotalCount(
                        "packages_debian_project_component_files_verification_total_count")
                .packagesDebianProjectComponentFilesVerifiedCount(
                        "packages_debian_project_component_files_verified_count")
                .packagesDebianProjectComponentFilesVerificationFailedCount(
                        "packages_debian_project_component_files_verification_failed_count")
                .packagesDebianProjectComponentFilesOldestUnsyncedTime(
                        "packages_debian_project_component_files_oldest_unsynced_time")
                .packagesHelmMetadataCachesCount("packages_helm_metadata_caches_count")
                .packagesHelmMetadataCachesChecksumTotalCount("packages_helm_metadata_caches_checksum_total_count")
                .packagesHelmMetadataCachesChecksummedCount("packages_helm_metadata_caches_checksummed_count")
                .packagesHelmMetadataCachesChecksumFailedCount("packages_helm_metadata_caches_checksum_failed_count")
                .packagesHelmMetadataCachesSyncedCount("packages_helm_metadata_caches_synced_count")
                .packagesHelmMetadataCachesFailedCount("packages_helm_metadata_caches_failed_count")
                .packagesHelmMetadataCachesRegistryCount("packages_helm_metadata_caches_registry_count")
                .packagesHelmMetadataCachesVerificationTotalCount(
                        "packages_helm_metadata_caches_verification_total_count")
                .packagesHelmMetadataCachesVerifiedCount("packages_helm_metadata_caches_verified_count")
                .packagesHelmMetadataCachesVerificationFailedCount(
                        "packages_helm_metadata_caches_verification_failed_count")
                .packagesHelmMetadataCachesOldestUnsyncedTime("packages_helm_metadata_caches_oldest_unsynced_time")
                .packagesNugetSymbolsCount("packages_nuget_symbols_count")
                .packagesNugetSymbolsChecksumTotalCount("packages_nuget_symbols_checksum_total_count")
                .packagesNugetSymbolsChecksummedCount("packages_nuget_symbols_checksummed_count")
                .packagesNugetSymbolsChecksumFailedCount("packages_nuget_symbols_checksum_failed_count")
                .packagesNugetSymbolsSyncedCount("packages_nuget_symbols_synced_count")
                .packagesNugetSymbolsFailedCount("packages_nuget_symbols_failed_count")
                .packagesNugetSymbolsRegistryCount("packages_nuget_symbols_registry_count")
                .packagesNugetSymbolsVerificationTotalCount("packages_nuget_symbols_verification_total_count")
                .packagesNugetSymbolsVerifiedCount("packages_nuget_symbols_verified_count")
                .packagesNugetSymbolsVerificationFailedCount("packages_nuget_symbols_verification_failed_count")
                .packagesNugetSymbolsOldestUnsyncedTime("packages_nuget_symbols_oldest_unsynced_time")
                .packagesDebianProjectComponentFilesSyncedInPercentage(
                        "packages_debian_project_component_files_synced_in_percentage")
                .packagesDebianProjectComponentFilesVerifiedInPercentage(
                        "packages_debian_project_component_files_verified_in_percentage")
                .packagesHelmMetadataCachesSyncedInPercentage("packages_helm_metadata_caches_synced_in_percentage")
                .packagesHelmMetadataCachesVerifiedInPercentage("packages_helm_metadata_caches_verified_in_percentage")
                .packagesNugetSymbolsSyncedInPercentage("packages_nuget_symbols_synced_in_percentage")
                .packagesNugetSymbolsVerifiedInPercentage("packages_nuget_symbols_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusPages geoNodeStatusPages() {
        return GitLabGeoNodeStatusPagesBuilder.builder()
                .pagesDeploymentsCount("pages_deployments_count")
                .pagesDeploymentsChecksumTotalCount("pages_deployments_checksum_total_count")
                .pagesDeploymentsChecksummedCount("pages_deployments_checksummed_count")
                .pagesDeploymentsChecksumFailedCount("pages_deployments_checksum_failed_count")
                .pagesDeploymentsSyncedCount("pages_deployments_synced_count")
                .pagesDeploymentsFailedCount("pages_deployments_failed_count")
                .pagesDeploymentsRegistryCount("pages_deployments_registry_count")
                .pagesDeploymentsVerificationTotalCount("pages_deployments_verification_total_count")
                .pagesDeploymentsVerifiedCount("pages_deployments_verified_count")
                .pagesDeploymentsVerificationFailedCount("pages_deployments_verification_failed_count")
                .pagesDeploymentsOldestUnsyncedTime("pages_deployments_oldest_unsynced_time")
                .pagesDeploymentsSyncedInPercentage("pages_deployments_synced_in_percentage")
                .pagesDeploymentsVerifiedInPercentage("pages_deployments_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusPersonal geoNodeStatusPersonal() {
        return GitLabGeoNodeStatusPersonalBuilder.builder()
                .personalSnippetUploadsCount("personal_snippet_uploads_count")
                .personalSnippetUploadsChecksumTotalCount("personal_snippet_uploads_checksum_total_count")
                .personalSnippetUploadsChecksummedCount("personal_snippet_uploads_checksummed_count")
                .personalSnippetUploadsChecksumFailedCount("personal_snippet_uploads_checksum_failed_count")
                .personalSnippetUploadsSyncedCount("personal_snippet_uploads_synced_count")
                .personalSnippetUploadsFailedCount("personal_snippet_uploads_failed_count")
                .personalSnippetUploadsRegistryCount("personal_snippet_uploads_registry_count")
                .personalSnippetUploadsVerificationTotalCount("personal_snippet_uploads_verification_total_count")
                .personalSnippetUploadsVerifiedCount("personal_snippet_uploads_verified_count")
                .personalSnippetUploadsVerificationFailedCount("personal_snippet_uploads_verification_failed_count")
                .personalSnippetUploadsOldestUnsyncedTime("personal_snippet_uploads_oldest_unsynced_time")
                .personalSnippetUploadsSyncedInPercentage("personal_snippet_uploads_synced_in_percentage")
                .personalSnippetUploadsVerifiedInPercentage("personal_snippet_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusPipeline geoNodeStatusPipeline() {
        return GitLabGeoNodeStatusPipelineBuilder.builder()
                .pipelineArtifactsCount("pipeline_artifacts_count")
                .pipelineArtifactsChecksumTotalCount("pipeline_artifacts_checksum_total_count")
                .pipelineArtifactsChecksummedCount("pipeline_artifacts_checksummed_count")
                .pipelineArtifactsChecksumFailedCount("pipeline_artifacts_checksum_failed_count")
                .pipelineArtifactsSyncedCount("pipeline_artifacts_synced_count")
                .pipelineArtifactsFailedCount("pipeline_artifacts_failed_count")
                .pipelineArtifactsRegistryCount("pipeline_artifacts_registry_count")
                .pipelineArtifactsVerificationTotalCount("pipeline_artifacts_verification_total_count")
                .pipelineArtifactsVerifiedCount("pipeline_artifacts_verified_count")
                .pipelineArtifactsVerificationFailedCount("pipeline_artifacts_verification_failed_count")
                .pipelineArtifactsOldestUnsyncedTime("pipeline_artifacts_oldest_unsynced_time")
                .pipelineArtifactsSyncedInPercentage("pipeline_artifacts_synced_in_percentage")
                .pipelineArtifactsVerifiedInPercentage("pipeline_artifacts_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusProject geoNodeStatusProject() {
        return GitLabGeoNodeStatusProjectBuilder.builder()
                .projectImportExportRelationExportUploadUploadsCount(
                        "project_import_export_relation_export_upload_uploads_count")
                .projectImportExportRelationExportUploadUploadsChecksumTotalCount(
                        "project_import_export_relation_export_upload_uploads_checksum_total_count")
                .projectImportExportRelationExportUploadUploadsChecksummedCount(
                        "project_import_export_relation_export_upload_uploads_checksummed_count")
                .projectImportExportRelationExportUploadUploadsChecksumFailedCount(
                        "project_import_export_relation_export_upload_uploads_checksum_failed_count")
                .projectImportExportRelationExportUploadUploadsSyncedCount(
                        "project_import_export_relation_export_upload_uploads_synced_count")
                .projectImportExportRelationExportUploadUploadsFailedCount(
                        "project_import_export_relation_export_upload_uploads_failed_count")
                .projectImportExportRelationExportUploadUploadsRegistryCount(
                        "project_import_export_relation_export_upload_uploads_registry_count")
                .projectImportExportRelationExportUploadUploadsVerificationTotalCount(
                        "project_import_export_relation_export_upload_uploads_verification_total_count")
                .projectImportExportRelationExportUploadUploadsVerifiedCount(
                        "project_import_export_relation_export_upload_uploads_verified_count")
                .projectImportExportRelationExportUploadUploadsVerificationFailedCount(
                        "project_import_export_relation_export_upload_uploads_verification_failed_count")
                .projectImportExportRelationExportUploadUploadsOldestUnsyncedTime(
                        "project_import_export_relation_export_upload_uploads_oldest_unsynced_time")
                .projectRepositoriesCount("project_repositories_count")
                .projectRepositoriesChecksumTotalCount("project_repositories_checksum_total_count")
                .projectRepositoriesChecksummedCount("project_repositories_checksummed_count")
                .projectRepositoriesChecksumFailedCount("project_repositories_checksum_failed_count")
                .projectRepositoriesSyncedCount("project_repositories_synced_count")
                .projectRepositoriesFailedCount("project_repositories_failed_count")
                .projectRepositoriesRegistryCount("project_repositories_registry_count")
                .projectRepositoriesVerificationTotalCount("project_repositories_verification_total_count")
                .projectRepositoriesVerifiedCount("project_repositories_verified_count")
                .projectRepositoriesVerificationFailedCount("project_repositories_verification_failed_count")
                .projectRepositoriesOldestUnsyncedTime("project_repositories_oldest_unsynced_time")
                .projectTopicUploadsCount("project_topic_uploads_count")
                .projectTopicUploadsChecksumTotalCount("project_topic_uploads_checksum_total_count")
                .projectTopicUploadsChecksummedCount("project_topic_uploads_checksummed_count")
                .projectTopicUploadsChecksumFailedCount("project_topic_uploads_checksum_failed_count")
                .projectTopicUploadsSyncedCount("project_topic_uploads_synced_count")
                .projectTopicUploadsFailedCount("project_topic_uploads_failed_count")
                .projectTopicUploadsRegistryCount("project_topic_uploads_registry_count")
                .projectTopicUploadsVerificationTotalCount("project_topic_uploads_verification_total_count")
                .projectTopicUploadsVerifiedCount("project_topic_uploads_verified_count")
                .projectTopicUploadsVerificationFailedCount("project_topic_uploads_verification_failed_count")
                .projectTopicUploadsOldestUnsyncedTime("project_topic_uploads_oldest_unsynced_time")
                .projectUploadsCount("project_uploads_count")
                .projectUploadsChecksumTotalCount("project_uploads_checksum_total_count")
                .projectUploadsChecksummedCount("project_uploads_checksummed_count")
                .projectUploadsChecksumFailedCount("project_uploads_checksum_failed_count")
                .projectUploadsSyncedCount("project_uploads_synced_count")
                .projectUploadsFailedCount("project_uploads_failed_count")
                .projectUploadsRegistryCount("project_uploads_registry_count")
                .projectUploadsVerificationTotalCount("project_uploads_verification_total_count")
                .projectUploadsVerifiedCount("project_uploads_verified_count")
                .projectUploadsVerificationFailedCount("project_uploads_verification_failed_count")
                .projectUploadsOldestUnsyncedTime("project_uploads_oldest_unsynced_time")
                .projectWikiRepositoriesCount("project_wiki_repositories_count")
                .projectWikiRepositoriesChecksumTotalCount("project_wiki_repositories_checksum_total_count")
                .projectWikiRepositoriesChecksummedCount("project_wiki_repositories_checksummed_count")
                .projectWikiRepositoriesChecksumFailedCount("project_wiki_repositories_checksum_failed_count")
                .projectWikiRepositoriesSyncedCount("project_wiki_repositories_synced_count")
                .projectWikiRepositoriesFailedCount("project_wiki_repositories_failed_count")
                .projectWikiRepositoriesRegistryCount("project_wiki_repositories_registry_count")
                .projectWikiRepositoriesVerificationTotalCount("project_wiki_repositories_verification_total_count")
                .projectWikiRepositoriesVerifiedCount("project_wiki_repositories_verified_count")
                .projectWikiRepositoriesVerificationFailedCount("project_wiki_repositories_verification_failed_count")
                .projectWikiRepositoriesOldestUnsyncedTime("project_wiki_repositories_oldest_unsynced_time")
                .projectImportExportRelationExportUploadUploadsSyncedInPercentage(
                        "project_import_export_relation_export_upload_uploads_synced_in_percentage")
                .projectImportExportRelationExportUploadUploadsVerifiedInPercentage(
                        "project_import_export_relation_export_upload_uploads_verified_in_percentage")
                .projectRepositoriesSyncedInPercentage("project_repositories_synced_in_percentage")
                .projectRepositoriesVerifiedInPercentage("project_repositories_verified_in_percentage")
                .projectTopicUploadsSyncedInPercentage("project_topic_uploads_synced_in_percentage")
                .projectTopicUploadsVerifiedInPercentage("project_topic_uploads_verified_in_percentage")
                .projectUploadsSyncedInPercentage("project_uploads_synced_in_percentage")
                .projectUploadsVerifiedInPercentage("project_uploads_verified_in_percentage")
                .projectWikiRepositoriesSyncedInPercentage("project_wiki_repositories_synced_in_percentage")
                .projectWikiRepositoriesVerifiedInPercentage("project_wiki_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusSnippet geoNodeStatusSnippet() {
        return GitLabGeoNodeStatusSnippetBuilder.builder()
                .snippetRepositoriesCount("snippet_repositories_count")
                .snippetRepositoriesChecksumTotalCount("snippet_repositories_checksum_total_count")
                .snippetRepositoriesChecksummedCount("snippet_repositories_checksummed_count")
                .snippetRepositoriesChecksumFailedCount("snippet_repositories_checksum_failed_count")
                .snippetRepositoriesSyncedCount("snippet_repositories_synced_count")
                .snippetRepositoriesFailedCount("snippet_repositories_failed_count")
                .snippetRepositoriesRegistryCount("snippet_repositories_registry_count")
                .snippetRepositoriesVerificationTotalCount("snippet_repositories_verification_total_count")
                .snippetRepositoriesVerifiedCount("snippet_repositories_verified_count")
                .snippetRepositoriesVerificationFailedCount("snippet_repositories_verification_failed_count")
                .snippetRepositoriesOldestUnsyncedTime("snippet_repositories_oldest_unsynced_time")
                .snippetRepositoriesSyncedInPercentage("snippet_repositories_synced_in_percentage")
                .snippetRepositoriesVerifiedInPercentage("snippet_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusSupply geoNodeStatusSupply() {
        return GitLabGeoNodeStatusSupplyBuilder.builder()
                .supplyChainAttestationsCount("supply_chain_attestations_count")
                .supplyChainAttestationsChecksumTotalCount("supply_chain_attestations_checksum_total_count")
                .supplyChainAttestationsChecksummedCount("supply_chain_attestations_checksummed_count")
                .supplyChainAttestationsChecksumFailedCount("supply_chain_attestations_checksum_failed_count")
                .supplyChainAttestationsSyncedCount("supply_chain_attestations_synced_count")
                .supplyChainAttestationsFailedCount("supply_chain_attestations_failed_count")
                .supplyChainAttestationsRegistryCount("supply_chain_attestations_registry_count")
                .supplyChainAttestationsVerificationTotalCount("supply_chain_attestations_verification_total_count")
                .supplyChainAttestationsVerifiedCount("supply_chain_attestations_verified_count")
                .supplyChainAttestationsVerificationFailedCount("supply_chain_attestations_verification_failed_count")
                .supplyChainAttestationsOldestUnsyncedTime("supply_chain_attestations_oldest_unsynced_time")
                .supplyChainAttestationsSyncedInPercentage("supply_chain_attestations_synced_in_percentage")
                .supplyChainAttestationsVerifiedInPercentage("supply_chain_attestations_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusTerraform geoNodeStatusTerraform() {
        return GitLabGeoNodeStatusTerraformBuilder.builder()
                .terraformStateVersionsCount("terraform_state_versions_count")
                .terraformStateVersionsChecksumTotalCount("terraform_state_versions_checksum_total_count")
                .terraformStateVersionsChecksummedCount("terraform_state_versions_checksummed_count")
                .terraformStateVersionsChecksumFailedCount("terraform_state_versions_checksum_failed_count")
                .terraformStateVersionsSyncedCount("terraform_state_versions_synced_count")
                .terraformStateVersionsFailedCount("terraform_state_versions_failed_count")
                .terraformStateVersionsRegistryCount("terraform_state_versions_registry_count")
                .terraformStateVersionsVerificationTotalCount("terraform_state_versions_verification_total_count")
                .terraformStateVersionsVerifiedCount("terraform_state_versions_verified_count")
                .terraformStateVersionsVerificationFailedCount("terraform_state_versions_verification_failed_count")
                .terraformStateVersionsOldestUnsyncedTime("terraform_state_versions_oldest_unsynced_time")
                .terraformStateVersionsSyncedInPercentage("terraform_state_versions_synced_in_percentage")
                .terraformStateVersionsVerifiedInPercentage("terraform_state_versions_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusUploads geoNodeStatusUploads() {
        return GitLabGeoNodeStatusUploadsBuilder.builder()
                .uploadsCount("uploads_count")
                .uploadsChecksumTotalCount("uploads_checksum_total_count")
                .uploadsChecksummedCount("uploads_checksummed_count")
                .uploadsChecksumFailedCount("uploads_checksum_failed_count")
                .uploadsSyncedCount("uploads_synced_count")
                .uploadsFailedCount("uploads_failed_count")
                .uploadsRegistryCount("uploads_registry_count")
                .uploadsVerificationTotalCount("uploads_verification_total_count")
                .uploadsVerifiedCount("uploads_verified_count")
                .uploadsVerificationFailedCount("uploads_verification_failed_count")
                .uploadsOldestUnsyncedTime("uploads_oldest_unsynced_time")
                .uploadsSyncedInPercentage("uploads_synced_in_percentage")
                .uploadsVerifiedInPercentage("uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusUser geoNodeStatusUser() {
        return GitLabGeoNodeStatusUserBuilder.builder()
                .userPermissionExportUploadUploadsCount("user_permission_export_upload_uploads_count")
                .userPermissionExportUploadUploadsChecksumTotalCount(
                        "user_permission_export_upload_uploads_checksum_total_count")
                .userPermissionExportUploadUploadsChecksummedCount(
                        "user_permission_export_upload_uploads_checksummed_count")
                .userPermissionExportUploadUploadsChecksumFailedCount(
                        "user_permission_export_upload_uploads_checksum_failed_count")
                .userPermissionExportUploadUploadsSyncedCount("user_permission_export_upload_uploads_synced_count")
                .userPermissionExportUploadUploadsFailedCount("user_permission_export_upload_uploads_failed_count")
                .userPermissionExportUploadUploadsRegistryCount("user_permission_export_upload_uploads_registry_count")
                .userPermissionExportUploadUploadsVerificationTotalCount(
                        "user_permission_export_upload_uploads_verification_total_count")
                .userPermissionExportUploadUploadsVerifiedCount("user_permission_export_upload_uploads_verified_count")
                .userPermissionExportUploadUploadsVerificationFailedCount(
                        "user_permission_export_upload_uploads_verification_failed_count")
                .userPermissionExportUploadUploadsOldestUnsyncedTime(
                        "user_permission_export_upload_uploads_oldest_unsynced_time")
                .userUploadsCount("user_uploads_count")
                .userUploadsChecksumTotalCount("user_uploads_checksum_total_count")
                .userUploadsChecksummedCount("user_uploads_checksummed_count")
                .userUploadsChecksumFailedCount("user_uploads_checksum_failed_count")
                .userUploadsSyncedCount("user_uploads_synced_count")
                .userUploadsFailedCount("user_uploads_failed_count")
                .userUploadsRegistryCount("user_uploads_registry_count")
                .userUploadsVerificationTotalCount("user_uploads_verification_total_count")
                .userUploadsVerifiedCount("user_uploads_verified_count")
                .userUploadsVerificationFailedCount("user_uploads_verification_failed_count")
                .userUploadsOldestUnsyncedTime("user_uploads_oldest_unsynced_time")
                .userPermissionExportUploadUploadsSyncedInPercentage(
                        "user_permission_export_upload_uploads_synced_in_percentage")
                .userPermissionExportUploadUploadsVerifiedInPercentage(
                        "user_permission_export_upload_uploads_verified_in_percentage")
                .userUploadsSyncedInPercentage("user_uploads_synced_in_percentage")
                .userUploadsVerifiedInPercentage("user_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoNodeStatusVulnerability geoNodeStatusVulnerability() {
        return GitLabGeoNodeStatusVulnerabilityBuilder.builder()
                .vulnerabilityArchiveExportUploadsCount("vulnerability_archive_export_uploads_count")
                .vulnerabilityArchiveExportUploadsChecksumTotalCount(
                        "vulnerability_archive_export_uploads_checksum_total_count")
                .vulnerabilityArchiveExportUploadsChecksummedCount(
                        "vulnerability_archive_export_uploads_checksummed_count")
                .vulnerabilityArchiveExportUploadsChecksumFailedCount(
                        "vulnerability_archive_export_uploads_checksum_failed_count")
                .vulnerabilityArchiveExportUploadsSyncedCount("vulnerability_archive_export_uploads_synced_count")
                .vulnerabilityArchiveExportUploadsFailedCount("vulnerability_archive_export_uploads_failed_count")
                .vulnerabilityArchiveExportUploadsRegistryCount("vulnerability_archive_export_uploads_registry_count")
                .vulnerabilityArchiveExportUploadsVerificationTotalCount(
                        "vulnerability_archive_export_uploads_verification_total_count")
                .vulnerabilityArchiveExportUploadsVerifiedCount("vulnerability_archive_export_uploads_verified_count")
                .vulnerabilityArchiveExportUploadsVerificationFailedCount(
                        "vulnerability_archive_export_uploads_verification_failed_count")
                .vulnerabilityArchiveExportUploadsOldestUnsyncedTime(
                        "vulnerability_archive_export_uploads_oldest_unsynced_time")
                .vulnerabilityExportPartUploadsCount("vulnerability_export_part_uploads_count")
                .vulnerabilityExportPartUploadsChecksumTotalCount(
                        "vulnerability_export_part_uploads_checksum_total_count")
                .vulnerabilityExportPartUploadsChecksummedCount("vulnerability_export_part_uploads_checksummed_count")
                .vulnerabilityExportPartUploadsChecksumFailedCount(
                        "vulnerability_export_part_uploads_checksum_failed_count")
                .vulnerabilityExportPartUploadsSyncedCount("vulnerability_export_part_uploads_synced_count")
                .vulnerabilityExportPartUploadsFailedCount("vulnerability_export_part_uploads_failed_count")
                .vulnerabilityExportPartUploadsRegistryCount("vulnerability_export_part_uploads_registry_count")
                .vulnerabilityExportPartUploadsVerificationTotalCount(
                        "vulnerability_export_part_uploads_verification_total_count")
                .vulnerabilityExportPartUploadsVerifiedCount("vulnerability_export_part_uploads_verified_count")
                .vulnerabilityExportPartUploadsVerificationFailedCount(
                        "vulnerability_export_part_uploads_verification_failed_count")
                .vulnerabilityExportPartUploadsOldestUnsyncedTime(
                        "vulnerability_export_part_uploads_oldest_unsynced_time")
                .vulnerabilityExportUploadsCount("vulnerability_export_uploads_count")
                .vulnerabilityExportUploadsChecksumTotalCount("vulnerability_export_uploads_checksum_total_count")
                .vulnerabilityExportUploadsChecksummedCount("vulnerability_export_uploads_checksummed_count")
                .vulnerabilityExportUploadsChecksumFailedCount("vulnerability_export_uploads_checksum_failed_count")
                .vulnerabilityExportUploadsSyncedCount("vulnerability_export_uploads_synced_count")
                .vulnerabilityExportUploadsFailedCount("vulnerability_export_uploads_failed_count")
                .vulnerabilityExportUploadsRegistryCount("vulnerability_export_uploads_registry_count")
                .vulnerabilityExportUploadsVerificationTotalCount(
                        "vulnerability_export_uploads_verification_total_count")
                .vulnerabilityExportUploadsVerifiedCount("vulnerability_export_uploads_verified_count")
                .vulnerabilityExportUploadsVerificationFailedCount(
                        "vulnerability_export_uploads_verification_failed_count")
                .vulnerabilityExportUploadsOldestUnsyncedTime("vulnerability_export_uploads_oldest_unsynced_time")
                .vulnerabilityRemediationUploadsCount("vulnerability_remediation_uploads_count")
                .vulnerabilityRemediationUploadsChecksumTotalCount(
                        "vulnerability_remediation_uploads_checksum_total_count")
                .vulnerabilityRemediationUploadsChecksummedCount("vulnerability_remediation_uploads_checksummed_count")
                .vulnerabilityRemediationUploadsChecksumFailedCount(
                        "vulnerability_remediation_uploads_checksum_failed_count")
                .vulnerabilityRemediationUploadsSyncedCount("vulnerability_remediation_uploads_synced_count")
                .vulnerabilityRemediationUploadsFailedCount("vulnerability_remediation_uploads_failed_count")
                .vulnerabilityRemediationUploadsRegistryCount("vulnerability_remediation_uploads_registry_count")
                .vulnerabilityRemediationUploadsVerificationTotalCount(
                        "vulnerability_remediation_uploads_verification_total_count")
                .vulnerabilityRemediationUploadsVerifiedCount("vulnerability_remediation_uploads_verified_count")
                .vulnerabilityRemediationUploadsVerificationFailedCount(
                        "vulnerability_remediation_uploads_verification_failed_count")
                .vulnerabilityRemediationUploadsOldestUnsyncedTime(
                        "vulnerability_remediation_uploads_oldest_unsynced_time")
                .vulnerabilityArchiveExportUploadsSyncedInPercentage(
                        "vulnerability_archive_export_uploads_synced_in_percentage")
                .vulnerabilityArchiveExportUploadsVerifiedInPercentage(
                        "vulnerability_archive_export_uploads_verified_in_percentage")
                .vulnerabilityExportPartUploadsSyncedInPercentage(
                        "vulnerability_export_part_uploads_synced_in_percentage")
                .vulnerabilityExportPartUploadsVerifiedInPercentage(
                        "vulnerability_export_part_uploads_verified_in_percentage")
                .vulnerabilityExportUploadsSyncedInPercentage("vulnerability_export_uploads_synced_in_percentage")
                .vulnerabilityExportUploadsVerifiedInPercentage("vulnerability_export_uploads_verified_in_percentage")
                .vulnerabilityRemediationUploadsSyncedInPercentage(
                        "vulnerability_remediation_uploads_synced_in_percentage")
                .vulnerabilityRemediationUploadsVerifiedInPercentage(
                        "vulnerability_remediation_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGranularScope granularScope() {
        return GitLabGranularScopeBuilder.builder()
                .access("personal_projects")
                .permissions(List.of("read_job"))
                .projectId(1L)
                .groupId(1L)
                .build();
    }

    public static GitLabGroup group() {
        return GitLabGroupBuilder.builder()
                .id(1L)
                .webUrl("http://gitlab.example.com/groups/diaspora")
                .name("Diaspora")
                .path("path")
                .description("description")
                .visibility("visibility")
                .shareWithGroupLock(true)
                .requireTwoFactorAuthentication(true)
                .twoFactorGracePeriod(1)
                .projectCreationLevel("project_creation_level")
                .autoDevopsEnabled(true)
                .subgroupCreationLevel("subgroup_creation_level")
                .emailsDisabled(true)
                .emailsEnabled(true)
                .showDiffPreviewInEmail(true)
                .mentionsDisabled(true)
                .lfsEnabled(true)
                .archived(true)
                .mathRenderingLimitsEnabled(true)
                .lockMathRenderingLimitsEnabled(true)
                .crmEnabled(true)
                .resourceAccessTokenNotifyInherited(true)
                .lockResourceAccessTokenNotifyInherited(true)
                .defaultBranch("default_branch")
                .defaultBranchProtection(1)
                .defaultBranchProtectionDefaults(CommonCatalogFixtures.groupDefaultBranchProtectionDefaults())
                .avatarUrl("avatar_url")
                .requestAccessEnabled(true)
                .fullName("full_name")
                .fullPath("full_path")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .parentId(1L)
                .organizationId(1L)
                .sharedRunnersSetting("shared_runners_setting")
                .maxArtifactsSize(1L)
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .statistics(CommonCatalogFixtures.groupStatistics())
                .markedForDeletionOn("marked_for_deletion_on")
                .rootStorageStatistics(CommonCatalogFixtures.namespaceRootStorageStatistics())
                .ldapCn("ldap_cn")
                .ldapAccess("ldap_access")
                .ldapGroupLinks(CommonCatalogFixtures.ldapGroupLink())
                .samlGroupLinks(CommonCatalogFixtures.samlGroupLink())
                .fileTemplateProjectId(1L)
                .wikiAccessLevel("wiki_access_level")
                .repositoryStorage("repository_storage")
                .duoCoreFeaturesEnabled(true)
                .duoFeaturesEnabled(true)
                .lockDuoFeaturesEnabled(true)
                .autoDuoCodeReviewEnabled("auto_duo_code_review_enabled")
                .duoCodeReviewDepthAllowed(true)
                .duoCodeReviewDefaultDepth("standard")
                .duoCodeReviewDecisionsEnabled("duo_code_review_decisions_enabled")
                .webBasedCommitSigningEnabled(true)
                .allowPersonalSnippets("allow_personal_snippets")
                .duoNamespaceAccessRules(List.of(Map.of("key", "value")))
                .builtInProjectTemplatesEnabled(true)
                .lockBuiltInProjectTemplatesEnabled(true)
                .build();
    }

    public static GitLabGroupAccess groupAccess() {
        return GitLabGroupAccessBuilder.builder()
                .accessLevel("access_level")
                .notificationLevel("notification_level")
                .build();
    }

    public static GitLabGroupDefaultBranchProtectionDefaults groupDefaultBranchProtectionDefaults() {
        return GitLabGroupDefaultBranchProtectionDefaultsBuilder.builder()
                .allowedToPush(List.of(CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToPush()))
                .allowForcePush(true)
                .allowedToMerge(List.of(CommonCatalogFixtures.groupDefaultBranchProtectionDefaultsAllowedToMerge()))
                .codeOwnerApprovalRequired(true)
                .developerCanInitialPush(true)
                .build();
    }

    public static GitLabGroupDefaultBranchProtectionDefaultsAllowedToMerge
            groupDefaultBranchProtectionDefaultsAllowedToMerge() {
        return GitLabGroupDefaultBranchProtectionDefaultsAllowedToMergeBuilder.builder()
                .accessLevel(GitLabGroupDefaultBranchProtectionDefaultsAllowedToMergeAccessLevel.DEVELOPER)
                .build();
    }

    public static GitLabGroupDefaultBranchProtectionDefaultsAllowedToPush
            groupDefaultBranchProtectionDefaultsAllowedToPush() {
        return GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushBuilder.builder()
                .accessLevel(GitLabGroupDefaultBranchProtectionDefaultsAllowedToPushAccessLevel.DEVELOPER)
                .build();
    }

    public static GitLabGroupLabel groupLabel() {
        return GitLabGroupLabelBuilder.builder()
                .id(1L)
                .name("bug")
                .description("Bug reported by user")
                .textColor("#FFFFFF")
                .descriptionHtml("<p>Bug reported by user</p>")
                .color("#FF0000")
                .archived(true)
                .openIssuesCount(1)
                .closedIssuesCount(1)
                .openMergeRequestsCount(1)
                .subscribed(true)
                .build();
    }

    public static GitLabGroupRepositoryStorageMove groupRepositoryStorageMove() {
        return GitLabGroupRepositoryStorageMoveBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .state("scheduled")
                .sourceStorageName("default")
                .destinationStorageName("storage1")
                .errorMessage("Failed to move repository")
                .group(CommonCatalogFixtures.basicGroupDetails())
                .build();
    }

    public static GitLabGroupStatistics groupStatistics() {
        return GitLabGroupStatisticsBuilder.builder()
                .storageSize("storage_size")
                .repositorySize("repository_size")
                .wikiSize("wiki_size")
                .lfsObjectsSize("lfs_objects_size")
                .jobArtifactsSize("job_artifacts_size")
                .pipelineArtifactsSize("pipeline_artifacts_size")
                .packagesSize("packages_size")
                .snippetsSize("snippets_size")
                .uploadsSize("uploads_size")
                .build();
    }

    public static GitLabIdentity identity() {
        return GitLabIdentityBuilder.builder()
                .provider("provider")
                .externUid("extern_uid")
                .samlProviderId(1L)
                .build();
    }

    public static GitLabIdentityDetail identityDetail() {
        return GitLabIdentityDetailBuilder.builder()
                .externUid("extern_uid")
                .userId(1L)
                .active(true)
                .build();
    }

    public static GitLabIntegration integration() {
        return GitLabIntegrationBuilder.builder()
                .id(1L)
                .title("Jenkins CI")
                .slug("jenkins")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .active(true)
                .commitEvents(true)
                .pushEvents(true)
                .issuesEvents(true)
                .incidentEvents(true)
                .alertEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .deploymentEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .jobEvents(true)
                .commentOnEventEnabled(true)
                .inherited(true)
                .vulnerabilityEvents(true)
                .properties(Map.of("key", "value"))
                .build();
    }

    public static GitLabIntegrationBasic integrationBasic() {
        return GitLabIntegrationBasicBuilder.builder()
                .id(1L)
                .title("Jenkins CI")
                .slug("jenkins")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .active(true)
                .commitEvents(true)
                .pushEvents(true)
                .issuesEvents(true)
                .incidentEvents(true)
                .alertEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .deploymentEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .jobEvents(true)
                .commentOnEventEnabled(true)
                .inherited(true)
                .vulnerabilityEvents(true)
                .build();
    }

    public static GitLabIssuableReferences issuableReferences() {
        return GitLabIssuableReferencesBuilder.builder()
                .shortValue("&6")
                .relative("&6")
                .full("test&6")
                .build();
    }

    public static GitLabIssuableTimeStats issuableTimeStats() {
        return GitLabIssuableTimeStatsBuilder.builder()
                .timeEstimate(1)
                .totalTimeSpent(1)
                .humanTimeEstimate("3h 30m")
                .humanTotalTimeSpent("1h")
                .build();
    }

    public static GitLabIssueBasic issueBasic() {
        return GitLabIssueBasicBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedBy(CommonCatalogFixtures.userBasic())
                .labels(List.of("bug"))
                .milestone(CommonCatalogFixtures.milestone())
                .assignees(List.of(CommonCatalogFixtures.userBasic()))
                .author(CommonCatalogFixtures.userBasic())
                .type(GitLabIssueBasicType.ISSUE)
                .assignee(CommonCatalogFixtures.userBasic())
                .userNotesCount(1)
                .mergeRequestsCount(1)
                .upvotes(1)
                .downvotes(1)
                .startDate(LocalDate.parse("2026-01-01"))
                .dueDate(LocalDate.parse("2026-01-01"))
                .confidential(true)
                .discussionLocked(true)
                .issueType("issue")
                .webUrl("http://example.com/example/example/issues/14")
                .timeStats(CommonCatalogFixtures.issuableTimeStats())
                .taskCompletionStatus(CommonCatalogFixtures.taskCompletionStatus())
                .weight(1)
                .blockingIssuesCount(1)
                .build();
    }

    public static GitLabIteration iteration() {
        return GitLabIterationBuilder.builder()
                .id(1L)
                .iid(1L)
                .sequence(1)
                .groupId(1L)
                .title("Iteration I")
                .description("Iteration description")
                .state(1)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startDate(LocalDate.parse("2026-01-01"))
                .dueDate(LocalDate.parse("2026-01-01"))
                .webUrl("https://gitlab.example.com/groups/gitlab-org/-/iterations/1")
                .build();
    }

    public static GitLabLabelBasic labelBasic() {
        return GitLabLabelBasicBuilder.builder()
                .id(1L)
                .name("bug")
                .description("Bug reported by user")
                .textColor("#FFFFFF")
                .descriptionHtml("<p>Bug reported by user</p>")
                .color("#FF0000")
                .archived(true)
                .build();
    }

    public static GitLabLdapGroupLink ldapGroupLink() {
        return GitLabLdapGroupLinkBuilder.builder()
                .cn("ldap-group-1")
                .groupAccess(1)
                .provider("ldapmain")
                .filter("id >= 500")
                .memberRoleId(1L)
                .build();
    }

    public static GitLabLicense license() {
        return GitLabLicenseBuilder.builder()
                .key("gpl-3.0")
                .name("GNU General Public License v3.0")
                .nickname("GNU GPLv3")
                .htmlUrl("http://choosealicense.com/licenses/gpl-3.0")
                .sourceUrl("source_url")
                .popular(true)
                .description("A simple license")
                .conditions(List.of("include-copyright"))
                .permissions(List.of("commercial-use"))
                .limitations(List.of("liability"))
                .content("GNU GENERAL PUBLIC LICENSE")
                .build();
    }

    public static GitLabLicenseBasic licenseBasic() {
        return GitLabLicenseBasicBuilder.builder()
                .key("gpl-3.0")
                .name("GNU General Public License v3.0")
                .nickname("GNU GPLv3")
                .htmlUrl("http://choosealicense.com/licenses/gpl-3.0")
                .sourceUrl("source_url")
                .build();
    }

    public static GitLabList list() {
        return GitLabListBuilder.builder()
                .id(1L)
                .label(CommonCatalogFixtures.labelBasic())
                .position(1)
                .milestone(CommonCatalogFixtures.milestone())
                .iteration(CommonCatalogFixtures.iteration())
                .assignee(CommonCatalogFixtures.userSafe())
                .status(CommonCatalogFixtures.workItemsStatus())
                .maxIssueCount(1)
                .maxIssueWeight(1)
                .limitMetric("issue_count")
                .build();
    }

    public static GitLabMarkdownUploadAdmin markdownUploadAdmin() {
        return GitLabMarkdownUploadAdminBuilder.builder()
                .id(1L)
                .size(1L)
                .filename("image.png")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .uploadedBy(CommonCatalogFixtures.userSafe())
                .build();
    }

    public static GitLabMember member() {
        return GitLabMemberBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .accessLevel(1)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBy(CommonCatalogFixtures.userBasic())
                .expiresAt("expires_at")
                .twoFactorEnabled(true)
                .groupSamlIdentity(CommonCatalogFixtures.identity())
                .groupScimIdentity(CommonCatalogFixtures.scimIdentity())
                .email("email")
                .isUsingSeat("is_using_seat")
                .override("override")
                .membershipState("membership_state")
                .memberRole(CommonCatalogFixtures.memberRole())
                .build();
    }

    public static GitLabMemberRole memberRole() {
        return GitLabMemberRoleBuilder.builder()
                .id(1L)
                .groupId(1L)
                .name("Custom guest")
                .description("Guest user who can also read_code")
                .baseAccessLevel(GitLabMemberRoleBaseAccessLevel.MINIMAL_ACCESS)
                .applySecurityScanProfiles(true)
                .adminMergeRequest(true)
                .archiveProject(true)
                .archiveSubgroup(true)
                .adminAiCatalogItemConsumer(true)
                .createSecurityScanProfiles(true)
                .destroyPackage(true)
                .removeProject(true)
                .deleteSecurityScanProfiles(true)
                .removeGroup(true)
                .manageSecurityPolicyLink(true)
                .adminAiCatalogItem(true)
                .adminComplianceFramework(true)
                .adminCicdVariables(true)
                .manageDeployTokens(true)
                .manageGroupAccessTokens(true)
                .adminGroupMember(true)
                .adminIntegrations(true)
                .manageMergeRequestSettings(true)
                .manageProjectAccessTokens(true)
                .adminProtectedBranch(true)
                .adminProtectedEnvironments(true)
                .adminPushRules(true)
                .adminRunners(true)
                .adminSecurityAttributes(true)
                .adminTerraformState(true)
                .adminVulnerability(true)
                .adminWebHook(true)
                .pullContainerImage(true)
                .pushContainerImage(true)
                .readAgentArtifacts(true)
                .readComplianceDashboard(true)
                .readSecurityScanProfiles(true)
                .readVirtualRegistry(true)
                .updateSecAiWorkflowSettings(true)
                .updateSecurityScanProfiles(true)
                .readAdminCicd(true)
                .readCrmContact(true)
                .readDependency(true)
                .readAdminGroups(true)
                .readAdminProjects(true)
                .readCode(true)
                .readRunners(true)
                .readSecurityAttribute(true)
                .readAdminSubscription(true)
                .readAdminMonitoring(true)
                .readAdminUsers(true)
                .readVulnerability(true)
                .build();
    }

    public static GitLabMergeRequest mergeRequest() {
        return GitLabMergeRequestBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBy(CommonCatalogFixtures.userBasic())
                .mergeUser(CommonCatalogFixtures.userBasic())
                .mergedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedBy(CommonCatalogFixtures.userBasic())
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .titleHtml("title_html")
                .descriptionHtml("description_html")
                .targetBranch("target_branch")
                .sourceBranch("source_branch")
                .userNotesCount(1)
                .upvotes(1)
                .downvotes(1)
                .author(CommonCatalogFixtures.mergeRequestAuthor())
                .assignees(List.of(CommonCatalogFixtures.userBasic()))
                .assignee(CommonCatalogFixtures.userBasic())
                .reviewers(List.of(CommonCatalogFixtures.userBasic()))
                .sourceProjectId(1L)
                .targetProjectId(1L)
                .labels(List.of("labels"))
                .draft(true)
                .imported(true)
                .importedFrom("bitbucket")
                .workInProgress(true)
                .milestone(CommonCatalogFixtures.milestone())
                .mergeWhenPipelineSucceeds(true)
                .mergeStatus("unchecked")
                .detailedMergeStatus("mergeable")
                .mergeAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .sha("1234abcd")
                .mergeCommitSha("1234abcd")
                .squashCommitSha("1234abcd")
                .discussionLocked(true)
                .shouldRemoveSourceBranch(true)
                .forceRemoveSourceBranch(true)
                .preparedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .allowCollaboration(true)
                .allowMaintainerToPush(true)
                .reference("!1")
                .references(CommonCatalogFixtures.issuableReferences())
                .webUrl("https://gitlab.example.com/my-group/my-project/-/merge_requests/1")
                .timeStats(CommonCatalogFixtures.issuableTimeStats())
                .squash(true)
                .squashOnMerge(true)
                .taskCompletionStatus(CommonCatalogFixtures.taskCompletionStatus())
                .hasConflicts(true)
                .blockingDiscussionsResolved(true)
                .approvalsBeforeMerge(1)
                .subscribed(true)
                .changesCount("1")
                .latestBuildStartedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .latestBuildFinishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .firstDeployedToProductionAt(Instant.parse("2026-01-01T00:00:00Z"))
                .pipeline(CommonCatalogFixtures.ciPipelineBasic())
                .headPipeline(CommonCatalogFixtures.ciPipeline())
                .diffRefs(CommonCatalogFixtures.diffRefs())
                .mergeError("Merge error")
                .rebaseInProgress(true)
                .divergedCommitsCount(1)
                .firstContribution(true)
                .user(CommonCatalogFixtures.mergeRequestUser())
                .build();
    }

    public static GitLabMergeRequestApprovalRuleSourceRule mergeRequestApprovalRuleSourceRule() {
        return GitLabMergeRequestApprovalRuleSourceRuleBuilder.builder()
                .approvalsRequired(1)
                .build();
    }

    public static GitLabMergeRequestApprovals mergeRequestApprovals() {
        return GitLabMergeRequestApprovalsBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergeStatus("can_be_merged")
                .approved(true)
                .approvalsRequired(1)
                .approvalsLeft(1)
                .requirePasswordToApprove(true)
                .approvedBy(List.of(CommonCatalogFixtures.approvals()))
                .suggestedApprovers(List.of(CommonCatalogFixtures.userBasic()))
                .approvers(List.of(Map.of("key", "value")))
                .approverGroups(List.of(Map.of("key", "value")))
                .userHasApproved(true)
                .userCanApprove(true)
                .approvalRulesLeft(List.of(CommonCatalogFixtures.approvalRuleShort()))
                .hasApprovalRules(true)
                .mergeRequestApproversAvailable(true)
                .multipleApprovalRulesAvailable(true)
                .invalidApproversRules(List.of(CommonCatalogFixtures.approvalRuleShort()))
                .build();
    }

    public static GitLabMergeRequestAuthor mergeRequestAuthor() {
        return GitLabMergeRequestAuthorBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .bot(true)
                .build();
    }

    public static GitLabMergeRequestBasic mergeRequestBasic() {
        return GitLabMergeRequestBasicBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .title("Impedit et ut et dolores vero provident ullam est")
                .description("Repellendus impedit et vel velit dignissimos.")
                .state("closed")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .mergedBy(CommonCatalogFixtures.userBasic())
                .mergeUser(CommonCatalogFixtures.userBasic())
                .mergedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedBy(CommonCatalogFixtures.userBasic())
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .titleHtml("title_html")
                .descriptionHtml("description_html")
                .targetBranch("target_branch")
                .sourceBranch("source_branch")
                .userNotesCount(1)
                .upvotes(1)
                .downvotes(1)
                .author(CommonCatalogFixtures.mergeRequestAuthor())
                .assignees(List.of(CommonCatalogFixtures.userBasic()))
                .assignee(CommonCatalogFixtures.userBasic())
                .reviewers(List.of(CommonCatalogFixtures.userBasic()))
                .sourceProjectId(1L)
                .targetProjectId(1L)
                .labels(List.of("labels"))
                .draft(true)
                .imported(true)
                .importedFrom("bitbucket")
                .workInProgress(true)
                .milestone(CommonCatalogFixtures.milestone())
                .mergeWhenPipelineSucceeds(true)
                .mergeStatus("unchecked")
                .detailedMergeStatus("mergeable")
                .mergeAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .sha("1234abcd")
                .mergeCommitSha("1234abcd")
                .squashCommitSha("1234abcd")
                .discussionLocked(true)
                .shouldRemoveSourceBranch(true)
                .forceRemoveSourceBranch(true)
                .preparedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .allowCollaboration(true)
                .allowMaintainerToPush(true)
                .reference("!1")
                .references(CommonCatalogFixtures.issuableReferences())
                .webUrl("https://gitlab.example.com/my-group/my-project/-/merge_requests/1")
                .timeStats(CommonCatalogFixtures.issuableTimeStats())
                .squash(true)
                .squashOnMerge(true)
                .taskCompletionStatus(CommonCatalogFixtures.taskCompletionStatus())
                .hasConflicts(true)
                .blockingDiscussionsResolved(true)
                .approvalsBeforeMerge(1)
                .build();
    }

    public static GitLabMergeRequestUser mergeRequestUser() {
        return GitLabMergeRequestUserBuilder.builder().canMerge(true).build();
    }

    public static GitLabMilestone milestone() {
        return GitLabMilestoneBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .groupId(1L)
                .title("title")
                .description("description")
                .state("state")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .dueDate("due_date")
                .startDate("start_date")
                .expired(true)
                .webUrl("web_url")
                .build();
    }

    public static GitLabMilestoneWithStats milestoneWithStats() {
        return GitLabMilestoneWithStatsBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .groupId("group_id")
                .title("title")
                .description("description")
                .state("state")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .dueDate("due_date")
                .startDate("start_date")
                .expired(true)
                .webUrl("web_url")
                .issueStats(CommonCatalogFixtures.milestoneWithStatsIssueStats())
                .build();
    }

    public static GitLabMilestoneWithStatsIssueStats milestoneWithStatsIssueStats() {
        return GitLabMilestoneWithStatsIssueStatsBuilder.builder()
                .total(1)
                .closed(1)
                .build();
    }

    public static GitLabNamespaceBasic namespaceBasic() {
        return GitLabNamespaceBasicBuilder.builder()
                .id(1L)
                .name("project")
                .path("my_project")
                .kind("project")
                .fullPath("group/my_project")
                .parentId(1L)
                .avatarUrl("https://example.com/avatar/12345")
                .webUrl("https://example.com/group/my_project")
                .build();
    }

    public static GitLabNamespaceRootStorageStatistics namespaceRootStorageStatistics() {
        return GitLabNamespaceRootStorageStatisticsBuilder.builder()
                .buildArtifactsSize(1L)
                .containerRegistrySize(1L)
                .containerRegistrySizeIsEstimated(true)
                .dependencyProxySize(1L)
                .lfsObjectsSize(1L)
                .packagesSize(1L)
                .pipelineArtifactsSize(1L)
                .repositorySize(1L)
                .snippetsSize(1L)
                .storageSize(1L)
                .uploadsSize(1L)
                .wikiSize(1L)
                .build();
    }

    public static GitLabNote note() {
        return GitLabNoteBuilder.builder()
                .id(1L)
                .type("DiscussionNote")
                .body("Note body.")
                .author(CommonCatalogFixtures.userBasic())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .system(true)
                .noteableId(1L)
                .noteableType("Issue")
                .projectId(1L)
                .commitId("7b09ce7e6f80347baf0316c8c94cdba9a0a7e91d")
                .position(Map.of("key", "value"))
                .resolvable(true)
                .resolved(true)
                .resolvedBy(CommonCatalogFixtures.userBasic())
                .resolvedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .suggestions(List.of(CommonCatalogFixtures.suggestion()))
                .confidential(true)
                .internal(true)
                .imported(true)
                .importedFrom("github")
                .noteableIid(1L)
                .commandsChanges(Map.of("key", "value"))
                .build();
    }

    public static GitLabNugetDependency nugetDependency() {
        return GitLabNugetDependencyBuilder.builder()
                .atId("http://gitlab.com/Sandbox.App/1.0.0.json#dependency")
                .atType("PackageDependency")
                .id("Dependency")
                .range("2.0.0")
                .build();
    }

    public static GitLabNugetDependencyGroup nugetDependencyGroup() {
        return GitLabNugetDependencyGroupBuilder.builder()
                .atId("http://gitlab.com/Sandbox.App/1.0.0.json#dependencygroup")
                .atType("PackageDependencyGroup")
                .targetFramework("fwk test")
                .dependencies(List.of(CommonCatalogFixtures.nugetDependency()))
                .build();
    }

    public static GitLabNugetPackageMetadata nugetPackageMetadata() {
        return GitLabNugetPackageMetadataBuilder.builder()
                .atId("https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json")
                .packageContent(
                        "https://gitlab.example.com/api/v4/projects/1/packages/nuget/download/MyNuGetPkg/1.3.0.17/helloworld.1.3.0.17.nupkg")
                .catalogEntry(CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                .build();
    }

    public static GitLabNugetPackageMetadataCatalogEntry nugetPackageMetadataCatalogEntry() {
        return GitLabNugetPackageMetadataCatalogEntryBuilder.builder()
                .atId("https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json")
                .dependencyGroups(List.of(CommonCatalogFixtures.nugetDependencyGroup()))
                .id("MyNuGetPkg")
                .version("1.3.0.17")
                .tags("tag#1 tag#2")
                .packageContent(
                        "https://gitlab.example.com/api/v4/projects/1/packages/nuget/download/MyNuGetPkg/1.3.0.17/helloworld.1.3.0.17.nupkg")
                .authors("Authors")
                .description("Description")
                .summary("Description")
                .projectUrl("http://sandbox.com/project")
                .licenseUrl("http://sandbox.com/license")
                .iconUrl("http://sandbox.com/icon")
                .published("2023-05-08T17:23:25Z")
                .build();
    }

    public static GitLabNugetPackagesMetadata nugetPackagesMetadata() {
        return GitLabNugetPackagesMetadataBuilder.builder()
                .count(1)
                .items(List.of(CommonCatalogFixtures.nugetPackagesMetadataItem()))
                .build();
    }

    public static GitLabNugetPackagesMetadataItem nugetPackagesMetadataItem() {
        return GitLabNugetPackagesMetadataItemBuilder.builder()
                .atId("https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json")
                .lower("1.3.0.17")
                .upper("1.3.0.17")
                .count(1)
                .items(List.of(CommonCatalogFixtures.nugetPackageMetadata()))
                .build();
    }

    public static GitLabNugetSearchResult nugetSearchResult() {
        return GitLabNugetSearchResultBuilder.builder()
                .atType("Package")
                .id("MyNuGetPkg")
                .title("MyNuGetPkg")
                .totalDownloads(1)
                .verified(true)
                .version("1.3.0.17")
                .versions(List.of(CommonCatalogFixtures.nugetSearchResultVersion()))
                .tags("tag#1 tag#2")
                .authors("Authors")
                .description("Description")
                .summary("Description")
                .projectUrl("http://sandbox.com/project")
                .licenseUrl("http://sandbox.com/license")
                .iconUrl("http://sandbox.com/icon")
                .build();
    }

    public static GitLabNugetSearchResultVersion nugetSearchResultVersion() {
        return GitLabNugetSearchResultVersionBuilder.builder()
                .atId("https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json")
                .version("1.3.0.17")
                .downloads(1)
                .build();
    }

    public static GitLabNugetSearchResults nugetSearchResults() {
        return GitLabNugetSearchResultsBuilder.builder()
                .totalHits(1)
                .data(List.of(CommonCatalogFixtures.nugetSearchResult()))
                .build();
    }

    public static GitLabNugetServiceIndex nugetServiceIndex() {
        return GitLabNugetServiceIndexBuilder.builder()
                .version("1.3.0.17")
                .resources(List.of(Map.of("key", "value")))
                .build();
    }

    public static GitLabPackage packageValue() {
        return GitLabPackageBuilder.builder()
                .id(1L)
                .name("@foo/bar")
                .conanPackageName("conan_package_name")
                .version("1.0.3")
                .packageType("npm")
                .status("default")
                .links(CommonCatalogFixtures.packageLinks())
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastDownloadedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .creatorId(1L)
                .projectId(1L)
                .projectPath("gitlab/foo/bar")
                .tags(List.of(CommonCatalogFixtures.packageTag()))
                .pipeline(CommonCatalogFixtures.packagePipeline())
                .pipelines(List.of(CommonCatalogFixtures.packagePipeline()))
                .versions(List.of(CommonCatalogFixtures.packageVersion()))
                .build();
    }

    public static GitLabPackageDebianDistribution packageDebianDistribution() {
        return GitLabPackageDebianDistributionBuilder.builder()
                .id(1L)
                .codename("sid")
                .suite("unstable")
                .origin("Grep")
                .label("grep.be")
                .version("12")
                .description("My description")
                .validTimeDurationSeconds(1)
                .components(List.of("main"))
                .architectures(List.of("amd64"))
                .build();
    }

    public static GitLabPackageLinks packageLinks() {
        return GitLabPackageLinksBuilder.builder()
                .webPath("web_path")
                .deleteApiPath("delete_api_path")
                .build();
    }

    public static GitLabPackagePipeline packagePipeline() {
        return GitLabPackagePipelineBuilder.builder()
                .id(1L)
                .iid(1L)
                .projectId(1L)
                .sha("0ec9e58fdfca6cdd6652c083c9edb53abc0bad52")
                .ref("feature-branch")
                .status("success")
                .source("push")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .webUrl("https://gitlab.example.com/gitlab-org/gitlab-foss/-/pipelines/61")
                .user(CommonCatalogFixtures.userBasic())
                .build();
    }

    public static GitLabPackageTag packageTag() {
        return GitLabPackageTagBuilder.builder()
                .id(1L)
                .packageId(1L)
                .name("name")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .build();
    }

    public static GitLabPackageVersion packageVersion() {
        return GitLabPackageVersionBuilder.builder()
                .id(1L)
                .version("version")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .tags(List.of(CommonCatalogFixtures.packageVersionTag()))
                .pipeline(CommonCatalogFixtures.packagePipeline())
                .build();
    }

    public static GitLabPackageVersionTag packageVersionTag() {
        return GitLabPackageVersionTagBuilder.builder()
                .id(1L)
                .packageId(1L)
                .name("name")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .build();
    }

    public static GitLabPersonalAccessToken personalAccessToken() {
        return GitLabPersonalAccessTokenBuilder.builder()
                .id(1L)
                .name("John Doe")
                .revoked(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .description("Token to manage api")
                .scopes(List.of("api"))
                .userId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedIps(List.of("127.0.0.1"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .active(true)
                .granular(true)
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabPersonalAccessTokenWithToken personalAccessTokenWithToken() {
        return GitLabPersonalAccessTokenWithTokenBuilder.builder()
                .id(1L)
                .name("John Doe")
                .revoked(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .description("Token to manage api")
                .scopes(List.of("api"))
                .userId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedIps(List.of("127.0.0.1"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .active(true)
                .granular(true)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .token("token")
                .build();
    }

    public static GitLabPlatformKubernetes platformKubernetes() {
        return GitLabPlatformKubernetesBuilder.builder()
                .apiUrl("api_url")
                .namespace("namespace")
                .authorizationType("authorization_type")
                .caCert("ca_cert")
                .build();
    }

    public static GitLabProject project() {
        return GitLabProjectBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .defaultBranch("main")
                .tagList(List.of("tag"))
                .topics(List.of("topic"))
                .sshUrlToRepo("git@gitlab.example.com:gitlab/gitlab.git")
                .httpUrlToRepo("https://gitlab.example.com/gitlab/gitlab.git")
                .webUrl("https://gitlab.example.com/gitlab/gitlab")
                .readmeUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/README.md")
                .forksCount(1)
                .licenseUrl("https://gitlab.example.com/gitlab/gitlab/blob/master/LICENCE")
                .license(CommonCatalogFixtures.licenseBasic())
                .avatarUrl("http://example.com/uploads/project/avatar/3/uploads/avatar.png")
                .starCount(1)
                .lastActivityAt(Instant.parse("2026-01-01T00:00:00Z"))
                .visibility("public")
                .namespace(CommonCatalogFixtures.namespaceBasic())
                .customAttributes(CommonCatalogFixtures.customAttribute())
                .repositoryStorage("default")
                .forkedFromProject(CommonCatalogFixtures.basicProjectDetails())
                .containerRegistryImagePrefix("registry.gitlab.example.com/gitlab/gitlab-client")
                .links(CommonCatalogFixtures.projectLinks())
                .markedForDeletionAt(LocalDate.parse("2026-01-01"))
                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                .packagesEnabled(true)
                .emptyRepo(true)
                .archived(true)
                .owner(CommonCatalogFixtures.userBasic())
                .resolveOutdatedDiffDiscussions(true)
                .containerExpirationPolicy(CommonCatalogFixtures.containerExpirationPolicy())
                .repositoryObjectFormat("sha1")
                .issuesEnabled(true)
                .mergeRequestsEnabled(true)
                .wikiEnabled(true)
                .jobsEnabled(true)
                .snippetsEnabled(true)
                .containerRegistryEnabled(true)
                .serviceDeskEnabled(true)
                .serviceDeskAddress("address@example.com")
                .canCreateMergeRequestIn(true)
                .issuesAccessLevel("enabled")
                .repositoryAccessLevel("enabled")
                .mergeRequestsAccessLevel("enabled")
                .forkingAccessLevel("enabled")
                .wikiAccessLevel("enabled")
                .buildsAccessLevel("enabled")
                .snippetsAccessLevel("enabled")
                .pagesAccessLevel("enabled")
                .analyticsAccessLevel("enabled")
                .containerRegistryAccessLevel("enabled")
                .securityAndComplianceAccessLevel("enabled")
                .releasesAccessLevel("enabled")
                .environmentsAccessLevel("enabled")
                .featureFlagsAccessLevel("enabled")
                .infrastructureAccessLevel("enabled")
                .monitorAccessLevel("enabled")
                .modelExperimentsAccessLevel("enabled")
                .modelRegistryAccessLevel("enabled")
                .packageRegistryAccessLevel("enabled")
                .emailsDisabled(true)
                .emailsEnabled(true)
                .showDiffPreviewInEmail(true)
                .sharedRunnersEnabled(true)
                .lfsEnabled(true)
                .creatorId(1L)
                .mrDefaultTargetSelf(true)
                .importUrl("https://gitlab.com/gitlab/gitlab.git")
                .importType("git")
                .importStatus("none")
                .importError("Import error")
                .openIssuesCount(1)
                .descriptionHtml("description_html")
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .ciDefaultGitDepth(1)
                .ciDeletePipelinesInSeconds(1)
                .ciForwardDeploymentEnabled(true)
                .ciForwardDeploymentRollbackAllowed(true)
                .ciJobTokenScopeEnabled(true)
                .ciSeparatedCaches(true)
                .ciAllowForkPipelinesToRunInParentProject(true)
                .ciIdTokenSubClaimComponents(List.of("ci_id_token_sub_claim_components"))
                .buildGitStrategy("fetch")
                .keepLatestArtifact(true)
                .restrictUserDefinedVariables(true)
                .ciPipelineVariablesMinimumOverrideRole("ci_pipeline_variables_minimum_override_role")
                .runnerTokenExpirationInterval(1)
                .groupRunnersEnabled(true)
                .resourceGroupDefaultProcessMode("unordered")
                .autoCancelPendingPipelines("enabled")
                .buildTimeout(1)
                .autoDevopsEnabled(true)
                .autoDevopsDeployStrategy("continuous")
                .ciPushRepositoryForJobTokenAllowed(true)
                .protectMergeRequestPipelines(true)
                .ciDisplayPipelineVariables(true)
                .ciSkipBranchPipelinesForMrs(true)
                .runnersToken("b8547b1dc37721d05889db52fa2f02")
                .ciConfigPath("")
                .publicJobs(true)
                .sharedWithGroups(List.of(Map.of("key", "value")))
                .onlyAllowMergeIfPipelineSucceeds(true)
                .allowMergeOnSkippedPipeline(true)
                .requestAccessEnabled(true)
                .onlyAllowMergeIfAllDiscussionsAreResolved(true)
                .removeSourceBranchAfterMerge(true)
                .printingMergeRequestLinkEnabled(true)
                .mergeMethod("merge")
                .squashOption("default_off")
                .automaticRebaseEnabled(true)
                .enforceAuthChecksOnUploads(true)
                .suggestionCommitMessage("Suggestion message")
                .mergeCommitTemplate("%(title)")
                .squashCommitTemplate("%(source_branch)")
                .mrDefaultTitleTemplate("%(source_branch)")
                .issueBranchTemplate("%(title)")
                .statistics(CommonCatalogFixtures.projectStatistics())
                .warnAboutPotentiallyUnwantedCharacters(true)
                .autocloseReferencedIssues(true)
                .maxArtifactsSize(1L)
                .approvalsBeforeMerge(1)
                .mirror(true)
                .mirrorUserId(1L)
                .mirrorTriggerBuilds(true)
                .onlyMirrorProtectedBranches(true)
                .mirrorOverwritesDivergedBranches(true)
                .externalAuthorizationClassificationLabel("external_authorization_classification_label")
                .requirementsEnabled(true)
                .requirementsAccessLevel("requirements_access_level")
                .securityAndComplianceEnabled(true)
                .secretPushProtectionEnabled(true)
                .preReceiveSecretDetectionEnabled(true)
                .complianceFrameworks(List.of("compliance_frameworks"))
                .issuesTemplate("issues_template")
                .mergeRequestsTemplate("merge_requests_template")
                .ciRestrictPipelineCancellationRole("ci_restrict_pipeline_cancellation_role")
                .mergePipelinesEnabled(true)
                .mergeTrainsEnabled(true)
                .mergeTrainsSkipTrainAllowed(true)
                .mergeTrainEnforcement("merge_train_enforcement")
                .maxPipelinesPerMergeTrain("max_pipelines_per_merge_train")
                .onlyAllowMergeIfAllStatusChecksPassed(true)
                .allowPipelineTriggerApproveDeployment(true)
                .preventMergeWithoutJiraIssue(true)
                .autoDuoCodeReviewEnabled(true)
                .duoCodeReviewDecisionsEnabled(true)
                .duoCodeReviewDepthAllowed(true)
                .duoCodeReviewDefaultDepth("standard")
                .reviewerAssignmentStrategy("code_owners")
                .duoRemoteFlowsEnabled(true)
                .duoFoundationalFlowsEnabled(true)
                .duoScheduledAutomationsEnabled("duo_scheduled_automations_enabled")
                .duoSastFpDetectionEnabled(true)
                .duoSecretDetectionFpEnabled(true)
                .duoDependencyBumpBreakingChangesEnabled(true)
                .duoSastVrWorkflowEnabled(true)
                .webBasedCommitSigningEnabled("web_based_commit_signing_enabled")
                .sppRepositoryPipelineAccess(true)
                .securityPolicyPipelineMustSucceed(true)
                .mergeRequestTitleRegex("/Title of merge request/")
                .mergeRequestTitleRegexDescription("This requires the title to include a Jira label")
                .build();
    }

    public static GitLabProjectAccess projectAccess() {
        return GitLabProjectAccessBuilder.builder()
                .accessLevel("access_level")
                .notificationLevel("notification_level")
                .build();
    }

    public static GitLabProjectDailyFetches projectDailyFetches() {
        return GitLabProjectDailyFetchesBuilder.builder()
                .count(1)
                .date(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabProjectEntity projectEntity() {
        return GitLabProjectEntityBuilder.builder()
                .id(1L)
                .name("GitLab")
                .fullPath("gitlab-org/gitlab")
                .fullName("GitLab Org / GitLab")
                .refsUrl("refs_url")
                .forked(true)
                .build();
    }

    public static GitLabProjectIdentity projectIdentity() {
        return GitLabProjectIdentityBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabProjectImportEntity projectImportEntity() {
        return GitLabProjectImportEntityBuilder.builder()
                .id(1L)
                .name("GitLab")
                .fullPath("gitlab-org/gitlab")
                .fullName("GitLab Org / GitLab")
                .refsUrl("refs_url")
                .forked(true)
                .importSource("source/source-repo")
                .importStatus(GitLabProjectImportEntityImportStatus.SCHEDULED)
                .humanImportStatusName("canceled")
                .providerLink("/source/source-repo")
                .importError("import_error")
                .importWarning("import_warning")
                .relationType("relation_type")
                .build();
    }

    public static GitLabProjectImportFailedRelation projectImportFailedRelation() {
        return GitLabProjectImportFailedRelationBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .exceptionClass("StandardError")
                .source("ImportRepositoryWorker")
                .exceptionMessage("exception_message")
                .relationName("issues")
                .lineNumber(1)
                .build();
    }

    public static GitLabProjectImportStatus projectImportStatus() {
        return GitLabProjectImportStatusBuilder.builder()
                .id(1L)
                .description("desc")
                .name("project1")
                .nameWithNamespace("John Doe / project1")
                .path("project1")
                .pathWithNamespace("namespace1/project1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .importStatus("scheduled")
                .importType("gitlab_project")
                .correlationId("dfcf583058ed4508e4c7c617bd7f0edd")
                .failedRelations(List.of(CommonCatalogFixtures.projectImportFailedRelation()))
                .importError("Error message")
                .stats(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectLinks projectLinks() {
        return GitLabProjectLinksBuilder.builder()
                .self("https://gitlab.example.com/api/v4/projects/4")
                .issues("https://gitlab.example.com/api/v4/projects/4/issues")
                .mergeRequests("https://gitlab.example.com/api/v4/projects/4/merge_requests")
                .repoBranches("https://gitlab.example.com/api/v4/projects/4/repository/branches")
                .labels("https://gitlab.example.com/api/v4/projects/4/labels")
                .events("https://gitlab.example.com/api/v4/projects/4/events")
                .members("https://gitlab.example.com/api/v4/projects/4/members")
                .clusterAgents("https://gitlab.example.com/api/v4/projects/4/cluster_agents")
                .build();
    }

    public static GitLabProjectRepositoryStorageMove projectRepositoryStorageMove() {
        return GitLabProjectRepositoryStorageMoveBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .state("scheduled")
                .sourceStorageName("default")
                .destinationStorageName("storage1")
                .errorMessage("Failed to move repository")
                .project(CommonCatalogFixtures.projectIdentity())
                .build();
    }

    public static GitLabProjectStatistics projectStatistics() {
        return GitLabProjectStatisticsBuilder.builder()
                .commitCount(1)
                .storageSize(1L)
                .repositorySize(1L)
                .wikiSize(1L)
                .lfsObjectsSize(1L)
                .jobArtifactsSize(1L)
                .pipelineArtifactsSize(1L)
                .packagesSize(1L)
                .snippetsSize(1L)
                .uploadsSize(1L)
                .containerRegistrySize(1L)
                .build();
    }

    public static GitLabProtectedBranch protectedBranch() {
        return GitLabProtectedBranchBuilder.builder()
                .id(1L)
                .name("main")
                .pushAccessLevels(List.of(CommonCatalogFixtures.protectedRefAccess()))
                .mergeAccessLevels(List.of(CommonCatalogFixtures.protectedRefAccess()))
                .allowForcePush(true)
                .unprotectAccessLevels(List.of(CommonCatalogFixtures.protectedRefAccess()))
                .codeOwnerApprovalRequired(true)
                .inherited(true)
                .build();
    }

    public static GitLabProtectedEnvironment protectedEnvironment() {
        return GitLabProtectedEnvironmentBuilder.builder()
                .name("production")
                .deployAccessLevels(CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                .requiredApprovalCount(1)
                .approvalRules(CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                .build();
    }

    public static GitLabProtectedEnvironmentsApprovalRule protectedEnvironmentsApprovalRule() {
        return GitLabProtectedEnvironmentsApprovalRuleBuilder.builder()
                .id(1L)
                .userId(1L)
                .groupId(1L)
                .accessLevel(1)
                .accessLevelDescription("access_level_description")
                .requiredApprovals(1)
                .groupInheritanceType(1)
                .build();
    }

    public static GitLabProtectedEnvironmentsDeployAccessLevel protectedEnvironmentsDeployAccessLevel() {
        return GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder()
                .id(1L)
                .accessLevel(1)
                .accessLevelDescription("Maintainers")
                .deployKeyId(1L)
                .userId(1L)
                .groupId(1L)
                .memberRoleId(1L)
                .memberRoleName("Lead Developer")
                .groupInheritanceType(1)
                .build();
    }

    public static GitLabProtectedRefAccess protectedRefAccess() {
        return GitLabProtectedRefAccessBuilder.builder()
                .id(1L)
                .accessLevel(1)
                .accessLevelDescription("Maintainers")
                .deployKeyId(1L)
                .userId(1L)
                .groupId(1L)
                .memberRoleId(1L)
                .memberRoleName("Lead Developer")
                .build();
    }

    public static GitLabProviderGcp providerGcp() {
        return GitLabProviderGcpBuilder.builder()
                .clusterId("cluster_id")
                .statusName("status_name")
                .gcpProjectId("gcp_project_id")
                .zone("zone")
                .machineType("machine_type")
                .numNodes("num_nodes")
                .endpoint("endpoint")
                .build();
    }

    public static GitLabRelatedEpic relatedEpic() {
        return GitLabRelatedEpicBuilder.builder()
                .id(1L)
                .workItemId(1L)
                .iid(1L)
                .color("#1068bf")
                .textColor("#1068bf")
                .groupId(1L)
                .parentId(1L)
                .parentIid(1L)
                .imported(true)
                .importedFrom("github")
                .title("My Epic")
                .description("Epic description")
                .confidential(true)
                .author(CommonCatalogFixtures.userBasic())
                .startDate(LocalDate.parse("2026-01-01"))
                .startDateIsFixed(true)
                .startDateFixed(Instant.parse("2026-01-01T00:00:00Z"))
                .startDateFromInheritedSource(Instant.parse("2026-01-01T00:00:00Z"))
                .startDateFromMilestones(Instant.parse("2026-01-01T00:00:00Z"))
                .endDate(Instant.parse("2026-01-01T00:00:00Z"))
                .dueDate(LocalDate.parse("2026-01-01"))
                .dueDateIsFixed(true)
                .dueDateFixed(Instant.parse("2026-01-01T00:00:00Z"))
                .dueDateFromInheritedSource(Instant.parse("2026-01-01T00:00:00Z"))
                .dueDateFromMilestones(Instant.parse("2026-01-01T00:00:00Z"))
                .state("opened")
                .webEditUrl("http://gitlab.example.com/groups/test/-/epics/4/edit")
                .webUrl("http://gitlab.example.com/groups/test/-/epics/4")
                .references(CommonCatalogFixtures.issuableReferences())
                .reference("&1")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .closedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .labels(List.of("labels"))
                .upvotes(1)
                .downvotes(1)
                .subscribed(true)
                .links(CommonCatalogFixtures.relatedEpicLinks())
                .relatedEpicLinkId(1L)
                .linkType("relates_to")
                .linkCreatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .linkUpdatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabRelatedEpicLinks relatedEpicLinks() {
        return GitLabRelatedEpicLinksBuilder.builder()
                .self("http://gitlab.example.com/api/v4/groups/7/epics/5")
                .epicIssues("http://gitlab.example.com/api/v4/groups/7/epics/5/issues")
                .group("http://gitlab.example.com/api/v4/groups/7")
                .parent("http://gitlab.example.com/api/v4/groups/7/epics/4")
                .build();
    }

    public static GitLabRelease release() {
        return GitLabReleaseBuilder.builder()
                .name("Release v1.0")
                .tagName("v1.0")
                .description("Finally released v1.0")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .releasedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .upcomingRelease(true)
                .descriptionHtml("description_html")
                .author(CommonCatalogFixtures.userBasic())
                .commit(CommonCatalogFixtures.commit())
                .milestones(List.of(CommonCatalogFixtures.milestoneWithStats()))
                .commitPath("/root/app/commit/588440f66559714280628a4f9799f0c4eb880a4a")
                .tagPath("/root/app/-/tags/v1.0")
                .assets(CommonCatalogFixtures.releaseAssets())
                .evidences(List.of(CommonCatalogFixtures.releaseEvidence()))
                .links(CommonCatalogFixtures.releaseLinks())
                .build();
    }

    public static GitLabReleaseAssets releaseAssets() {
        return GitLabReleaseAssetsBuilder.builder()
                .count(1)
                .sources(List.of(CommonCatalogFixtures.releaseSource()))
                .links(List.of(ReleaselinksCatalogFixtures.releaseLink()))
                .build();
    }

    public static GitLabReleaseEvidence releaseEvidence() {
        return GitLabReleaseEvidenceBuilder.builder()
                .sha("760d6cdfb0879c3ffedec13af470e0f71cf52c6cde4d")
                .filepath("https://gitlab.example.com/root/app/-/releases/v1.0/evidence.json")
                .collectedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabReleaseLinks releaseLinks() {
        return GitLabReleaseLinksBuilder.builder()
                .closedIssuesUrl("closed_issues_url")
                .closedMergeRequestsUrl("closed_merge_requests_url")
                .editUrl("edit_url")
                .mergedMergeRequestsUrl("merged_merge_requests_url")
                .openedIssuesUrl("opened_issues_url")
                .openedMergeRequestsUrl("opened_merge_requests_url")
                .self("self")
                .build();
    }

    public static GitLabReleaseSource releaseSource() {
        return GitLabReleaseSourceBuilder.builder()
                .format("zip")
                .url("https://gitlab.example.com/root/app/-/archive/v1.0/app-v1.0.zip")
                .build();
    }

    public static GitLabSSHKey sshkey() {
        return GitLabSSHKeyBuilder.builder()
                .id(1L)
                .title("Sample key 25")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .key(
                        "ssh-rsa AAAAB3NzaC1yc2EAAAABJQAAAIEAiPWx6WM4lhHNedGfBpPJNPpZ7yKu+dnn1SJejgt1256k6Yjz\\\n      GGphH2TUxwKzxcKDKKezwkpfnxPkSMkuEspGRt/aZZ9wa++Oi7Qkr8prgHc4soW6NUlfDzpvZK2H5E7eQaSeP3SAwGmQKUFHCdd\\\n      NaP0L+hM7zhFNzjFvpaMgJw0=")
                .usageType("auth")
                .build();
    }

    public static GitLabSamlGroupLink samlGroupLink() {
        return GitLabSamlGroupLinkBuilder.builder()
                .name("saml-group-1")
                .accessLevel(1)
                .memberRoleId(1L)
                .provider("saml")
                .build();
    }

    public static GitLabScimIdentity scimIdentity() {
        return GitLabScimIdentityBuilder.builder()
                .externUid("extern_uid")
                .groupId(1L)
                .active(true)
                .build();
    }

    public static GitLabSnippetRepositoryStorageMove snippetRepositoryStorageMove() {
        return GitLabSnippetRepositoryStorageMoveBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .state("scheduled")
                .sourceStorageName("default")
                .destinationStorageName("storage1")
                .errorMessage("Failed to move repository")
                .snippet(CommonCatalogFixtures.basicSnippet())
                .build();
    }

    public static GitLabStorageShardEntity storageShardEntity() {
        return GitLabStorageShardEntityBuilder.builder().name("name").build();
    }

    public static GitLabSuggestion suggestion() {
        return GitLabSuggestionBuilder.builder()
                .id(1L)
                .fromLine(1)
                .toLine(1)
                .appliable(true)
                .applied(true)
                .fromContent("Original content\n")
                .toContent("New content\n")
                .build();
    }

    public static GitLabTaskCompletionStatus taskCompletionStatus() {
        return GitLabTaskCompletionStatusBuilder.builder()
                .count(1)
                .completedCount(1)
                .build();
    }

    public static GitLabTemplate template() {
        return GitLabTemplateBuilder.builder()
                .name("Ruby")
                .content("# Ruby gitignore template")
                .build();
    }

    public static GitLabTemplateList templateList() {
        return GitLabTemplateListBuilder.builder()
                .key("mit")
                .name("MIT License")
                .build();
    }

    public static GitLabTodo todo() {
        return GitLabTodoBuilder.builder()
                .id(1L)
                .project(CommonCatalogFixtures.projectIdentity())
                .group(CommonCatalogFixtures.namespaceBasic())
                .author(CommonCatalogFixtures.userBasic())
                .actionName("assigned")
                .targetType("Issue")
                .target(Map.of("key", "value"))
                .targetUrl("http://example.com/foo/bar/-/issues/1")
                .body("Task description")
                .state("pending")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabUser user() {
        return GitLabUserBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .bio("bio")
                .location("location")
                .linkedin("linkedin")
                .twitter("twitter")
                .discord("discord")
                .websiteUrl("website_url")
                .github("github")
                .jobTitle("job_title")
                .pronouns("pronouns")
                .organization("organization")
                .bot(true)
                .workInformation("work_information")
                .followers(1)
                .following(1)
                .isFollowed(true)
                .localTime("local_time")
                .build();
    }

    public static GitLabUserAgentDetail userAgentDetail() {
        return GitLabUserAgentDetailBuilder.builder()
                .userAgent("AppleWebKit/537.36")
                .ipAddress("127.0.0.1")
                .akismetSubmitted(true)
                .build();
    }

    public static GitLabUserBasic userBasic() {
        return GitLabUserBasicBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .build();
    }

    public static GitLabUserPublic userPublic() {
        return GitLabUserPublicBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .bio("bio")
                .location("location")
                .linkedin("linkedin")
                .twitter("twitter")
                .discord("discord")
                .websiteUrl("website_url")
                .github("github")
                .jobTitle("job_title")
                .pronouns("pronouns")
                .organization("organization")
                .bot(true)
                .workInformation("work_information")
                .followers("followers")
                .following("following")
                .isFollowed("is_followed")
                .localTime("local_time")
                .lastSignInAt(Instant.parse("2026-01-01T00:00:00Z"))
                .confirmedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastActivityOn(LocalDate.parse("2026-01-01"))
                .email("john@example.com")
                .themeId(1L)
                .colorSchemeId(1L)
                .projectsLimit(1)
                .currentSignInAt(Instant.parse("2026-01-01T00:00:00Z"))
                .identities(List.of(CommonCatalogFixtures.identity()))
                .canCreateGroup(true)
                .canCreateProject(true)
                .twoFactorEnabled(true)
                .external(true)
                .privateProfile(true)
                .commitEmail("commit_email")
                .preferredLanguage("en")
                .sharedRunnersMinutesLimit("shared_runners_minutes_limit")
                .extraSharedRunnersMinutesLimit("extra_shared_runners_minutes_limit")
                .scimIdentities(List.of(CommonCatalogFixtures.scimIdentity()))
                .build();
    }

    public static GitLabUserSafe userSafe() {
        return GitLabUserSafeBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .build();
    }

    public static GitLabUserWithAdmin userWithAdmin() {
        return GitLabUserWithAdminBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .bio("bio")
                .location("location")
                .linkedin("linkedin")
                .twitter("twitter")
                .discord("discord")
                .websiteUrl("website_url")
                .github("github")
                .jobTitle("job_title")
                .pronouns("pronouns")
                .organization("organization")
                .bot(true)
                .workInformation("work_information")
                .followers("followers")
                .following("following")
                .isFollowed("is_followed")
                .localTime("local_time")
                .lastSignInAt(Instant.parse("2026-01-01T00:00:00Z"))
                .confirmedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastActivityOn(LocalDate.parse("2026-01-01"))
                .email("john@example.com")
                .themeId(1L)
                .colorSchemeId(1L)
                .projectsLimit(1)
                .currentSignInAt(Instant.parse("2026-01-01T00:00:00Z"))
                .identities(List.of(CommonCatalogFixtures.identity()))
                .canCreateGroup(true)
                .canCreateProject(true)
                .twoFactorEnabled(true)
                .external(true)
                .privateProfile(true)
                .commitEmail("commit_email")
                .preferredLanguage("en")
                .sharedRunnersMinutesLimit("shared_runners_minutes_limit")
                .extraSharedRunnersMinutesLimit("extra_shared_runners_minutes_limit")
                .scimIdentities(List.of(CommonCatalogFixtures.scimIdentity()))
                .isAdmin("is_admin")
                .note("note")
                .namespaceId("namespace_id")
                .provisionedByProjectId("provisioned_by_project_id")
                .createdBy(CommonCatalogFixtures.userBasic())
                .usingLicenseSeat("using_license_seat")
                .isAuditor("is_auditor")
                .provisionedByGroupId("provisioned_by_group_id")
                .enterpriseGroupId("enterprise_group_id")
                .enterpriseGroupAssociatedAt("enterprise_group_associated_at")
                .build();
    }

    public static GitLabVulnerability vulnerability() {
        return GitLabVulnerabilityBuilder.builder()
                .id(1L)
                .title("title")
                .description("description")
                .state("state")
                .severity("severity")
                .reportType("report_type")
                .project(CommonCatalogFixtures.projectIdentity())
                .finding(Map.of("key", "value"))
                .resolvedOnDefaultBranch(true)
                .projectDefaultBranch("project_default_branch")
                .authorId(1L)
                .resolvedById(1L)
                .dismissedById(1L)
                .confirmedById(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .resolvedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .dismissedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .confirmedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastEditedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .startDate(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedById(1L)
                .lastEditedById(1L)
                .dueDate(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabWikiAttachment wikiAttachment() {
        return GitLabWikiAttachmentBuilder.builder()
                .fileName("dk.png")
                .filePath("uploads/6a061c4cf9f1c28cb22c384b4b8d4e3c/dk.png")
                .branch("main")
                .link(CommonCatalogFixtures.wikiAttachmentLink())
                .build();
    }

    public static GitLabWikiAttachmentLink wikiAttachmentLink() {
        return GitLabWikiAttachmentLinkBuilder.builder()
                .url("uploads/6a061c4cf9f1c28cb22c384b4b8d4e3c/dk.png")
                .markdown("![dk](uploads/6a061c4cf9f1c28cb22c384b4b8d4e3c/dk.png)")
                .build();
    }

    public static GitLabWikiPage wikiPage() {
        return GitLabWikiPageBuilder.builder()
                .format("markdown")
                .slug("deploy")
                .title("deploy")
                .wikiPageMetaId(1L)
                .content("Here is an instruction how to deploy this project.")
                .encoding("UTF-8")
                .frontMatter(Map.of("key", "value"))
                .build();
    }

    public static GitLabWikiPageBasic wikiPageBasic() {
        return GitLabWikiPageBasicBuilder.builder()
                .format("markdown")
                .slug("deploy")
                .title("deploy")
                .wikiPageMetaId(1L)
                .build();
    }

    public static GitLabWorkItemsStatus workItemsStatus() {
        return GitLabWorkItemsStatusBuilder.builder()
                .id(1L)
                .name("To do")
                .iconName(GitLabWorkItemsStatusIconName.STATUS_NEUTRAL)
                .color("#737278")
                .position(1)
                .description("description")
                .category(GitLabWorkItemsStatusCategory.TRIAGE)
                .build();
    }
}
