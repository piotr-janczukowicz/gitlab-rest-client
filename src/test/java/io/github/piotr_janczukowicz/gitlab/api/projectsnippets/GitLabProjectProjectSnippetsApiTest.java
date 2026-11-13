package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserAgentDetail;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectSnippetsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectProjectSnippetsApi api() {
        return new GitLabProjectProjectSnippetsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectProjectSnippetsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json") + "]"));

        final GitLabPage<GitLabProjectSnippet> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsnippetsCatalogFixtures.projectSnippet());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json") + "]"));

        final GitLabPage<GitLabProjectSnippet> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsnippetsCatalogFixtures.projectSnippet());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final GitLabProjectSnippet result =
                api().create("group/sub/project", ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsnippetsCatalogFixtures.projectSnippet());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/snippets");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"title\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        "group/sub/project", ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final Optional<GitLabProjectSnippet> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ProjectsnippetsCatalogFixtures.projectSnippet());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectSnippet> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final GitLabProjectSnippet result = api().update(
                        "group/sub/project", 1L, ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectsnippetsCatalogFixtures.projectSnippet());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/snippets/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"content\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project", 1L, ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/snippets/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRaw_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final Optional<GitLabProjectSnippet> result = api().getRaw("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ProjectsnippetsCatalogFixtures.projectSnippet());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/raw");
        });
    }

    @Test
    void getRaw_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectSnippet> result = api().getRaw("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getFilesRaw_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectSnippet.class, "project-snippet.json")));

        final Optional<GitLabProjectSnippet> result = api().getFilesRaw("group/sub/project", 1L, "ref", "file_path");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ProjectsnippetsCatalogFixtures.projectSnippet());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/files/ref/file_path/raw");
        });
    }

    @Test
    void getFilesRaw_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectSnippet> result = api().getFilesRaw("group/sub/project", 1L, "ref", "file_path");

        assertThat(result).isEmpty();
    }

    @Test
    void getUserAgentDetail_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabUserAgentDetail.class, "user-agent-detail.json")));

        final Optional<GitLabUserAgentDetail> result = api().getUserAgentDetail("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.userAgentDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/snippets/1/user_agent_detail");
        });
    }

    @Test
    void getUserAgentDetail_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabUserAgentDetail> result = api().getUserAgentDetail("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }
}
