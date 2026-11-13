package io.github.piotr_janczukowicz.gitlab.api.saml;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIdentityDetail;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabSamlGroupLink;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupSAMLApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupSAMLApi api() {
        return new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupSAMLApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json") + "]"));

        final List<GitLabSamlGroupLink> result = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).containsExactly(CommonCatalogFixtures.samlGroupLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml_group_links");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.create("group/sub/project", SamlCatalogFixtures.groupSAMLCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.create("group/sub/project", SamlCatalogFixtures.groupSAMLCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        final GitLabSamlGroupLink result =
                api().create("group/sub/project", SamlCatalogFixtures.groupSAMLCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.samlGroupLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/saml_group_links");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"saml_group_name\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().create("group/sub/project", SamlCatalogFixtures.groupSAMLCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", "saml_group_name"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", "saml_group_name"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        final Optional<GitLabSamlGroupLink> result = api().get("group/sub/project", "saml_group_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.samlGroupLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabSamlGroupLink> result = api().get("group/sub/project", "saml_group_name");

        assertThat(result).isEmpty();
    }

    @Test
    void get_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        api().get(
                        "group/sub/project",
                        "saml_group_name",
                        GitLabGroupSAMLGetFilterBuilder.builder()
                                .provider("provider")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("provider", "provider");
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", "saml_group_name"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", "saml_group_name"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        final Optional<GitLabSamlGroupLink> result = api().delete("group/sub/project", "saml_group_name");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.samlGroupLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/saml_group_links/saml_group_name");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", "saml_group_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabSamlGroupLink> result = api().delete("group/sub/project", "saml_group_name");

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabSamlGroupLink.class, "saml-group-link.json")));

        api().delete(
                        "group/sub/project",
                        "saml_group_name",
                        GitLabGroupSAMLDeleteFilterBuilder.builder()
                                .provider("provider")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("provider", "provider");
    }

    @Test
    void getIdentities_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getIdentities("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getIdentities_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupSAMLApi lowTier =
                new GitLabGroupSAMLApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getIdentities("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getIdentities_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabIdentityDetail.class, "identity-detail.json")));

        final GitLabIdentityDetail result = api().getIdentities("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.identityDetail());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/saml/identities");
        });
    }

    @Test
    void getIdentities_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getIdentities("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
