package io.github.piotr_janczukowicz.gitlab.api.releases;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabRelease;
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
class GitLabProjectReleasesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabRelease.class, "release.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/releases?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabRelease.class, "release.json") + "]"));

        final List<GitLabRelease> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectReleasesApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.release(), CommonCatalogFixtures.release());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/releases",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRelease.class, "release.json")));

        final GitLabRelease result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleasesApi(GitLabCaller.of(client))
                    .create("group/sub/project", ReleasesCatalogFixtures.projectReleasesCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.release());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/releases");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/releases", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleasesApi api = new GitLabProjectReleasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", ReleasesCatalogFixtures.projectReleasesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/releases");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRelease.class, "release.json")));

        final Optional<GitLabRelease> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleasesApi(GitLabCaller.of(client)).get("group/sub/project", "tag_name");
        }

        assertThat(result).contains(CommonCatalogFixtures.release());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectReleasesApi(GitLabCaller.of(client))
                    .get("group/sub/project", "tag_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRelease.class, "release.json")));

        final GitLabRelease result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleasesApi(GitLabCaller.of(client))
                    .update("group/sub/project", "tag_name", ReleasesCatalogFixtures.projectReleasesUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.release());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleasesApi api = new GitLabProjectReleasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project", "tag_name", ReleasesCatalogFixtures.projectReleasesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRelease.class, "release.json")));

        final Optional<GitLabRelease> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleasesApi(GitLabCaller.of(client)).delete("group/sub/project", "tag_name");
        }

        assertThat(result).contains(CommonCatalogFixtures.release());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleasesApi api = new GitLabProjectReleasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "tag_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name", GitLabApiStubSupport.noContent());

        final Optional<GitLabRelease> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleasesApi(GitLabCaller.of(client)).delete("group/sub/project", "tag_name");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name");
    }

    @Test
    void callDownload_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/downloads/direct_asset_path",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectReleasesApi(GitLabCaller.of(client))
                    .callDownload("group/sub/project", "tag_name", "direct_asset_path");
        }

        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/downloads/direct_asset_path");
    }

    @Test
    void callDownload_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/downloads/direct_asset_path",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleasesApi api = new GitLabProjectReleasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callDownload("group/sub/project", "tag_name", "direct_asset_path"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/downloads/direct_asset_path");
    }

    @Test
    void callPermalinkLatest_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectReleasesApi(GitLabCaller.of(client)).callPermalinkLatest("group/sub/project");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest");
    }

    @Test
    void callPermalinkLatest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleasesApi api = new GitLabProjectReleasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPermalinkLatest("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest");
    }

    @Test
    void callPermalinkLatestBySuffixPath_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest/suffix_path",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectReleasesApi(GitLabCaller.of(client))
                    .callPermalinkLatestBySuffixPath("group/sub/project", "suffix_path");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest/suffix_path");
    }

    @Test
    void callPermalinkLatestBySuffixPath_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest/suffix_path",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleasesApi api = new GitLabProjectReleasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callPermalinkLatestBySuffixPath("group/sub/project", "suffix_path"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/releases/permalink/latest/suffix_path");
    }

    @Test
    void evidence_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/evidence",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabRelease.class, "release.json")));

        final GitLabRelease result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectReleasesApi(GitLabCaller.of(client)).evidence("group/sub/project", "tag_name");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.release());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/evidence");
    }

    @Test
    void evidence_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/evidence",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectReleasesApi api = new GitLabProjectReleasesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.evidence("group/sub/project", "tag_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/releases/tag_name/evidence");
    }
}
