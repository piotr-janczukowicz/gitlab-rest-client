package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * A GitLab geo site status.
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
@CatalogSchema("components/schemas/APIEntitiesGeoSiteStatus")
public record GitLabGeoSiteStatus(
        @JsonUnwrapped GitLabGeoSiteStatusContainer container,
        @JsonUnwrapped GitLabGeoSiteStatusAbuse abuse,
        @JsonUnwrapped GitLabGeoSiteStatusAchievement achievement,
        @JsonUnwrapped GitLabGeoSiteStatusAlert alert,
        @JsonUnwrapped GitLabGeoSiteStatusAppearance appearance,
        @JsonUnwrapped GitLabGeoSiteStatusBulk bulk,
        @JsonUnwrapped GitLabGeoSiteStatusCi ci,
        @JsonUnwrapped GitLabGeoSiteStatusDependency dependency,
        @JsonUnwrapped GitLabGeoSiteStatusDesign design,
        @JsonUnwrapped GitLabGeoSiteStatusGroup group,
        @JsonUnwrapped GitLabGeoSiteStatusImport importValue,
        @JsonUnwrapped GitLabGeoSiteStatusIssuable issuable,
        @JsonUnwrapped GitLabGeoSiteStatusJob job,
        @JsonUnwrapped GitLabGeoSiteStatusLfs lfs,
        @JsonUnwrapped GitLabGeoSiteStatusMerge merge,
        @JsonUnwrapped GitLabGeoSiteStatusOrganization organization,
        @JsonUnwrapped GitLabGeoSiteStatusPackage packageValue,
        @JsonUnwrapped GitLabGeoSiteStatusPackages packages,
        @JsonUnwrapped GitLabGeoSiteStatusPages pages,
        @JsonUnwrapped GitLabGeoSiteStatusPersonal personal,
        @JsonUnwrapped GitLabGeoSiteStatusPipeline pipeline,
        @JsonUnwrapped GitLabGeoSiteStatusProject project,
        @JsonUnwrapped GitLabGeoSiteStatusSnippet snippet,
        @JsonUnwrapped GitLabGeoSiteStatusSupply supply,
        @JsonUnwrapped GitLabGeoSiteStatusTerraform terraform,
        @JsonUnwrapped GitLabGeoSiteStatusUploads uploads,
        @JsonUnwrapped GitLabGeoSiteStatusUser user,
        @JsonUnwrapped GitLabGeoSiteStatusVulnerability vulnerability,
        @JsonUnwrapped GitLabGeoSiteStatusAi ai,
        @JsonUnwrapped GitLabGeoSiteStatusOther other) {
    public GitLabGeoSiteStatus {
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
