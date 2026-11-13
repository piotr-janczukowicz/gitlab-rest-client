package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImport;
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
class GitLabGroupAndProjectMigrationByDirectTransferApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/bulk_imports",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabBulkImport.class, "bulk-import.json") + "]")
                        .header("Link", "<" + base + "/api/v4/bulk_imports?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabBulkImport.class, "bulk-import.json") + "]"));

        final List<GitLabBulkImport> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.bulkImport(), CommonCatalogFixtures.bulkImport());
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/bulk_imports",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final GitLabBulkImport result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client))
                    .create(
                            GroupandprojectmigrationbydirecttransferCatalogFixtures
                                    .groupAndProjectMigrationByDirectTransferCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.bulkImport());
        HTTP.verifyRequested(POST, "/api/v4/bulk_imports");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/bulk_imports", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupAndProjectMigrationByDirectTransferApi api =
                    new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    GroupandprojectmigrationbydirecttransferCatalogFixtures
                            .groupAndProjectMigrationByDirectTransferCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/bulk_imports");
    }

    @Test
    void listEntities_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/bulk_imports/entities",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]")
                        .header("Link", "<" + base + "/api/v4/bulk_imports/entities?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final List<GitLabBulkImportsEntity> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client))
                    .listEntities()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity(),
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports/entities", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/bulk_imports/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final Optional<GitLabBulkImport> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.bulkImport());
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/bulk_imports/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports/1");
    }

    @Test
    void listEntitiesByImportId_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/bulk_imports/1/entities",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]")
                        .header("Link", "<" + base + "/api/v4/bulk_imports/1/entities?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final List<GitLabBulkImportsEntity> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client))
                    .listEntitiesByImportId(1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity(),
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports/1/entities", 2);
    }

    @Test
    void getEntity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/bulk_imports/1/entities/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json")));

        final Optional<GitLabBulkImportsEntity> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client)).getEntity(1L, 1L);
        }

        assertThat(result).contains(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports/1/entities/1");
    }

    @Test
    void getEntity_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/bulk_imports/1/entities/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client))
                    .getEntity(1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports/1/entities/1");
    }

    @Test
    void listEntitiesFailures_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/bulk_imports/1/entities/1/failures",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabBulkImportsEntityFailure.class, "bulk-imports-entity-failure.json")
                        + "]"));

        final List<GitLabBulkImportsEntityFailure> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client))
                    .listEntitiesFailures(1L, 1L);
        }

        assertThat(result)
                .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure());
        HTTP.verifyRequested(GET, "/api/v4/bulk_imports/1/entities/1/failures");
    }

    @Test
    void cancel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/bulk_imports/1/cancel",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final GitLabBulkImport result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client)).cancel(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.bulkImport());
        HTTP.verifyRequested(POST, "/api/v4/bulk_imports/1/cancel");
    }

    @Test
    void cancel_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/bulk_imports/1/cancel", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupAndProjectMigrationByDirectTransferApi api =
                    new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.cancel(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/bulk_imports/1/cancel");
    }
}
