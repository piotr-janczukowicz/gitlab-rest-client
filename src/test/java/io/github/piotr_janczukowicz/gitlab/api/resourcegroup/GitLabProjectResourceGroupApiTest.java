package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJobBasic;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectResourceGroupApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectResourceGroupApi api() {
        return new GitLabProjectResourceGroupApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectResourceGroupApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json") + "]"));

        final GitLabPage<GitLabCiResourceGroup> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcegroupCatalogFixtures.ciResourceGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/resource_groups");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json") + "]"));

        final GitLabPage<GitLabCiResourceGroup> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ResourcegroupCatalogFixtures.ciResourceGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/resource_groups");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json")));

        final Optional<GitLabCiResourceGroup> result = api().get("group/sub/project", "key");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ResourcegroupCatalogFixtures.ciResourceGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/resource_groups/key");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiResourceGroup> result = api().get("group/sub/project", "key");

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiResourceGroup.class, "ci-resource-group.json")));

        final GitLabCiResourceGroup result = api().update(
                        "group/sub/project", "key", ResourcegroupCatalogFixtures.projectResourceGroupUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ResourcegroupCatalogFixtures.ciResourceGroup());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/resource_groups/key");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"process_mode\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project", "key", ResourcegroupCatalogFixtures.projectResourceGroupUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getCurrentJob_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiJobBasic.class, "ci-job-basic.json")));

        final Optional<GitLabCiJobBasic> result = api().getCurrentJob("group/sub/project", "key");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.ciJobBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/current_job");
        });
    }

    @Test
    void getCurrentJob_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiJobBasic> result = api().getCurrentJob("group/sub/project", "key");

        assertThat(result).isEmpty();
    }

    @Test
    void listUpcomingJobs_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabCiJobBasic.class, "ci-job-basic.json") + "]"));

        final GitLabPage<GitLabCiJobBasic> page = api().listUpcomingJobs("group/sub/project", "key");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciJobBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/upcoming_jobs");
        });
    }

    @Test
    void listUpcomingJobs_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabCiJobBasic.class, "ci-job-basic.json") + "]"));

        final GitLabPage<GitLabCiJobBasic> page =
                api().listUpcomingJobs("group/sub/project", "key", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciJobBasic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/resource_groups/key/upcoming_jobs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }
}
