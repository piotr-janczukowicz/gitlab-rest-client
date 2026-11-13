package io.github.piotr_janczukowicz.gitlab.api.suggestions;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSuggestion;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSuggestionsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabSuggestionsApi api() {
        return new GitLabSuggestionsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabSuggestionsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void apply_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSuggestion.class, "suggestion.json")));

        final GitLabSuggestion result = api().apply(1L, SuggestionsCatalogFixtures.suggestionsApplyPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.suggestion());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/suggestions/1/apply");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"commit_message\":");
        });
    }

    @Test
    void apply_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().apply(1L, SuggestionsCatalogFixtures.suggestionsApplyPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void batchApply_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSuggestion.class, "suggestion.json")));

        final GitLabSuggestion result = api().batchApply(SuggestionsCatalogFixtures.suggestionsBatchApplyPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.suggestion());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/suggestions/batch_apply");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"ids\":");
        });
    }

    @Test
    void batchApply_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().batchApply(SuggestionsCatalogFixtures.suggestionsBatchApplyPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
