package io.github.piotr_janczukowicz.gitlab.api.members;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMember;
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
class GitLabGroupMembersApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupMembersApi api() {
        return new GitLabGroupMembersApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupMembersApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().list(
                        "group/sub/project",
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members");
            softly.assertThat(request.uri()).hasParameter("query", "query");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().list(
                        "group/sub/project",
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("query", "query");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMember.class, "member.json")));

        final GitLabMember result =
                api().create("group/sub/project", MembersCatalogFixtures.groupMembersCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/members");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"access_level\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create("group/sub/project", MembersCatalogFixtures.groupMembersCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listAll("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members/all");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listAll(
                        "group/sub/project",
                        GitLabGroupMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabGroupMembersListAllState.AWAITING)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members/all");
            softly.assertThat(request.uri()).hasParameter("query", "query");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listAll("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members/all");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listAll_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final GitLabPage<GitLabMember> page = api().listAll(
                        "group/sub/project",
                        GitLabGroupMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabGroupMembersListAllState.AWAITING)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members/all");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("query", "query");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMember.class, "member.json")));

        final Optional<GitLabMember> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMember> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMember.class, "member.json")));

        final GitLabMember result =
                api().update("group/sub/project", 1L, MembersCatalogFixtures.groupMembersUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/members/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"access_level\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().update("group/sub/project", 1L, MembersCatalogFixtures.groupMembersUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/members/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(
                        "group/sub/project",
                        1L,
                        GitLabGroupMembersDeleteFilterBuilder.builder()
                                .skipSubresources(true)
                                .unassignIssuables(true)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("skip_subresources", "true");
    }

    @Test
    void getAll_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMember.class, "member.json")));

        final Optional<GitLabMember> result = api().getAll("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/members/all/1");
        });
    }

    @Test
    void getAll_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabMember> result = api().getAll("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void createOverride_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMember.class, "member.json")));

        final GitLabMember result = api().createOverride("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/members/1/override");
        });
    }

    @Test
    void createOverride_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createOverride("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteOverride_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabMember.class, "member.json")));

        final Optional<GitLabMember> result = api().deleteOverride("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.member());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/members/1/override");
        });
    }

    @Test
    void deleteOverride_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteOverride("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteOverride_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabMember> result = api().deleteOverride("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void approve_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().approve("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/members/1/approve");
    }

    @Test
    void approve_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().approve("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void approveAll_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().approveAll("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/members/approve_all");
    }

    @Test
    void approveAll_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().approveAll("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callPendingMembers_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callPendingMembers("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/pending_members");
    }

    @Test
    void callPendingMembers_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callPendingMembers("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void state_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().state("group/sub/project", 1L, MembersCatalogFixtures.groupMembersStatePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/members/1/state");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"state\":");
        });
    }

    @Test
    void state_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().state("group/sub/project", 1L, MembersCatalogFixtures.groupMembersStatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listBillableMembersMemberships_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBillableMembership.class, "billable-membership.json") + "]"));

        final GitLabPage<GitLabBillableMembership> page = api().listBillableMembersMemberships("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MembersCatalogFixtures.billableMembership());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members/1/memberships");
        });
    }

    @Test
    void listBillableMembersMemberships_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBillableMembership.class, "billable-membership.json") + "]"));

        final GitLabPage<GitLabBillableMembership> page =
                api().listBillableMembersMemberships("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MembersCatalogFixtures.billableMembership());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members/1/memberships");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listBillableMembersIndirect_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBillableMembership.class, "billable-membership.json") + "]"));

        final GitLabPage<GitLabBillableMembership> page = api().listBillableMembersIndirect("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MembersCatalogFixtures.billableMembership());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members/1/indirect");
        });
    }

    @Test
    void listBillableMembersIndirect_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBillableMembership.class, "billable-membership.json") + "]"));

        final GitLabPage<GitLabBillableMembership> page =
                api().listBillableMembersIndirect("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(MembersCatalogFixtures.billableMembership());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/billable_members/1/indirect");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void deleteBillableMember_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteBillableMember("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/billable_members/1");
    }

    @Test
    void deleteBillableMember_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteBillableMember("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
