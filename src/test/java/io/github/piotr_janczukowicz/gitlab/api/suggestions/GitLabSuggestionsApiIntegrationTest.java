package io.github.piotr_janczukowicz.gitlab.api.suggestions;

import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSuggestion;
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
class GitLabSuggestionsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void apply_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/suggestions/1/apply",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSuggestion.class, "suggestion.json")));

        final GitLabSuggestion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSuggestionsApi(GitLabCaller.of(client))
                    .apply(1L, SuggestionsCatalogFixtures.suggestionsApplyPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.suggestion());
        HTTP.verifyRequested(PUT, "/api/v4/suggestions/1/apply");
    }

    @Test
    void apply_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/suggestions/1/apply", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSuggestionsApi api = new GitLabSuggestionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.apply(1L, SuggestionsCatalogFixtures.suggestionsApplyPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/suggestions/1/apply");
    }

    @Test
    void batchApply_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/suggestions/batch_apply",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSuggestion.class, "suggestion.json")));

        final GitLabSuggestion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSuggestionsApi(GitLabCaller.of(client))
                    .batchApply(SuggestionsCatalogFixtures.suggestionsBatchApplyPayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.suggestion());
        HTTP.verifyRequested(PUT, "/api/v4/suggestions/batch_apply");
    }

    @Test
    void batchApply_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/suggestions/batch_apply", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSuggestionsApi api = new GitLabSuggestionsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.batchApply(SuggestionsCatalogFixtures.suggestionsBatchApplyPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/suggestions/batch_apply");
    }
}
