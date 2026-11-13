package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerRegistryRuleUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRepositoryPathPatternIsNullable() {
        final GitLabContainerRegistryRuleUpdatePayloadBuilder builder =
                GitLabContainerRegistryRuleUpdatePayloadBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload())
                        .repositoryPathPattern(null);

        final GitLabContainerRegistryRuleUpdatePayload built = builder.build();

        assertThat(built.repositoryPathPattern()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabContainerRegistryRuleUpdatePayloadBuilder builder =
                GitLabContainerRegistryRuleUpdatePayloadBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload())
                        .minimumAccessLevelForPush(null);

        final GitLabContainerRegistryRuleUpdatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabContainerRegistryRuleUpdatePayloadBuilder builder =
                GitLabContainerRegistryRuleUpdatePayloadBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload())
                        .minimumAccessLevelForDelete(null);

        final GitLabContainerRegistryRuleUpdatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerRegistryRuleUpdatePayload value =
                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.repositoryPathPattern()).isEqualTo("repository_path_pattern");
            softly.assertThat(value.minimumAccessLevelForPush())
                    .isEqualTo(GitLabContainerRegistryRuleUpdateMinimumAccessLevelForPush.EMPTY);
            softly.assertThat(value.minimumAccessLevelForDelete())
                    .isEqualTo(GitLabContainerRegistryRuleUpdateMinimumAccessLevelForDelete.EMPTY);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerRegistryRuleUpdatePayload original =
                ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload();

        final GitLabContainerRegistryRuleUpdatePayload rebuilt =
                GitLabContainerRegistryRuleUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerRegistryRuleUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("repositoryPathPattern", "minimumAccessLevelForPush", "minimumAccessLevelForDelete");
    }
}
