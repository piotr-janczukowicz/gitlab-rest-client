package io.github.piotr_janczukowicz.gitlab.api.attestations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;

/** The GitLab operations of project attestations. */
public final class GitLabProjectAttestationsApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/attestations/{subject_digest}");
    private static final PathTemplate CALL_DOWNLOAD =
            PathTemplate.of("/projects/{id}/attestations/{attestation_iid}/download");
    private static final JsonType<List<GitLabSupplyChainAttestation>> SUPPLY_CHAIN_ATTESTATION_LIST_TYPE =
            JsonTypes.listOf(GitLabSupplyChainAttestation.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectAttestationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/attestations/{subject_digest}}).
     *
     * @param id the id
     * @param subjectDigest the subject digest
     * @return the items
     * @throws IllegalArgumentException if {@code id} or {@code subjectDigest} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabSupplyChainAttestation> list(final String id, final String subjectDigest) throws IOException {
        requireNotBlank(id, "id");
        requireNotBlank(subjectDigest, "subjectDigest");
        return caller.fetch(get(LIST, id, subjectDigest), SUPPLY_CHAIN_ATTESTATION_LIST_TYPE);
    }

    /**
     * Call download ({@code GET /projects/{id}/attestations/{attestation_iid}/download}).
     *
     * @param id the id
     * @param attestationIid the attestation iid
     * @throws IllegalArgumentException if {@code id} or {@code attestationIid} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void callDownload(final String id, final String attestationIid) throws IOException {
        requireNotBlank(id, "id");
        requireNotBlank(attestationIid, "attestationIid");
        caller.send(get(CALL_DOWNLOAD, id, attestationIid));
    }
}
