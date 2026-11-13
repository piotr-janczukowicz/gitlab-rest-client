package io.github.piotr_janczukowicz.gitlab.api.goproxy;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectGoProxyApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectGoProxyApi api() {
        return new GitLabProjectGoProxyApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectGoProxyApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void callVList_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callVList("group/sub/project", "module_name");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/list");
    }

    @Test
    void callVList_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callVList("group/sub/project", "module_name"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getVModuleVersionInfo_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGoModuleVersion.class, "go-module-version.json")));

        final Optional<GitLabGoModuleVersion> result =
                api().getVModuleVersionInfo("group/sub/project", "module_name", "module_version");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GoproxyCatalogFixtures.goModuleVersion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "GET /api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.info");
        });
    }

    @Test
    void getVModuleVersionInfo_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGoModuleVersion> result =
                api().getVModuleVersionInfo("group/sub/project", "module_name", "module_version");

        assertThat(result).isEmpty();
    }

    @Test
    void callVModuleVersionMod_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callVModuleVersionMod("group/sub/project", "module_name", "module_version");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.mod");
    }

    @Test
    void callVModuleVersionMod_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callVModuleVersionMod("group/sub/project", "module_name", "module_version"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callVModuleVersionZip_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callVModuleVersionZip("group/sub/project", "module_name", "module_version");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/packages/go/module_name/@v/module_version.zip");
    }

    @Test
    void callVModuleVersionZip_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().callVModuleVersionZip("group/sub/project", "module_name", "module_version"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
