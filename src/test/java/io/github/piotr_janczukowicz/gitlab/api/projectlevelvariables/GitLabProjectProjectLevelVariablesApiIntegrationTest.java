package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiVariable;
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
class GitLabProjectProjectLevelVariablesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/variables",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabCiVariable.class, "ci-variable.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/variables?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCiVariable.class, "ci-variable.json") + "]"));

        final List<GitLabCiVariable> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.ciVariable(), CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/variables", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/variables",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final GitLabCiVariable result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/variables");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/variables", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectLevelVariablesApi api =
                    new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/variables");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/variables/key",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final Optional<GitLabCiVariable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client)).get("group/sub/project", "key");
        }

        assertThat(result).contains(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/variables/key");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/variables/key", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client))
                    .get("group/sub/project", "key")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/variables/key");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/variables/key",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final GitLabCiVariable result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "key",
                            ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/variables/key");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/variables/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectLevelVariablesApi api =
                    new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "key",
                    ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/variables/key");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/variables/key",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabCiVariable.class, "ci-variable.json")));

        final Optional<GitLabCiVariable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "key");
        }

        assertThat(result).contains(CommonCatalogFixtures.ciVariable());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/variables/key");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/variables/key", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProjectLevelVariablesApi api =
                    new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "key"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/variables/key");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/variables/key", GitLabApiStubSupport.noContent());

        final Optional<GitLabCiVariable> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProjectLevelVariablesApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "key");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/variables/key");
    }
}
