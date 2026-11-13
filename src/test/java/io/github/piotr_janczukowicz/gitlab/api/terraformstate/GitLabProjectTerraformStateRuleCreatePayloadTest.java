package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTerraformStateRuleCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenStateNameIsNullable() {
        final GitLabProjectTerraformStateRuleCreatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleCreatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload())
                        .stateName(null);

        final GitLabProjectTerraformStateRuleCreatePayload built = builder.build();

        assertThat(built.stateName()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenStateNameIsTooLong() {
        final GitLabProjectTerraformStateRuleCreatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleCreatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload())
                        .stateName("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenStateNameHasTheMaximumLength() {
        final GitLabProjectTerraformStateRuleCreatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleCreatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload())
                        .stateName("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenMinimumAccessLevelForWriteIsNull() {
        final GitLabProjectTerraformStateRuleCreatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleCreatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload())
                        .minimumAccessLevelForWrite(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("minimumAccessLevelForWrite");
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedFromIsNullable() {
        final GitLabProjectTerraformStateRuleCreatePayloadBuilder builder =
                GitLabProjectTerraformStateRuleCreatePayloadBuilder.builder(
                                TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload())
                        .allowedFrom(null);

        final GitLabProjectTerraformStateRuleCreatePayload built = builder.build();

        assertThat(built.allowedFrom()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTerraformStateRuleCreatePayload value =
                TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.stateName()).isEqualTo("state_name");
            softly.assertThat(value.minimumAccessLevelForWrite())
                    .isEqualTo(GitLabProjectTerraformStateRuleCreateMinimumAccessLevelForWrite.DEVELOPER);
            softly.assertThat(value.allowedFrom()).isEqualTo(GitLabProjectTerraformStateRuleCreateAllowedFrom.ANYWHERE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTerraformStateRuleCreatePayload original =
                TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload();

        final GitLabProjectTerraformStateRuleCreatePayload rebuilt =
                GitLabProjectTerraformStateRuleCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectTerraformStateRuleCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("stateName", "minimumAccessLevelForWrite", "allowedFrom");
    }
}
