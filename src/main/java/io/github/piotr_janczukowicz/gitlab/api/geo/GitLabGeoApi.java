package io.github.piotr_janczukowicz.gitlab.api.geo;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGeoNodeStatus;
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
import java.util.List;

/** The GitLab operations of geo. */
public final class GitLabGeoApi extends GitLabResourceApi {
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate CALL_PROXY = PathTemplate.of("/geo/proxy");
    private static final PathTemplate CALL = PathTemplate.of("/geo/retrieve/{replicable_name}/{replicable_id}");
    private static final PathTemplate LIST_PIPELINE_REFS =
            PathTemplate.of("/geo/repositories/{gl_repository}/pipeline_refs");
    private static final PathTemplate CREATE_STATUS = PathTemplate.of("/geo/status");
    private static final PathTemplate CREATE_FAILURES = PathTemplate.of("/geo/failures");
    private static final PathTemplate INFO_REFS_UPLOAD_PACK =
            PathTemplate.of("/geo/proxy_git_ssh/info_refs_upload_pack");
    private static final PathTemplate UPLOAD_PACK = PathTemplate.of("/geo/proxy_git_ssh/upload_pack");
    private static final PathTemplate INFO_REFS_RECEIVE_PACK =
            PathTemplate.of("/geo/proxy_git_ssh/info_refs_receive_pack");
    private static final PathTemplate RECEIVE_PACK = PathTemplate.of("/geo/proxy_git_ssh/receive_pack");
    private static final PathTemplate GRAPHQL = PathTemplate.of("/geo/node_proxy/{id}/graphql");
    private static final JsonType<List<GitLabGeoPipelineRefs>> GEO_PIPELINE_REFS_LIST_TYPE =
            JsonTypes.listOf(GitLabGeoPipelineRefs.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGeoApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Call proxy ({@code GET /geo/proxy}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callProxy() throws IOException {
        caller.send(get(CALL_PROXY));
    }

    /**
     * Call ({@code GET /geo/retrieve/{replicable_name}/{replicable_id}}).
     *
     * @param replicableName the replicable name
     * @param replicableId the replicable id
     * @throws IllegalArgumentException if {@code replicableName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void call(final String replicableName, final long replicableId) throws IOException {
        requireNotBlank(replicableName, "replicableName");
        caller.send(get(CALL, replicableName, replicableId));
    }

    /**
     * List pipeline refs ({@code GET /geo/repositories/{gl_repository}/pipeline_refs}).
     *
     * @param glRepository the gl repository
     * @return the items
     * @throws IllegalArgumentException if {@code glRepository} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabGeoPipelineRefs> listPipelineRefs(final String glRepository) throws IOException {
        requireNotBlank(glRepository, "glRepository");
        return caller.fetch(get(LIST_PIPELINE_REFS, glRepository), GEO_PIPELINE_REFS_LIST_TYPE);
    }

    /**
     * Create status ({@code POST /geo/status}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabGeoNodeStatus createStatus(final GitLabGeoCreateStatusPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(post(CREATE_STATUS), payload), GitLabGeoNodeStatus.class);
    }

    /**
     * Create failures ({@code POST /geo/failures}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createFailures(final GitLabGeoCreateFailuresPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_FAILURES), payload));
    }

    /**
     * Info refs upload pack ({@code POST /geo/proxy_git_ssh/info_refs_upload_pack}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void infoRefsUploadPack(final GitLabGeoInfoRefsUploadPackPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(INFO_REFS_UPLOAD_PACK), payload));
    }

    /**
     * Upload pack ({@code POST /geo/proxy_git_ssh/upload_pack}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void uploadPack(final GitLabGeoUploadPackPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(UPLOAD_PACK), payload));
    }

    /**
     * Info refs receive pack ({@code POST /geo/proxy_git_ssh/info_refs_receive_pack}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void infoRefsReceivePack(final GitLabGeoInfoRefsReceivePackPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(INFO_REFS_RECEIVE_PACK), payload));
    }

    /**
     * Receive pack ({@code POST /geo/proxy_git_ssh/receive_pack}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void receivePack(final GitLabGeoReceivePackPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(RECEIVE_PACK), payload));
    }

    /**
     * Graphql ({@code POST /geo/node_proxy/{id}/graphql}).
     *
     * @param id the id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public void graphql(final long id) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4GeoNodeProxyIdGraphql");
        caller.send(post(GRAPHQL, id));
    }
}
