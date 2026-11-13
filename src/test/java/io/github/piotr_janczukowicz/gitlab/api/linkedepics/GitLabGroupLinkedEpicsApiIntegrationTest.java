package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabRelatedEpic;
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
class GitLabGroupLinkedEpicsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabRelatedEpic.class, "related-epic.json") + "]"));

        final List<GitLabRelatedEpic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupLinkedEpicsApi(GitLabCaller.of(client)).list("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.relatedEpic());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabRelatedEpicLink.class, "related-epic-link.json")));

        final GitLabRelatedEpicLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupLinkedEpicsApi(GitLabCaller.of(client))
                    .create("group/sub/project", 1L, LinkedepicsCatalogFixtures.groupLinkedEpicsCreatePayload());
        }

        assertThat(result).isEqualTo(LinkedepicsCatalogFixtures.relatedEpicLink());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupLinkedEpicsApi api = new GitLabGroupLinkedEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", 1L, LinkedepicsCatalogFixtures.groupLinkedEpicsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabRelatedEpicLink.class, "related-epic-link.json")));

        final Optional<GitLabRelatedEpicLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupLinkedEpicsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(LinkedepicsCatalogFixtures.relatedEpicLink());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupLinkedEpicsApi api = new GitLabGroupLinkedEpicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabRelatedEpicLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupLinkedEpicsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/epics/1/related_epics/1");
    }
}
