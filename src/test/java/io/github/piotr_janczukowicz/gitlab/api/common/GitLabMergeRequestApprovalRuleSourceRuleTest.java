package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestApprovalRuleSourceRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabMergeRequestApprovalRuleSourceRuleBuilder builder =
                GitLabMergeRequestApprovalRuleSourceRuleBuilder.builder(
                                CommonCatalogFixtures.mergeRequestApprovalRuleSourceRule())
                        .approvalsRequired(null);

        final GitLabMergeRequestApprovalRuleSourceRule built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestApprovalRuleSourceRule value =
                CommonCatalogFixtures.mergeRequestApprovalRuleSourceRule();

        assertThat(value.approvalsRequired()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestApprovalRuleSourceRule original =
                CommonCatalogFixtures.mergeRequestApprovalRuleSourceRule();

        final GitLabMergeRequestApprovalRuleSourceRule rebuilt =
                GitLabMergeRequestApprovalRuleSourceRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestApprovalRuleSourceRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("approvalsRequired");
    }
}
