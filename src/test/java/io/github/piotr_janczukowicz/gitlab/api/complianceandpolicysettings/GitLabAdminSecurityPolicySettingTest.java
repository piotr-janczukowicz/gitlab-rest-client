package io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAdminSecurityPolicySettingTest {

    @Test
    void constructor_shouldAcceptNull_whenCspNamespaceIdIsNullable() {
        final GitLabAdminSecurityPolicySettingBuilder builder = GitLabAdminSecurityPolicySettingBuilder.builder(
                        ComplianceandpolicysettingsCatalogFixtures.adminSecurityPolicySetting())
                .cspNamespaceId(null);

        final GitLabAdminSecurityPolicySetting built = builder.build();

        assertThat(built.cspNamespaceId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAdminSecurityPolicySetting value =
                ComplianceandpolicysettingsCatalogFixtures.adminSecurityPolicySetting();

        assertThat(value.cspNamespaceId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAdminSecurityPolicySetting original =
                ComplianceandpolicysettingsCatalogFixtures.adminSecurityPolicySetting();

        final GitLabAdminSecurityPolicySetting rebuilt =
                GitLabAdminSecurityPolicySettingBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAdminSecurityPolicySetting.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cspNamespaceId");
    }
}
