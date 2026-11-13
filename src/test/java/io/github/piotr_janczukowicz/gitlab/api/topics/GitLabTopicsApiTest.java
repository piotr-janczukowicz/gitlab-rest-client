package io.github.piotr_janczukowicz.gitlab.api.topics;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTopicsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabTopicsApi api() {
        return new GitLabTopicsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabTopicsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabProjectTopic.class, "project-topic.json") + "]"));

        final GitLabPage<GitLabProjectTopic> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/topics");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabProjectTopic.class, "project-topic.json") + "]"));

        final GitLabPage<GitLabProjectTopic> page = api().list(GitLabTopicsListFilterBuilder.builder()
                .search("search")
                .withoutProjects(true)
                .organizationId(1L)
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/topics");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabProjectTopic.class, "project-topic.json") + "]"));

        final GitLabPage<GitLabProjectTopic> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/topics");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabProjectTopic.class, "project-topic.json") + "]"));

        final GitLabPage<GitLabProjectTopic> page = api().list(
                        GitLabTopicsListFilterBuilder.builder()
                                .search("search")
                                .withoutProjects(true)
                                .organizationId(1L)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/topics");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final GitLabProjectTopic result =
                api().create(MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/topics");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create(MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final Optional<GitLabProjectTopic> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/topics/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabProjectTopic> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final GitLabProjectTopic result = api().update(
                        1L, MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/topics/1");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        1L, MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/topics/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void merge_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabProjectTopic.class, "project-topic.json")));

        final GitLabProjectTopic result = api().merge(TopicsCatalogFixtures.topicsMergePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(TopicsCatalogFixtures.projectTopic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/topics/merge");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"source_topic_id\":");
        });
    }

    @Test
    void merge_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().merge(TopicsCatalogFixtures.topicsMergePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
