package io.github.piotr_janczukowicz.gitlab.api.ldap;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabLDAPApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ldap/groups",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabLdapGroup.class, "ldap-group.json") + "]"));

        final List<GitLabLdapGroup> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabLDAPApi(GitLabCaller.of(client)).list();
        }

        assertThat(result).containsExactly(LdapCatalogFixtures.ldapGroup());
        HTTP.verifyRequested(GET, "/api/v4/ldap/groups");
    }

    @Test
    void listByProvider_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/ldap/provider/groups",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabLdapGroup.class, "ldap-group.json") + "]"));

        final List<GitLabLdapGroup> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabLDAPApi(GitLabCaller.of(client)).listByProvider("provider");
        }

        assertThat(result).containsExactly(LdapCatalogFixtures.ldapGroup());
        HTTP.verifyRequested(GET, "/api/v4/ldap/provider/groups");
    }
}
