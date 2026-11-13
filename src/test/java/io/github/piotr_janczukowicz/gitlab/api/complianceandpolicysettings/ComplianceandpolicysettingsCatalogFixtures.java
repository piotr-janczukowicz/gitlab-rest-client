package io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;

public final class ComplianceandpolicysettingsCatalogFixtures {

    private ComplianceandpolicysettingsCatalogFixtures() {}

    public static GitLabAdminSecurityPolicySetting adminSecurityPolicySetting() {
        return GitLabAdminSecurityPolicySettingBuilder.builder()
                .cspNamespaceId(1L)
                .build();
    }

    public static GitLabComplianceAndPolicySettingsUpdatePayload complianceAndPolicySettingsUpdatePayload() {
        return GitLabComplianceAndPolicySettingsUpdatePayloadBuilder.builder()
                .cspNamespaceId(1L)
                .build();
    }
}
