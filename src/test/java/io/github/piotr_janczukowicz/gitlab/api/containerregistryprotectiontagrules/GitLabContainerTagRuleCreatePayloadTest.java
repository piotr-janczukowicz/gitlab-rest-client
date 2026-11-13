package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerTagRuleCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTagNamePatternIsNullable() {
        final GitLabContainerTagRuleCreatePayloadBuilder builder = GitLabContainerTagRuleCreatePayloadBuilder.builder(
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload())
                .tagNamePattern(null);

        final GitLabContainerTagRuleCreatePayload built = builder.build();

        assertThat(built.tagNamePattern()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenMinimumAccessLevelForPushIsNull() {
        final GitLabContainerTagRuleCreatePayloadBuilder builder = GitLabContainerTagRuleCreatePayloadBuilder.builder(
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload())
                .minimumAccessLevelForPush(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("minimumAccessLevelForPush");
    }

    @Test
    void constructor_shouldRefuseNull_whenMinimumAccessLevelForDeleteIsNull() {
        final GitLabContainerTagRuleCreatePayloadBuilder builder = GitLabContainerTagRuleCreatePayloadBuilder.builder(
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload())
                .minimumAccessLevelForDelete(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("minimumAccessLevelForDelete");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerTagRuleCreatePayload value =
                ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.tagNamePattern()).isEqualTo("tag_name_pattern");
            softly.assertThat(value.minimumAccessLevelForPush())
                    .isEqualTo(GitLabContainerTagRuleCreateMinimumAccessLevelForPush.MAINTAINER);
            softly.assertThat(value.minimumAccessLevelForDelete())
                    .isEqualTo(GitLabContainerTagRuleCreateMinimumAccessLevelForDelete.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerTagRuleCreatePayload original =
                ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload();

        final GitLabContainerTagRuleCreatePayload rebuilt =
                GitLabContainerTagRuleCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerTagRuleCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tagNamePattern", "minimumAccessLevelForPush", "minimumAccessLevelForDelete");
    }
}
