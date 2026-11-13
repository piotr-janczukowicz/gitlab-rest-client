package io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

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
class GitLabComplianceAndPolicySettingsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/admin/security/compliance_policy_settings",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAdminSecurityPolicySetting.class, "admin-security-policy-setting.json")));

        final GitLabAdminSecurityPolicySetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabComplianceAndPolicySettingsApi(GitLabCaller.of(client)).get();
        }

        assertThat(result).isEqualTo(ComplianceandpolicysettingsCatalogFixtures.adminSecurityPolicySetting());
        HTTP.verifyRequested(GET, "/api/v4/admin/security/compliance_policy_settings");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/admin/security/compliance_policy_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabComplianceAndPolicySettingsApi api =
                    new GitLabComplianceAndPolicySettingsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.get());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/admin/security/compliance_policy_settings");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/admin/security/compliance_policy_settings",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabAdminSecurityPolicySetting.class, "admin-security-policy-setting.json")));

        final GitLabAdminSecurityPolicySetting result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabComplianceAndPolicySettingsApi(GitLabCaller.of(client))
                    .update(ComplianceandpolicysettingsCatalogFixtures.complianceAndPolicySettingsUpdatePayload());
        }

        assertThat(result).isEqualTo(ComplianceandpolicysettingsCatalogFixtures.adminSecurityPolicySetting());
        HTTP.verifyRequested(PUT, "/api/v4/admin/security/compliance_policy_settings");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/admin/security/compliance_policy_settings", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabComplianceAndPolicySettingsApi api =
                    new GitLabComplianceAndPolicySettingsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.update(ComplianceandpolicysettingsCatalogFixtures.complianceAndPolicySettingsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/admin/security/compliance_policy_settings");
    }
}
