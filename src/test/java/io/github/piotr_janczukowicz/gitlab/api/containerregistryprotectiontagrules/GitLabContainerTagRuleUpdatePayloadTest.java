package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerTagRuleUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTagNamePatternIsNullable() {
        final GitLabContainerTagRuleUpdatePayloadBuilder builder = GitLabContainerTagRuleUpdatePayloadBuilder.builder(
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload())
                .tagNamePattern(null);

        final GitLabContainerTagRuleUpdatePayload built = builder.build();

        assertThat(built.tagNamePattern()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabContainerTagRuleUpdatePayloadBuilder builder = GitLabContainerTagRuleUpdatePayloadBuilder.builder(
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload())
                .minimumAccessLevelForPush(null);

        final GitLabContainerTagRuleUpdatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabContainerTagRuleUpdatePayloadBuilder builder = GitLabContainerTagRuleUpdatePayloadBuilder.builder(
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload())
                .minimumAccessLevelForDelete(null);

        final GitLabContainerTagRuleUpdatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerTagRuleUpdatePayload value =
                ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.tagNamePattern()).isEqualTo("tag_name_pattern");
            softly.assertThat(value.minimumAccessLevelForPush())
                    .isEqualTo(GitLabContainerTagRuleUpdateMinimumAccessLevelForPush.EMPTY);
            softly.assertThat(value.minimumAccessLevelForDelete())
                    .isEqualTo(GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete.EMPTY);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerTagRuleUpdatePayload original =
                ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload();

        final GitLabContainerTagRuleUpdatePayload rebuilt =
                GitLabContainerTagRuleUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerTagRuleUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tagNamePattern", "minimumAccessLevelForPush", "minimumAccessLevelForDelete");
    }
}
