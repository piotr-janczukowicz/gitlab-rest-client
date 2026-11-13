package io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabComplianceAndPolicySettingsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCspNamespaceIdIsNullable() {
        final GitLabComplianceAndPolicySettingsUpdatePayloadBuilder builder =
                GitLabComplianceAndPolicySettingsUpdatePayloadBuilder.builder(
                                ComplianceandpolicysettingsCatalogFixtures.complianceAndPolicySettingsUpdatePayload())
                        .cspNamespaceId(null);

        final GitLabComplianceAndPolicySettingsUpdatePayload built = builder.build();

        assertThat(built.cspNamespaceId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabComplianceAndPolicySettingsUpdatePayload value =
                ComplianceandpolicysettingsCatalogFixtures.complianceAndPolicySettingsUpdatePayload();

        assertThat(value.cspNamespaceId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabComplianceAndPolicySettingsUpdatePayload original =
                ComplianceandpolicysettingsCatalogFixtures.complianceAndPolicySettingsUpdatePayload();

        final GitLabComplianceAndPolicySettingsUpdatePayload rebuilt =
                GitLabComplianceAndPolicySettingsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabComplianceAndPolicySettingsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cspNamespaceId");
    }
}
