package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicGroupDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
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
class GitLabProjectProjectCICDJobTokenScopeApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectJobTokenScope.class, "project-job-token-scope.json")));

        final GitLabProjectJobTokenScope result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).isEqualTo(ProjectcicdjobtokenscopeCatalogFixtures.projectJobTokenScope());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectCICDJobTokenScopeApi api =
                    new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope");
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeUpdatePayload());
        }

        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectCICDJobTokenScopeApi api =
                    new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope");
    }

    @Test
    void listAllowlist_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope/allowlist",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope/allowlist?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json") + "]"));

        final List<GitLabBasicProjectDetails> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client))
                    .listAllowlist("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.basicProjectDetails(), CommonCatalogFixtures.basicProjectDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope/allowlist", 2);
    }

    @Test
    void createAllowlist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/1/job_token_scope/allowlist",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProjectScopeLink.class, "project-scope-link.json")));

        final GitLabProjectScopeLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client))
                    .createAllowlist(
                            1L,
                            ProjectcicdjobtokenscopeCatalogFixtures
                                    .projectProjectCICDJobTokenScopeCreateAllowlistPayload());
        }

        assertThat(result).isEqualTo(ProjectcicdjobtokenscopeCatalogFixtures.projectScopeLink());
        HTTP.verifyRequested(POST, "/api/v4/projects/1/job_token_scope/allowlist");
    }

    @Test
    void createAllowlist_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/1/job_token_scope/allowlist", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectCICDJobTokenScopeApi api =
                    new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAllowlist(
                    1L,
                    ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeCreateAllowlistPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/1/job_token_scope/allowlist");
    }

    @Test
    void listGroupsAllowlist_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope/groups_allowlist",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabBasicGroupDetails.class, "basic-group-details.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope/groups_allowlist?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabBasicGroupDetails.class, "basic-group-details.json") + "]"));

        final List<GitLabBasicGroupDetails> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client))
                    .listGroupsAllowlist("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.basicGroupDetails(), CommonCatalogFixtures.basicGroupDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/job_token_scope/groups_allowlist", 2);
    }

    @Test
    void createGroupsAllowlist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/1/job_token_scope/groups_allowlist",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupScopeLink.class, "group-scope-link.json")));

        final GitLabGroupScopeLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client))
                    .createGroupsAllowlist(
                            1L,
                            ProjectcicdjobtokenscopeCatalogFixtures
                                    .projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload());
        }

        assertThat(result).isEqualTo(ProjectcicdjobtokenscopeCatalogFixtures.groupScopeLink());
        HTTP.verifyRequested(POST, "/api/v4/projects/1/job_token_scope/groups_allowlist");
    }

    @Test
    void createGroupsAllowlist_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/1/job_token_scope/groups_allowlist", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectCICDJobTokenScopeApi api =
                    new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createGroupsAllowlist(
                    1L,
                    ProjectcicdjobtokenscopeCatalogFixtures
                            .projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/1/job_token_scope/groups_allowlist");
    }

    @Test
    void deleteGroupsAllowlist_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/1/job_token_scope/groups_allowlist/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client)).deleteGroupsAllowlist(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/1/job_token_scope/groups_allowlist/1");
    }

    @Test
    void deleteGroupsAllowlist_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/1/job_token_scope/groups_allowlist/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectCICDJobTokenScopeApi api =
                    new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteGroupsAllowlist(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/1/job_token_scope/groups_allowlist/1");
    }

    @Test
    void deleteAllowlist_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/1/job_token_scope/allowlist/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client)).deleteAllowlist(1L, 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/1/job_token_scope/allowlist/1");
    }

    @Test
    void deleteAllowlist_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/1/job_token_scope/allowlist/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectCICDJobTokenScopeApi api =
                    new GitLabProjectProjectCICDJobTokenScopeApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteAllowlist(1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/1/job_token_scope/allowlist/1");
    }
}
