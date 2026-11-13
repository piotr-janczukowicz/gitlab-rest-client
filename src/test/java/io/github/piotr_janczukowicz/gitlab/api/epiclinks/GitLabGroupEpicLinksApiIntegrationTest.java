package io.github.piotr_janczukowicz.gitlab.api.epiclinks;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpic;
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
class GitLabGroupEpicLinksApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final List<GitLabEpic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicLinksApi(GitLabCaller.of(client)).list("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final GitLabEpic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicLinksApi(GitLabCaller.of(client))
                    .create("group/sub/project", 1L, EpiclinksCatalogFixtures.groupEpicLinksCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicLinksApi api = new GitLabGroupEpicLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", 1L, EpiclinksCatalogFixtures.groupEpicLinksCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics");
    }

    @Test
    void createByChildEpicId_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final GitLabEpic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicLinksApi(GitLabCaller.of(client))
                    .createByChildEpicId("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1");
    }

    @Test
    void createByChildEpicId_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicLinksApi api = new GitLabGroupEpicLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createByChildEpicId("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final GitLabEpic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicLinksApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, 1L, EpiclinksCatalogFixtures.groupEpicLinksUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicLinksApi api = new GitLabGroupEpicLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.update("group/sub/project", 1L, 1L, EpiclinksCatalogFixtures.groupEpicLinksUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabEpic.class, "epic.json")));

        final Optional<GitLabEpic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicLinksApi(GitLabCaller.of(client)).delete("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.epic());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupEpicLinksApi api = new GitLabGroupEpicLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabEpic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupEpicLinksApi(GitLabCaller.of(client)).delete("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/epics/1");
    }
}
