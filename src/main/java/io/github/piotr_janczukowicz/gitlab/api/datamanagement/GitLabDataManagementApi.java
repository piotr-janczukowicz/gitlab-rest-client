package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of data management. */
public final class GitLabDataManagementApi extends GitLabResourceApi {
    private static final String PARAM_MODELNAME = "modelName";
    private static final PathTemplate GET = PathTemplate.of("/admin/data_management/{model_name}/{record_identifier}");
    private static final PathTemplate CHECKSUM_BY_RECORD_IDENTIFIER =
            PathTemplate.of("/admin/data_management/{model_name}/{record_identifier}/checksum");
    private static final PathTemplate LIST = PathTemplate.of("/admin/data_management/{model_name}");
    private static final PathTemplate CHECKSUM = PathTemplate.of("/admin/data_management/{model_name}/checksum");
    private static final JsonType<List<GitLabAdminModel>> ADMIN_MODEL_LIST_TYPE =
            JsonTypes.listOf(GitLabAdminModel.class);
    private static final GitLabListSpec<GitLabAdminModel> ADMIN_MODEL_SPEC =
            GitLabListSpec.offset(ADMIN_MODEL_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDataManagementApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Get ({@code GET /admin/data_management/{model_name}/{record_identifier}}).
     *
     * @param modelName the model name
     * @param recordIdentifier the record identifier
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code modelName} or {@code recordIdentifier} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public Optional<GitLabAdminModel> get(final String modelName, final String recordIdentifier) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AdminDataManagementModelNameRecordIdentifier");
        requireNotBlank(modelName, PARAM_MODELNAME);
        requireNotBlank(recordIdentifier, "recordIdentifier");
        return caller.fetchOrEmpty(get(GET, modelName, recordIdentifier), GitLabAdminModel.class);
    }

    /**
     * Checksum by record identifier ({@code PUT /admin/data_management/{model_name}/{record_identifier}/checksum}).
     *
     * @param modelName the model name
     * @param recordIdentifier the record identifier
     * @return the resource
     * @throws IllegalArgumentException if {@code modelName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAdminModel checksumByRecordIdentifier(final String modelName, final int recordIdentifier)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4AdminDataManagementModelNameRecordIdentifierChecksum");
        requireNotBlank(modelName, PARAM_MODELNAME);
        return caller.fetch(put(CHECKSUM_BY_RECORD_IDENTIFIER, modelName, recordIdentifier), GitLabAdminModel.class);
    }

    /**
     * List ({@code GET /admin/data_management/{model_name}}).
     *
     * @param modelName the model name
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code modelName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAdminModel> list(final String modelName) throws IOException {
        return list(modelName, GitLabDataManagementListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /admin/data_management/{model_name}}).
     *
     * @param modelName the model name
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code modelName} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAdminModel> list(final String modelName, final GitLabPageRequest request)
            throws IOException {
        return list(modelName, GitLabDataManagementListFilter.empty(), request);
    }

    /**
     * List ({@code GET /admin/data_management/{model_name}}).
     *
     * @param modelName the model name
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code modelName} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAdminModel> list(final String modelName, final GitLabDataManagementListFilter filter)
            throws IOException {
        return list(modelName, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /admin/data_management/{model_name}}).
     *
     * @param modelName the model name
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code modelName} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabPage<GitLabAdminModel> list(
            final String modelName, final GitLabDataManagementListFilter filter, final GitLabPageRequest request)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "getApiV4AdminDataManagementModelName");
        requireNotBlank(modelName, PARAM_MODELNAME);
        requireNonNull(filter, "filter");
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, ADMIN_MODEL_SPEC, modelName);
    }

    /**
     * Checksum ({@code PUT /admin/data_management/{model_name}/checksum}).
     *
     * @param modelName the model name
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code modelName} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabAdminModel checksum(final String modelName, final GitLabDataManagementChecksumPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4AdminDataManagementModelNameChecksum");
        requireNotBlank(modelName, PARAM_MODELNAME);
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(put(CHECKSUM, modelName), payload), GitLabAdminModel.class);
    }
}
