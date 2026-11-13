package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
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
class GitLabBatchedBackgroundMigrationsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabBatchedBackgroundMigrationsApi api() {
        return new GitLabBatchedBackgroundMigrationsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabBatchedBackgroundMigrationsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listAdminBatchedBackgroundOperations_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")
                                + "]"));

        final List<GitLabBatchedBackgroundOperation> result = api().listAdminBatchedBackgroundOperations();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/batched_background_operations");
        });
    }

    @Test
    void getAdminBatchedBackgroundOperation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")));

        final Optional<GitLabBatchedBackgroundOperation> result = api().getAdminBatchedBackgroundOperation(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/batched_background_operations/1");
        });
    }

    @Test
    void getAdminBatchedBackgroundOperation_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabBatchedBackgroundOperation> result = api().getAdminBatchedBackgroundOperation(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getAdminBatchedBackgroundOperation_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")));

        api().getAdminBatchedBackgroundOperation(
                        1L,
                        GitLabBatchedMigrationGetFilterBuilder.builder()
                                .database(GitLabBatchedMigrationGetDatabase.MAIN)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("database", "main");
    }

    @Test
    void stopAdminBatchedBackgroundOperation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")));

        final GitLabBatchedBackgroundOperation result = api().stopAdminBatchedBackgroundOperation(
                        1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationStopPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/batched_background_operations/1/stop");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"database\":");
        });
    }

    @Test
    void stopAdminBatchedBackgroundOperation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().stopAdminBatchedBackgroundOperation(
                        1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationStopPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void restartAdminBatchedBackgroundOperation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")));

        final GitLabBatchedBackgroundOperation result = api().restartAdminBatchedBackgroundOperation(
                        1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationRestartPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/batched_background_operations/1/restart");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"database\":");
        });
    }

    @Test
    void restartAdminBatchedBackgroundOperation_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().restartAdminBatchedBackgroundOperation(
                        1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationRestartPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")));

        final Optional<GitLabBatchedBackgroundMigration> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/batched_background_migrations/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabBatchedBackgroundMigration> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")));

        api().get(
                        1L,
                        GitLabBatchedBackgroundMigrationsGetFilterBuilder.builder()
                                .database(GitLabBatchedBackgroundMigrationsGetDatabase.MAIN)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("database", "main");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")
                                + "]"));

        final List<GitLabBatchedBackgroundMigration> result = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/admin/batched_background_migrations");
        });
    }

    @Test
    void resume_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")));

        final GitLabBatchedBackgroundMigration result =
                api().resume(1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsResumePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/batched_background_migrations/1/resume");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"database\":");
        });
    }

    @Test
    void resume_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resume(
                        1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsResumePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void pause_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")));

        final GitLabBatchedBackgroundMigration result =
                api().pause(1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsPausePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/admin/batched_background_migrations/1/pause");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"database\":");
        });
    }

    @Test
    void pause_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().pause(1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsPausePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
