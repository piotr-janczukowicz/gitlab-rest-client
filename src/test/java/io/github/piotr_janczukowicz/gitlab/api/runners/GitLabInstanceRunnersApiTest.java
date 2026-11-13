package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiResetTokenResult;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunner;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerController;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerManager;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerRegistrationDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiRunnerWithUuid;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
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
class GitLabInstanceRunnersApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceRunnersApi api() {
        return new GitLabInstanceRunnersApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceRunnersApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listRunnerControllers_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabInstanceRunnersApi lowTier =
                new GitLabInstanceRunnersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listRunnerControllers());

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listRunnerControllers_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabInstanceRunnersApi lowTier =
                new GitLabInstanceRunnersApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listRunnerControllers());

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listRunnerControllers_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json") + "]"));

        final GitLabPage<GitLabCiRunnerController> page = api().listRunnerControllers();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerController());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runner_controllers");
        });
    }

    @Test
    void listRunnerControllers_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerController.class, "ci-runner-controller.json") + "]"));

        final GitLabPage<GitLabCiRunnerController> page = api().listRunnerControllers(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerController());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runner_controllers");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().list(GitLabInstanceRunnersListFilterBuilder.builder()
                .scope(GitLabInstanceRunnersListScope.SPECIFIC)
                .type(GitLabInstanceRunnersListType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabInstanceRunnersListStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners");
            softly.assertThat(request.uri()).hasParameter("scope", "specific");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().list(
                        GitLabInstanceRunnersListFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "specific");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiRunnerRegistrationDetails.class, "ci-runner-registration-details.json")));

        final GitLabCiRunnerRegistrationDetails result =
                api().create(RunnersCatalogFixtures.instanceRunnersCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerRegistrationDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/runners");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().create(RunnersCatalogFixtures.instanceRunnersCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("token");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/runners");
            softly.assertThat(request.uri()).hasParameter("token", "token");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("token"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().listAll();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/all");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().listAll(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/all");
            softly.assertThat(request.uri()).hasParameter("scope", "specific");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().listAll(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/all");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiRunnerWithUuid.class, "ci-runner-with-uuid.json") + "]"));

        final GitLabPage<GitLabCiRunnerWithUuid> page = api().listAll(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.ciRunnerWithUuid());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/all");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "specific");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiRunnerDetails.class, "ci-runner-details.json")));

        final Optional<GitLabCiRunnerDetails> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(RunnersCatalogFixtures.ciRunnerDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabCiRunnerDetails> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiRunnerDetails.class, "ci-runner-details.json")));

        api().get(
                        1L,
                        GitLabInstanceRunnersGetFilterBuilder.builder()
                                .includeProjects(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("include_projects", "true");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiRunnerDetails.class, "ci-runner-details.json")));

        final GitLabCiRunnerDetails result = api().update(1L, RunnersCatalogFixtures.instanceRunnersUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RunnersCatalogFixtures.ciRunnerDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/runners/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"description\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().update(1L, RunnersCatalogFixtures.instanceRunnersUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabCiRunner.class, "ci-runner.json")));

        final Optional<GitLabCiRunner> result = api().deleteById(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.ciRunner());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/runners/1");
        });
    }

    @Test
    void deleteById_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteById(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteById_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabCiRunner> result = api().deleteById(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listManagers_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabCiRunnerManager.class, "ci-runner-manager.json") + "]"));

        final List<GitLabCiRunnerManager> result = api().listManagers(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.ciRunnerManager());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1/managers");
        });
    }

    @Test
    void listProjects_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json")
                                + "]"));

        final GitLabPage<GitLabBasicProjectDetails> page = api().listProjects(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.basicProjectDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1/projects");
        });
    }

    @Test
    void listProjects_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json")
                                + "]"));

        final GitLabPage<GitLabBasicProjectDetails> page = api().listProjects(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.basicProjectDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1/projects");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listJobs_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobBasicWithProject.class, "ci-job-basic-with-project.json")
                                + "]"));

        final GitLabPage<GitLabCiJobBasicWithProject> page = api().listJobs(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RunnersCatalogFixtures.ciJobBasicWithProject());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1/jobs");
        });
    }

    @Test
    void listJobs_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobBasicWithProject.class, "ci-job-basic-with-project.json")
                                + "]"));

        final GitLabPage<GitLabCiJobBasicWithProject> page = api().listJobs(
                        1L,
                        GitLabInstanceRunnersListJobsFilterBuilder.builder()
                                .systemId("system_id")
                                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                                .cursor("cursor")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RunnersCatalogFixtures.ciJobBasicWithProject());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1/jobs");
            softly.assertThat(request.uri()).hasParameter("system_id", "system_id");
        });
    }

    @Test
    void listJobs_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobBasicWithProject.class, "ci-job-basic-with-project.json")
                                + "]"));

        final GitLabPage<GitLabCiJobBasicWithProject> page = api().listJobs(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RunnersCatalogFixtures.ciJobBasicWithProject());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1/jobs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listJobs_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabCiJobBasicWithProject.class, "ci-job-basic-with-project.json")
                                + "]"));

        final GitLabPage<GitLabCiJobBasicWithProject> page = api().listJobs(
                        1L,
                        GitLabInstanceRunnersListJobsFilterBuilder.builder()
                                .systemId("system_id")
                                .status(GitLabInstanceRunnersListJobsStatus.CREATED)
                                .cursor("cursor")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(RunnersCatalogFixtures.ciJobBasicWithProject());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/1/jobs");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("system_id", "system_id");
        });
    }

    @Test
    void resetAuthenticationTokenById_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result = api().resetAuthenticationTokenById(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/runners/1/reset_authentication_token");
        });
    }

    @Test
    void resetAuthenticationTokenById_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resetAuthenticationTokenById(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void resetRegistrationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result = api().resetRegistrationToken();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/runners/reset_registration_token");
        });
    }

    @Test
    void resetRegistrationToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resetRegistrationToken());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteManager_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteManager("token", "system_id");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/runners/managers");
            softly.assertThat(request.uri()).hasParameter("token", "token");
        });
    }

    @Test
    void deleteManager_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteManager("token", "system_id"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void verify_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiRunnerRegistrationDetails.class, "ci-runner-registration-details.json")));

        final GitLabCiRunnerRegistrationDetails result =
                api().verify(RunnersCatalogFixtures.instanceRunnersVerifyPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciRunnerRegistrationDetails());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/runners/verify");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void verify_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().verify(RunnersCatalogFixtures.instanceRunnersVerifyPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void resetAuthenticationToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabCiResetTokenResult.class, "ci-reset-token-result.json")));

        final GitLabCiResetTokenResult result =
                api().resetAuthenticationToken(RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ciResetTokenResult());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/runners/reset_authentication_token");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"token\":");
        });
    }

    @Test
    void resetAuthenticationToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resetAuthenticationToken(
                        RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getRouterDiscovery_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabCiJobRouterDiscoveryInformation.class,
                                "ci-job-router-discovery-information.json")));

        final GitLabCiJobRouterDiscoveryInformation result = api().getRouterDiscovery();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(RunnersCatalogFixtures.ciJobRouterDiscoveryInformation());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/runners/router/discovery");
        });
    }

    @Test
    void getRouterDiscovery_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getRouterDiscovery());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
