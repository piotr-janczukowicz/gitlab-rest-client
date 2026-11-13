package io.github.piotr_janczukowicz.gitlab.api.geosites;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabGeoSitesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/geo_sites",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGeoSite.class, "geo-site.json") + "]")
                        .header("Link", "<" + base + "/api/v4/geo_sites?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabGeoSite.class, "geo-site.json") + "]"));

        final List<GitLabGeoSite> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGeoSitesApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(GeositesCatalogFixtures.geoSite(), GeositesCatalogFixtures.geoSite());
        HTTP.verifyRequested(GET, "/api/v4/geo_sites", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/geo_sites",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoSite.class, "geo-site.json")));

        final GitLabGeoSite result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoSitesApi(GitLabCaller.of(client))
                    .create(GeositesCatalogFixtures.geoSitesCreatePayload());
        }

        assertThat(result).isEqualTo(GeositesCatalogFixtures.geoSite());
        HTTP.verifyRequested(POST, "/api/v4/geo_sites");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo_sites", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoSitesApi api = new GitLabGeoSitesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(GeositesCatalogFixtures.geoSitesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo_sites");
    }

    @Test
    void listStatus_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/geo_sites/status",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json") + "]")
                        .header("Link", "<" + base + "/api/v4/geo_sites/status?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json") + "]"));

        final List<GitLabGeoSiteStatus> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGeoSitesApi(GitLabCaller.of(client)).listStatus().all();
        }

        assertThat(items)
                .containsExactly(GeositesCatalogFixtures.geoSiteStatus(), GeositesCatalogFixtures.geoSiteStatus());
        HTTP.verifyRequested(GET, "/api/v4/geo_sites/status", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/geo_sites/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoSite.class, "geo-site.json")));

        final Optional<GitLabGeoSite> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoSitesApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(GeositesCatalogFixtures.geoSite());
        HTTP.verifyRequested(GET, "/api/v4/geo_sites/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/geo_sites/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGeoSitesApi(GitLabCaller.of(client)).get(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/geo_sites/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/geo_sites/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoSite.class, "geo-site.json")));

        final GitLabGeoSite result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoSitesApi(GitLabCaller.of(client))
                    .update(1L, GeositesCatalogFixtures.geoSitesUpdatePayload());
        }

        assertThat(result).isEqualTo(GeositesCatalogFixtures.geoSite());
        HTTP.verifyRequested(PUT, "/api/v4/geo_sites/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/geo_sites/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoSitesApi api = new GitLabGeoSitesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(1L, GeositesCatalogFixtures.geoSitesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/geo_sites/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/geo_sites/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGeoSitesApi(GitLabCaller.of(client)).delete(1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/geo_sites/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/geo_sites/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoSitesApi api = new GitLabGeoSitesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/geo_sites/1");
    }

    @Test
    void getStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/geo_sites/1/status",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json")));

        final Optional<GitLabGeoSiteStatus> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoSitesApi(GitLabCaller.of(client)).getStatus(1L);
        }

        assertThat(result).contains(GeositesCatalogFixtures.geoSiteStatus());
        HTTP.verifyRequested(GET, "/api/v4/geo_sites/1/status");
    }

    @Test
    void getStatus_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/geo_sites/1/status", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGeoSitesApi(GitLabCaller.of(client)).getStatus(1L).isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/geo_sites/1/status");
    }

    @Test
    void repair_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/geo_sites/1/repair",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json")));

        final GitLabGeoSiteStatus result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGeoSitesApi(GitLabCaller.of(client)).repair(1L);
        }

        assertThat(result).isEqualTo(GeositesCatalogFixtures.geoSiteStatus());
        HTTP.verifyRequested(POST, "/api/v4/geo_sites/1/repair");
    }

    @Test
    void repair_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/geo_sites/1/repair", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGeoSitesApi api = new GitLabGeoSitesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.repair(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/geo_sites/1/repair");
    }
}
