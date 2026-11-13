package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabRolloutsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/rollouts/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCdRollout.class, "cd-rollout.json")));

        final GitLabCdRollout result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabRolloutsApi(GitLabCaller.of(client))
                    .create(1L, RolloutsCatalogFixtures.rolloutsCreatePayload());
        }

        assertThat(result).isEqualTo(RolloutsCatalogFixtures.cdRollout());
        HTTP.verifyRequested(POST, "/api/v4/rollouts/1");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/rollouts/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabRolloutsApi api = new GitLabRolloutsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(1L, RolloutsCatalogFixtures.rolloutsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/rollouts/1");
    }
}
