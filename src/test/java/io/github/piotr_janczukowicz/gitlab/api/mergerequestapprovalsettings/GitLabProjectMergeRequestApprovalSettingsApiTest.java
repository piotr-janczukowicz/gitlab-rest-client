package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestApprovalSettingsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectMergeRequestApprovalSettingsApi api() {
        return new GitLabProjectMergeRequestApprovalSettingsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectMergeRequestApprovalSettingsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalSettingsApi lowTier = new GitLabProjectMergeRequestApprovalSettingsApi(
                GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalSettingsApi lowTier = new GitLabProjectMergeRequestApprovalSettingsApi(
                GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMergeRequestApprovalSetting.class, "merge-request-approval-setting.json")));

        final GitLabMergeRequestApprovalSetting result = api().get("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/merge_request_approval_setting");
        });
    }

    @Test
    void get_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().get("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalSettingsApi lowTier = new GitLabProjectMergeRequestApprovalSettingsApi(
                GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project",
                MergerequestapprovalsettingsCatalogFixtures.projectMergeRequestApprovalSettingsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void update_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabProjectMergeRequestApprovalSettingsApi lowTier = new GitLabProjectMergeRequestApprovalSettingsApi(
                GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project",
                MergerequestapprovalsettingsCatalogFixtures.projectMergeRequestApprovalSettingsUpdatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabMergeRequestApprovalSetting.class, "merge-request-approval-setting.json")));

        final GitLabMergeRequestApprovalSetting result = api().update(
                        "group/sub/project",
                        MergerequestapprovalsettingsCatalogFixtures.projectMergeRequestApprovalSettingsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(MergerequestapprovalsettingsCatalogFixtures.mergeRequestApprovalSetting());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/projects/group%2Fsub%2Fproject/merge_request_approval_setting");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"allow_author_approval\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        MergerequestapprovalsettingsCatalogFixtures
                                .projectMergeRequestApprovalSettingsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
