package io.github.piotr_janczukowicz.gitlab.api.attestations;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectAttestationsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/attestations/subject_digest",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabSupplyChainAttestation.class, "supply-chain-attestation.json")
                                + "]"));

        final List<GitLabSupplyChainAttestation> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAttestationsApi(GitLabCaller.of(client))
                    .list("group/sub/project", "subject_digest");
        }

        assertThat(result).containsExactly(AttestationsCatalogFixtures.supplyChainAttestation());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/attestations/subject_digest");
    }

    @Test
    void callDownload_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/attestations/attestation_iid/download",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAttestationsApi(GitLabCaller.of(client))
                    .callDownload("group/sub/project", "attestation_iid");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/attestations/attestation_iid/download");
    }

    @Test
    void callDownload_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/attestations/attestation_iid/download",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAttestationsApi api = new GitLabProjectAttestationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDownload("group/sub/project", "attestation_iid"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/attestations/attestation_iid/download");
    }
}
