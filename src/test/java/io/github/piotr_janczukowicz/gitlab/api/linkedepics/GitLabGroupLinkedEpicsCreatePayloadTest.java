package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupLinkedEpicsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTargetGroupIdIsNullable() {
        final GitLabGroupLinkedEpicsCreatePayloadBuilder builder = GitLabGroupLinkedEpicsCreatePayloadBuilder.builder(
                        LinkedepicsCatalogFixtures.groupLinkedEpicsCreatePayload())
                .targetGroupId(null);

        final GitLabGroupLinkedEpicsCreatePayload built = builder.build();

        assertThat(built.targetGroupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetEpicIidIsNullable() {
        final GitLabGroupLinkedEpicsCreatePayloadBuilder builder = GitLabGroupLinkedEpicsCreatePayloadBuilder.builder(
                        LinkedepicsCatalogFixtures.groupLinkedEpicsCreatePayload())
                .targetEpicIid(null);

        final GitLabGroupLinkedEpicsCreatePayload built = builder.build();

        assertThat(built.targetEpicIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabGroupLinkedEpicsCreatePayloadBuilder builder = GitLabGroupLinkedEpicsCreatePayloadBuilder.builder(
                        LinkedepicsCatalogFixtures.groupLinkedEpicsCreatePayload())
                .linkType(null);

        final GitLabGroupLinkedEpicsCreatePayload built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupLinkedEpicsCreatePayload value = LinkedepicsCatalogFixtures.groupLinkedEpicsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.targetGroupId()).isEqualTo("1");
            softly.assertThat(value.targetEpicIid()).isEqualTo(1L);
            softly.assertThat(value.linkType()).isEqualTo(GitLabGroupLinkedEpicsCreateLinkType.RELATES_TO);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupLinkedEpicsCreatePayload original = LinkedepicsCatalogFixtures.groupLinkedEpicsCreatePayload();

        final GitLabGroupLinkedEpicsCreatePayload rebuilt =
                GitLabGroupLinkedEpicsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupLinkedEpicsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("targetGroupId", "targetEpicIid", "linkType");
    }
}
