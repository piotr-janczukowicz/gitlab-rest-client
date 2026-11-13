package io.github.piotr_janczukowicz.gitlab.api.protectedbranches;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProtectedBranch;
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
class GitLabProjectProtectedBranchesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_branches",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabProtectedBranch.class, "protected-branch.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/protected_branches?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProtectedBranch.class, "protected-branch.json") + "]"));

        final List<GitLabProtectedBranch> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(CommonCatalogFixtures.protectedBranch(), CommonCatalogFixtures.protectedBranch());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_branches",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProtectedBranch.class, "protected-branch.json")));

        final GitLabProtectedBranch result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.protectedBranch());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedBranchesApi api =
                    new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project", ProtectedbranchesCatalogFixtures.projectProtectedBranchesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProtectedBranch.class, "protected-branch.json")));

        final Optional<GitLabProtectedBranch> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client)).get("group/sub/project", "name");
        }

        assertThat(result).contains(CommonCatalogFixtures.protectedBranch());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client))
                    .get("group/sub/project", "name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProtectedBranch.class, "protected-branch.json")));

        final GitLabProtectedBranch result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "name",
                            ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.protectedBranch());
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedBranchesApi api =
                    new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "name",
                    ProtectedbranchesCatalogFixtures.projectProtectedBranchesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client)).delete("group/sub/project", "name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedBranchesApi api =
                    new GitLabProjectProtectedBranchesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/protected_branches/name");
    }
}
