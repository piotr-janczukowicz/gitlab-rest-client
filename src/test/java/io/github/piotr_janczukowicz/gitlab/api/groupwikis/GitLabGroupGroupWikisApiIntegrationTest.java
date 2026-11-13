package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabWikiAttachment;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabWikiPage;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabWikiPageBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabGroupGroupWikisApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/wikis",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabWikiPageBasic.class, "wiki-page-basic.json") + "]"));

        final List<GitLabWikiPageBasic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupWikisApi(GitLabCaller.of(client)).list("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.wikiPageBasic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/wikis");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/wikis",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabWikiPage.class, "wiki-page.json")));

        final GitLabWikiPage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupWikisApi(GitLabCaller.of(client))
                    .create("group/sub/project", GroupwikisCatalogFixtures.groupGroupWikisCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.wikiPage());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/wikis");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/wikis", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupWikisApi api = new GitLabGroupGroupWikisApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", GroupwikisCatalogFixtures.groupGroupWikisCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/wikis");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabWikiPage.class, "wiki-page.json")));

        final Optional<GitLabWikiPage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupWikisApi(GitLabCaller.of(client)).get("group/sub/project", "slug");
        }

        assertThat(result).contains(CommonCatalogFixtures.wikiPage());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupWikisApi(GitLabCaller.of(client))
                    .get("group/sub/project", "slug")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabWikiPage.class, "wiki-page.json")));

        final GitLabWikiPage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupWikisApi(GitLabCaller.of(client))
                    .update("group/sub/project", "slug", GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.wikiPage());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupWikisApi api = new GitLabGroupGroupWikisApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.update("group/sub/project", "slug", GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupWikisApi(GitLabCaller.of(client)).delete("group/sub/project", "slug");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupWikisApi api = new GitLabGroupGroupWikisApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "slug"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/wikis/slug");
    }

    @Test
    void createAttachment_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/wikis/attachments",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabWikiAttachment.class, "wiki-attachment.json")));

        final GitLabWikiAttachment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupWikisApi(GitLabCaller.of(client))
                    .createAttachment(
                            "group/sub/project",
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.wikiAttachment());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/wikis/attachments");
    }

    @Test
    void createAttachment_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/wikis/attachments", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupWikisApi api = new GitLabGroupGroupWikisApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createAttachment(
                    "group/sub/project",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/wikis/attachments");
    }
}
