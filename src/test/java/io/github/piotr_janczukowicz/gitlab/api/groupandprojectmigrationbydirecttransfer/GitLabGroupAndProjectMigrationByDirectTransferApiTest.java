package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBulkImport;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
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
class GitLabGroupAndProjectMigrationByDirectTransferApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupAndProjectMigrationByDirectTransferApi api() {
        return new GitLabGroupAndProjectMigrationByDirectTransferApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupAndProjectMigrationByDirectTransferApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabBulkImport.class, "bulk-import.json") + "]"));

        final GitLabPage<GitLabBulkImport> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabBulkImport.class, "bulk-import.json") + "]"));

        final GitLabPage<GitLabBulkImport> page = api().list(
                        GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                                .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                                .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports");
            softly.assertThat(request.uri()).hasParameter("sort", "asc");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabBulkImport.class, "bulk-import.json") + "]"));

        final GitLabPage<GitLabBulkImport> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabBulkImport.class, "bulk-import.json") + "]"));

        final GitLabPage<GitLabBulkImport> page = api().list(
                        GitLabGroupAndProjectMigrationByDirectTransferListFilterBuilder.builder()
                                .sort(GitLabGroupAndProjectMigrationByDirectTransferListSort.ASC)
                                .status(GitLabGroupAndProjectMigrationByDirectTransferListStatus.CREATED)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("sort", "asc");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final GitLabBulkImport result = api().create(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures
                                .groupAndProjectMigrationByDirectTransferCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/bulk_imports");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"configuration\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures
                                .groupAndProjectMigrationByDirectTransferCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listEntities_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntities();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/entities");
        });
    }

    @Test
    void listEntities_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntities(
                        GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                                .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                                .status(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.CREATED)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/entities");
            softly.assertThat(request.uri()).hasParameter("sort", "asc");
        });
    }

    @Test
    void listEntities_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntities(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/entities");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listEntities_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntities(
                        GitLabGroupAndProjectMigrationByDirectTransferListEntitiesFilterBuilder.builder()
                                .sort(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesSort.ASC)
                                .status(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.CREATED)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/entities");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("sort", "asc");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final Optional<GitLabBulkImport> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabBulkImport> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listEntitiesByImportId_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntitiesByImportId(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/1/entities");
        });
    }

    @Test
    void listEntitiesByImportId_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntitiesByImportId(
                        1L,
                        GitLabBulkImportEntityListFilterBuilder.builder()
                                .status(GitLabBulkImportEntityListStatus.CREATED)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/1/entities");
            softly.assertThat(request.uri()).hasParameter("status", "created");
        });
    }

    @Test
    void listEntitiesByImportId_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntitiesByImportId(1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/1/entities");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listEntitiesByImportId_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json") + "]"));

        final GitLabPage<GitLabBulkImportsEntity> page = api().listEntitiesByImportId(
                        1L,
                        GitLabBulkImportEntityListFilterBuilder.builder()
                                .status(GitLabBulkImportEntityListStatus.CREATED)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items())
                    .containsExactly(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/1/entities");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("status", "created");
        });
    }

    @Test
    void getEntity_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabBulkImportsEntity.class, "bulk-imports-entity.json")));

        final Optional<GitLabBulkImportsEntity> result = api().getEntity(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .contains(GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntity());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/bulk_imports/1/entities/1");
        });
    }

    @Test
    void getEntity_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabBulkImportsEntity> result = api().getEntity(1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void listEntitiesFailures_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabBulkImportsEntityFailure.class, "bulk-imports-entity-failure.json")
                                + "]"));

        final List<GitLabBulkImportsEntityFailure> result = api().listEntitiesFailures(1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(
                            GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/bulk_imports/1/entities/1/failures");
        });
    }

    @Test
    void cancel_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabBulkImport.class, "bulk-import.json")));

        final GitLabBulkImport result = api().cancel(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.bulkImport());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/bulk_imports/1/cancel");
        });
    }

    @Test
    void cancel_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().cancel(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
