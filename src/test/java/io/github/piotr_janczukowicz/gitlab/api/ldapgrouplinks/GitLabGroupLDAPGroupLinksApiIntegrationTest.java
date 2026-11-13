package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLdapGroupLink;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabGroupLDAPGroupLinksApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabLdapGroupLink.class, "ldap-group-link.json") + "]"));

        final List<GitLabLdapGroupLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client)).list("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.ldapGroupLink());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabLdapGroupLink.class, "ldap-group-link.json")));

        final GitLabLdapGroupLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client))
                    .create("group/sub/project", LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.ldapGroupLink());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupLDAPGroupLinksApi api = new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", LdapgrouplinksCatalogFixtures.groupLDAPGroupLinksCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client)).delete("group/sub/project", "provider");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupLDAPGroupLinksApi api = new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "provider"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links");
    }

    @Test
    void deleteByCn_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/cn", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client)).deleteByCn("group/sub/project", "cn");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/cn");
    }

    @Test
    void deleteByCn_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/cn", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupLDAPGroupLinksApi api = new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteByCn("group/sub/project", "cn"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/cn");
    }

    @Test
    void deleteByProviderAndCn_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/provider/cn",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client))
                    .deleteByProviderAndCn("group/sub/project", "provider", "cn");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/provider/cn");
    }

    @Test
    void deleteByProviderAndCn_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/provider/cn",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupLDAPGroupLinksApi api = new GitLabGroupLDAPGroupLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteByProviderAndCn("group/sub/project", "provider", "cn"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/ldap_group_links/provider/cn");
    }
}
