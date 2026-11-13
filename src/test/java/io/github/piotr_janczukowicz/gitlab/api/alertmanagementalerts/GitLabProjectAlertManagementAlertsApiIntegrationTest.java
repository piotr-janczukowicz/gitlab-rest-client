package io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts;

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
class GitLabProjectAlertManagementAlertsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client)).authorize("group/sub/project", 1L);
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAlertManagementAlertsApi api =
                    new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/authorize");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMetricImage.class, "metric-image.json") + "]"));

        final List<GitLabMetricImage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client)).list("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(AlertmanagementalertsCatalogFixtures.metricImage());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMetricImage.class, "metric-image.json")));

        final GitLabMetricImage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(AlertmanagementalertsCatalogFixtures.metricImage());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAlertManagementAlertsApi api =
                    new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    1L,
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMetricImage.class, "metric-image.json")));

        final GitLabMetricImage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(AlertmanagementalertsCatalogFixtures.metricImage());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAlertManagementAlertsApi api =
                    new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    1L,
                    1L,
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMetricImage.class, "metric-image.json")));

        final Optional<GitLabMetricImage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(AlertmanagementalertsCatalogFixtures.metricImage());
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAlertManagementAlertsApi api =
                    new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L, 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabMetricImage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAlertManagementAlertsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", 1L, 1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/alert_management_alerts/1/metric_images/1");
    }
}
