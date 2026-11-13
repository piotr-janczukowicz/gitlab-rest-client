package io.github.piotr_janczukowicz.gitlab.api.topics;

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
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabTopicsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/topics",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabProjectTopic.class, "project-topic.json") + "]")
                        .header("Link", "<" + base + "/api/v4/topics?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectTopic.class, "project-topic.json") + "]"));

        final List<GitLabProjectTopic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabTopicsApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(TopicsCatalogFixtures.projectTopic(), TopicsCatalogFixtures.projectTopic());
        HTTP.verifyRequested(GET, "/api/v4/topics", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/topics",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final GitLabProjectTopic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabTopicsApi(GitLabCaller.of(client))
                    .create(MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(TopicsCatalogFixtures.projectTopic());
        HTTP.verifyRequested(POST, "/api/v4/topics");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/topics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabTopicsApi api = new GitLabTopicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/topics");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/topics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final Optional<GitLabProjectTopic> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabTopicsApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(TopicsCatalogFixtures.projectTopic());
        HTTP.verifyRequested(GET, "/api/v4/topics/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/topics/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabTopicsApi(GitLabCaller.of(client)).get(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/topics/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/topics/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final GitLabProjectTopic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabTopicsApi(GitLabCaller.of(client))
                    .update(
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(TopicsCatalogFixtures.projectTopic());
        HTTP.verifyRequested(PUT, "/api/v4/topics/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/topics/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabTopicsApi api = new GitLabTopicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    1L, MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/topics/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/topics/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabTopicsApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/topics/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/topics/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabTopicsApi api = new GitLabTopicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/topics/1");
    }

    @Test
    void merge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/topics/merge",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final GitLabProjectTopic result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabTopicsApi(GitLabCaller.of(client)).merge(TopicsCatalogFixtures.topicsMergePayload());
        }

        assertThat(result).isEqualTo(TopicsCatalogFixtures.projectTopic());
        HTTP.verifyRequested(POST, "/api/v4/topics/merge");
    }

    @Test
    void merge_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/topics/merge", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabTopicsApi api = new GitLabTopicsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.merge(TopicsCatalogFixtures.topicsMergePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/topics/merge");
    }
}
