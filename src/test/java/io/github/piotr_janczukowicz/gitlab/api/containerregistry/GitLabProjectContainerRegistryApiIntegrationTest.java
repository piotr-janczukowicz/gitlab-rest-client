package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabContainerRegistryRepository;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabContainerRegistryTag;
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
class GitLabProjectContainerRegistryApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabContainerRegistryRepository.class, "container-registry-repository.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabContainerRegistryRepository.class, "container-registry-repository.json")
                        + "]"));

        final List<GitLabContainerRegistryRepository> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectContainerRegistryApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.containerRegistryRepository(),
                        CommonCatalogFixtures.containerRegistryRepository());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories", 2);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectContainerRegistryApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectContainerRegistryApi api =
                    new GitLabProjectContainerRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1");
    }

    @Test
    void listTags_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabContainerRegistryTag.class, "container-registry-tag.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabContainerRegistryTag.class, "container-registry-tag.json") + "]"));

        final List<GitLabContainerRegistryTag> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectContainerRegistryApi(GitLabCaller.of(client))
                    .listTags("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.containerRegistryTag(), CommonCatalogFixtures.containerRegistryTag());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags", 2);
    }

    @Test
    void deleteTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectContainerRegistryApi(GitLabCaller.of(client)).deleteTag("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags");
    }

    @Test
    void deleteTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectContainerRegistryApi api =
                    new GitLabProjectContainerRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteTag("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags");
    }

    @Test
    void getTag_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabContainerRegistryTagDetails.class, "container-registry-tag-details.json")));

        final Optional<GitLabContainerRegistryTagDetails> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectContainerRegistryApi(GitLabCaller.of(client))
                    .getTag("group/sub/project", 1L, "tag_name");
        }

        assertThat(result).contains(ContainerregistryCatalogFixtures.containerRegistryTagDetails());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name");
    }

    @Test
    void getTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectContainerRegistryApi(GitLabCaller.of(client))
                    .getTag("group/sub/project", 1L, "tag_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name");
    }

    @Test
    void deleteTagByTagName_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectContainerRegistryApi(GitLabCaller.of(client))
                    .deleteTagByTagName("group/sub/project", 1L, "tag_name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name");
    }

    @Test
    void deleteTagByTagName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectContainerRegistryApi api =
                    new GitLabProjectContainerRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteTagByTagName("group/sub/project", 1L, "tag_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/repositories/1/tags/tag_name");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/registry/repositories/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabContainerRegistryRepository.class, "container-registry-repository.json")));

        final Optional<GitLabContainerRegistryRepository> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectContainerRegistryApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).contains(CommonCatalogFixtures.containerRegistryRepository());
        HTTP.verifyRequested(GET, "/api/v4/registry/repositories/group%2Fsub%2Fproject");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/registry/repositories/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectContainerRegistryApi(GitLabCaller.of(client))
                    .get("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/registry/repositories/group%2Fsub%2Fproject");
    }

    @Test
    void createContainerRegistryEventEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/container_registry_event/events", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectContainerRegistryApi(GitLabCaller.of(client)).createContainerRegistryEventEvent();
        }

        HTTP.verifyRequested(POST, "/api/v4/container_registry_event/events");
    }

    @Test
    void createContainerRegistryEventEvent_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/container_registry_event/events", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectContainerRegistryApi api =
                    new GitLabProjectContainerRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createContainerRegistryEventEvent());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/container_registry_event/events");
    }
}
