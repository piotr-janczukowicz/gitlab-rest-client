package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDeployKeysUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectDeployKeysUpdatePayloadBuilder builder = GitLabProjectDeployKeysUpdatePayloadBuilder.builder(
                        DeploykeysCatalogFixtures.projectDeployKeysUpdatePayload())
                .title(null);

        final GitLabProjectDeployKeysUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanPushIsNullable() {
        final GitLabProjectDeployKeysUpdatePayloadBuilder builder = GitLabProjectDeployKeysUpdatePayloadBuilder.builder(
                        DeploykeysCatalogFixtures.projectDeployKeysUpdatePayload())
                .canPush(null);

        final GitLabProjectDeployKeysUpdatePayload built = builder.build();

        assertThat(built.canPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeployKeysUpdatePayload value = DeploykeysCatalogFixtures.projectDeployKeysUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.canPush()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeployKeysUpdatePayload original =
                DeploykeysCatalogFixtures.projectDeployKeysUpdatePayload();

        final GitLabProjectDeployKeysUpdatePayload rebuilt =
                GitLabProjectDeployKeysUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeployKeysUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "canPush");
    }
}
