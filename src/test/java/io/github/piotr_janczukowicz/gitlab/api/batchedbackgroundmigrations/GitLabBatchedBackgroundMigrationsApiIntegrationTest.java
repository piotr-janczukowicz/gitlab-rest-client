package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
class GitLabBatchedBackgroundMigrationsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listAdminBatchedBackgroundOperations_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/batched_background_operations",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")
                        + "]"));

        final List<GitLabBatchedBackgroundOperation> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .listAdminBatchedBackgroundOperations();
        }

        assertThat(result).containsExactly(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
        HTTP.verifyRequested(GET, "/api/v4/admin/batched_background_operations");
    }

    @Test
    void getAdminBatchedBackgroundOperation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/batched_background_operations/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")));

        final Optional<GitLabBatchedBackgroundOperation> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .getAdminBatchedBackgroundOperation(1L);
        }

        assertThat(result).contains(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
        HTTP.verifyRequested(GET, "/api/v4/admin/batched_background_operations/1");
    }

    @Test
    void getAdminBatchedBackgroundOperation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/batched_background_operations/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .getAdminBatchedBackgroundOperation(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/admin/batched_background_operations/1");
    }

    @Test
    void stopAdminBatchedBackgroundOperation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/batched_background_operations/1/stop",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")));

        final GitLabBatchedBackgroundOperation result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .stopAdminBatchedBackgroundOperation(
                            1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationStopPayload());
        }

        assertThat(result).isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_operations/1/stop");
    }

    @Test
    void stopAdminBatchedBackgroundOperation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/batched_background_operations/1/stop", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabBatchedBackgroundMigrationsApi api =
                    new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.stopAdminBatchedBackgroundOperation(
                    1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationStopPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_operations/1/stop");
    }

    @Test
    void restartAdminBatchedBackgroundOperation_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/batched_background_operations/1/restart",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabBatchedBackgroundOperation.class, "batched-background-operation.json")));

        final GitLabBatchedBackgroundOperation result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .restartAdminBatchedBackgroundOperation(
                            1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationRestartPayload());
        }

        assertThat(result).isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundOperation());
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_operations/1/restart");
    }

    @Test
    void restartAdminBatchedBackgroundOperation_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/batched_background_operations/1/restart", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabBatchedBackgroundMigrationsApi api =
                    new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.restartAdminBatchedBackgroundOperation(
                    1L, BatchedbackgroundmigrationsCatalogFixtures.batchedMigrationRestartPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_operations/1/restart");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/batched_background_migrations/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")));

        final Optional<GitLabBatchedBackgroundMigration> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
        HTTP.verifyRequested(GET, "/api/v4/admin/batched_background_migrations/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/batched_background_migrations/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/admin/batched_background_migrations/1");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/batched_background_migrations",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")
                        + "]"));

        final List<GitLabBatchedBackgroundMigration> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client)).list();
        }

        assertThat(result).containsExactly(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
        HTTP.verifyRequested(GET, "/api/v4/admin/batched_background_migrations");
    }

    @Test
    void resume_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/batched_background_migrations/1/resume",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")));

        final GitLabBatchedBackgroundMigration result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .resume(1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsResumePayload());
        }

        assertThat(result).isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_migrations/1/resume");
    }

    @Test
    void resume_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/batched_background_migrations/1/resume", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabBatchedBackgroundMigrationsApi api =
                    new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.resume(
                    1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsResumePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_migrations/1/resume");
    }

    @Test
    void pause_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/batched_background_migrations/1/pause",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabBatchedBackgroundMigration.class, "batched-background-migration.json")));

        final GitLabBatchedBackgroundMigration result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client))
                    .pause(1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsPausePayload());
        }

        assertThat(result).isEqualTo(BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigration());
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_migrations/1/pause");
    }

    @Test
    void pause_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/batched_background_migrations/1/pause", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabBatchedBackgroundMigrationsApi api =
                    new GitLabBatchedBackgroundMigrationsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.pause(
                    1L, BatchedbackgroundmigrationsCatalogFixtures.batchedBackgroundMigrationsPausePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/batched_background_migrations/1/pause");
    }
}
