package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class PipelinesCatalogFixtures {

    private PipelinesCatalogFixtures() {}

    public static GitLabCiBridge ciBridge() {
        return GitLabCiBridgeBuilder.builder()
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
                .project(PipelinesCatalogFixtures.ciBridgeProject())
                .downstreamPipeline(CommonCatalogFixtures.ciPipelineBasic())
                .build();
    }

    public static GitLabCiBridgeProject ciBridgeProject() {
        return GitLabCiBridgeProjectBuilder.builder()
                .ciJobTokenScopeEnabled(true)
                .build();
    }

    public static GitLabCiPipelineMergeRequest ciPipelineMergeRequest() {
        return GitLabCiPipelineMergeRequestBuilder.builder()
                .iid(1L)
                .title("Add rate limiting to the public API")
                .webUrl("https://gitlab.example.com/foo/bar/-/merge_requests/14")
                .build();
    }

    public static GitLabCiPipelineWithMetadata ciPipelineWithMetadata() {
        return GitLabCiPipelineWithMetadataBuilder.builder()
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
                .coverage("coverage")
                .detailedStatus(CommonCatalogFixtures.detailedStatusEntity())
                .archived(true)
                .name("Build pipeline")
                .build();
    }

    public static GitLabCiUserPipeline ciUserPipeline() {
        return GitLabCiUserPipelineBuilder.builder()
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
                .name("Build pipeline")
                .project(CommonCatalogFixtures.projectIdentity())
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .duration(1)
                .queuedDuration(1)
                .detailedStatus(CommonCatalogFixtures.detailedStatusEntity())
                .mergeRequest(PipelinesCatalogFixtures.ciPipelineMergeRequest())
                .build();
    }

    public static GitLabProjectPipelinesCreatePayload projectPipelinesCreatePayload() {
        return GitLabProjectPipelinesCreatePayloadBuilder.builder()
                .ref("develop")
                .variables(List.of(PipelinesCatalogFixtures.projectPipelinesCreateVariable()))
                .inputs(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectPipelinesCreateVariable projectPipelinesCreateVariable() {
        return GitLabProjectPipelinesCreateVariableBuilder.builder()
                .key("UPLOAD_TO_S3")
                .value("true")
                .variableType(GitLabProjectPipelinesCreateVariableType.ENV_VAR)
                .build();
    }

    public static GitLabProjectPipelinesMetadataPayload projectPipelinesMetadataPayload() {
        return GitLabProjectPipelinesMetadataPayloadBuilder.builder()
                .name("Deployment to production")
                .build();
    }

    public static GitLabTestCaseEntity testCaseEntity() {
        return GitLabTestCaseEntityBuilder.builder()
                .status("success")
                .name("Security Reports can create an auto-remediation MR")
                .classname("vulnerability_management_spec")
                .file("./spec/test_spec.rb")
                .executionTime(1)
                .systemOutput("Failure/Error: is_expected.to eq(3)")
                .stackTrace("Failure/Error: is_expected.to eq(3)")
                .recentFailures(Map.of("key", "value"))
                .attachmentUrl("http://localhost/namespace1/project1/-/jobs/1/artifacts/file/some/path.png")
                .build();
    }

    public static GitLabTestReportEntity testReportEntity() {
        return GitLabTestReportEntityBuilder.builder()
                .totalTime(1)
                .totalCount(1)
                .successCount(1)
                .failedCount(1)
                .skippedCount(1)
                .errorCount(1)
                .testSuites(List.of(PipelinesCatalogFixtures.testSuiteEntity()))
                .build();
    }

    public static GitLabTestReportSummaryEntity testReportSummaryEntity() {
        return GitLabTestReportSummaryEntityBuilder.builder()
                .total(Map.of("key", "value"))
                .testSuites(List.of(PipelinesCatalogFixtures.testSuiteSummaryEntity()))
                .build();
    }

    public static GitLabTestSuiteEntity testSuiteEntity() {
        return GitLabTestSuiteEntityBuilder.builder()
                .name("test")
                .totalTime(1)
                .totalCount(1)
                .successCount(1)
                .failedCount(1)
                .skippedCount(1)
                .errorCount(1)
                .suiteError("JUnit XML parsing failed: 1:1: FATAL: Document is empty")
                .testCases(List.of(PipelinesCatalogFixtures.testCaseEntity()))
                .build();
    }

    public static GitLabTestSuiteSummaryEntity testSuiteSummaryEntity() {
        return GitLabTestSuiteSummaryEntityBuilder.builder()
                .name("test")
                .totalTime(1)
                .totalCount(1)
                .successCount(1)
                .failedCount(1)
                .skippedCount(1)
                .errorCount(1)
                .suiteError("JUnit XML parsing failed: 1:1: FATAL: Document is empty")
                .testCases(List.of(PipelinesCatalogFixtures.testCaseEntity()))
                .buildIds(List.of(1L))
                .build();
    }
}
