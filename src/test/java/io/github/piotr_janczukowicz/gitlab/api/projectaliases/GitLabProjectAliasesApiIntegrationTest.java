package io.github.piotr_janczukowicz.gitlab.api.projectaliases;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabProjectAliasesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/project_aliases",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabProjectAlias.class, "project-alias.json") + "]")
                        .header("Link", "<" + base + "/api/v4/project_aliases?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectAlias.class, "project-alias.json") + "]"));

        final List<GitLabProjectAlias> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectAliasesApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items)
                .containsExactly(
                        ProjectaliasesCatalogFixtures.projectAlias(), ProjectaliasesCatalogFixtures.projectAlias());
        HTTP.verifyRequested(GET, "/api/v4/project_aliases", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/project_aliases",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectAlias.class, "project-alias.json")));

        final GitLabProjectAlias result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAliasesApi(GitLabCaller.of(client))
                    .create(ProjectaliasesCatalogFixtures.projectAliasesCreatePayload());
        }

        assertThat(result).isEqualTo(ProjectaliasesCatalogFixtures.projectAlias());
        HTTP.verifyRequested(POST, "/api/v4/project_aliases");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/project_aliases", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAliasesApi api = new GitLabProjectAliasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(ProjectaliasesCatalogFixtures.projectAliasesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/project_aliases");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/project_aliases/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectAlias.class, "project-alias.json")));

        final Optional<GitLabProjectAlias> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAliasesApi(GitLabCaller.of(client)).get("name");
        }

        assertThat(result).contains(ProjectaliasesCatalogFixtures.projectAlias());
        HTTP.verifyRequested(GET, "/api/v4/project_aliases/name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/project_aliases/name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectAliasesApi(GitLabCaller.of(client))
                    .get("name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/project_aliases/name");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/project_aliases/name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAliasesApi(GitLabCaller.of(client)).delete("name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/project_aliases/name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/project_aliases/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAliasesApi api = new GitLabProjectAliasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/project_aliases/name");
    }
}
