package io.github.piotr_janczukowicz.gitlab.api.saml;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIdentityDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSamlGroupLink;
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
class GitLabGroupSAMLApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json") + "]"));

        final List<GitLabSamlGroupLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupSAMLApi(GitLabCaller.of(client)).list("group/sub/project");
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.samlGroupLink());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        final GitLabSamlGroupLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupSAMLApi(GitLabCaller.of(client))
                    .create("group/sub/project", SamlCatalogFixtures.groupSAMLCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.samlGroupLink());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupSAMLApi api = new GitLabGroupSAMLApi(GitLabCaller.of(client));
            thrown =
                    catchThrowable(() -> api.create("group/sub/project", SamlCatalogFixtures.groupSAMLCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        final Optional<GitLabSamlGroupLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupSAMLApi(GitLabCaller.of(client)).get("group/sub/project", "saml_group_name");
        }

        assertThat(result).contains(CommonCatalogFixtures.samlGroupLink());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupSAMLApi(GitLabCaller.of(client))
                    .get("group/sub/project", "saml_group_name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        final Optional<GitLabSamlGroupLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupSAMLApi(GitLabCaller.of(client)).delete("group/sub/project", "saml_group_name");
        }

        assertThat(result).contains(CommonCatalogFixtures.samlGroupLink());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupSAMLApi api = new GitLabGroupSAMLApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "saml_group_name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabSamlGroupLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupSAMLApi(GitLabCaller.of(client)).delete("group/sub/project", "saml_group_name");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name");
    }

    @Test
    void getIdentities_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/saml/identities",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final GitLabIdentityDetail result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupSAMLApi(GitLabCaller.of(client)).getIdentities("group/sub/project");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.identityDetail());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml/identities");
    }

    @Test
    void getIdentities_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml/identities", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupSAMLApi api = new GitLabGroupSAMLApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.getIdentities("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/saml/identities");
    }
}
