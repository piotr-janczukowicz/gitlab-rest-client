package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeTrainsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectMergeTrainsApi api() {
        return new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectMergeTrainsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page = api().list(
                        "group/sub/project",
                        GitLabProjectMergeTrainsListFilterBuilder.builder()
                                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                                .sort(GitLabProjectMergeTrainsListSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains");
            softly.assertThat(request.uri()).hasParameter("scope", "active");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page = api().list(
                        "group/sub/project",
                        GitLabProjectMergeTrainsListFilterBuilder.builder()
                                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                                .sort(GitLabProjectMergeTrainsListSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "active");
        });
    }

    @Test
    void listByTargetBranch_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listByTargetBranch("group/sub/project", "target_branch"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listByTargetBranch_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listByTargetBranch("group/sub/project", "target_branch"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listByTargetBranch_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page = api().listByTargetBranch("group/sub/project", "target_branch");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains/target_branch");
        });
    }

    @Test
    void listByTargetBranch_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page = api().listByTargetBranch(
                        "group/sub/project",
                        "target_branch",
                        GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                                .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                                .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains/target_branch");
            softly.assertThat(request.uri()).hasParameter("scope", "active");
        });
    }

    @Test
    void listByTargetBranch_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page =
                api().listByTargetBranch("group/sub/project", "target_branch", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains/target_branch");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listByTargetBranch_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final GitLabPage<GitLabMergeTrainsCar> page = api().listByTargetBranch(
                        "group/sub/project",
                        "target_branch",
                        GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                                .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                                .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains/target_branch");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "active");
        });
    }

    @Test
    void getMergeRequest_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getMergeRequest("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getMergeRequest_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getMergeRequest("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getMergeRequest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json")));

        final Optional<GitLabMergeTrainsCar> result = api().getMergeRequest("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1");
        });
    }

    @Test
    void getMergeRequest_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMergeTrainsCar> result = api().getMergeRequest("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void createMergeRequest_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createMergeRequest(
                "group/sub/project", 1L, MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createMergeRequest_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeTrainsApi lowTier =
                new GitLabProjectMergeTrainsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createMergeRequest(
                "group/sub/project", 1L, MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createMergeRequest_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final List<GitLabMergeTrainsCar> result = api().createMergeRequest(
                        "group/sub/project",
                        1L,
                        MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1");
        });
    }
}
