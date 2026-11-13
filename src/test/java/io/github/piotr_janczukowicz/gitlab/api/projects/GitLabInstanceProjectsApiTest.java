package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
class GitLabInstanceProjectsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceProjectsApi api() {
        return new GitLabInstanceProjectsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceProjectsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list("user_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/user_id/projects");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list(
                        "user_id",
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/user_id/projects");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list("user_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/user_id/projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().list(
                        "user_id",
                        GitLabInstanceProjectsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListOrderBy.ID)
                                .sort(GitLabInstanceProjectsListSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListMinAccessLevel.GUEST)
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
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/users/user_id/projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void listUsersContributedProjects_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().listUsersContributedProjects("user_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/contributed_projects");
        });
    }

    @Test
    void listUsersContributedProjects_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().listUsersContributedProjects(
                        "user_id",
                        GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                                .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                                .simple(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/contributed_projects");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void listUsersContributedProjects_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page =
                api().listUsersContributedProjects("user_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/contributed_projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listUsersContributedProjects_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().listUsersContributedProjects(
                        "user_id",
                        GitLabInstanceProjectsListUsersContributedProjectsFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListUsersContributedProjectsOrderBy.ID)
                                .sort(GitLabInstanceProjectsListUsersContributedProjectsSort.ASC)
                                .simple(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/contributed_projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void listUsersStarredProjects_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().listUsersStarredProjects("user_id");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/starred_projects");
        });
    }

    @Test
    void listUsersStarredProjects_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().listUsersStarredProjects(
                        "user_id",
                        GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
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
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/starred_projects");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void listUsersStarredProjects_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page =
                api().listUsersStarredProjects("user_id", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/starred_projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listUsersStarredProjects_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final GitLabPage<GitLabProjectWithAccess> page = api().listUsersStarredProjects(
                        "user_id",
                        GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                                .orderBy(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.ID)
                                .sort(GitLabInstanceProjectsListUsersStarredProjectsSort.ASC)
                                .archived(true)
                                .visibility(GitLabInstanceProjectsListUsersStarredProjectsVisibility.PRIVATE)
                                .search("search")
                                .searchNamespaces(true)
                                .owned(true)
                                .starred(true)
                                .imported(true)
                                .membership(true)
                                .withIssuesEnabled(true)
                                .withMergeRequestsEnabled(true)
                                .withProgrammingLanguage("with_programming_language")
                                .minAccessLevel(GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel.GUEST)
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
            softly.assertThat(page.items()).containsExactly(ProjectsCatalogFixtures.projectWithAccess());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/user_id/starred_projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }
}
