package io.github.piotr_janczukowicz.gitlab.api.members;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMember;
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
class GitLabProjectMembersApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/members",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMember.class, "member.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/members?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final List<GitLabMember> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMembersApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.member(), CommonCatalogFixtures.member());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/members", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/members",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMember.class, "member.json")));

        final GitLabMember result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMembersApi(GitLabCaller.of(client))
                    .create("group/sub/project", MembersCatalogFixtures.projectMembersCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.member());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/members");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/members", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMembersApi api = new GitLabProjectMembersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", MembersCatalogFixtures.projectMembersCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/members");
    }

    @Test
    void listAll_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/members/all",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMember.class, "member.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/members/all?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabMember.class, "member.json") + "]"));

        final List<GitLabMember> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMembersApi(GitLabCaller.of(client))
                    .listAll("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.member(), CommonCatalogFixtures.member());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/members/all", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/members/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMember.class, "member.json")));

        final Optional<GitLabMember> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMembersApi(GitLabCaller.of(client)).get("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.member());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/members/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/members/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMembersApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/members/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/members/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMember.class, "member.json")));

        final GitLabMember result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMembersApi(GitLabCaller.of(client))
                    .update("group/sub/project", 1L, MembersCatalogFixtures.projectMembersUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.member());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/members/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/members/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMembersApi api = new GitLabProjectMembersApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update("group/sub/project", 1L, MembersCatalogFixtures.projectMembersUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/members/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/members/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMembersApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/members/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/members/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMembersApi api = new GitLabProjectMembersApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/members/1");
    }

    @Test
    void getAll_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/members/all/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMember.class, "member.json")));

        final Optional<GitLabMember> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMembersApi(GitLabCaller.of(client)).getAll("group/sub/project", 1L);
        }

        assertThat(result).contains(CommonCatalogFixtures.member());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/members/all/1");
    }

    @Test
    void getAll_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/members/all/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMembersApi(GitLabCaller.of(client))
                    .getAll("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/members/all/1");
    }
}
