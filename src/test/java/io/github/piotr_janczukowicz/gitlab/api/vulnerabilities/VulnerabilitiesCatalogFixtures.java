package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public final class VulnerabilitiesCatalogFixtures {

    private VulnerabilitiesCatalogFixtures() {}

    public static GitLabGroupVulnerabilityExportPayload groupVulnerabilityExportPayload() {
        return GitLabGroupVulnerabilityExportPayloadBuilder.builder()
                .exportFormat(GitLabGroupVulnerabilityExportFormat.CSV)
                .sendEmail(true)
                .reportData(VulnerabilitiesCatalogFixtures.groupVulnerabilityExportReportData())
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportData groupVulnerabilityExportReportData() {
        return GitLabGroupVulnerabilityExportReportDataBuilder.builder()
                .projectVulnerabilitiesHistory(Map.of("key", "value"))
                .groupVulnerabilitiesOverTime(Map.of("key", "value"))
                .projectSecurityStatus(Map.of("key", "value"))
                .totalRiskScore(Map.of("key", "value"))
                .openVulnerabilitiesOverTime(Map.of("key", "value"))
                .vulnerabilitiesByAge(Map.of("key", "value"))
                .vulnerabilitiesBySeverityCount(
                        VulnerabilitiesCatalogFixtures
                                .groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCount())
                .dashboardType(GitLabGroupVulnerabilityExportReportDataDashboardType.PROJECT)
                .fullPath("full_path")
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCount
            groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCount() {
        return GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountBuilder.builder()
                .critical(
                        VulnerabilitiesCatalogFixtures
                                .groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCritical())
                .high(
                        VulnerabilitiesCatalogFixtures
                                .groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHigh())
                .medium(
                        VulnerabilitiesCatalogFixtures
                                .groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMedium())
                .low(
                        VulnerabilitiesCatalogFixtures
                                .groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLow())
                .unknown(
                        VulnerabilitiesCatalogFixtures
                                .groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknown())
                .info(
                        VulnerabilitiesCatalogFixtures
                                .groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfo())
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCritical
            groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCritical() {
        return GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCriticalBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHigh
            groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHigh() {
        return GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHighBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfo
            groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfo() {
        return GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfoBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLow
            groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLow() {
        return GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLowBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMedium
            groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMedium() {
        return GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMediumBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknown
            groupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknown() {
        return GitLabGroupVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknownBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabProjectVulnerabilitiesAiDetectionFlagPayload projectVulnerabilitiesAiDetectionFlagPayload() {
        return GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder()
                .confidenceScore(1)
                .description("description")
                .origin("origin")
                .build();
    }

    public static GitLabProjectVulnerabilitiesConfirmPayload projectVulnerabilitiesConfirmPayload() {
        return GitLabProjectVulnerabilitiesConfirmPayloadBuilder.builder()
                .comment("comment")
                .build();
    }

    public static GitLabProjectVulnerabilitiesCreateIssueLinkPayload projectVulnerabilitiesCreateIssueLinkPayload() {
        return GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder.builder()
                .targetIssueIid(1L)
                .targetProjectId("target_project_id")
                .linkType("link_type")
                .build();
    }

    public static GitLabProjectVulnerabilitiesResolvePayload projectVulnerabilitiesResolvePayload() {
        return GitLabProjectVulnerabilitiesResolvePayloadBuilder.builder()
                .comment("comment")
                .build();
    }

    public static GitLabProjectVulnerabilitiesRevertPayload projectVulnerabilitiesRevertPayload() {
        return GitLabProjectVulnerabilitiesRevertPayloadBuilder.builder()
                .comment("comment")
                .build();
    }

    public static GitLabProjectVulnerabilityArchiveExportPayload projectVulnerabilityArchiveExportPayload() {
        return GitLabProjectVulnerabilityArchiveExportPayloadBuilder.builder()
                .startDate(LocalDate.parse("2026-01-01"))
                .endDate(LocalDate.parse("2026-01-01"))
                .exportFormat(GitLabProjectVulnerabilityArchiveExportFormat.CSV)
                .build();
    }

    public static GitLabProjectVulnerabilityExportFilters projectVulnerabilityExportFilters() {
        return GitLabProjectVulnerabilityExportFiltersBuilder.builder()
                .severity(List.of("severity"))
                .state(List.of("state"))
                .reportType(List.of("report_type"))
                .scannerId(List.of("scanner_id"))
                .projectId(List.of(1))
                .hasResolution(true)
                .hasIssues(true)
                .hasMergeRequest(true)
                .hasRemediations(true)
                .scanner(List.of("scanner"))
                .image(List.of("image"))
                .clusterAgentId(List.of("cluster_agent_id"))
                .build();
    }

    public static GitLabProjectVulnerabilityExportPayload projectVulnerabilityExportPayload() {
        return GitLabProjectVulnerabilityExportPayloadBuilder.builder()
                .exportFormat(GitLabProjectVulnerabilityExportFormat.CSV)
                .sendEmail(true)
                .reportData(VulnerabilitiesCatalogFixtures.projectVulnerabilityExportReportData())
                .filters(VulnerabilitiesCatalogFixtures.projectVulnerabilityExportFilters())
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportData projectVulnerabilityExportReportData() {
        return GitLabProjectVulnerabilityExportReportDataBuilder.builder()
                .projectVulnerabilitiesHistory(Map.of("key", "value"))
                .groupVulnerabilitiesOverTime(Map.of("key", "value"))
                .projectSecurityStatus(Map.of("key", "value"))
                .totalRiskScore(Map.of("key", "value"))
                .openVulnerabilitiesOverTime(Map.of("key", "value"))
                .vulnerabilitiesByAge(Map.of("key", "value"))
                .vulnerabilitiesBySeverityCount(
                        VulnerabilitiesCatalogFixtures
                                .projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCount())
                .dashboardType(GitLabProjectVulnerabilityExportReportDataDashboardType.PROJECT)
                .fullPath("full_path")
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCount
            projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCount() {
        return GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountBuilder.builder()
                .critical(
                        VulnerabilitiesCatalogFixtures
                                .projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCritical())
                .high(
                        VulnerabilitiesCatalogFixtures
                                .projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHigh())
                .medium(
                        VulnerabilitiesCatalogFixtures
                                .projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMedium())
                .low(
                        VulnerabilitiesCatalogFixtures
                                .projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLow())
                .unknown(
                        VulnerabilitiesCatalogFixtures
                                .projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknown())
                .info(
                        VulnerabilitiesCatalogFixtures
                                .projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfo())
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCritical
            projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCritical() {
        return GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountCriticalBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHigh
            projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHigh() {
        return GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountHighBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfo
            projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfo() {
        return GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountInfoBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLow
            projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLow() {
        return GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountLowBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMedium
            projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMedium() {
        return GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountMediumBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknown
            projectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknown() {
        return GitLabProjectVulnerabilityExportReportDataVulnerabilitiesBySeverityCountUnknownBuilder.builder()
                .count(1)
                .medianAge(1.5)
                .color("color")
                .build();
    }

    public static GitLabVulnerabilityArchiveExport vulnerabilityArchiveExport() {
        return GitLabVulnerabilityArchiveExportBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .format("format")
                .status("status")
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .links(VulnerabilitiesCatalogFixtures.vulnerabilityArchiveExportLinks())
                .build();
    }

    public static GitLabVulnerabilityArchiveExportLinks vulnerabilityArchiveExportLinks() {
        return GitLabVulnerabilityArchiveExportLinksBuilder.builder()
                .self("self")
                .download("download")
                .build();
    }

    public static GitLabVulnerabilityExport vulnerabilityExport() {
        return GitLabVulnerabilityExportBuilder.builder()
                .id(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .projectId(1L)
                .groupId(1L)
                .format("format")
                .status("status")
                .startedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .sendEmail(true)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .links(VulnerabilitiesCatalogFixtures.vulnerabilityExportLinks())
                .build();
    }

    public static GitLabVulnerabilityExportLinks vulnerabilityExportLinks() {
        return GitLabVulnerabilityExportLinksBuilder.builder()
                .self("self")
                .download("download")
                .build();
    }

    public static GitLabVulnerabilityExportPayload vulnerabilityExportPayload() {
        return GitLabVulnerabilityExportPayloadBuilder.builder()
                .exportFormat(GitLabVulnerabilityExportFormat.CSV)
                .sendEmail(true)
                .build();
    }

    public static GitLabVulnerabilityIssueLink vulnerabilityIssueLink() {
        return GitLabVulnerabilityIssueLinkBuilder.builder()
                .id(1L)
                .vulnerability(CommonCatalogFixtures.vulnerability())
                .issue(CommonCatalogFixtures.issueBasic())
                .linkType("link_type")
                .build();
    }

    public static GitLabVulnerabilityRelatedIssue vulnerabilityRelatedIssue() {
        return GitLabVulnerabilityRelatedIssueBuilder.builder()
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
                .type(GitLabVulnerabilityRelatedIssueType.ISSUE)
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
                .vulnerabilityLinkId(1L)
                .vulnerabilityLinkType("vulnerability_link_type")
                .build();
    }
}
