package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLdapGroupLink;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupLDAPGroupLinksApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupLDAPGroupLinksApi api() {
        return new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupLDAPGroupLinksApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabLdapGroupLink.class, "ldap-group-link.json") + "]"));

        final List<GitLabLdapGroupLink> result = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.ldapGroupLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.create("group/sub/project", LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.create("group/sub/project", LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabLdapGroupLink.class, "ldap-group-link.json")));

        final GitLabLdapGroupLink result =
                api().create("group/sub/project", LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.ldapGroupLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"cn\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create("group/sub/project", LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", "provider"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", "provider"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", "provider");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
            softly.assertThat(request.uri()).hasParameter("provider", "provider");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", "provider"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(
                        "group/sub/project",
                        "provider",
                        GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder()
                                .cn("cn")
                                .filter("filter")
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("cn", "cn");
    }

    @Test
    void deleteByCn_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteByCn("group/sub/project", "cn"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteByCn_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteByCn("group/sub/project", "cn"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteByCn_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteByCn("group/sub/project", "cn");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/cn");
    }

    @Test
    void deleteByCn_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteByCn("group/sub/project", "cn"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteByProviderAndCn_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.deleteByProviderAndCn("group/sub/project", "provider", "cn"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteByProviderAndCn_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupLDAPGroupLinksApi lowTier =
                new GitLabGroupLDAPGroupLinksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.deleteByProviderAndCn("group/sub/project", "provider", "cn"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteByProviderAndCn_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteByProviderAndCn("group/sub/project", "provider", "cn");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/provider/cn");
    }

    @Test
    void deleteByProviderAndCn_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteByProviderAndCn("group/sub/project", "provider", "cn"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
