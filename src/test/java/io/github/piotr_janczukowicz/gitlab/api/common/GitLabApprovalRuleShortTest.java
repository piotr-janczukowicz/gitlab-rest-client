package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApprovalRuleShortTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabApprovalRuleShortBuilder builder = GitLabApprovalRuleShortBuilder.builder(
                        CommonCatalogFixtures.approvalRuleShort())
                .id(null);

        final GitLabApprovalRuleShort built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabApprovalRuleShortBuilder builder = GitLabApprovalRuleShortBuilder.builder(
                        CommonCatalogFixtures.approvalRuleShort())
                .name(null);

        final GitLabApprovalRuleShort built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabApprovalRuleShortBuilder builder = GitLabApprovalRuleShortBuilder.builder(
                        CommonCatalogFixtures.approvalRuleShort())
                .ruleType(null);

        final GitLabApprovalRuleShort built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApprovalRuleShort value = CommonCatalogFixtures.approvalRuleShort();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("QA");
            softly.assertThat(value.ruleType()).isEqualTo("regular");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApprovalRuleShort original = CommonCatalogFixtures.approvalRuleShort();

        final GitLabApprovalRuleShort rebuilt =
                GitLabApprovalRuleShortBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApprovalRuleShort.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "ruleType");
    }
}
