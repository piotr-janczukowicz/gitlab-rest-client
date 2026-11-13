package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstancePagesDomainsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstancePagesDomainsApi api() {
        return new GitLabInstancePagesDomainsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstancePagesDomainsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPagesDomainBasic.class, "pages-domain-basic.json") + "]"));

        final GitLabPage<GitLabPagesDomainBasic> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PagesdomainsCatalogFixtures.pagesDomainBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pages/domains");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPagesDomainBasic.class, "pages-domain-basic.json") + "]"));

        final GitLabPage<GitLabPagesDomainBasic> page = api().list(GitLabInstancePagesDomainsListFilterBuilder.builder()
                .domain("domain")
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PagesdomainsCatalogFixtures.pagesDomainBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pages/domains");
            softly.assertThat(request.uri()).hasParameter("domain", "domain");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPagesDomainBasic.class, "pages-domain-basic.json") + "]"));

        final GitLabPage<GitLabPagesDomainBasic> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PagesdomainsCatalogFixtures.pagesDomainBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pages/domains");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPagesDomainBasic.class, "pages-domain-basic.json") + "]"));

        final GitLabPage<GitLabPagesDomainBasic> page = api().list(
                        GitLabInstancePagesDomainsListFilterBuilder.builder()
                                .domain("domain")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(PagesdomainsCatalogFixtures.pagesDomainBasic());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/pages/domains");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("domain", "domain");
        });
    }
}
