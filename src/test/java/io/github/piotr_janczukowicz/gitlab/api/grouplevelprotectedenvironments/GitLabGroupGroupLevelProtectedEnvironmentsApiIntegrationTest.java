package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProtectedEnvironment;
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
class GitLabGroupGroupLevelProtectedEnvironmentsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabProtectedEnvironment.class, "protected-environment.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/protected_environments?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabProtectedEnvironment.class, "protected-environment.json") + "]"));

        final List<GitLabProtectedEnvironment> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        CommonCatalogFixtures.protectedEnvironment(), CommonCatalogFixtures.protectedEnvironment());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProtectedEnvironment.class, "protected-environment.json")));

        final GitLabProtectedEnvironment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.protectedEnvironment());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLevelProtectedEnvironmentsApi api =
                    new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProtectedEnvironment.class, "protected-environment.json")));

        final Optional<GitLabProtectedEnvironment> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabGroupGroupLevelProtectedEnvironmentsGetName.PRODUCTION);
        }

        assertThat(result).contains(CommonCatalogFixtures.protectedEnvironment());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client))
                    .get("group/sub/project", GitLabGroupGroupLevelProtectedEnvironmentsGetName.PRODUCTION)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabProtectedEnvironment.class, "protected-environment.json")));

        final GitLabProtectedEnvironment result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            GitLabGroupProtectedEnvironmentUpdateName.PRODUCTION,
                            GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.protectedEnvironment());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLevelProtectedEnvironmentsApi api =
                    new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    GitLabGroupProtectedEnvironmentUpdateName.PRODUCTION,
                    GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/production");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", "name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLevelProtectedEnvironmentsApi api =
                    new GitLabGroupGroupLevelProtectedEnvironmentsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/protected_environments/name");
    }
}
