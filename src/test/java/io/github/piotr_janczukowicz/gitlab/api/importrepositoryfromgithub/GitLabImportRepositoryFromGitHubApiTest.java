package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectEntity;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectImportEntity;
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
class GitLabImportRepositoryFromGitHubApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabImportRepositoryFromGitHubApi api() {
        return new GitLabImportRepositoryFromGitHubApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabImportRepositoryFromGitHubApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectEntity.class, "project-entity.json")));

        final GitLabProjectEntity result =
                api().create(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.projectEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/import/github");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"personal_access_token\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void cancel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectImportEntity.class, "project-import-entity.json")));

        final GitLabProjectImportEntity result =
                api().cancel(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCancelPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.projectImportEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/import/github/cancel");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"project_id\":");
        });
    }

    @Test
    void cancel_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().cancel(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCancelPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createGist_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createGist(ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/import/github/gists");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"personal_access_token\":");
        });
    }

    @Test
    void createGist_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createGist(
                        ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
