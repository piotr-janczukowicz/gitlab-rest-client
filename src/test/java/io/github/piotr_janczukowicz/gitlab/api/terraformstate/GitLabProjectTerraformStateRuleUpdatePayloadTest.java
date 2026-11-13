package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTerraformStateRuleUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenStateNameIsNullable() {
        final GitLabProjectTerraformStateRuleUpdatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleUpdatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleUpdatePayload())
                        .stateName(null);

        final GitLabProjectTerraformStateRuleUpdatePayload built = builder.build();

        assertThat(built.stateName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForWriteIsNullable() {
        final GitLabProjectTerraformStateRuleUpdatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleUpdatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleUpdatePayload())
                        .minimumAccessLevelForWrite(null);

        final GitLabProjectTerraformStateRuleUpdatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForWrite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedFromIsNullable() {
        final GitLabProjectTerraformStateRuleUpdatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleUpdatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleUpdatePayload())
                        .allowedFrom(null);

        final GitLabProjectTerraformStateRuleUpdatePayload built = builder.build();

        assertThat(built.allowedFrom()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTerraformStateRuleUpdatePayload value =
                TerraformstateCatalogFixtures.projectTerraformStateRuleUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.stateName()).isEqualTo("state_name");
            softly.assertThat(value.minimumAccessLevelForWrite())
                    .isEqualTo(GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite.DEVELOPER);
            softly.assertThat(value.allowedFrom()).isEqualTo(GitLabProjectTerraformStateRuleUpdateAllowedFrom.ANYWHERE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTerraformStateRuleUpdatePayload original =
                TerraformstateCatalogFixtures.projectTerraformStateRuleUpdatePayload();

        final GitLabProjectTerraformStateRuleUpdatePayload rebuilt =
                GitLabProjectTerraformStateRuleUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectTerraformStateRuleUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("stateName", "minimumAccessLevelForWrite", "allowedFrom");
    }
}
