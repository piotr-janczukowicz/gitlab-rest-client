package io.github.piotr_janczukowicz.gitlab.api.branches;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.HEAD;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectBranchesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabBranch.class, "branch.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/repository/branches?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabBranch.class, "branch.json") + "]"));

        final List<GitLabBranch> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectBranchesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(BranchesCatalogFixtures.branch(), BranchesCatalogFixtures.branch());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBranch.class, "branch.json")));

        final GitLabBranch result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectBranchesApi(GitLabCaller.of(client))
                    .create("group/sub/project", BranchesCatalogFixtures.projectBranchesCreatePayload());
        }

        assertThat(result).isEqualTo(BranchesCatalogFixtures.branch());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectBranchesApi api = new GitLabProjectBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", BranchesCatalogFixtures.projectBranchesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBranch.class, "branch.json")));

        final Optional<GitLabBranch> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectBranchesApi(GitLabCaller.of(client)).get("group/sub/project", "branch");
        }

        assertThat(result).contains(BranchesCatalogFixtures.branch());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectBranchesApi(GitLabCaller.of(client))
                    .get("group/sub/project", "branch")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectBranchesApi(GitLabCaller.of(client)).delete("group/sub/project", "branch");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectBranchesApi api = new GitLabProjectBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "branch"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch");
    }

    @Test
    void head_shouldReturnTrue_whenTheResourceExists() throws Exception {
        HTTP.stub(HEAD, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch", 200);

        final boolean exists;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            exists = new GitLabProjectBranchesApi(GitLabCaller.of(client)).head("group/sub/project", "branch");
        }

        assertThat(exists).isTrue();
    }

    @Test
    void protect_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/protect",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBranch.class, "branch.json")));

        final GitLabBranch result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectBranchesApi(GitLabCaller.of(client))
                    .protect("group/sub/project", "branch", BranchesCatalogFixtures.projectBranchesProtectPayload());
        }

        assertThat(result).isEqualTo(BranchesCatalogFixtures.branch());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/protect");
    }

    @Test
    void protect_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/protect",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectBranchesApi api = new GitLabProjectBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.protect(
                    "group/sub/project", "branch", BranchesCatalogFixtures.projectBranchesProtectPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/protect");
    }

    @Test
    void unprotect_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/unprotect",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBranch.class, "branch.json")));

        final GitLabBranch result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectBranchesApi(GitLabCaller.of(client)).unprotect("group/sub/project", "branch");
        }

        assertThat(result).isEqualTo(BranchesCatalogFixtures.branch());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/unprotect");
    }

    @Test
    void unprotect_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/unprotect",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectBranchesApi api = new GitLabProjectBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unprotect("group/sub/project", "branch"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/repository/branches/branch/unprotect");
    }

    @Test
    void deleteMergedBranches_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/merged_branches",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectBranchesApi(GitLabCaller.of(client)).deleteMergedBranches("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/merged_branches");
    }

    @Test
    void deleteMergedBranches_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/repository/merged_branches",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectBranchesApi api = new GitLabProjectBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteMergedBranches("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/repository/merged_branches");
    }
}
