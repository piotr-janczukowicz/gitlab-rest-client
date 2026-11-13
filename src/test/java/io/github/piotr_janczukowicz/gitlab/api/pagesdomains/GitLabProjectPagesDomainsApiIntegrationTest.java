package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabProjectPagesDomainsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pages/domains",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabPagesDomain.class, "pages-domain.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/pages/domains?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPagesDomain.class, "pages-domain.json") + "]"));

        final List<GitLabPagesDomain> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(PagesdomainsCatalogFixtures.pagesDomain(), PagesdomainsCatalogFixtures.pagesDomain());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/pages/domains",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabPagesDomain.class, "pages-domain.json")));

        final GitLabPagesDomain result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client))
                    .create("group/sub/project", PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload());
        }

        assertThat(result).isEqualTo(PagesdomainsCatalogFixtures.pagesDomain());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPagesDomainsApi api = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabPagesDomain.class, "pages-domain.json")));

        final Optional<GitLabPagesDomain> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client)).get("group/sub/project", "domain");
        }

        assertThat(result).contains(PagesdomainsCatalogFixtures.pagesDomain());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "domain")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain");
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPagesDomainsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "domain",
                            PagesdomainsCatalogFixtures.projectPagesDomainsUpdatePayload());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPagesDomainsApi api = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", "domain", PagesdomainsCatalogFixtures.projectPagesDomainsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectPagesDomainsApi(GitLabCaller.of(client)).delete("group/sub/project", "domain");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPagesDomainsApi api = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "domain"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain");
    }

    @Test
    void verify_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain/verify",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabPagesDomain.class, "pages-domain.json")));

        final GitLabPagesDomain result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client)).verify("group/sub/project", "domain");
        }

        assertThat(result).isEqualTo(PagesdomainsCatalogFixtures.pagesDomain());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain/verify");
    }

    @Test
    void verify_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain/verify",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectPagesDomainsApi api = new GitLabProjectPagesDomainsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.verify("group/sub/project", "domain"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/pages/domains/domain/verify");
    }
}
