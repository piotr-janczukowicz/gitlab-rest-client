package io.github.piotr_janczukowicz.gitlab.api.epics;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabAwardEmoji;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpicIssue;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabRelatedEpic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTodo;
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
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupEpicsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupEpicsApi api() {
        return new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupEpicsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listRelatedEpicLinks_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listRelatedEpicLinks("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listRelatedEpicLinks_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listRelatedEpicLinks("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listRelatedEpicLinks_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabRelatedEpic.class, "related-epic.json") + "]"));

        final GitLabPage<GitLabRelatedEpic> page = api().listRelatedEpicLinks("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.relatedEpic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/related_epic_links");
        });
    }

    @Test
    void listRelatedEpicLinks_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabRelatedEpic.class, "related-epic.json") + "]"));

        final GitLabPage<GitLabRelatedEpic> page = api().listRelatedEpicLinks(
                        "group/sub/project",
                        GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.relatedEpic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/related_epic_links");
            softly.assertThat(request.uri()).hasParameter("updated_before", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void listRelatedEpicLinks_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabRelatedEpic.class, "related-epic.json") + "]"));

        final GitLabPage<GitLabRelatedEpic> page =
                api().listRelatedEpicLinks("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.relatedEpic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/related_epic_links");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listRelatedEpicLinks_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabRelatedEpic.class, "related-epic.json") + "]"));

        final GitLabPage<GitLabRelatedEpic> page = api().listRelatedEpicLinks(
                        "group/sub/project",
                        GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.relatedEpic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/related_epic_links");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("updated_before", "2026-01-01T00:00:00Z");
        });
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().list(
                        "group/sub/project",
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().list(
                        "group/sub/project",
                        GitLabGroupEpicsListFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listDashed_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listDashed("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listDashed_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listDashed("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listDashed_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().listDashed("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/epics");
        });
    }

    @Test
    void listDashed_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().listDashed(
                        "group/sub/project",
                        GitLabGroupEpicsListDashedFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListDashedOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListDashedSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListDashedState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/epics");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void listDashed_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().listDashed("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/epics");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listDashed_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpic.class, "epic.json") + "]"));

        final GitLabPage<GitLabEpic> page = api().listDashed(
                        "group/sub/project",
                        GitLabGroupEpicsListDashedFilterBuilder.builder()
                                .orderBy(GitLabGroupEpicsListDashedOrderBy.CREATED_AT)
                                .sort(GitLabGroupEpicsListDashedSort.ASC)
                                .search("search")
                                .state(GitLabGroupEpicsListDashedState.OPENED)
                                .authorId(1L)
                                .authorUsername("author_username")
                                .labels(List.of("labels"))
                                .withLabelsDetails(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .includeAncestorGroups(true)
                                .includeDescendantGroups(true)
                                .myReactionEmoji("my_reaction_emoji")
                                .confidential(true)
                                .notLabels(List.of("not[labels]"))
                                .notAuthorId(1)
                                .notAuthorUsername("not[author_username]")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/epics");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "created_at");
        });
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEpic.class, "epic.json")));

        final Optional<GitLabEpic> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabEpic> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getDashed_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getDashed("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getDashed_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getDashed("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getDashed_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEpic.class, "epic.json")));

        final Optional<GitLabEpic> result = api().getDashed("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/epics/1");
        });
    }

    @Test
    void getDashed_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabEpic> result = api().getDashed("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.create("group/sub/project", EpicsCatalogFixtures.groupEpicsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.create("group/sub/project", EpicsCatalogFixtures.groupEpicsCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEpic.class, "epic.json")));

        final GitLabEpic result = api().create("group/sub/project", EpicsCatalogFixtures.groupEpicsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/epics");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"title\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().create("group/sub/project", EpicsCatalogFixtures.groupEpicsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.update("group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void update_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(
                () -> lowTier.update("group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsUpdatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabEpic.class, "epic.json")));

        final GitLabEpic result = api().update("group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.epic());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/epics/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"title\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().update("group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/epics/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listIssues_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listIssues("group/sub/project", "epic_iid"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listIssues_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listIssues("group/sub/project", "epic_iid"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listIssues_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpicIssue.class, "epic-issue.json") + "]"));

        final GitLabPage<GitLabEpicIssue> page = api().listIssues("group/sub/project", "epic_iid");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epicIssue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/epics/epic_iid/issues");
        });
    }

    @Test
    void listIssues_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEpicIssue.class, "epic-issue.json") + "]"));

        final GitLabPage<GitLabEpicIssue> page =
                api().listIssues("group/sub/project", "epic_iid", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.epicIssue());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/-/epics/epic_iid/issues");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void todo_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.todo("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void todo_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.todo("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void todo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any())).thenReturn(response(200, FileUtils.readString(GitLabTodo.class, "todo.json")));

        final GitLabTodo result = api().todo("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.todo());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/epics/1/todo");
        });
    }

    @Test
    void todo_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().todo("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAwardEmoji("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listAwardEmoji("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listAwardEmoji_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page = api().listAwardEmoji("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji");
        });
    }

    @Test
    void listAwardEmoji_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, "[" + FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json") + "]"));

        final GitLabPage<GitLabAwardEmoji> page =
                api().listAwardEmoji("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAwardEmoji(
                "group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createAwardEmoji(
                "group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final GitLabAwardEmoji result = api().createAwardEmoji(
                        "group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createAwardEmoji(
                        "group/sub/project", 1L, EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAwardEmoji("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getAwardEmoji("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getAwardEmoji_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabAwardEmoji.class, "award-emoji.json")));

        final Optional<GitLabAwardEmoji> result = api().getAwardEmoji("group/sub/project", 1L, 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.awardEmoji());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1");
        });
    }

    @Test
    void getAwardEmoji_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabAwardEmoji> result = api().getAwardEmoji("group/sub/project", 1L, 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void deleteAwardEmoji_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteAwardEmoji("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteAwardEmoji_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupEpicsApi lowTier =
                new GitLabGroupEpicsApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteAwardEmoji("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteAwardEmoji_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteAwardEmoji("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/epics/1/award_emoji/1");
    }

    @Test
    void deleteAwardEmoji_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteAwardEmoji("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
