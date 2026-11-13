package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabCodeSuggestionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createCompletion_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/completions", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabCodeSuggestionsApi(GitLabCaller.of(client))
                    .createCompletion(CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/completions");
    }

    @Test
    void createCompletion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/completions", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSuggestionsApi api = new GitLabCodeSuggestionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.createCompletion(CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/completions");
    }

    @Test
    void directAccess_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/direct_access", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabCodeSuggestionsApi(GitLabCaller.of(client))
                    .directAccess(CodesuggestionsCatalogFixtures.codeSuggestionsDirectAccessPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/direct_access");
    }

    @Test
    void directAccess_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/direct_access", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSuggestionsApi api = new GitLabCodeSuggestionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.directAccess(CodesuggestionsCatalogFixtures.codeSuggestionsDirectAccessPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/direct_access");
    }

    @Test
    void enabled_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/enabled", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabCodeSuggestionsApi(GitLabCaller.of(client))
                    .enabled(CodesuggestionsCatalogFixtures.codeSuggestionsEnabledPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/enabled");
    }

    @Test
    void enabled_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/enabled", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSuggestionsApi api = new GitLabCodeSuggestionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.enabled(CodesuggestionsCatalogFixtures.codeSuggestionsEnabledPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/enabled");
    }

    @Test
    void createConnectionDetail_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/connection_details", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabCodeSuggestionsApi(GitLabCaller.of(client)).createConnectionDetail();
        }

        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/connection_details");
    }

    @Test
    void createConnectionDetail_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/code_suggestions/connection_details", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabCodeSuggestionsApi api = new GitLabCodeSuggestionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createConnectionDetail());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/code_suggestions/connection_details");
    }
}
