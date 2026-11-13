package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

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
class GitLabInstancePagesDomainsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/pages/domains",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabPagesDomainBasic.class, "pages-domain-basic.json") + "]")
                        .header("Link", "<" + base + "/api/v4/pages/domains?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabPagesDomainBasic.class, "pages-domain-basic.json") + "]"));

        final List<GitLabPagesDomainBasic> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstancePagesDomainsApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        PagesdomainsCatalogFixtures.pagesDomainBasic(), PagesdomainsCatalogFixtures.pagesDomainBasic());
        HTTP.verifyRequested(GET, "/api/v4/pages/domains", 2);
    }
}
