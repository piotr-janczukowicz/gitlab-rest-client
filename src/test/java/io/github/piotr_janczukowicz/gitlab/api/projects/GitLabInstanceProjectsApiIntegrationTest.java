package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabInstanceProjectsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/user_id/projects",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/user_id/projects?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final List<GitLabProjectWithAccess> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceProjectsApi(GitLabCaller.of(client))
                    .list("user_id")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.projectWithAccess(), ProjectsCatalogFixtures.projectWithAccess());
        HTTP.verifyRequested(GET, "/api/v4/users/user_id/projects", 2);
    }

    @Test
    void listUsersContributedProjects_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/user_id/contributed_projects",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/users/user_id/contributed_projects?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final List<GitLabProjectWithAccess> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceProjectsApi(GitLabCaller.of(client))
                    .listUsersContributedProjects("user_id")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.projectWithAccess(), ProjectsCatalogFixtures.projectWithAccess());
        HTTP.verifyRequested(GET, "/api/v4/users/user_id/contributed_projects", 2);
    }

    @Test
    void listUsersStarredProjects_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/user_id/starred_projects",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]")
                        .header("Link", "<" + base + "/api/v4/users/user_id/starred_projects?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectWithAccess.class, "project-with-access.json") + "]"));

        final List<GitLabProjectWithAccess> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceProjectsApi(GitLabCaller.of(client))
                    .listUsersStarredProjects("user_id")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectsCatalogFixtures.projectWithAccess(), ProjectsCatalogFixtures.projectWithAccess());
        HTTP.verifyRequested(GET, "/api/v4/users/user_id/starred_projects", 2);
    }
}
