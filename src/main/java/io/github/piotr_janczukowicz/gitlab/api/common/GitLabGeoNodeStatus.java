package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * A GitLab geo node status.
 *
 * @param container the container properties
 * @param abuse the abuse properties
 * @param achievement the achievement properties
 * @param alert the alert properties
 * @param appearance the appearance properties
 * @param bulk the bulk properties
 * @param ci the ci properties
 * @param dependency the dependency properties
 * @param design the design properties
 * @param group the group properties
 * @param importValue the import properties
 * @param issuable the issuable properties
 * @param job the job properties
 * @param lfs the lfs properties
 * @param merge the merge properties
 * @param organization the organization properties
 * @param packageValue the package properties
 * @param packages the packages properties
 * @param pages the pages properties
 * @param personal the personal properties
 * @param pipeline the pipeline properties
 * @param project the project properties
 * @param snippet the snippet properties
 * @param supply the supply properties
 * @param terraform the terraform properties
 * @param uploads the uploads properties
 * @param user the user properties
 * @param vulnerability the vulnerability properties
 * @param ai the ai properties
 * @param other the other properties
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGeoNodeStatus")
public record GitLabGeoNodeStatus(
        @JsonUnwrapped GitLabGeoNodeStatusContainer container,
        @JsonUnwrapped GitLabGeoNodeStatusAbuse abuse,
        @JsonUnwrapped GitLabGeoNodeStatusAchievement achievement,
        @JsonUnwrapped GitLabGeoNodeStatusAlert alert,
        @JsonUnwrapped GitLabGeoNodeStatusAppearance appearance,
        @JsonUnwrapped GitLabGeoNodeStatusBulk bulk,
        @JsonUnwrapped GitLabGeoNodeStatusCi ci,
        @JsonUnwrapped GitLabGeoNodeStatusDependency dependency,
        @JsonUnwrapped GitLabGeoNodeStatusDesign design,
        @JsonUnwrapped GitLabGeoNodeStatusGroup group,
        @JsonUnwrapped GitLabGeoNodeStatusImport importValue,
        @JsonUnwrapped GitLabGeoNodeStatusIssuable issuable,
        @JsonUnwrapped GitLabGeoNodeStatusJob job,
        @JsonUnwrapped GitLabGeoNodeStatusLfs lfs,
        @JsonUnwrapped GitLabGeoNodeStatusMerge merge,
        @JsonUnwrapped GitLabGeoNodeStatusOrganization organization,
        @JsonUnwrapped GitLabGeoNodeStatusPackage packageValue,
        @JsonUnwrapped GitLabGeoNodeStatusPackages packages,
        @JsonUnwrapped GitLabGeoNodeStatusPages pages,
        @JsonUnwrapped GitLabGeoNodeStatusPersonal personal,
        @JsonUnwrapped GitLabGeoNodeStatusPipeline pipeline,
        @JsonUnwrapped GitLabGeoNodeStatusProject project,
        @JsonUnwrapped GitLabGeoNodeStatusSnippet snippet,
        @JsonUnwrapped GitLabGeoNodeStatusSupply supply,
        @JsonUnwrapped GitLabGeoNodeStatusTerraform terraform,
        @JsonUnwrapped GitLabGeoNodeStatusUploads uploads,
        @JsonUnwrapped GitLabGeoNodeStatusUser user,
        @JsonUnwrapped GitLabGeoNodeStatusVulnerability vulnerability,
        @JsonUnwrapped GitLabGeoNodeStatusAi ai,
        @JsonUnwrapped GitLabGeoNodeStatusOther other) {
    public GitLabGeoNodeStatus {
        requireNonNull(container, "container");
        requireNonNull(abuse, "abuse");
        requireNonNull(achievement, "achievement");
        requireNonNull(alert, "alert");
        requireNonNull(appearance, "appearance");
        requireNonNull(bulk, "bulk");
        requireNonNull(ci, "ci");
        requireNonNull(dependency, "dependency");
        requireNonNull(design, "design");
        requireNonNull(group, "group");
        requireNonNull(importValue, "importValue");
        requireNonNull(issuable, "issuable");
        requireNonNull(job, "job");
        requireNonNull(lfs, "lfs");
        requireNonNull(merge, "merge");
        requireNonNull(organization, "organization");
        requireNonNull(packageValue, "packageValue");
        requireNonNull(packages, "packages");
        requireNonNull(pages, "pages");
        requireNonNull(personal, "personal");
        requireNonNull(pipeline, "pipeline");
        requireNonNull(project, "project");
        requireNonNull(snippet, "snippet");
        requireNonNull(supply, "supply");
        requireNonNull(terraform, "terraform");
        requireNonNull(uploads, "uploads");
        requireNonNull(user, "user");
        requireNonNull(vulnerability, "vulnerability");
        requireNonNull(ai, "ai");
        requireNonNull(other, "other");
    }
}
