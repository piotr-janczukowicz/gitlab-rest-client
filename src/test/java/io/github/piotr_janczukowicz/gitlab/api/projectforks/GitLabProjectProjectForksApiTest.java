package io.github.piotr_janczukowicz.gitlab.api.projectforks;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProject;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectForksApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectProjectForksApi api() {
        return new GitLabProjectProjectForksApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectProjectForksApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result =
                api().create("group/sub/project", ProjectforksCatalogFixtures.projectProjectForksCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/fork");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"namespace\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create("group/sub/project", ProjectforksCatalogFixtures.projectProjectForksCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/fork");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/forks");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().list(
                        "group/sub/project",
                        GitLabProjectProjectForksListFilterBuilder.builder()
                                .orderBy(GitLabProjectProjectForksListOrderBy.ID)
                                .sort(GitLabProjectProjectForksListSort.ASC)
                                .archived(true)
                                .visibility(GitLabProjectProjectForksListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabProjectProjectForksListMinAccessLevel.GUEST)
                                .idAfter(1)
                                .idBefore(1)
                                .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .repositoryStorage("repository_storage")
                                .topic(List.of("topic"))
                                .topicId(1L)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .includePendingDelete(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .wikiChecksumFailed(true)
                                .repositoryChecksumFailed(true)
                                .includeHidden(true)
                                .simple(true)
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/forks");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/forks");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabProject.class, "project.json") + "]"));

        final GitLabPage<GitLabProject> page = api().list(
                        "group/sub/project",
                        GitLabProjectProjectForksListFilterBuilder.builder()
                                .orderBy(GitLabProjectProjectForksListOrderBy.ID)
                                .sort(GitLabProjectProjectForksListSort.ASC)
                                .archived(true)
                                .visibility(GitLabProjectProjectForksListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabProjectProjectForksListMinAccessLevel.GUEST)
                                .idAfter(1)
                                .idBefore(1)
                                .lastActivityAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastActivityBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .repositoryStorage("repository_storage")
                                .topic(List.of("topic"))
                                .topicId(1L)
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .includePendingDelete(true)
                                .markedForDeletionOn(LocalDate.parse("2026-01-01"))
                                .active(true)
                                .wikiChecksumFailed(true)
                                .repositoryChecksumFailed(true)
                                .includeHidden(true)
                                .simple(true)
                                .statistics(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/forks");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void createByForkedFromId_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProject.class, "project.json")));

        final GitLabProject result = api().createByForkedFromId("group/sub/project", "forked_from_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.project());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/fork/forked_from_id");
        });
    }

    @Test
    void createByForkedFromId_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().createByForkedFromId("group/sub/project", "forked_from_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
