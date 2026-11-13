package io.github.piotr_janczukowicz.gitlab.api.npmrepository;

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
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectNPMRepositoryApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getProjectPackageDistTags_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNpmPackageTag.class, "npm-package-tag.json")));

        final Optional<GitLabNpmPackageTag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getProjectPackageDistTags("group/sub/project", "package_name");
        }

        assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackageTag());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags");
    }

    @Test
    void getProjectPackageDistTags_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getProjectPackageDistTags("group/sub/project", "package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags");
    }

    @Test
    void updateProjectPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .updateProjectPackageDistTag("group/sub/project", "package_name", "tag");
        }

        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void updateProjectPackageDistTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateProjectPackageDistTag("group/sub/project", "package_name", "tag"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deleteProjectPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .deleteProjectPackageDistTag("group/sub/project", "package_name", "tag");
        }

        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deleteProjectPackageDistTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteProjectPackageDistTag("group/sub/project", "package_name", "tag"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void bulkProjectNpmV1SecurityAdvisory_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/advisories/bulk",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .bulkProjectNpmV1SecurityAdvisory("group/sub/project");
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void bulkProjectNpmV1SecurityAdvisory_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/advisories/bulk",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bulkProjectNpmV1SecurityAdvisory("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void quickProjectNpmV1SecurityAudit_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/audits/quick",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .quickProjectNpmV1SecurityAudit("group/sub/project");
        }

        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void quickProjectNpmV1SecurityAudit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/audits/quick",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.quickProjectNpmV1SecurityAudit("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void call_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name/-/file_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .call("group/sub/project", "package_name", "file_name");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name/-/file_name");
    }

    @Test
    void call_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name/-/file_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.call("group/sub/project", "package_name", "file_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name/-/file_name");
    }

    @Test
    void getProject_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNpmPackage.class, "npm-package.json")));

        final Optional<GitLabNpmPackage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getProject("group/sub/project", "package_name");
        }

        assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackage());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name");
    }

    @Test
    void getProject_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getProject("group/sub/project", "package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name");
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "package_name",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "package_name",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/packages/npm/package_name");
    }

    @Test
    void getPackageDistTags_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/npm/-/package/package_name/dist-tags",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNpmPackageTag.class, "npm-package-tag.json")));

        final Optional<GitLabNpmPackageTag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client)).getPackageDistTags("package_name");
        }

        assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackageTag());
        HTTP.verifyRequested(GET, "/api/v4/packages/npm/-/package/package_name/dist-tags");
    }

    @Test
    void getPackageDistTags_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/npm/-/package/package_name/dist-tags", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getPackageDistTags("package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/packages/npm/-/package/package_name/dist-tags");
    }

    @Test
    void updatePackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(PUT, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client)).updatePackageDistTag("package_name", "tag");
        }

        HTTP.verifyRequested(PUT, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void updatePackageDistTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updatePackageDistTag("package_name", "tag"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deletePackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client)).deletePackageDistTag("package_name", "tag");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deletePackageDistTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deletePackageDistTag("package_name", "tag"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void bulkNpmV1SecurityAdvisory_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/packages/npm/-/npm/v1/security/advisories/bulk", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client)).bulkNpmV1SecurityAdvisory();
        }

        HTTP.verifyRequested(POST, "/api/v4/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void bulkNpmV1SecurityAdvisory_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/packages/npm/-/npm/v1/security/advisories/bulk", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bulkNpmV1SecurityAdvisory());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void quickNpmV1SecurityAudit_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/packages/npm/-/npm/v1/security/audits/quick", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client)).quickNpmV1SecurityAudit();
        }

        HTTP.verifyRequested(POST, "/api/v4/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void quickNpmV1SecurityAudit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/packages/npm/-/npm/v1/security/audits/quick", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.quickNpmV1SecurityAudit());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/packages/npm/package_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNpmPackage.class, "npm-package.json")));

        final Optional<GitLabNpmPackage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client)).get("package_name");
        }

        assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackage());
        HTTP.verifyRequested(GET, "/api/v4/packages/npm/package_name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/packages/npm/package_name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .get("package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/packages/npm/package_name");
    }

    @Test
    void getGroupPackageDistTags_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNpmPackageTag.class, "npm-package-tag.json")));

        final Optional<GitLabNpmPackageTag> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getGroupPackageDistTags("group/sub/project", "package_name");
        }

        assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackageTag());
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags");
    }

    @Test
    void getGroupPackageDistTags_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getGroupPackageDistTags("group/sub/project", "package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags");
    }

    @Test
    void updateGroupPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .updateGroupPackageDistTag("group/sub/project", "package_name", "tag");
        }

        HTTP.verifyRequested(
                PUT, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void updateGroupPackageDistTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateGroupPackageDistTag("group/sub/project", "package_name", "tag"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                PUT, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deleteGroupPackageDistTag_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .deleteGroupPackageDistTag("group/sub/project", "package_name", "tag");
        }

        HTTP.verifyRequested(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void deleteGroupPackageDistTag_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteGroupPackageDistTag("group/sub/project", "package_name", "tag"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                DELETE, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/package/package_name/dist-tags/tag");
    }

    @Test
    void bulkGroupNpmV1SecurityAdvisory_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/advisories/bulk",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .bulkGroupNpmV1SecurityAdvisory("group/sub/project");
        }

        HTTP.verifyRequested(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void bulkGroupNpmV1SecurityAdvisory_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/advisories/bulk",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.bulkGroupNpmV1SecurityAdvisory("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/advisories/bulk");
    }

    @Test
    void quickGroupNpmV1SecurityAudit_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/audits/quick",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .quickGroupNpmV1SecurityAudit("group/sub/project");
        }

        HTTP.verifyRequested(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void quickGroupNpmV1SecurityAudit_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/audits/quick",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectNPMRepositoryApi api = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.quickGroupNpmV1SecurityAudit("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(
                POST, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/-/npm/v1/security/audits/quick");
    }

    @Test
    void getGroup_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/package_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNpmPackage.class, "npm-package.json")));

        final Optional<GitLabNpmPackage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getGroup("group/sub/project", "package_name");
        }

        assertThat(result).contains(NpmrepositoryCatalogFixtures.npmPackage());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/package_name");
    }

    @Test
    void getGroup_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/package_name",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectNPMRepositoryApi(GitLabCaller.of(client))
                    .getGroup("group/sub/project", "package_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/-/packages/npm/package_name");
    }
}
