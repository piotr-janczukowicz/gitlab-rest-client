package io.github.piotr_janczukowicz.gitlab.api.avatar;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabAvatarApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void avatarUser_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/user/avatar",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAvatar.class, "avatar.json")));

        final GitLabAvatar result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAvatarApi(GitLabCaller.of(client))
                    .avatarUser(
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result).isEqualTo(AvatarCatalogFixtures.avatar());
        HTTP.verifyRequested(PUT, "/api/v4/user/avatar");
    }

    @Test
    void avatarUser_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/user/avatar", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAvatarApi api = new GitLabAvatarApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.avatarUser(
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/user/avatar");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/avatar",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabAvatar.class, "avatar.json")));

        final GitLabAvatar result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabAvatarApi(GitLabCaller.of(client)).get("email");
        }

        assertThat(result).isEqualTo(AvatarCatalogFixtures.avatar());
        HTTP.verifyRequested(GET, "/api/v4/avatar");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/avatar", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabAvatarApi api = new GitLabAvatarApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get("email"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/avatar");
    }
}
