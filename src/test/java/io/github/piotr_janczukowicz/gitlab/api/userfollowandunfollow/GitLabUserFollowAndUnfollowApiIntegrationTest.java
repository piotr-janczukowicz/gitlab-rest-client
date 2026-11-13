package io.github.piotr_janczukowicz.gitlab.api.userfollowandunfollow;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUser;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabUserFollowAndUnfollowApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void createFollow_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users/1/follow",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUser.class, "user.json")));

        final GitLabUser result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserFollowAndUnfollowApi(GitLabCaller.of(client)).createFollow(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.user());
        HTTP.verifyRequested(POST, "/api/v4/users/1/follow");
    }

    @Test
    void createFollow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/follow", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserFollowAndUnfollowApi api = new GitLabUserFollowAndUnfollowApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createFollow(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/follow");
    }

    @Test
    void createUnfollow_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/users/1/unfollow",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabUser.class, "user.json")));

        final GitLabUser result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabUserFollowAndUnfollowApi(GitLabCaller.of(client)).createUnfollow(1L);
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.user());
        HTTP.verifyRequested(POST, "/api/v4/users/1/unfollow");
    }

    @Test
    void createUnfollow_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/users/1/unfollow", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabUserFollowAndUnfollowApi api = new GitLabUserFollowAndUnfollowApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createUnfollow(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/users/1/unfollow");
    }
}
