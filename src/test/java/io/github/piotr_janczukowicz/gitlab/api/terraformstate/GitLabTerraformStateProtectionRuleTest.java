package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTerraformStateProtectionRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabTerraformStateProtectionRuleBuilder builder = GitLabTerraformStateProtectionRuleBuilder.builder(
                        TerraformstateCatalogFixtures.terraformStateProtectionRule())
                .id(null);

        final GitLabTerraformStateProtectionRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabTerraformStateProtectionRuleBuilder builder = GitLabTerraformStateProtectionRuleBuilder.builder(
                        TerraformstateCatalogFixtures.terraformStateProtectionRule())
                .projectId(null);

        final GitLabTerraformStateProtectionRule built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateNameIsNullable() {
        final GitLabTerraformStateProtectionRuleBuilder builder = GitLabTerraformStateProtectionRuleBuilder.builder(
                        TerraformstateCatalogFixtures.terraformStateProtectionRule())
                .stateName(null);

        final GitLabTerraformStateProtectionRule built = builder.build();

        assertThat(built.stateName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForWriteIsNullable() {
        final GitLabTerraformStateProtectionRuleBuilder builder = GitLabTerraformStateProtectionRuleBuilder.builder(
                        TerraformstateCatalogFixtures.terraformStateProtectionRule())
                .minimumAccessLevelForWrite(null);

        final GitLabTerraformStateProtectionRule built = builder.build();

        assertThat(built.minimumAccessLevelForWrite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedFromIsNullable() {
        final GitLabTerraformStateProtectionRuleBuilder builder = GitLabTerraformStateProtectionRuleBuilder.builder(
                        TerraformstateCatalogFixtures.terraformStateProtectionRule())
                .allowedFrom(null);

        final GitLabTerraformStateProtectionRule built = builder.build();

        assertThat(built.allowedFrom()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTerraformStateProtectionRule value = TerraformstateCatalogFixtures.terraformStateProtectionRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.stateName()).isEqualTo("production");
            softly.assertThat(value.minimumAccessLevelForWrite()).isEqualTo("maintainer");
            softly.assertThat(value.allowedFrom()).isEqualTo("ci_only");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTerraformStateProtectionRule original =
                TerraformstateCatalogFixtures.terraformStateProtectionRule();

        final GitLabTerraformStateProtectionRule rebuilt =
                GitLabTerraformStateProtectionRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTerraformStateProtectionRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "projectId", "stateName", "minimumAccessLevelForWrite", "allowedFrom");
    }
}
