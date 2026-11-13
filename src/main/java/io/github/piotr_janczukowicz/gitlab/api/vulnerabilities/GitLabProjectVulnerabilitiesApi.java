package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabVulnerability;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of project vulnerabilities. */
public final class GitLabProjectVulnerabilitiesApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate CREATE_SECURITY_PROJECTS_VULNERABILITY_E =
            PathTemplate.of("/security/projects/{id}/vulnerability_exports");
    private static final PathTemplate CREATE_SECURITY_GROUPS_VULNERABILITY_EXP =
            PathTemplate.of("/security/groups/{id}/vulnerability_exports");
    private static final PathTemplate CREATE_SECURITY_VULNERABILITY_EXPORT =
            PathTemplate.of("/security/vulnerability_exports");
    private static final PathTemplate GET_SECURITY_VULNERABILITY_EXPORT =
            PathTemplate.of("/security/vulnerability_exports/{id}");
    private static final PathTemplate GET_SECURITY_VULNERABILITY_EXPORTS_DOWNL =
            PathTemplate.of("/security/vulnerability_exports/{id}/download");
    private static final PathTemplate CREATE_SECURITY_PROJECTS_VULNERABILITY_A =
            PathTemplate.of("/security/projects/{id}/vulnerability_archive_exports");
    private static final PathTemplate GET_SECURITY_VULNERABILITY_ARCHIVE_EXPOR =
            PathTemplate.of("/security/vulnerability_archive_exports/{id}");
    private static final PathTemplate GET_SECURITY_VULNERABILITY_ARCHIVE_EXP_2 =
            PathTemplate.of("/security/vulnerability_archive_exports/{id}/download");
    private static final PathTemplate LIST_ISSUE_LINKS = PathTemplate.of("/vulnerabilities/{id}/issue_links");
    private static final PathTemplate DELETE_ISSUE_LINK =
            PathTemplate.of("/vulnerabilities/{id}/issue_links/{issue_link_id}");
    private static final PathTemplate AI_DETECTION_FLAG =
            PathTemplate.of("/vulnerabilities/{vulnerability_id}/flags/ai_detection");
    private static final PathTemplate GET = PathTemplate.of("/vulnerabilities/{id}");
    private static final PathTemplate RESOLVE = PathTemplate.of("/vulnerabilities/{id}/resolve");
    private static final PathTemplate DISMISS = PathTemplate.of("/vulnerabilities/{id}/dismiss");
    private static final PathTemplate CONFIRM = PathTemplate.of("/vulnerabilities/{id}/confirm");
    private static final PathTemplate REVERT = PathTemplate.of("/vulnerabilities/{id}/revert");
    private static final JsonType<List<GitLabVulnerabilityRelatedIssue>> VULNERABILITY_RELATED_ISSUE_LIST_TYPE =
            JsonTypes.listOf(GitLabVulnerabilityRelatedIssue.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectVulnerabilitiesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create security projects vulnerability export ({@code POST /security/projects/{id}/vulnerability_exports}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerabilityExport createSecurityProjectsVulnerabilityExport(
            final String id, final GitLabProjectVulnerabilityExportPayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4SecurityProjectsIdVulnerabilityExports");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_SECURITY_PROJECTS_VULNERABILITY_E, id), payload),
                GitLabVulnerabilityExport.class);
    }

    /**
     * Create security groups vulnerability export ({@code POST /security/groups/{id}/vulnerability_exports}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerabilityExport createSecurityGroupsVulnerabilityExport(
            final String id, final GitLabGroupVulnerabilityExportPayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4SecurityGroupsIdVulnerabilityExports");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_SECURITY_GROUPS_VULNERABILITY_EXP, id), payload),
                GitLabVulnerabilityExport.class);
    }

    /**
     * Create security vulnerability export ({@code POST /security/vulnerability_exports}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerabilityExport createSecurityVulnerabilityExport(final GitLabVulnerabilityExportPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4SecurityVulnerabilityExports");
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_SECURITY_VULNERABILITY_EXPORT), payload), GitLabVulnerabilityExport.class);
    }

    /**
     * Get security vulnerability export ({@code GET /security/vulnerability_exports/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabVulnerabilityExport> getSecurityVulnerabilityExport(final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4SecurityVulnerabilityExportsId");
        return caller.fetchOrEmpty(get(GET_SECURITY_VULNERABILITY_EXPORT, id), GitLabVulnerabilityExport.class);
    }

    /**
     * Get security vulnerability exports download ({@code GET /security/vulnerability_exports/{id}/download}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public long getSecurityVulnerabilityExportsDownload(final long id, final OutputStream out) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4SecurityVulnerabilityExportsIdDownload");
        requireNonNull(out, "out");
        return caller.download(get(GET_SECURITY_VULNERABILITY_EXPORTS_DOWNL, id), out);
    }

    /**
     * Get security vulnerability exports download ({@code GET /security/vulnerability_exports/{id}/download}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Path getSecurityVulnerabilityExportsDownload(final long id, final Path target) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4SecurityVulnerabilityExportsIdDownload");
        requireNonNull(target, "target");
        return caller.download(get(GET_SECURITY_VULNERABILITY_EXPORTS_DOWNL, id), target);
    }

    /**
     * Create security projects vulnerability archive export ({@code POST
     * /security/projects/{id}/vulnerability_archive_exports}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerabilityArchiveExport createSecurityProjectsVulnerabilityArchiveExport(
            final String id, final GitLabProjectVulnerabilityArchiveExportPayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4SecurityProjectsIdVulnerabilityArchiveExports");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(post(CREATE_SECURITY_PROJECTS_VULNERABILITY_A, id), payload),
                GitLabVulnerabilityArchiveExport.class);
    }

    /**
     * Get security vulnerability archive export ({@code GET /security/vulnerability_archive_exports/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabVulnerabilityArchiveExport> getSecurityVulnerabilityArchiveExport(final long id)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4SecurityVulnerabilityArchiveExportsId");
        return caller.fetchOrEmpty(
                get(GET_SECURITY_VULNERABILITY_ARCHIVE_EXPOR, id), GitLabVulnerabilityArchiveExport.class);
    }

    /**
     * Get security vulnerability archive exports download ({@code GET
     * /security/vulnerability_archive_exports/{id}/download}).
     *
     * @param id the id
     * @return the number of bytes written
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public long getSecurityVulnerabilityArchiveExportsDownload(final long id, final OutputStream out)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4SecurityVulnerabilityArchiveExportsIdDownload");
        requireNonNull(out, "out");
        return caller.download(get(GET_SECURITY_VULNERABILITY_ARCHIVE_EXP_2, id), out);
    }

    /**
     * Get security vulnerability archive exports download ({@code GET
     * /security/vulnerability_archive_exports/{id}/download}).
     *
     * @param id the id
     * @return the file that was written
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Path getSecurityVulnerabilityArchiveExportsDownload(final long id, final Path target) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4SecurityVulnerabilityArchiveExportsIdDownload");
        requireNonNull(target, "target");
        return caller.download(get(GET_SECURITY_VULNERABILITY_ARCHIVE_EXP_2, id), target);
    }

    /**
     * List issue links ({@code GET /vulnerabilities/{id}/issue_links}).
     *
     * @param id the id
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabVulnerabilityRelatedIssue> listIssueLinks(final long id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4VulnerabilitiesIdIssueLinks");
        return caller.fetch(get(LIST_ISSUE_LINKS, id), VULNERABILITY_RELATED_ISSUE_LIST_TYPE);
    }

    /**
     * Create issue link ({@code POST /vulnerabilities/{id}/issue_links}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerabilityIssueLink createIssueLink(
            final long id, final GitLabProjectVulnerabilitiesCreateIssueLinkPayload payload) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4VulnerabilitiesIdIssueLinks");
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(LIST_ISSUE_LINKS, id), payload), GitLabVulnerabilityIssueLink.class);
    }

    /**
     * Delete issue link ({@code DELETE /vulnerabilities/{id}/issue_links/{issue_link_id}}).
     *
     * @param id the id
     * @param issueLinkId the issue link id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabVulnerabilityIssueLink> deleteIssueLink(final long id, final long issueLinkId)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "deleteApiV4VulnerabilitiesIdIssueLinksIssueLinkId");
        return caller.fetchOptional(delete(DELETE_ISSUE_LINK, id, issueLinkId), GitLabVulnerabilityIssueLink.class);
    }

    /**
     * Ai detection flag ({@code POST /vulnerabilities/{vulnerability_id}/flags/ai_detection}).
     *
     * @param vulnerabilityId the vulnerability id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code vulnerabilityId} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void aiDetectionFlag(
            final String vulnerabilityId, final GitLabProjectVulnerabilitiesAiDetectionFlagPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4VulnerabilitiesVulnerabilityIdFlagsAiDetection");
        requireNotBlank(vulnerabilityId, "vulnerabilityId");
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(AI_DETECTION_FLAG, vulnerabilityId), payload));
    }

    /**
     * Get ({@code GET /vulnerabilities/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public Optional<GitLabVulnerability> get(final String id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4VulnerabilitiesId");
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOrEmpty(get(GET, id), GitLabVulnerability.class);
    }

    /**
     * Resolve ({@code POST /vulnerabilities/{id}/resolve}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerability resolve(final String id, final GitLabProjectVulnerabilitiesResolvePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4VulnerabilitiesIdResolve");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(RESOLVE, id), payload), GitLabVulnerability.class);
    }

    /**
     * Dismiss ({@code POST /vulnerabilities/{id}/dismiss}).
     *
     * @param id the id
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerability dismiss(final String id) throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4VulnerabilitiesIdDismiss");
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(post(DISMISS, id), GitLabVulnerability.class);
    }

    /**
     * Confirm ({@code POST /vulnerabilities/{id}/confirm}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerability confirm(final String id, final GitLabProjectVulnerabilitiesConfirmPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4VulnerabilitiesIdConfirm");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CONFIRM, id), payload), GitLabVulnerability.class);
    }

    /**
     * Revert ({@code POST /vulnerabilities/{id}/revert}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabVulnerability revert(final String id, final GitLabProjectVulnerabilitiesRevertPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4VulnerabilitiesIdRevert");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(REVERT, id), payload), GitLabVulnerability.class);
    }
}
